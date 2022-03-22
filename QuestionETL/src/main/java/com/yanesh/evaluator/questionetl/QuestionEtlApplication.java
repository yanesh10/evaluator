package com.yanesh.evaluator.questionetl;

import com.yanesh.evaluator.questionetl.importer.Importer;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
@AllArgsConstructor
public class QuestionEtlApplication implements CommandLineRunner {

    private final Importer importer;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(QuestionEtlApplication.class);
        app.run(args);

    }

    @Override
    public void run(String... args) throws Exception {
        importer.importData();
        exit(0);
    }

}
