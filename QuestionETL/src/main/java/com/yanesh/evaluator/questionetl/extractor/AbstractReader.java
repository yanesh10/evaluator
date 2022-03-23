package com.yanesh.evaluator.questionetl.extractor;

import com.yanesh.evaluator.commonlibrary.models.Answer;
import com.yanesh.evaluator.commonlibrary.models.Question;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Slf4j
public abstract class AbstractReader implements Reader {

    public FileInputStream retrieveFile(String fileLocation) throws FileNotFoundException {
        log.info("Reading file: {}", fileLocation);
        return new FileInputStream(fileLocation);
    }

    public Question constructQuestion(int id, String question, List<Answer> answers, List<String> tags) {
        return new Question(id, question, answers, tags);
    }
}
