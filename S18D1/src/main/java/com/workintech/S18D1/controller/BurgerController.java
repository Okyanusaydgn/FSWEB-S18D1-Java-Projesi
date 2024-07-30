package com.workintech.S18D1.controller;


import com.workintech.S18D1.dao.BurgerDao;
import com.workintech.S18D1.dao.BurgerDaoImpl;
import com.workintech.S18D1.entity.BreadType;
import com.workintech.S18D1.entity.Burger;
import com.workintech.S18D1.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")

public class BurgerController {

    private final BurgerDao burgerDao;


    @Autowired
    public BurgerController(BurgerDao burgerDao){
        this.burgerDao = burgerDao;
    }


    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }

    @GetMapping
    public List<Burger> findAll(){
        return burgerDao.findAll();
    }

    @GetMapping
    public Burger find(@PathVariable("id") long id) {
        return burgerDao.findById(id);
    }

    @PutMapping("/{id}")
    public Burger update(@RequestBody Burger burger){
        return  burgerDao.update(burger);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBread(@PathVariable("breadType") String breadType){
        BreadType bt = BreadType.valueOf(breadType);
        return burgerDao.findByBread(bt);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable("price") Integer price){

        return burgerDao.findByPrice(price);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable("content") String content){
        return burgerDao.findByContent(content);
    }
}
