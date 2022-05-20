package com.user.exception.handler;

import com.user.exception.UserAlreadyExistException;
import com.user.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserNotFoundExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<Object>("User Not Found !!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<Object> exception(UserAlreadyExistException userAlreadyExistException) {
        return new ResponseEntity<Object>("User Already Exist With this Office ID !!", HttpStatus.ALREADY_REPORTED);
    }

}