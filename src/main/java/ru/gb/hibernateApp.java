package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.gb.Service.impl.CustomerDaoImpl;
import ru.gb.Service.impl.ProductDaoImpl;


public class hibernateApp {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringContextConfig.class);


        CustomerDaoImpl customerDao = context.getBean(CustomerDaoImpl.class);

        ProductDaoImpl productDao = context.getBean(ProductDaoImpl.class);


    }
}
