package com.workintech.S18D1.dao;

import com.workintech.S18D1.entity.BreadType;
import com.workintech.S18D1.entity.Burger;
import com.workintech.S18D1.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BurgerDaoImpl implements BurgerDao {

    private final EntityManager entityManager;
    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> selectResult = entityManager.createQuery("SELECT b from Burger b", Burger.class);
        return selectResult.getResultList();
    }

    @Override
    public Burger findById(long id) {
        Burger burger = entityManager.find(Burger.class,id);
        if(burger == null){
            throw new BurgerException("Burger with given id is not exist: " + id, HttpStatus.NOT_FOUND);
        }
        return burger;
    }

    @Override
    public Burger update(Burger burger){
        return entityManager.merge(burger);
    }

    @Override
    public Burger remove(long id) {
        Burger foundBurger = findById(id);
        entityManager.remove(foundBurger);
        return foundBurger;
    }

    @Override
    public List<Burger> findByPrice(Integer price) {
        TypedQuery<Burger> query =  entityManager.createQuery("SELECT b FROM Burger b.price > :price ORDER BY b.price desc", Burger.class);
        query.setParameter("price",price); // bunu yukarıdaki ":price" yazan kısım temsil ediyor. iki nokta (:) price yaparak dışarıdan değer alıyor.
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBread(BreadType breadType) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b where b.breadType > :breadType ORDER BY b.name desc",Burger.class);
        query.setParameter("breadType",breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b where b.contents LIKE CONCAT('%', :concent, '%') ORDER BY b.name", Burger.class);
        query.setParameter("content",content);
        return query.getResultList();
    }
}
