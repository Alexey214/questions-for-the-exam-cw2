package pro.sky.java.cw2.QuestionsForTheExamCW.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.cw2.QuestionsForTheExamCW.data.Question;
import pro.sky.java.cw2.QuestionsForTheExamCW.repository.QuestionRepository;
import pro.sky.java.cw2.QuestionsForTheExamCW.service.QuestionService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public JavaQuestionServiceImpl(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question getRandomQuestion() {
        Question questionTmp;
        if (questionRepository.getAll().isEmpty()) {
            return questionTmp = new Question("ОШИБКА", "ОШИБКА");
        }
        Random random = new Random();
        int rand = random.nextInt(questionRepository.getAll().size());
        List<Question> questionList = questionRepository.getAll().stream().collect(Collectors.toList());
        return questionTmp = questionList.get(rand);
    }
}
