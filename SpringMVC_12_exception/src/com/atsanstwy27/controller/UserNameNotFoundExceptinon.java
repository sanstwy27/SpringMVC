package com.atkjs927.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "用戶被拒絕登入", value = HttpStatus.NOT_ACCEPTABLE)
public class UserNameNotFoundExceptinon extends RuntimeException{

    private static final long serialVersionUID = 1L;
}


