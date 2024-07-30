package com.workintech.S18D1.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Burger", schema="fsweb")



public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_vegan")
    private Boolean isVegan;

    @Column(name = "bread_type")
    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    @Column(name = "contents")
    private String contents;


}
