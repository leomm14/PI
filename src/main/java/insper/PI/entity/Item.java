package insper.PI.entity;

import insper.PI.dto.SaveItemDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;

    // Função para converter o SaveDto em Entidade
    public static Item toModel(SaveItemDto dto) {
        Item item = new Item();
        item.setNome(dto.getNome());
        item.setCategoria(dto.getCategoria());
        return item;
    }
}