package com.yanesh.evaluator.commonlibrary.models;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@Document
public class Question {

    private String question;
    private List<Answer> possibleAnswers;
    private Answer validAnswer;

}
