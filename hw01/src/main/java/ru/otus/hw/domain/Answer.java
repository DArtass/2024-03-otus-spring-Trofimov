package ru.otus.hw.domain;

public record Answer(String text, boolean isCorrect) {
    public String getAnswerText() {
        return text();
    }

    public boolean isAnswerCorrect() {
        return isCorrect();
    }
}
