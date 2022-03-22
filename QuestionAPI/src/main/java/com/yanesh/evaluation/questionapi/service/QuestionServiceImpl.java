package com.yanesh.evaluation.questionapi.service;

import com.yanesh.evaluator.commonlibrary.models.Question;
import com.yanesh.evaluator.commonlibrary.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Value("${collections.question}")
    private String collectionName;

    @Override
    public List<Question> getQuestionList() {
        return questionRepository.findAll(collectionName);
    }

    @Override
    public List<Question> getQuestionList(List<String> tags) {
        return questionRepository.findAllByTags(tags);
    }
}
