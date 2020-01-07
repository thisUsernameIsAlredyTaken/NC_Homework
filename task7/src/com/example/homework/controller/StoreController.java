package com.example.homework.controller;

import com.example.homework.entity.Store;
import com.example.homework.service.crud.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("store")
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;

    // CRUD
    @PostMapping
    public void addStore(@RequestBody Store store,
                         HttpServletResponse response) {
        if (storeService.add(store)) {
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @GetMapping("{id}")
    public Store findStoreById(@PathVariable long id,
                               HttpServletResponse response) {
        Store store = storeService.findById(id);
        if (store == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return store;
    }

    @PutMapping("{id}")
    public void updateStore(@PathVariable long id,
                            @RequestBody Store store,
                            HttpServletResponse response) {
        if (store.getId() != null) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return;
        }
        store.setId(id);
        if (storeService.update(store)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @DeleteMapping("{id}")
    public void deleteStore(@PathVariable long id,
                            HttpServletResponse response) {
        if (storeService.deleteById(id)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
    //

    @GetMapping
    public List<Store> findAllStores() {
        return storeService.findAll();
    }

    @PatchMapping("{id}")
    public void patchStore(@PathVariable long id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String district,
                           @RequestParam(required = false) Double commission,
                           HttpServletResponse response) {
        if (storeService.patchById(id, name, district, commission)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
}
