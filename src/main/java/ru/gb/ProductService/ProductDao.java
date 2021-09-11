package ru.gb.ProductService;

import ru.gb.model.Product;

import java.util.List;

public interface ProductDao {


    void remove(int id);
    List<Product> findAll();
    Product findById(int id);
    Product saveOrUpdate(Product product);
}
