package ru.otus.hw.service;

import org.junit.jupiter.api.Test;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class TestServiceImplTest {

    @Test
    public void testExecuteTest() {
        IOService ioService = mock(IOService.class);
        QuestionDao questionDao = mock(QuestionDao.class);

        List<Question> questions = List.of(
                new Question("Question 1",
                        Arrays.asList(new Answer("Answer 1", true), new Answer("Answer 2", false))),
                new Question("Question 2",
                        Arrays.asList(new Answer("Answer 3", false), new Answer("Answer 4", true)))
        );

        when(questionDao.findAll()).thenReturn(questions);

        TestServiceImpl testService = new TestServiceImpl(ioService, questionDao);

        testService.executeTest();

        verify(ioService, times(1)).printLine("");
        verify(ioService, times(1)).printFormattedLine("Please answer the questions below%n");
        for (Question question : questions) {
            verify(ioService, times(1)).printLine(question.getQuestionText());
            for (Answer answer : question.getAnswerOptions()) {
                verify(ioService, times(1)).printLine(answer.text());
            }
        }
    }
}