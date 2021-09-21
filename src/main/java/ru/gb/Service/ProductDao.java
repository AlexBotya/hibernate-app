package ru.gb.Service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.model.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

}
