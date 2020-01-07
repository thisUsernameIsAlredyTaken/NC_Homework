package com.example.homework.service.crud;

import com.example.homework.entity.Store;
import com.example.homework.repos.StoreRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreService {

    private final StoreRepos storeRepos;

    // CRUD
    public boolean add(Store store) {
        if (store == null || store.getId() != null) {
            return false;
        }
        storeRepos.save(store);
        return true;
    }

    public Store findById(long id) {
        if (id < 1) {
            return null;
        }
        return storeRepos.findById(id).orElse(null);
    }

    public boolean update(Store store) {
        if (store == null || store.getId() == null) {
            return false;
        }
        if (!isExist(store.getId())) {
            return false;
        }
        storeRepos.save(store);
        return true;
    }

    public boolean deleteById(long id) {
        if (!isExist(id)) {
            return false;
        }
        storeRepos.deleteById(id);
        return true;
    }
    //

    public boolean isExist(long id) {
        if (id < 1) {
            return false;
        }
        return storeRepos.existsById(id);
    }

    public List<Store> findAll() {
        return storeRepos.findAll();
    }

    public boolean patchById(long id, String name, String district,
                             Double commission) {
        Store store = findById(id);
        if (store == null) {
            return false;
        }
        Optional.ofNullable(name).ifPresent(store::setName);
        Optional.ofNullable(district).ifPresent(store::setDistrict);
        Optional.ofNullable(commission).ifPresent(store::setCommission);
        storeRepos.save(store);
        return true;
    }
}
