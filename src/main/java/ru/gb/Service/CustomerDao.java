package ru.gb.Service;

import ru.gb.model.Customer;
import ru.gb.model.Product;

import java.util.List;

public interface CustomerDao {
    void remove(int id);
    List<Product> findAll();
    Product findById(int id);
    Product saveOrUpdate(Customer customer);
}
