package ru.gb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.gb.Service.CustomerDao;
import ru.gb.Service.impl.CustomerDaoImpl;


import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table
public class Customer extends CustomerDaoImpl {
    @Id
    private int id;
    @Column
    private String name;
    @Column
    @OneToMany(mappedBy = "Customer", cascade = CascadeType.ALL)
    private List<Product> products;

    public Customer(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
}
