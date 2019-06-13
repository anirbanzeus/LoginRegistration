package com.fse.springboot.assignment.captcha;

import com.fse.springboot.assignment.web.error.ReCaptchaInvalidException;

public interface CaptchaService {
    void processResponse(final String response) throws ReCaptchaInvalidException;

    String getReCaptchaSite();

    String getReCaptchaSecret();
}
