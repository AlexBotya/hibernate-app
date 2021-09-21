package ru.gb.Service.impl;

import org.hibernate.cfg.Configuration;
import ru.gb.Service.ProductDao;
import ru.gb.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .buildSessionFactory();
    EntityManager entityManager = factory.createEntityManager();

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
    public Product saveOrUpdate(Product product) {

        int idOfFind = product.getId();
        Product productFromDbIfExistOrNull = entityManager.find(Product.class, idOfFind);

        if (productFromDbIfExistOrNull == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            return product;
        }
        else return productFromDbIfExistOrNull;
    }
}
