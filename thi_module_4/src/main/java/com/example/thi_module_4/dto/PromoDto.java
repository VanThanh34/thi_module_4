package com.example.thi_module_4.dto;

import com.example.thi_module_4.validation.ValidDateRange;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ValidDateRange
public class PromoDto {
    private Integer id;

    @NotBlank(message = "Tiêu đề khuyến mãi không được để trống")
    private String title;

    @NotNull(message = "Mức giảm giá không được để trống và phải lớn hơn 10.000VND")
    @Min(10000)
    private double price;

    @NotNull(message = "Ngày bắt đầu không được để trống")
    @FutureOrPresent(message = "Ngày bắt đầu phải lớn hơn ngày hiện tại")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateStart;

    @NotNull(message = "Ngày kết thúc không được để trống")
    @FutureOrPresent(message = "Ngày kết thúc phải lớn hơn ngày bắt đầu ít nhất 1 ngày")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateEnd;

    @NotBlank(message = "Chi tiết khuyến mãi không được để trống")
    private String detail;
}
