package br.com.client.order.domain.service;

import br.com.client.order.domain.dto.PageDto;
import br.com.client.order.domain.dto.PedidoDto;
import br.com.client.order.domain.dto.PedidoRecordDto;
import br.com.client.order.domain.handler.exception.IllegalBusinessException;
import br.com.client.order.domain.mapper.PedidoMapper;
import br.com.client.order.domain.model.SituacaoPedido;
import br.com.client.order.infrastructure.persistence.entity.Pedido;
import br.com.client.order.infrastructure.persistence.repository.ItemRepository;
import br.com.client.order.infrastructure.persistence.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private ItemRepository itemRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ItemRepository itemRepository) {
        this.pedidoRepository = pedidoRepository;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public CompletableFuture<Void> processarPedido(PedidoDto pedidoDto, String uuid) {

        // Verificação de existência do pedido com base no UUID
        if (pedidoRepository.existsByNuPedidoAndDataCriacaoAfter(uuid, LocalDateTime.now().minusMonths(1))) {
            throw new IllegalBusinessException("Pedido com número já existente criado nos últimos 30 dias.");
        }

        Pedido pedido = PedidoMapper.toEntity(pedidoDto);
        pedido.setNuPedido(uuid);
        pedido.setSituacaoPedido(SituacaoPedido.PENDENTE);

        BigDecimal valorPedido = pedido.getItens().stream()
                .map(item -> item.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        pedido.setPrecoPedido(valorPedido);

        // Persistir o pedido
        pedidoRepository.save(pedido);

        // Atualiza os itens do pedido
        pedido.getItens().forEach(item -> item.getId().setIdPedido(pedido.getIdPedido()));
        itemRepository.saveAll(pedido.getItens());

        return CompletableFuture.completedFuture(null);
    }

    public PageDto<PedidoRecordDto> buscarPedidosPaginados(
            int pagina, int tamanho, String ordenacao, boolean ascendente, boolean incluirItens) {

        Sort sort = Sort.by(ordenacao);
        if (!ascendente) {
            sort = sort.descending();
        }

        PageRequest pageRequest = PageRequest.of(pagina, tamanho, sort);
        Page<Pedido> pedidos = null;
        if (incluirItens) {
            pedidos =pedidoRepository.findPagedOrdersWithItens(pageRequest, incluirItens);
        } else {
            pedidos= pedidoRepository.findPagedOrdersWithoutItens(pageRequest, incluirItens);
        }

        List<PedidoRecordDto> pedidosDTO = pedidos.getContent().stream()
                .map(pedido -> PedidoMapper.toDTO(pedido, incluirItens))
                .toList();

        return new PageDto<>(
                pedidosDTO,
                pedidos.getNumber(),
                pedidos.getSize(),
                pedidos.getTotalElements(),
                pedidos.getTotalPages(),
                pedidos.isLast()
        );
    }
    public PedidoRecordDto buscarPedidoPorId(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new IllegalBusinessException("Pedido com ID " + idPedido + " não encontrado."));
        return PedidoMapper.toDTO(pedido, true);
    }

    public PedidoRecordDto buscarPedidoPorNumero(String nuPedido) {
        Pedido pedido = pedidoRepository.findByNuPedido(nuPedido)
                .orElseThrow(() -> new IllegalBusinessException("Pedido com número " + nuPedido + " não encontrado."));
        return PedidoMapper.toDTO(pedido, true);
    }
}

