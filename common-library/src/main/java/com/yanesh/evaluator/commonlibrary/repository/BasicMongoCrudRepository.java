package com.yanesh.evaluator.commonlibrary.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class BasicMongoCrudRepository<D> implements MongoCrudRepository<D> {

    protected final MongoTemplate mongoTemplate;

    @Override
    public void save(D entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public void save(D entity, String collectionName) {
        mongoTemplate.save(entity, collectionName);
    }

    @Override
    public Optional<D> findById(Object id, Class<D> entityType) {
        return Optional.ofNullable(mongoTemplate.findById(id, entityType));
    }

    @Override
    public List<D> findAll(Class<D> entityType, String collectionName) {
        return mongoTemplate.findAll(entityType, collectionName);
    }

    @Override
    public void createCollection(String collectionName) {
        if (!mongoTemplate.collectionExists(collectionName)) {
            mongoTemplate.createCollection(collectionName);
        }
    }

    @Override
    public void dropCollection(String collectionName) {
        mongoTemplate.dropCollection(collectionName);
    }
}
