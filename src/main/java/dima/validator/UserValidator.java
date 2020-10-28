package dima.validator;

import dima.controller.dto.UserDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.Locale;

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
            String message = messageSource.getMessage("username.empty", new Object[]{}, Locale.getDefault());
            errors.rejectValue("username", "username.empty", message);
        }

        if (errors.hasErrors()) return;

        if (!userForm.getPassword().equals(userForm.getRepeatPassword())) {
            logger.error("passwords mismatch ");
            errors.rejectValue("repeatPassword", "password.mismatch", "Пароли не совпадают");
        }

        if (errors.hasErrors()) return;
    }
}
