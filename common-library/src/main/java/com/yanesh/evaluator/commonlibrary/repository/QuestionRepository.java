package com.yanesh.evaluator.commonlibrary.repository;

import com.yanesh.evaluator.commonlibrary.models.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class QuestionRepository extends BasicMongoCrudRepository<Question> {

    public QuestionRepository(MongoTemplate mongoTemplate) {
        super(mongoTemplate);
    }
}
