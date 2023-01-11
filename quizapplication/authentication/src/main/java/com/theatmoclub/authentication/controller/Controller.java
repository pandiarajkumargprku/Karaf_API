package com.theatmoclub.authentication.controller;

import com.theatmoclub.authentication.model.User;
import com.theatmoclub.authentication.service.Service;
import com.theatmoclub.authentication.service.ServiceImplements;

/**
 * <h1>Controller</h1>
 *
 *   <p> This Controller getting the request and
 *      gives in to the service.
 *  /p>
 *
 *   @author pandiaraj kumarG
 */
public class Controller {

    private static final Service SERVICE = new ServiceImplements();

    /**
     * Checks the email of user and admin from database
     *
     * @param choice
     * @param email
     */
    public static boolean checkEmail(final int choice, final String email) {
        return SERVICE.checkEmail(choice, email);
    }

    /**
     * Checks the password of user and admin from database
     *
     * @param choice
     * @param password
     */
    public static boolean checkPassword(final int choice, final String password) {
        return SERVICE.checkPassword(choice, password);
    }

    /**
     * SignUp admin and user details
     *
     * @param choice
     * @param user
     */
    public static boolean signUpInsert(final int choice, final User user) {
        return SERVICE.insertSignUpDetail(choice, user);
    }
    
    /**
     * SignUp admin and user details
     *
     * @param choice
     * @param user
     */
    public static boolean signUpInsert(final int choice, final User user) {
        return SERVICE.insertSignUpDetail(choice, user);
    }
}
