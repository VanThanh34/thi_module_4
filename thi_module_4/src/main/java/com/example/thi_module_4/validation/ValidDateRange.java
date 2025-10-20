package com.example.thi_module_4.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateRangeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateRange {
    String message() default "Ngày kết thúc phải lớn hơn ngày bắt đầu ít nhất 1 ngày";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
