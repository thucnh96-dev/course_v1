package com.project.controller.API;

import com.project.constants.UrlConstants;
import com.project.controller.AbtractController;
import com.project.entity.User;
import com.project.entity.UserExamQuestion;
import com.project.entity.UserExamQuestionNormalAnswer;
import com.project.form.UserAnswerQuestionRequest;
import com.project.response.APIResponse;
import com.project.service.UserExamQuestionNormalAnswerService;
import com.project.service.UserExamQuestionService;
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
@Api(value = "APIUser Answer Question", description = "APIUser Answer Question")
public class APIUserAnswerQuestion extends AbtractController {

    @Autowired
    UserExamQuestionService userExamQuestionService;

    @Autowired
    UserExamQuestionNormalAnswerService userExamQuestionNormalAnswerService;


    @PostMapping(value = UrlConstants.URI_USER_ANSWER_QUESTION)
    @ApiOperation(value = "answerQuestion", response = Object.class)
    ResponseEntity<APIResponse> answerQuestion(@RequestBody UserAnswerQuestionRequest userAnswerQuestionRequest, Principal principal) {

        User user = realUser(principal);
        existingValidator.validateNullOrEmpty(user,"Authentication fail");
        UserExamQuestion userExamQuestion =  userExamQuestionService.findById(userAnswerQuestionRequest.getUserExamQuestionId());
        existingValidator.validateNullOrEmpty(userExamQuestion,"UserExamQuestion fail");
        UserExamQuestionNormalAnswer userExamQuestionNormalAnswer = new UserExamQuestionNormalAnswer();
        userExamQuestionNormalAnswer.setUserAnswer(userAnswerQuestionRequest.getAnswer());
        userExamQuestionNormalAnswer.setUserExamQuestion(userExamQuestion);
        userExamQuestionNormalAnswer =  userExamQuestionNormalAnswerService.save(userExamQuestionNormalAnswer);

        return responseUtil.successResponse(userExamQuestionNormalAnswer);
    }

}
