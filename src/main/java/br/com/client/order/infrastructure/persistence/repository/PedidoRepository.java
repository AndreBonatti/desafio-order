package br.com.client.order.infrastructure.persistence.repository;

import br.com.client.order.infrastructure.persistence.entity.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT COUNT(p) > 0 FROM Pedido p WHERE p.nuPedido = :nuPedido AND p.dataCriacao > :dataCriacao")
    boolean existsByNuPedidoAndDataCriacaoAfter(@Param("nuPedido") String nuPedido, @Param("dataCriacao") LocalDateTime dataCriacao);

    @Query("SELECT p FROM Pedido p LEFT JOIN FETCH p.itens WHERE :incluirItens = true")
    Page<Pedido> findPagedOrdersWithItens(Pageable pageable, boolean incluirItens);

    @Query("SELECT p FROM Pedido p WHERE :incluirItens = false")
    Page<Pedido> findPagedOrdersWithoutItens(Pageable pageable, boolean incluirItens);

    Optional<Pedido> findByNuPedido(String nuPedido);
}
