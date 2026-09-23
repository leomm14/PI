package insper.PI.observer;

import insper.PI.entity.Avaliacao;

public interface AvaliacaoObservable {
    void notificarObservadores(Avaliacao avaliacao, String statusAnterior);
}