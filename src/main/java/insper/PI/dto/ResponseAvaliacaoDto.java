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
    public static ResponseAvaliacaoDto toDto(Avaliacao item) {
        ResponseAvaliacaoDto dto = new ResponseAvaliacaoDto();
        dto.setId(item.getId());
        dto.setNome(item.getNome());
        dto.setConteudo(item.getConteudo());
        dto.setNota(item.getNota());
        dto.setDataAvaliacao(item.getDataAvaliacao());
        return dto;
    }
}