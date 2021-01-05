package br.com.api.todo.list.repository;

import br.com.api.todo.list.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {
}
