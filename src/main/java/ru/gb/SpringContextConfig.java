package ru.gb;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gb.Service.impl.CustomerDaoImpl;
import ru.gb.Service.impl.ProductDaoImpl;
import ru.gb.core.EntityCore;


@Configuration
public class SpringContextConfig {

    @Bean
    public EntityCore entityCore() {return new EntityCore();}

    @Bean

    public CustomerDaoImpl customer() {return new CustomerDaoImpl();}

    @Bean
    public ProductDaoImpl product() {return new ProductDaoImpl();}


}
