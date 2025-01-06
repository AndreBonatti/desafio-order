package br.com.client.order.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItensDto {

    @NotNull(message = "O ID do produto não pode ser nulo")
    @Positive(message = "O ID do produto deve ser um valor positivo")
    private Long idProduto;

    @NotNull(message = "O nome do produto não pode ser nulo")
    @Size(min = 3, max = 100, message = "O nome do produto deve ter entre 3 e 100 caracteres")
    private String nomeProduto;

    @Size(max = 255, message = "A descrição de atributos não pode ter mais de 255 caracteres")
    private String descricaoAtributos;

    @Size(max = 255, message = "A descrição do produto não pode ter mais de 255 caracteres")
    private String descricaoProduto;

    @NotNull(message = "A quantidade não pode ser nula")
    @Positive(message = "A quantidade deve ser um valor positivo")
    private Integer quantidade;

    @NotNull(message = "O preço não pode ser nulo")
    @Positive(message = "O preço deve ser um valor positivo")
    private BigDecimal preco;
}
