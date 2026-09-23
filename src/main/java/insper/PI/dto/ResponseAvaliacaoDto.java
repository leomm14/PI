package insper.PI.dto;

import insper.PI.entity.Avaliacao;
import lombok.Data;

@Data
public class ResponseAvaliacaoDto {
    private Long id;
    private String nome;
    private String conteudo;
    private Integer nota;
    private String dataAvaliacao;

    // Função para converter a Entidade no DTO de resposta
    public static ResponseAvaliacaoDto toDto(Avaliacao avaliacao) {
        ResponseAvaliacaoDto dto = new ResponseAvaliacaoDto();
        dto.setId(avaliacao.getId());
        dto.setNome(avaliacao.getNome());
        dto.setConteudo(avaliacao.getConteudo());
        dto.setNota(avaliacao.getNota());
        dto.setDataAvaliacao(avaliacao.getDataAvaliacao());
        return dto;
    }
}