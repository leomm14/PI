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


}
