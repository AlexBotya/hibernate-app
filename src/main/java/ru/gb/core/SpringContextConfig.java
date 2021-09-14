package ru.gb.core;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.gb.Service.impl.CustomerDaoImpl;
import ru.gb.Service.impl.ProductDaoImpl;
import ru.gb.model.Customer;
import ru.gb.model.Product;

@Configuration
public class SpringContextConfig {

    @Bean
    public EntityCore entityCore() {return new EntityCore();}

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Customer customer() {return new Customer();}
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public Product product() {return new Product();}


}
