package br.com.client.order.domain.dto;

import br.com.client.order.domain.model.SituacaoPedido;
import br.com.client.order.domain.model.TipoCanalPedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoRecordDto (
                           Long idPedido,
                           String nuPedido,
                           SituacaoPedido situacaoPedido,
                           TipoCanalPedido tipoCanal,
                           LocalDateTime dataCriacao,
                           BigDecimal precoPedido,
                           List<ItemRecordDto> itens
) implements Serializable {}