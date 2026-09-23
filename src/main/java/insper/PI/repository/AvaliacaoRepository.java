package insper.PI.repository;

import insper.PI.entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    // Método para o filtro opcional
    List<Avaliacao> findByCategoria(String categoria);
}