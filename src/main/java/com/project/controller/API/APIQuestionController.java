package com.project.controller.API;

import com.project.validator.Questionvalidator;
import com.project.constants.CommonConstants;
import com.project.constants.UrlConstants;
import com.project.controller.AbtractController;
import com.project.entity.Exam;
import com.project.entity.ExamQuestion;
import com.project.entity.Question;
import com.project.entity.QuestionNormal;
import com.project.form.QuestionForm;
import com.project.response.APIResponse;
import com.project.service.ExamQuestionService;
import com.project.service.ExamService;
import com.project.service.QuestionNormalService;
import com.project.service.QuestionService;
import com.project.utils.Common;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value= UrlConstants.URI_API)
@Api(value = "APIQuestionController", description = "APIQuestionController")
public class APIQuestionController extends AbtractController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamQuestionService examQuestionService;

    @Autowired
    private QuestionNormalService questionNormalService;

    @Autowired
    @Qualifier("questionvalidator")
    private Questionvalidator questionvalidator;

    @PostMapping(value = UrlConstants.URI_QUESTION)
    @ApiOperation(value = "createQuestion", response = Object.class)
    ResponseEntity<APIResponse> createQuestion(@RequestBody QuestionForm questionForm, Principal principal) {

        questionvalidator.validate(questionForm);

        Exam  exam = examService.findbyId(questionForm.getExamId());
        existingValidator.validateNullOrEmpty(exam,"Exam");
        Question question = new Question();
        question.setExplan(questionForm.getExplan());
        question.setQuestionName(questionForm.getQuestionName());

        if (CommonConstants.Difficulty.HIGH.toString().equals(questionForm.getDifficulty())){
            question.setDifficulty(CommonConstants.Difficulty.HIGH);
        }
        if (CommonConstants.Difficulty.ALL.toString().equals(questionForm.getDifficulty())){
            question.setDifficulty(CommonConstants.Difficulty.ALL);
        }
        if (CommonConstants.Difficulty.HIGH.toString().equals(questionForm.getDifficulty())){
            question.setDifficulty(CommonConstants.Difficulty.HIGH);
        }
        if (CommonConstants.Difficulty.MIDDLE.toString().equals(questionForm.getDifficulty())){
            question.setDifficulty(CommonConstants.Difficulty.MIDDLE);
        }
        if (CommonConstants.Difficulty.LOW.toString().equals(questionForm.getDifficulty())){
            question.setDifficulty(CommonConstants.Difficulty.LOW);
        }
        question.setCreateAt(new Date());
        question  =  questionService.save(question);

        QuestionNormal questionNormal = new QuestionNormal();
        questionNormal.setQuestion(question);
        questionNormal.setAnswer1(questionForm.getAnswer1());
        questionNormal.setAnswer2(questionForm.getAnswer2());
        questionNormal.setAnswer3(questionForm.getAnswer3());
        questionNormal.setAnswer4(questionForm.getAnswer4());

        if (CommonConstants.QuestionNormalCorect.answer1.toString().equals(questionForm.getAnswerCorect())){
            questionNormal.setAnswerCorect(CommonConstants.QuestionNormalCorect.answer1);
        }
        if (CommonConstants.QuestionNormalCorect.answer2.toString().equals(questionForm.getAnswerCorect())){
            questionNormal.setAnswerCorect(CommonConstants.QuestionNormalCorect.answer2);
        }
        if (CommonConstants.QuestionNormalCorect.answer3.toString().equals(questionForm.getAnswerCorect())){
            questionNormal.setAnswerCorect(CommonConstants.QuestionNormalCorect.answer3);
        }
        if (CommonConstants.QuestionNormalCorect.answer4.toString().equals(questionForm.getAnswerCorect())){
            questionNormal.setAnswerCorect(CommonConstants.QuestionNormalCorect.answer4);
        }

        questionNormal.setCreateAt(new Date());
        questionNormal = questionNormalService.save(questionNormal);


        ExamQuestion examQuestion = new ExamQuestion();
        examQuestion.setExam(exam);
        examQuestion.setQuestion(question);
        examQuestion.setCreateAt(new Date());

        examQuestion = examQuestionService.save(examQuestion);

        return responseUtil.successResponse("OKE");

    }

    @PostMapping(value = UrlConstants.URI_QUESTION + UrlConstants.URI_EXAM_ID)
    @ApiOperation(value = "createQuestionList", response = Object.class)
    ResponseEntity<APIResponse> createQuestionList( @PathVariable("examId") Long examId, @RequestBody List<QuestionForm> questionForms ) {

        questionvalidator.validate(questionForms);

        Exam  exam = examService.findbyId(examId);
        existingValidator.validateNullOrEmpty(exam,"Exam");

        String questionCode = null;
        Long questionGroup = null;

        if (questionForms.get(0).getAutoGen() !=null && questionForms.get(0).getAutoGen() && questionForms.get(0).getNumber()  > 1  ){

            questionCode  = Common.numberGenerator();
            questionGroup = Common.numberGeneratorLong();
        }

        List<Question> saves  = new ArrayList<>();

        for(QuestionForm questionForm : questionForms){

            // init  Question Entity
            Question question = new Question();
            question.setCreateAt(new Date());
            question.setExplan(questionForm.getExplan());
            question.setQuestionName(questionForm.getQuestionName());

            if (CommonConstants.Difficulty.HIGH.toString().equals(questionForm.getDifficulty())){
                question.setDifficulty(CommonConstants.Difficulty.HIGH);
            }
            if (CommonConstants.Difficulty.ALL.toString().equals(questionForm.getDifficulty())){
                question.setDifficulty(CommonConstants.Difficulty.ALL);
            }

            if (CommonConstants.Difficulty.MIDDLE.toString().equals(questionForm.getDifficulty())){
                question.setDifficulty(CommonConstants.Difficulty.MIDDLE);
            }
            if (CommonConstants.Difficulty.LOW.toString().equals(questionForm.getDifficulty())){
                question.setDifficulty(CommonConstants.Difficulty.LOW);
            }

           // question  =  questionService.save(question);

            QuestionNormal questionNormal = new QuestionNormal();
            questionNormal.setCreateAt(new Date());
            questionNormal.setQuestion(question);
            questionNormal.setAnswer1(questionForm.getAnswer1());
            questionNormal.setAnswer2(questionForm.getAnswer2());
            questionNormal.setAnswer3(questionForm.getAnswer3());
            questionNormal.setAnswer4(questionForm.getAnswer4());

            // QuestionNormal Corect
            if (CommonConstants.QuestionNormalCorect.answer1.toString().equals(questionForm.getAnswerCorect())){
                questionNormal.setAnswerCorect(CommonConstants.QuestionNormalCorect.answer1);
            }
            if (CommonConstants.QuestionNormalCorect.answer2.toString().equals(questionForm.getAnswerCorect())){
                questionNormal.setAnswerCorect(CommonConstants.QuestionNormalCorect.answer2);
            }
            if (CommonConstants.QuestionNormalCorect.answer3.toString().equals(questionForm.getAnswerCorect())){
                questionNormal.setAnswerCorect(CommonConstants.QuestionNormalCorect.answer3);
            }
            if (CommonConstants.QuestionNormalCorect.answer4.toString().equals(questionForm.getAnswerCorect())){
                questionNormal.setAnswerCorect(CommonConstants.QuestionNormalCorect.answer4);
            }
            //set QuestionNormal freign
            question.setQuestionNormal(questionNormal);
            saves.add(question); // init list on saved

        }
         saves =  questionService.save(saves);

      /*  questionNormal.setCreateAt(new Date());
        questionNormal = questionNormalService.save(questionNormal);

        ExamQuestion examQuestion = new ExamQuestion();
        examQuestion.setExam(exam);
        examQuestion.setQuestion(question);
        examQuestion.setCreateAt(new Date());
        examQuestion = examQuestionService.save(examQuestion);*/

        return responseUtil.successResponse(saves);

    }
}
