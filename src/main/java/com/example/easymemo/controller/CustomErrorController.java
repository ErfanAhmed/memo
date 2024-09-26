package com.example.easymemo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import static java.util.Objects.isNull;

/**
 * @author erfan
 * @since 2/20/23
 */
@RestController
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public ResponseEntity<?> handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (isNull(status)) {
            //todo: can status be null??
        }

        HttpStatus httpStatus = HttpStatus.resolve(Integer.valueOf(status.toString()));

        return new ResponseEntity<>("Hmm something is wrong!", httpStatus);
    }
}
