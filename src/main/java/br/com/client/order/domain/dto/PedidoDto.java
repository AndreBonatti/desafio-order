package br.com.client.order.domain.dto;

import br.com.client.order.domain.model.TipoCanalPedido;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {

    @NotNull(message = "O tipo de canal não pode ser nulo")
    private TipoCanalPedido tipoCanal;

    @NotNull(message = "A lista de itens não pode ser nula")
    @Size(min = 1, message = "O pedido deve ter pelo menos um item")
    private List<ItensDto> itens;
}
