package com.yanesh.evaluator.questionetl.extractor;

import com.yanesh.evaluator.commonlibrary.models.Answer;
import com.yanesh.evaluator.commonlibrary.models.Question;
import com.yanesh.evaluator.questionetl.exception.InvalidCellFormatException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.yanesh.evaluator.questionetl.constants.Constants.COMMA_SEPARATOR;

@Slf4j
@Service
public class ExcelReader extends AbstractReader {

    @Override
    public List<Question> read(FileInputStream file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        sheet.removeRow(sheet.getRow(0));
        List<Question> questionsList = new ArrayList<>();
        for (Row row : sheet) {
            String question = getCellValue(row, 0);
            List<Answer> answers = getAnswers(row);
            Answer validAnswer = new Answer(getCellValue(row, 5));
            List<String> tags = getTags(getCellValue(row, 6));
            questionsList.add(constructQuestion(question, answers, validAnswer, tags));
        }
        return questionsList;
    }

    private List<Answer> getAnswers(Row row) {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer(getCellValue(row, 1)));
        answers.add(new Answer(getCellValue(row, 2)));
        answers.add(new Answer(getCellValue(row, 3)));
        answers.add(new Answer(getCellValue(row, 4)));
        return answers;
    }

    private List<String> getTags(String tags){
        return Arrays.stream(tags.split(COMMA_SEPARATOR)).collect(Collectors.toList());
    }

    private String getCellValue(Row row, int i) {
        if (row.getCell(i).getCellType() == CellType.STRING) {
            return row.getCell(i).getStringCellValue();
        }
        throw new InvalidCellFormatException("Invalid Cell Format");
    }
}
