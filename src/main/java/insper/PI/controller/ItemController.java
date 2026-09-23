package insper.PI.controller;

import insper.PI.dto.ResponseItemDto;
import insper.PI.dto.SaveItemDto;
import insper.PI.entity.Item;
import insper.PI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<ResponseItemDto> getAll(@RequestParam(required = false) String categoria) {
        // Uso direto da tua função toDto via Method Reference
        return itemService.listarItens(categoria).stream()
                .map(ResponseItemDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseItemDto create(@RequestBody SaveItemDto dto) {
        Item itemSalvo = itemService.salvarItem(dto);
        // Usa a função para devolver logo formatado
        return ResponseItemDto.toDto(itemSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        itemService.deletarItem(id);
    }
}