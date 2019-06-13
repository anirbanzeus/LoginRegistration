package com.fse.springboot.assignment.security;

public interface SecurityUserService {

    String validatePasswordResetToken(long id, String token);

}
