package com.yanesh.evaluator.questionetl.importer;

import com.yanesh.evaluator.commonlibrary.models.Question;
import com.yanesh.evaluator.commonlibrary.repository.QuestionRepository;
import com.yanesh.evaluator.questionetl.extractor.Reader;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class QuestionImporter implements Importer {

    @Value("${etl.reader.excel.file")
    private String fileLocation;

    private final Reader reader;
    private final QuestionRepository questionRepository;

    @Override
    public void importData() {
        try {
            FileInputStream file = reader.retrieveFile(fileLocation);
            List<Question> questionList = reader.read(file);
            save(questionList);
        } catch (FileNotFoundException e) {
            log.error("File not found on path: {}", fileLocation);
        } catch (IOException e) {
            log.error("Fail to read data from file");
        }
    }

    @Override
    public void save(List<Question> questionList) {
        questionList.forEach(questionRepository::save);
    }
}
