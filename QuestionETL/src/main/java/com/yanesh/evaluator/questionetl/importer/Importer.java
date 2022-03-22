package com.yanesh.evaluator.questionetl.importer;

import com.yanesh.evaluator.commonlibrary.models.Question;

import java.util.List;

public interface Importer {

    void importData();

    void save(List<Question> questionList);

}
