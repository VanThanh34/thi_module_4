package com.example.thi_module_4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;
    @Column(name ="date_start")
    private LocalDate dateStart;
    @Column(name ="date_end")
    private LocalDate dateEnd;
    @Column(name = "price")
    private double price;
    @Column(name = "detail")
    private String detail;
}
