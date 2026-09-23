package insper.PI.dto;

import insper.PI.entity.Item;
import lombok.Data;

@Data
public class ResponseItemDto {
    private Long id;
    private String nome;
    private String categoria;

    // Função para converter a Entidade no DTO de resposta
    public static ResponseItemDto toDto(Item item) {
        ResponseItemDto dto = new ResponseItemDto();
        dto.setId(item.getId());
        dto.setNome(item.getNome());
        dto.setCategoria(item.getCategoria());
        return dto;
    }
}