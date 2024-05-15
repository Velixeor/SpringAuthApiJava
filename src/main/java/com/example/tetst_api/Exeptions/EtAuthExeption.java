package com.example.tetst_api.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EtAuthExeption extends RuntimeException {
    public EtAuthExeption(String message){
    super(message);
    }


}
