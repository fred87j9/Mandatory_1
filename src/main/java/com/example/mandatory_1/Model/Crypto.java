package com.example.mandatory_1.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "cryptos")
@Entity
public class Crypto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private int price;
    @Column
    private long marketCap;


}

