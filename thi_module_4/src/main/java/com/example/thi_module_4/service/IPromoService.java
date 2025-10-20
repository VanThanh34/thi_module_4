package com.example.thi_module_4.service;

import com.example.thi_module_4.entity.Promo;

import java.time.LocalDate;
import java.util.List;

public interface IPromoService {
    List<Promo> findAll();

    void save(Promo promo);

    Promo findById(Integer id);

    void update(Promo existingPromo);

    void delete(Integer id);

    List<Promo> findByPrice(Double price);

    List<Promo> findByDate(LocalDate dateStart);

    List<Promo> findByDateEnd(LocalDate dateEnd);
}
