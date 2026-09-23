package insper.PI.entity;

import insper.PI.dto.SaveAvaliacaoDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String conteudo;

    @Column
    private Integer nota;

    @Column
    private String dataAvaliacao;

    @Column
    private String status;

    // Função para converter o SaveDto em Entidade
    public static Avaliacao toModel(SaveAvaliacaoDto dto) {
        Avaliacao item = new Avaliacao();
        item.setNome(dto.getNome());
        item.setNome(dto.getNome());
        item.setNota(dto.getNota());
        item.setDataAvaliacao(dto.getDataAvaliacao());

        return item;
    }
}