package com.example.thi_module_4.controller;

import com.example.thi_module_4.dto.PromoDto;
import com.example.thi_module_4.entity.Promo;
import com.example.thi_module_4.exception.PromoNotFoundException;
import com.example.thi_module_4.service.IPromoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/promos")
@RequiredArgsConstructor
public class PromoController {
    private final IPromoService promoService;

    @GetMapping
    public String getAll(Model model) {
        List<Promo> promos = promoService.findAll();
        model.addAttribute("promos", promos);
        return "list";
    }

    @GetMapping("/create")
    public String createPromo(Model model) {
        model.addAttribute("promoDto", new PromoDto());
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("promoDto") PromoDto promoDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "create";
        }

        Promo s1 = new Promo();
        BeanUtils.copyProperties(promoDto, s1);
        promoService.save(s1);

        redirect.addFlashAttribute("message", " Thêm mới khuyến mãi thành công!");
        return "redirect:/promos";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Promo promo = promoService.findById(id);
        if (promo == null) {
            throw new PromoNotFoundException("Không tìm thấy khuyến mãi có ID: " + id);
        }

        PromoDto promoDto = new PromoDto();
        BeanUtils.copyProperties(promo, promoDto);

        model.addAttribute("promoDto", promoDto);
        return "update";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("promoDto") PromoDto promoDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirect,
                                Model model) {
        if (bindingResult.hasErrors()) {
            return "update";
        }

        Promo existingPromo = promoService.findById(promoDto.getId());
        if (existingPromo == null) {
            model.addAttribute("message", "Không tìm thấy khuyến mãi với ID: " + promoDto.getId());
            return "error";
        }

        BeanUtils.copyProperties(promoDto, existingPromo);
        promoService.update(existingPromo);

        redirect.addFlashAttribute("message", "Cập nhật sản phẩm thành công!");
        return "redirect:/promos";
    }

    @GetMapping("/delete/{id}")
    public String deletePromo(@PathVariable Integer id, RedirectAttributes redirect) {
        Promo promo = promoService.findById(id);
        if (promo == null) {
            redirect.addFlashAttribute("message", " Không tìm thấy khuyến mãi để xóa!");
            return "redirect:/promos";
        }
        promoService.delete(id);
        redirect.addFlashAttribute("message", " Xóa khuyến mãi thành công!");
        return "redirect:/promos";
    }

    @GetMapping("/search/price")
    public String searchProduct(@RequestParam("price") Double price, Model model) {
        List<Promo> promos = promoService.findByPrice(price);
        model.addAttribute("promos", promos);
        model.addAttribute("search", price);
        return "list";
    }

    @GetMapping("/search/dateStart")
    public String searchProductDateStart(@RequestParam("dateStart") LocalDate dateStart, Model model) {
        List<Promo> promos = promoService.findByDate(dateStart);
        model.addAttribute("promos", promos);
        model.addAttribute("search", dateStart);
        return "list";
    }

    @GetMapping("/search/dateEnd")
    public String searchProductDateEnd(@RequestParam("dateEnd") LocalDate dateEnd, Model model) {
        List<Promo> promos = promoService.findByDateEnd(dateEnd);
        model.addAttribute("promos", promos);
        model.addAttribute("search", dateEnd);
        return "list";
    }

}
