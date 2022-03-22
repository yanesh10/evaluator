package com.yanesh.evaluator.commonlibrary.repository;

import com.yanesh.evaluator.commonlibrary.models.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class QuestionRepository extends BasicMongoCrudRepository<Question> {

    public QuestionRepository(MongoTemplate mongoTemplate) {
        super(mongoTemplate);
    }

    public List<Question> findAll(String collectionName){
        return mongoTemplate.findAll(Question.class, collectionName);
    }

    public List<Question> findAllByTags(List<String> tags, String collectionName) {
        return findAll(collectionName).stream()
                .filter(questions -> questions.getTags().stream().anyMatch(tags::contains))
                .collect(Collectors.toList());
    }
}
