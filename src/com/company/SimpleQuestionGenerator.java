package com.company;

import java.util.ArrayList;
import java.util.List;

public class SimpleQuestionGenerator implements QuestionGenerator {

    @Override
    public List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Czy Polska leży w Europie", true));
        questions.add(new Question("Czy Polska to kontynent", false));
        questions.add(new Question("3+2=5", true));
        questions.add(new Question("Czy Londyn to miasto", true));
        questions.add(new Question("Czy to ostatnie pytanie", true));
        return questions;
    }

}

