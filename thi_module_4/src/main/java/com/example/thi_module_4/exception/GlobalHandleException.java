package com.example.thi_module_4.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(PromoNotFoundException.class)
    public String handlePromoNotFound(PromoNotFoundException ex, Model model) {
        model.addAttribute("message", " Không tìm thấy khuyến mãi");
        return "error";
    }
}
