package br.com.api.todo.list.service;

import br.com.api.todo.list.entity.ItemEntity;
import br.com.api.todo.list.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
//@NoArgsConstructor
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void validateItems(ItemEntity itemEntity) {
        if(itemEntity.getMateria().isEmpty() | isNull(itemEntity.getMateria())) {
            throw new RuntimeException("Campo 'matéria' é obrigatório!");
        }

        if(itemEntity.getTarefa().isEmpty() | isNull(itemEntity.getTarefa())) {
            throw new RuntimeException("Campo 'tarefa' é obrigatório!");
        }

        if(isNull(itemEntity.getDtEntrega())) {
            throw new RuntimeException("Campo 'data de entrega' é obrigatório!");
        }
    }

    public Iterable<ItemEntity> getItems() {
        Iterable<ItemEntity> listItems = itemRepository.findAll();
        if(isNull(listItems)) {
            throw new RuntimeException("Nenhum resultado encontrado");
        } else {
            return listItems;
        }
    }

    public ItemEntity saveItem(ItemEntity itemEntity) {
        this.validateItems(itemEntity);
        return itemRepository.save(itemEntity);
    }

    public ItemEntity findItemById(Integer idItem) {
        Optional<ItemEntity> itemObj = itemRepository.findById(idItem);

        if (!itemObj.isPresent()) {
            throw new RuntimeException("Item não encontrado no sistema!");
        }

        return itemObj.get();
    }

    public ItemEntity updateItem(Integer idItem, ItemEntity itemEntity) {
        if(isNull(idItem)) {
            throw new RuntimeException("Id não encontrado");
        } else {
            this.validateItems(itemEntity);
            return itemRepository.save(itemEntity);
        }
    }

    public void deleteItem(Integer idItem) {
        this.findItemById(idItem);
        itemRepository.deleteById(idItem);
    }
}
