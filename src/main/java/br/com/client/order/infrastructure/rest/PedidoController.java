package br.com.client.order.infrastructure.rest;

import br.com.client.order.common.constants.Application;
import br.com.client.order.domain.dto.PageDto;
import br.com.client.order.domain.dto.PedidoDto;
import br.com.client.order.domain.dto.PedidoRecordDto;
import br.com.client.order.domain.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Application.PEDIDO)
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<HttpStatusCode> criarPedido(@Valid @RequestBody PedidoDto pedidoDto,
                                                      @RequestHeader("uuid")  String uuid) {
        pedidoService.processarPedido(pedidoDto, uuid);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public PageDto<PedidoRecordDto> buscarPedidos(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "100") int tamanho,
            @RequestParam(defaultValue = "idPedido") String ordenacao,
            @RequestParam(defaultValue = "true") boolean ascendente,
            @RequestParam(defaultValue = "false") boolean incluirItens) {

        return pedidoService.buscarPedidosPaginados(
                pagina, tamanho, ordenacao, ascendente, incluirItens);
    }

    // Endpoint para buscar pedido por ID
    @GetMapping("/{idPedido}")
    public PedidoRecordDto buscarPedidoPorId(@PathVariable Long idPedido) {
        return pedidoService.buscarPedidoPorId(idPedido);
    }

    // Endpoint para buscar pedido por número único uuid
    @GetMapping("/numero/{nuPedido}")
    public PedidoRecordDto buscarPedidoPorNumero(@PathVariable String nuPedido) {
        return pedidoService.buscarPedidoPorNumero(nuPedido);
    }
}