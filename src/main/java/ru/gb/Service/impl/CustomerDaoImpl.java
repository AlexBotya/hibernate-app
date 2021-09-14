package ru.gb.Service.impl;

import ru.gb.Service.CustomerDao;

import ru.gb.core.EntityCore;
import ru.gb.model.Customer;
import ru.gb.model.Product;

import javax.persistence.EntityManager;


import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    EntityCore core = new EntityCore();
    EntityManager entityManager = core.start();
    @Override
    public void remove(int id) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        if (product!=null) entityManager.remove(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Product> findAll() {
        return entityManager
                .createQuery("select product from Product as product", Product.class)
                .getResultList();
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }


    @Override
    public Customer saveOrUpdate(Customer customer) {

        int idOfFind = customer.getId();
        Customer customerFromDbIfExistOrNull = entityManager.find(Customer.class, idOfFind);

        if (customerFromDbIfExistOrNull == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return customer;
        }
        else return customerFromDbIfExistOrNull;
    }
}
