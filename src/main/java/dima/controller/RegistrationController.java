package dima.controller;

import dima.controller.dto.UserDto;
import dima.service.RegistrationService;
import dima.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private static final Logger logger = LogManager.getLogger(RegistrationController.class.getName());

    private RegistrationService registrationService;
    private final UserValidator userValidator;

    @Autowired
    public RegistrationController(RegistrationService registrationService, UserValidator userValidator) {
        this.registrationService = registrationService;
        this.userValidator = userValidator;
    }

    //Post запрос Регистрация пользователя и получение списка всех зарегистрированных пользователей
    @RequestMapping(method = RequestMethod.POST)
    public UserDto userRegistration(@Validated @RequestBody UserDto userDto, BindingResult result) {

        if (result.hasErrors()) {
            userDto.setErrors(result.getAllErrors());
            return userDto;
        }

        registrationService.regStudent(userDto);
        return userDto;
    }

    @ModelAttribute
    public UserDto userDto() {
        return new UserDto();
    }

    @InitBinder(value = "userDto")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

}
