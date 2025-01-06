package br.com.client.order.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemId implements Serializable {

    @Column(name = "ID_PEDIDO")
    private Long idPedido;

    @Column(name = "NU_ITEM")
    private Integer nuItem;
}