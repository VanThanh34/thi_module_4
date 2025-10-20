package com.example.thi_module_4.validation;

import com.example.thi_module_4.dto.PromoDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class DateRangeValidator implements ConstraintValidator<ValidDateRange, PromoDto> {

    @Override
    public boolean isValid(PromoDto dto, ConstraintValidatorContext context) {
        if (dto.getDateStart() == null || dto.getDateEnd() == null) {
            return true; // để NotNull xử lý riêng
        }

        boolean valid = dto.getDateEnd().isAfter(dto.getDateStart().plusDays(0));

        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Ngày kết thúc phải sau ngày bắt đầu ít nhất 1 ngày")
                    .addPropertyNode("dateEnd")
                    .addConstraintViolation();
        }

        return valid;
    }
}
