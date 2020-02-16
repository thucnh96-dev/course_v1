package com.project.Validator;

import com.project.constants.CommonConstants;
import com.project.form.QuestionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import static org.springframework.util.Assert.isTrue;

@Component("questionvalidator")
public class Questionvalidator  extends AbstractThrowableValidator<QuestionForm , IllegalArgumentException> {

    @Autowired
    @Qualifier("existingValidator")
    private  ExistingValidator existingValidator;

    @Override
    public void validate(QuestionForm questionForm) throws IllegalArgumentException {

        existingValidator.validateNullOrEmpty(questionForm.getQuestionName(),"Vui lòng nhập tên cau hỏi.");
        existingValidator.validateNullOrEmpty(questionForm.getAnswer1(),"Vui lòng nhập đáp án 1.");
        existingValidator.validateNullOrEmpty(questionForm.getAnswer2(),"Vui lòng nhập đáp án 2.");
        existingValidator.validateNullOrEmpty(questionForm.getAnswer3(),"Vui lòng nhập đáp án 3.");
        existingValidator.validateNullOrEmpty(questionForm.getAnswer4(),"Vui lòng nhập đáp án 4.");

        existingValidator.validateNullOrEmpty(questionForm.getAnswerCorect(),"Vui lòng chọn đáp án đúng cho cau hỏi.");
        isTrue(CommonConstants.QuestionNormalCorect.valueOf(questionForm.getAnswerCorect())!=null,"Vui lòng chọn đáp án đúng cho cau hỏi.");
        existingValidator.validateNullOrEmpty(questionForm.getAnswerCorect(),"Vui lòng chọn đáp án đúng cho cau hỏi.");

    }

    public void validate(List<QuestionForm> questionForms) throws IllegalArgumentException {
        isTrue(questionForms == null && questionForms.isEmpty(),"Vui lòng nhập 1 câu hỏi");
        for (QuestionForm question : questionForms ){
            this.validate(question);
        }

    }


}
