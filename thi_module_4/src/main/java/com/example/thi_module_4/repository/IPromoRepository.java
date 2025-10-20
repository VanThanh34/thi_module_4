package com.example.thi_module_4.repository;

import com.example.thi_module_4.entity.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPromoRepository extends JpaRepository<Promo, Integer> {
    List<Promo> findAllByPriceIs(Double price);

    List<Promo> findAllByDateStartIs(LocalDate dateStart);

    List<Promo> findAllByDateEndIs(LocalDate dateEnd);
}
