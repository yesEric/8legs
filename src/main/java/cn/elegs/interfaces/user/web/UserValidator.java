package cn.elegs.interfaces.user.web;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 用户信息前端校验.
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return RegistrationCommand.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "username", "username.not.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.not.empty");
    }
}
