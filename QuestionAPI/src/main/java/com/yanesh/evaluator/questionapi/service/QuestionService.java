package com.yanesh.evaluator.questionapi.service;

import com.yanesh.evaluator.commonlibrary.models.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestionList();

    List<Question> getQuestionList(List<String> tags);

}
