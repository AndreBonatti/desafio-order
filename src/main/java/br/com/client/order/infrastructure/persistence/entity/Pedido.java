package br.com.client.order.infrastructure.persistence.entity;

import br.com.client.order.domain.model.SituacaoPedido;
import br.com.client.order.domain.model.TipoCanalPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_PEDIDO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Long idPedido;

    @Column(name = "NU_PEDIDO")
    private String nuPedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "ST_PEDIDO", nullable = false)
    private SituacaoPedido situacaoPedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_CANAL", nullable = false)
    private TipoCanalPedido tipoCanal;

    @CreationTimestamp
    @Column(name = "TS_CRIACAO", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "PC_PEDIDO", nullable = false)
    private BigDecimal precoPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Item> itens;
}
