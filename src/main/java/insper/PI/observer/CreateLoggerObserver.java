package insper.PI.observer;

import insper.PI.entity.Avaliacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CreateLoggerObserver implements AvaliacaoObserver {

    private static final Logger logger = LoggerFactory.getLogger(CreateLoggerObserver.class);

    Instant timestamp = Instant.now();

    @Override
    public void atualizar(Avaliacao avaliacao, String statusAnterior, String statusNovo) {
        String mensagem = String.format(
                "CREATE - Avaliacao ID: %d | Status: %s → %s | TimeStamp: %TH",
                avaliacao.getId(),
                statusAnterior,
                statusNovo,
                timestamp.getEpochSecond()
        );
        logger.info(mensagem);
    }
}
