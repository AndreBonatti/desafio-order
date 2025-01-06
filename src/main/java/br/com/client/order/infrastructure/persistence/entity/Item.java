package br.com.client.order.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_ITENS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @EmbeddedId
    private ItemId id;

    @Column(name = "ID_PRODUTO", nullable = false)
    private Long idProduto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEDIDO", insertable = false, updatable = false)
    private Pedido pedido;

    @Column(name = "NO_PRODUTO", nullable = false)
    private String nomeProduto;

    @Column(name = "DS_ATRIBUTOS")
    private String descricaoAtributos;

    @Column(name = "DS_DESCRICAO")
    private String descricaoProduto;

    @Column(name = "QT_PRODUTO", nullable = false)
    private Integer quantidade;

    @Column(name = "PC_PRODUTO", nullable = false)
    private BigDecimal preco;
}

