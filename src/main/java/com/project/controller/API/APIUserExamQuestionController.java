package com.project.controller.API;

import com.project.constants.UrlConstants;
import com.project.controller.AbtractController;
import com.project.entity.ExamQuestion;
import com.project.entity.UserExam;
import com.project.entity.UserExamQuestion;
import com.project.entity.UserExamQuestionNormalAnswer;
import com.project.form.UserExamQuestionNormalAnswerForm;
import com.project.response.APIResponse;
import com.project.service.ExamQuestionService;
import com.project.service.UserExamQuestionNormalAnswerService;
import com.project.service.UserExamQuestionService;
import com.project.service.UserExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value= UrlConstants.URI_API)
@Api(value = "APIUserExamQuestionController", description = "APIUserExamQuestionController")
public class APIUserExamQuestionController extends AbtractController {

    @Autowired
    private ExamQuestionService examQuestionService;


    @Autowired
    private UserExamQuestionService userExamQuestionService;

    @Autowired
    private UserExamQuestionNormalAnswerService userExamQuestionNormalAnswerService;

    @Autowired
    private UserExamService userExamService;

    @PostMapping(value = UrlConstants.URI_USER_EXAM_QUESTION)
    @ApiOperation(value = "createUserExamQuestion", response = Object.class)
    ResponseEntity<APIResponse> createUserExamQuestion(@RequestBody UserExamQuestionNormalAnswerForm questionNormalAnswerForm , Principal principal){

        ExamQuestion ob = examQuestionService.findById(questionNormalAnswerForm.getExamQuestionId());
        existingValidator.validateNullOrEmpty(ob,"ExamQuestion");

        UserExam userExam = userExamService.findById(questionNormalAnswerForm.getUserExamId());
        existingValidator.validateNullOrEmpty(userExam,"UserExam");

        UserExamQuestion userExamQuestion = new UserExamQuestion();
        userExamQuestion.setUserExam(userExam);
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
