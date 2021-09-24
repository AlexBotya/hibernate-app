package ru.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.Service.ProductDao;

import ru.gb.model.Product;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products/mvc")
public class ProductMVCController {
    private final ProductDao repository;

    public ProductMVCController(ProductDao repository) {
        this.repository = repository;
    }

    @GetMapping
        public String findAll(Model model) {


        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        model.addAttribute("products", repository.findAll());
        return "products";
    }



    @PostMapping
    public String save(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product-add";
        }

        repository.save(product);
        return "redirect:/products/mvc";
    }
}
