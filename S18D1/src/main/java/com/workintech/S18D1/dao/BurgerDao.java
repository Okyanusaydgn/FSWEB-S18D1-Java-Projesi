package com.workintech.S18D1.dao;

import com.workintech.S18D1.entity.BreadType;
import com.workintech.S18D1.entity.Burger;

import java.util.List;

public interface BurgerDao {


    Burger save(Burger burger);

    List<Burger> findAll();

    Burger findById(long id);


    Burger update(Burger burger);

    Burger remove(long id);


    List<Burger> findByPrice(Integer price);


    List<Burger> findByBread(BreadType breadType);

    List<Burger> findByContent(String Content);

}
