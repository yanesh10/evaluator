package com.yanesh.evaluator.questionapi.controller;

import com.yanesh.evaluator.questionapi.service.QuestionService;
import com.yanesh.evaluator.commonlibrary.models.Question;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/{api.version}/questions")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("")
    public List<Question> getQuestions(){
        return questionService.getQuestionList();
    }

    @GetMapping("/tags")
    public List<Question> getQuestionsByTags(List<String> tags){
        return questionService.getQuestionList(tags);
    }
}
