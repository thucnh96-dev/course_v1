package com.project.controller.API;

import com.project.Validator.ExamValidator;
import com.project.constants.UrlConstants;
import com.project.controller.AbtractController;
import com.project.entity.Exam;
import com.project.form.ExamForm;
import com.project.response.APIResponse;
import com.project.service.ExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "APIExamController", description = "APIExamController")
public class APIExamController extends AbtractController {

    @Autowired
    private ExamService examService;

    @Autowired
    @Qualifier("examValidator")
    private ExamValidator examValidator;

    @PostMapping(value = UrlConstants.URI_EXAM)
    @ApiOperation(value = "createUserExamQuestion", response = Object.class)
    ResponseEntity<APIResponse> createUserExamQuestion(@RequestBody ExamForm examForm , Principal principal){

        examValidator.validate(examForm);
        Exam exam  = examService.findByName(examForm.getTitle());
        existingValidator.validate(exam,"Exam");

        Exam saved = new Exam();
        saved.setTitle(examForm.getTitle());
        saved.setUser(this.realUser(principal));
        saved.setStartAt(examForm.getStartAt());
        saved.setEndAt(examForm.getEndAt());
        saved.setAnnounceAt(examForm.getAnnounceAt());
        if (examForm.getExamCutoffTime()!=null && examForm.getExamCutoffTime() ){
            saved.setExamCutoffTime(true);
            saved.setQuestionAverageTime(examForm.getQuestionAverageTime());
        }else{
            saved.setExamCutoffTime(false);
            saved.setQuestionAverageTime(null);
        }
        saved = examService.save(saved);

        return responseUtil.successResponse("OKE");
    }


}
