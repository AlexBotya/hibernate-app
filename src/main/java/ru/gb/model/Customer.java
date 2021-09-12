package ru.gb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table
public class Customer {
    @Id
    private int id;
    @Column
    private String name;
    @Column
    @OneToMany
    private List<Product> products;

    public Customer(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
}
