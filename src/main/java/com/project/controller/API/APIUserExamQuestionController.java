package com.project.controller.API;

import com.project.Validator.ExistingValidator;
import com.project.constants.UrlConstants;
import com.project.controller.AbtractController;
import com.project.entity.ExamQuestion;
import com.project.entity.UserExamQuestion;
import com.project.entity.UserExamQuestionNormalAnswer;
import com.project.form.UserExamQuestionNormalAnswerForm;
import com.project.response.APIResponse;
import com.project.service.ExamQuestionService;
import com.project.service.UserExamQuestionNormalAnswerService;
import com.project.service.UserExamQuestionService;
import com.project.service.UserExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value= UrlConstants.URI_API)
public class APIUserExamQuestionController extends AbtractController {


    @Autowired
    private ExamQuestionService examQuestionService;


    @Autowired
    private UserExamQuestionService userExamQuestionService;

    @Autowired
    private UserExamQuestionNormalAnswerService userExamQuestionNormalAnswerService;

    @PostMapping(value = UrlConstants.URI_USER_EXAM_QUESTION)
    ResponseEntity<APIResponse> createUserExamQuestion(@RequestBody UserExamQuestionNormalAnswerForm questionNormalAnswerForm , Principal principal){

        ExamQuestion ob = examQuestionService.findById(questionNormalAnswerForm.getExamQuestionId());
        existingValidator.validateNullOrEmpty(ob,"ExamQuestion");

        UserExamQuestion userExamQuestion = new UserExamQuestion();

        userExamQuestion.setUser(this.realUser(principal));
        userExamQuestion.setAnswered(true);
        userExamQuestion.setExamQuestion(ob);

        userExamQuestion = userExamQuestionService.save(userExamQuestion);

        UserExamQuestionNormalAnswer questionNormalAnswer = new UserExamQuestionNormalAnswer();
        questionNormalAnswer.setUserAnswer(questionNormalAnswerForm.getUserAnswer());
        questionNormalAnswer.setUserExamQuestion(userExamQuestion);
        userExamQuestionNormalAnswerService.save(questionNormalAnswer);

        if (questionNormalAnswer.getUserAnswer().equals( ob.getQuestion().getQuestionNormal().getAnswerCorect().toString() ) ){
            userExamQuestion.setCorrect(true);
        }else {
            userExamQuestion.setCorrect(false);
        }
        userExamQuestion = userExamQuestionService.save(userExamQuestion);

        return responseUtil.successResponse("OKE");
    }
}
