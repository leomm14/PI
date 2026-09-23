package insper.PI.controller;

import insper.PI.dto.ResponseAvaliacaoDto;
import insper.PI.dto.SaveAvaliacaoDto;
import insper.PI.entity.Avaliacao;
import insper.PI.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/itens")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/{id}")
    public ResponseAvaliacaoDto getUsuario(@PathVariable Long id) {return avaliacaoService.getDTO(id);}

    @GetMapping
    public List<ResponseAvaliacaoDto> getAll() {
        // Uso direto da tua função toDto via Method Reference
        return avaliacaoService.listarItens().stream()
                .map(ResponseAvaliacaoDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAvaliacaoDto create(@RequestBody SaveAvaliacaoDto dto) {
        Avaliacao avaliacaoSalvo = avaliacaoService.salvarItem(dto);
        // Usa a função para devolver logo formatado
        return ResponseAvaliacaoDto.toDto(avaliacaoSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        avaliacaoService.deletarItem(id);
    }
}