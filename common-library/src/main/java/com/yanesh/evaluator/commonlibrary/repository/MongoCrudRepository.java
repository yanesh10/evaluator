package com.yanesh.evaluator.commonlibrary.repository;

import java.util.List;
import java.util.Optional;

public interface MongoCrudRepository <D> {

    void save(D entity);
    void save(D entity, String collectionName);

    Optional<D> findById(Object id, Class<D> entityType);
    List<D> findAll(Class<D> entityType, String collectionName);

    void createCollection(String collectionName);
    void dropCollection(String collectionName);
}
