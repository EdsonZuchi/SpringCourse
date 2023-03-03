package io.github.edsonzuchi.domain.repository;

import io.github.edsonzuchi.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidos extends JpaRepository<ItemPedido, Integer> {
}
