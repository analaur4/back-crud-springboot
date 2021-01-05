package br.com.api.todo.list.controller;

import br.com.api.todo.list.VO.HttpGenericResponse;
import br.com.api.todo.list.entity.ItemEntity;
import br.com.api.todo.list.service.ItemService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/todo-list")
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public ResponseEntity<HttpGenericResponse> getItems() {
        try {
            Iterable<ItemEntity> listItems = itemService.getItems();

            return new ResponseEntity<HttpGenericResponse>(new HttpGenericResponse().builder()
                    .status("OK")
                    .message("")
                    .response(listItems)
                    .build(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<HttpGenericResponse>(new HttpGenericResponse().builder()
                    .status("NOK")
                    .message(e.getMessage())
                    .response(null)
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<HttpGenericResponse> saveItem(@Valid @RequestBody ItemEntity itemEntity) {
        try {
            ItemEntity newItem = itemService.saveItem(itemEntity);

            return new ResponseEntity<HttpGenericResponse>(new HttpGenericResponse().builder()
                    .status("OK")
                    .message("Item criado com sucesso!")
                    .response(newItem)
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<HttpGenericResponse>(new HttpGenericResponse().builder()
                    .status("NOK")
                    .message(e.getMessage())
                    .response(null)
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpGenericResponse> getByIdItem(@PathVariable("id") Integer id) {
        try {
            ItemEntity newItem = itemService.findItemById(id);

            return new ResponseEntity<HttpGenericResponse>(new HttpGenericResponse().builder()
                    .status("OK")
                    .message("")
                    .response(newItem)
                    .build(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<HttpGenericResponse>(new HttpGenericResponse().builder()
                    .status("NOK")
                    .message(e.getMessage())
                    .response(null)
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpGenericResponse> updateItem(@PathVariable("id") Integer id,
                                                          @RequestBody ItemEntity itemEntity) {
        try {
            ItemEntity newItem = itemService.updateItem(id, itemEntity);

            return new ResponseEntity<HttpGenericResponse>(new HttpGenericResponse().builder()
                    .status("OK")
                    .message("Item alterado com sucesso!")
                    .response(newItem)
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<HttpGenericResponse>(new HttpGenericResponse().builder()
                    .status("NOK")
                    .message(e.getMessage())
                    .response(null)
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpGenericResponse> deleteItem(@PathVariable("id") Integer id) {
        try {

            itemService.deleteItem(id);

            return new ResponseEntity<HttpGenericResponse>(new HttpGenericResponse().builder()
                    .status("OK")
                    .message("Item deletado!")
                    .response(null)
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<HttpGenericResponse>(new HttpGenericResponse().builder()
                    .status("NOK")
                    .message(e.getMessage())
                    .response(null)
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

}
