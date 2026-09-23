package insper.PI.observer;

import insper.PI.entity.Avaliacao;

public interface AvaliacaoObserver {
    void atualizar(Avaliacao avaliacao, String statusAnterior, String statusNovo);
}
