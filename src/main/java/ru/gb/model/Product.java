package ru.gb.model;

import lombok.*;
import ru.gb.Service.impl.ProductDaoImpl;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "products")

public class Product extends ProductDaoImpl {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "title", length = 30)
    private String title;
    @Column(name = "price")
    private int price;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable  = false)
    private Customer customer;

    public Product(String title, int price, Customer customer) {
        this.title = title;
        this.price = price;
        this.customer = customer;
    }

    public void setId(int id) {
        this.id = id;
    }
}
