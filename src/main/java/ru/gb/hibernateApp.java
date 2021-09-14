package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.gb.core.SpringContextConfig;
import ru.gb.model.Customer;
import ru.gb.model.Product;

public class hibernateApp {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringContextConfig.class);

        Product product = context.getBean(Product.class);
        Customer customer = context.getBean(ru.gb.model.Customer.class);
        Customer customer2= context.getBean(ru.gb.model.Customer.class);


    }
}
