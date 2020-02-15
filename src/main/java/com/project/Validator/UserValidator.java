package com.project.Validator;

import com.project.form.UserFormRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import static org.springframework.util.Assert.isTrue;

@Component("userValidator")
public class UserValidator extends AbstractThrowableValidator<UserFormRegister, IllegalArgumentException> {

    @Autowired
    @Qualifier("existingValidator")
    private  ExistingValidator existingValidator;


    @Override
    public void validate(UserFormRegister userFormRegister) throws IllegalArgumentException {
        existingValidator.validateNullOrEmpty(userFormRegister.getUserName(),"userName");
        existingValidator.validateNullOrEmpty(userFormRegister.getPassWord(),"passWord");
        existingValidator.validateNullOrEmpty(userFormRegister.getPhone(),"phone");
        existingValidator.validateNullOrEmpty(userFormRegister.getRePassWord(),"rePassword");
        isTrue(userFormRegister.getPassWord().equalsIgnoreCase(userFormRegister.getRePassWord()),"Mật khẩu không khớp ");

    }
}
