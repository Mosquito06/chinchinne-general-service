package com.chinchinne.generalservice.exception;

import com.chinchinne.generalservice.model.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException
{
    private final ErrorCode errorCode;
}
