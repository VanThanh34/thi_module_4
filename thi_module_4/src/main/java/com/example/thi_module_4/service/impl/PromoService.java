package com.example.thi_module_4.service.impl;

import com.example.thi_module_4.entity.Promo;
import com.example.thi_module_4.repository.IPromoRepository;
import com.example.thi_module_4.service.IPromoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PromoService implements IPromoService {
    private final IPromoRepository promoRepository;
    @Override
    public List<Promo> findAll() {
        return promoRepository.findAll();
    }

    @Override
    public void save(Promo promo) {
        promoRepository.save(promo);
    }

    @Override
    public Promo findById(Integer id) {
        return promoRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Promo existingPromo) {
        promoRepository.save(existingPromo);
    }

    @Override
    public void delete(Integer id) {
        if (promoRepository.existsById(id)) {
            promoRepository.deleteById(id);
        }
    }

    @Override
    public List<Promo> findByPrice(Double price) {
        return promoRepository.findAllByPriceIs(price);
    }

    @Override
    public List<Promo> findByDate(LocalDate dateStart) {
        return promoRepository.findAllByDateStartIs(dateStart);
    }

    @Override
    public List<Promo> findByDateEnd(LocalDate dateEnd) {
        return promoRepository.findAllByDateEndIs(dateEnd);
    }
}
