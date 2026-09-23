package insper.PI.repository;

import insper.PI.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Método para o filtro opcional
    List<Item> findByCategoria(String categoria);
}