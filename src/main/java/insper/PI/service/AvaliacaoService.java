package insper.PI.service;

import insper.PI.dto.ResponseAvaliacaoDto;
import insper.PI.dto.SaveAvaliacaoDto;
import insper.PI.entity.Avaliacao;
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

    public ResponseAvaliacaoDto getDTO(Long id) {

        Avaliacao avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não encontrada"));

        return ResponseAvaliacaoDto.toDto(avaliacao);

    }

    public List<Avaliacao> listarAvaliacao() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao salvarAvaliacao(SaveAvaliacaoDto dto) {
        // Usa a tua função toModel para criar a entidade diretamente
        Avaliacao avaliacao = Avaliacao.toModel(dto);
        return avaliacaoRepository.save(avaliacao);
    }

    public void deletarAvaliacao(Long id) {
        if (!avaliacaoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliacao não encontrado");
        }
        avaliacaoRepository.deleteById(id);
    }
}