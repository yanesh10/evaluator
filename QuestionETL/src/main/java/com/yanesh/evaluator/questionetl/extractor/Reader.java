package com.yanesh.evaluator.questionetl.extractor;

import com.yanesh.evaluator.commonlibrary.models.Question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Reader {

    FileInputStream retrieveFile(String fileLocation) throws FileNotFoundException;
    List<Question> read(FileInputStream file) throws IOException;

}
