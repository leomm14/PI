package insper.PI.service;

import insper.PI.dto.SaveItemDto;
import insper.PI.entity.Item;
import insper.PI.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listarItens(String categoria) {
        if (categoria != null && !categoria.isBlank()) {
            return itemRepository.findByCategoria(categoria);
        }
        return itemRepository.findAll();
    }

    public Item salvarItem(SaveItemDto dto) {
        // Usa a tua função toModel para criar a entidade diretamente
        Item item = Item.toModel(dto);
        return itemRepository.save(item);
    }

    public void deletarItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado");
        }
        itemRepository.deleteById(id);
    }
}