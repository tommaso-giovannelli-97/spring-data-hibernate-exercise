package com.bitrock.springdataproject.services;

import com.bitrock.springdataproject.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Class that can be extended to do all basic db operations.
 */
public class BaseDbService<T extends BaseEntity> {

    final JpaRepository<T,Long> repository;

    public BaseDbService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T getById(Long id) {
        Optional<T> optionalEntity = repository.findById(id);
        return optionalEntity.orElse(null);
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T update(Long id, T entity) throws Exception {
        Optional<T> optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new Exception("No existing entity with the given id");
        }
        entity.setId(id);
        return repository.save(entity);
    }

    public void deleteById(Long id) {repository.deleteById(id);}
}
