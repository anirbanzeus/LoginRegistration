package com.fse.springboot.assignment.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fse.springboot.assignment.captcha.CaptchaServiceImpl;
import com.fse.springboot.assignment.persistance.model.User;
import com.fse.springboot.assignment.registration.OnRegistrationCompleteEvent;
import com.fse.springboot.assignment.service.UserService;
import com.fse.springboot.assignment.web.dto.UserDto;
import com.fse.springboot.assignment.web.util.GenericResponse;

@Controller
public class RegistrationCaptchaController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private CaptchaServiceImpl captchaService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public RegistrationCaptchaController() {
        super();
    }

    // Registration

    @RequestMapping(value = "/user/registrationCaptcha", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse captchaRegisterUserAccount(@Valid final UserDto accountDto, final HttpServletRequest request) {

        final String response = request.getParameter("g-recaptcha-response");
        captchaService.processResponse(response);

        LOGGER.debug("Registering user account with information: {}", accountDto);

        final User registered = userService.registerNewUserAccount(accountDto);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
        return new GenericResponse("success");
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

}
