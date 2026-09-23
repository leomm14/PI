package insper.PI.dto;

import lombok.Data;

@Data
public class SaveAvaliacaoDto {
    private String nome;
    private String conteudo;
    private Integer nota;
    private String dataAvaliacao;
}