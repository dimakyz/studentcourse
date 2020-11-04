package dima.validator;

import dima.controller.dto.UserDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//Валидатор для регистрации
@Component
public class UserValidator implements Validator {
    private MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(UserValidator.class.getName());

    public UserValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userForm = (UserDto) target;
        if (userForm.getUsername().isEmpty()) {
            logger.error("username is empty");
            errors.rejectValue("username", "username.empty", "Error: username is empty");
            throw new ArithmeticException("usernameException");
        }

        if (errors.hasErrors()) return;

        if (userForm.getPassword().length() < 4) {
            logger.error("Weak Password. Need more than 4 simbols");
            errors.rejectValue("password", "password.low", "Weak Password");
            throw new IllegalArgumentException("illegalArgumentException");
        }

        if (errors.hasErrors()) return;

        if (!userForm.getPassword().equals(userForm.getRepeatPassword())) {
            logger.error("passwords mismatch ");
            errors.rejectValue("repeatPassword", "password.mismatch", "Пароли не совпадают");
        }

        if (errors.hasErrors()) return;
    }
}
