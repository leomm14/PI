package insper.PI.service;

import insper.PI.dto.ResponseAvaliacaoDto;
import insper.PI.dto.SaveAvaliacaoDto;
import insper.PI.entity.Avaliacao;
import insper.PI.observer.AvaliacaoObserver;
import insper.PI.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired(required = false)
    private List<AvaliacaoObserver> observers;


    public void notificarObservadores(Avaliacao avaliacao, String statusAnterior) {
        if (observers != null) {
            for (AvaliacaoObserver observer : observers) {
                observer.atualizar(avaliacao, statusAnterior, avaliacao.getStatus());
            }
        }
    }

    public Avaliacao getById(Long id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não encontrada"));
    }

    public List<Avaliacao> listarAvaliacao() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao salvarAvaliacao(SaveAvaliacaoDto dto) {
        // Usa a tua função toModel para criar a entidade diretamente
        Avaliacao avaliacao = Avaliacao.toModel(dto);
        notificarObservadores(avaliacao, null);
        return avaliacaoRepository.save(avaliacao);
    }

    public void deletarAvaliacao(Long id) {
        if (!avaliacaoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliacao não encontrado");
        }
        Avaliacao avaliacao = getById(id);
        avaliacaoRepository.deleteById(id);
        notificarObservadores(avaliacao, null);
    }
}