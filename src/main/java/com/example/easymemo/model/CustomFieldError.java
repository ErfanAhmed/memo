package com.example.easymemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author erfan
 * @since 2/13/23
 */
@Data
@AllArgsConstructor
public class CustomFieldError {
    private String filedName;
    private String errorMsg;
}
