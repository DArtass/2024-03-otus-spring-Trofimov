package ru.otus.hw.domain;

import java.util.List;

public record Question(String text, List<Answer> answers) {
    public String getQuestionText() {
        return text();
    }

    public List<Answer> getAnswerOptions() {
        return answers();
    }
}
