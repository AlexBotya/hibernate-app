package ru.gb.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "title", length = 30)
    private String title;
    @Column(name = "price")
    private int price;

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
}
