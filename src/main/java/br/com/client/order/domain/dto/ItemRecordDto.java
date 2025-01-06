package br.com.client.order.domain.dto;

import java.math.BigDecimal;

public record ItemRecordDto(Long idProduto,
                            String nomeProduto,
                            String descricaoAtributos,
                            String descricaoProduto,
                            Integer quantidade,
                            BigDecimal preco
) {
}