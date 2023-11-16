package com.secret.dessertmap.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="shop")
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shopId;

    @Column
    private String shopName;

    @Column
    private String memberId;

    @Column
    private int shopPhoneNum;

    @Column
    private String shopAddress;

}
