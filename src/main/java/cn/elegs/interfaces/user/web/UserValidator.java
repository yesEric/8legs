package cn.elegs.interfaces.user.web;

import org.apache.regexp.RE;
import org.apache.regexp.RECompiler;
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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.not.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.not.empty");

        String username = (String) errors.getFieldValue("username");
        String password = (String) errors.getFieldValue("password");

        RE re = new RE();
        RECompiler compiler = new RECompiler();
        re.setProgram(compiler.compile("^[a-zA-Z]\\w{5,24}$"));
        if (!re.match(username)) {
            errors.reject("username", "username.mismatch");
        }
        re.setProgram(compiler.compile("^[a-zA-Z]\\w{5,17}$"));
        if (!re.match(username)) {
            errors.reject("password", "password.mismatch");
        }
    }
}
