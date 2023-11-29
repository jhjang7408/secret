package com.secret.dessertmap.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="dessert")
public class DessertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dessertId;

    @Column
    private String shopId;

    @Column
    private String dessertName;

    @Column
    private int dessertPrice;


}
