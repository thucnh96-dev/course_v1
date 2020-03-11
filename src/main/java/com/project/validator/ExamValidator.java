package com.project.validator;

import com.project.form.ExamForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static org.springframework.util.Assert.isTrue;

@Component("examValidator")
public class ExamValidator extends AbstractThrowableValidator<ExamForm, IllegalArgumentException> {
    @Autowired
    private  ExistingValidator existingValidator;


    @Override
    public void validate(ExamForm examForm) throws IllegalArgumentException {
        existingValidator.validateNullOrEmpty(examForm.getTitle(),"Title");
        existingValidator.validateNullOrEmpty(examForm.getStartAt(),"StartAt");
        existingValidator.validateNullOrEmpty(examForm.getEndAt(),"EndAt");
        existingValidator.validateNullOrEmpty(examForm.getAnnounceAt(),"AnnounceAt");

        isTrue( examForm.getEndAt().after(examForm.getStartAt()) ,"Thời gian nhập không đúng." );

        isTrue( examForm.getStartAt().after(examForm.getAnnounceAt()) ,"Thời gian thông báo trước." );

    }
}
