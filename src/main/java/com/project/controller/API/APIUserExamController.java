package com.project.controller.API;

import com.project.constants.UrlConstants;
import com.project.controller.AbtractController;
import com.project.entity.Exam;
import com.project.entity.User;
import com.project.entity.UserExam;
import com.project.form.UserExamForm;
import com.project.response.APIResponse;
import com.project.service.ExamService;
import com.project.service.UserService;
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
@Api(value = "APIUserExamController", description = "APIUserExamController")
public class APIUserExamController extends AbtractController {

     @Autowired
     private   ExamService  examService ;

     @Autowired
     private UserService userService;

    @PostMapping(value = UrlConstants.URI_USER_EXAM)
    @ApiOperation(value = "createUserExamQuestion", response = Object.class)
    ResponseEntity<APIResponse> createUserExam(@RequestBody UserExamForm userExamForm, Principal principal){

        Exam exam = examService.findbyId(userExamForm.getExamId());
        existingValidator.validateNullOrEmpty(exam,"exam");

        User user = userService.findById(userExamForm.getUserId());
        existingValidator.validateNullOrEmpty(user,"user");

        UserExam userExam = new UserExam() ;
        userExam.setExpectPoint(userExamForm.getExpectPoint());
        userExam.setExam(exam);
        userExam.setUser(user);
        userExam.setImmediatelyResult(userExamForm.getImmediatelyResult());

        return responseUtil.successResponse("OKE");
    }
}
