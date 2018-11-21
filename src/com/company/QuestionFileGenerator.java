package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionFileGenerator implements QuestionGenerator {

    @Override
    public List<Question> generateQuestions() {
        String fileName = "questions.txt";

        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Question> questionsList = new ArrayList<>();
        for (String line : list) {
            String content = line.substring(0, line.indexOf('?') + 1);
            if (line.contains("TAK")) {
                questionsList.add(new Question(content, true));
            }
            if (line.contains("NIE")) {
                questionsList.add(new Question(content, false));
            }
        }
        return questionsList;
    }
}