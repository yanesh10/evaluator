package com.yanesh.evaluator.commonlibrary.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@Document
@Builder
@Getter
public class Question {

    private String question;
    private List<Answer> possibleAnswers;
    private Answer validAnswer;
    private List<String> tags;

}
