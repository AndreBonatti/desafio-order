package br.com.client.order.domain.mapper;

import br.com.client.order.domain.dto.ItemRecordDto;
import br.com.client.order.domain.dto.PedidoDto;
import br.com.client.order.domain.dto.PedidoRecordDto;
import br.com.client.order.infrastructure.persistence.entity.Item;
import br.com.client.order.infrastructure.persistence.entity.ItemId;
import br.com.client.order.infrastructure.persistence.entity.Pedido;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PedidoMapper {

    private PedidoMapper() {
        throw new IllegalStateException("Utility mapper class");
    }

    public static Pedido toEntity(PedidoDto pedidoDto) {
        Pedido pedido = new Pedido();
        pedido.setTipoCanal(pedidoDto.getTipoCanal());
        AtomicInteger numeroSequencial = new AtomicInteger(0);
        List<Item> itens = pedidoDto.getItens().stream().map(itensDto -> {
            Item item = new Item();

            // Atribuindo o número sequencial ao ItemId
            ItemId itemId = new ItemId();
            itemId.setIdPedido(pedido.getIdPedido());
            itemId.setNuItem(numeroSequencial.incrementAndGet());

            item.setId(itemId);
            item.setPedido(pedido);

            item.setIdProduto(itensDto.getIdProduto());
            item.setNomeProduto(itensDto.getNomeProduto());
            item.setDescricaoAtributos(itensDto.getDescricaoAtributos());
            item.setDescricaoProduto(itensDto.getDescricaoProduto());
            item.setQuantidade(itensDto.getQuantidade());
            item.setPreco(itensDto.getPreco());
            return item;
        }).toList();
        pedido.setItens(itens);
        return pedido;
    }

    public static PedidoRecordDto toDTO(Pedido pedido, boolean incluirItens) {
        List<ItemRecordDto> itens = incluirItens && pedido.getItens() != null
                ? pedido.getItens().stream().map(item -> new ItemRecordDto(
                item.getIdProduto(),
                item.getNomeProduto(),
                item.getDescricaoAtributos(),
                item.getDescricaoProduto(),
                item.getQuantidade(),
                item.getPreco()
        )).toList()
                : null;

        return new PedidoRecordDto(
                pedido.getIdPedido(),
                pedido.getNuPedido(),
                pedido.getSituacaoPedido(),
                pedido.getTipoCanal(),
                pedido.getDataCriacao(),
                pedido.getPrecoPedido(),
                itens
        );
    }

}