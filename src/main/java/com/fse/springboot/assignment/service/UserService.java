/**
 * 
 */
package com.fse.springboot.assignment.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import com.fse.springboot.assignment.persistance.model.PasswordResetToken;
import com.fse.springboot.assignment.persistance.model.User;
import com.fse.springboot.assignment.persistance.model.VerificationToken;
import com.fse.springboot.assignment.web.dto.UserDto;
import com.fse.springboot.assignment.web.error.UserAlreadyExistException;

/**
 * @author Anirban Majumdar
 *
 */
public interface UserService {
	
	    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;

	    User getUser(String verificationToken);

	    void saveRegisteredUser(User user);

	    void deleteUser(User user);

	    void createVerificationTokenForUser(User user, String token);

	    VerificationToken getVerificationToken(String VerificationToken);

	    VerificationToken generateNewVerificationToken(String token);

	    void createPasswordResetTokenForUser(User user, String token);

	    User findUserByEmail(String email);

	    PasswordResetToken getPasswordResetToken(String token);

	    User getUserByPasswordResetToken(String token);

	    Optional<User> getUserByID(long id);

	    void changeUserPassword(User user, String password);

	    boolean checkIfValidOldPassword(User user, String password);

	    String validateVerificationToken(String token);

	    String generateQRUrl(User user) throws UnsupportedEncodingException;

	    User updateUser2FA(boolean use2FA);

	    List<String> getUsersFromSessionRegistry();

}
