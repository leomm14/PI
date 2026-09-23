package insper.PI.service;

import insper.PI.dto.ResponseAvaliacaoDto;
import insper.PI.dto.SaveAvaliacaoDto;
import insper.PI.entity.Avaliacao;
import insper.PI.repository.AvaliacaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AvaliacaoServiceTests {

    @InjectMocks
    private AvaliacaoService avaliacaoService;

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @Test
    public void test_shouldReturnAvaliacaoWhenCallGetDTO() {

        SaveAvaliacaoDto dto = new SaveAvaliacaoDto();
        dto.setNome("PI agil");
        dto.setConteudo("java");
        dto.setNota(5);
        dto.setDataAvaliacao("23-09-2026");

        Avaliacao avaliacao = Avaliacao.toModel(dto);

        // mocks
        Mockito.when(avaliacaoRepository.findById(1L))
                .thenReturn(Optional.of(avaliacao));

        // chamada
        Avaliacao op = avaliacaoService.getById(1L);

        // asserts
        Assertions.assertEquals("PI agil", op.getNome());
        Assertions.assertEquals("java", op.getConteudo());
        Assertions.assertEquals(5, op.getNota());
        Assertions.assertEquals("23-09-2026", op.getDataAvaliacao());
    }

    @Test
    public void test_shouldReturnTwoPaymentsWhenListarAvaliacao() {
        List<Avaliacao> avaliacao = new ArrayList<>();
        avaliacao.add(new Avaliacao());
        avaliacao.add(new Avaliacao());

        // cria os mocks
        Mockito.when(avaliacaoRepository.findAll())
                .thenReturn(avaliacao);

        // chama o metodo testado
        List<Avaliacao> response = avaliacaoService.listarAvaliacao();

        // asserts
        Assertions.assertEquals(2, response.size());
    }


    @Test
    public void test_shouldCreateAvaliacao() {
        // mocks
        SaveAvaliacaoDto dto = new SaveAvaliacaoDto();
        dto.setNome("PI agil");
        dto.setConteudo("java");
        dto.setNota(5);
        dto.setDataAvaliacao("23-09-2026");

        Avaliacao avaliacao = Avaliacao.toModel(dto);

        Mockito.when(avaliacaoRepository.save(Mockito.any()))
                .thenReturn(avaliacao);

        // chamada
        Avaliacao response = avaliacaoService.salvarAvaliacao(dto);

        // asserts
        Assertions.assertEquals("PI agil", response.getNome());
        Assertions.assertEquals("java", response.getConteudo());
        Assertions.assertEquals(5, response.getNota());
        Assertions.assertEquals("23-09-2026", response.getDataAvaliacao());
    }



}
