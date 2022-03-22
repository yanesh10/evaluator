package com.yanesh.evaluator.questionetl.importer;

import com.yanesh.evaluator.commonlibrary.models.Question;
import com.yanesh.evaluator.commonlibrary.repository.QuestionRepository;
import com.yanesh.evaluator.questionetl.extractor.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class QuestionImporter implements Importer {

    @Value("${etl.reader.excel.file}")
    private String fileLocation;

    private final Reader reader;
    private final QuestionRepository questionRepository;

    public QuestionImporter(Reader reader, QuestionRepository questionRepository) {
        this.reader = reader;
        this.questionRepository = questionRepository;
    }

    @Override
    public void importData() {
        try {
            log.info("Starting Import Data");
            FileInputStream file = reader.retrieveFile(fileLocation);
            List<Question> questionList = reader.read(file);
            log.info("Extracted a list of {} questions", questionList.size());
            save(questionList);
            log.info("Import Data complete");
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
