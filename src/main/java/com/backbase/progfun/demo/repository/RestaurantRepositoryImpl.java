package com.backbase.progfun.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.backbase.progfun.demo.model.Restaurant;
import com.backbase.progfun.demo.model.Website;

class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void removeRestaurantWithWebsite(Website website) {
        TypedQuery<Restaurant> query = em.createQuery("from Restaurant where website like :website", Restaurant.class);
        query.setParameter("website", website);
        em.remove(query.getSingleResult());
    }
}
