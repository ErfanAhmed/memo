package com.example.easymemo.exceptionHandler;

import com.example.easymemo.model.CustomFieldError;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author erfan
 * @since 2/13/23
 */
@Component
public class ExceptionHandlerUtil {

    public List<CustomFieldError> handleCustomFieldErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(e -> new CustomFieldError(e.getField(), e.getDefaultMessage()))
                .collect(Collectors.toList());

    }
}
