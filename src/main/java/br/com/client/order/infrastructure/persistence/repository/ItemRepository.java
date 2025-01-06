package br.com.client.order.infrastructure.persistence.repository;

import br.com.client.order.infrastructure.persistence.entity.Item;
import br.com.client.order.infrastructure.persistence.entity.ItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, ItemId> {
}