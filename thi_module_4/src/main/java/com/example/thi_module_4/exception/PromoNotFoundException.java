package com.example.thi_module_4.exception;

import com.example.thi_module_4.dto.PromoDto;

public class PromoNotFoundException extends RuntimeException{
    public PromoNotFoundException(String message){
        super(message);
    }
}
