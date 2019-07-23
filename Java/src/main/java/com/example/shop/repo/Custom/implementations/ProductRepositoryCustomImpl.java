package com.example.shop.repo.Custom.implementations;

import com.example.shop.controller.filters.ProductFilter;
import com.example.shop.model.Product;
import com.example.shop.model.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> productFilter(ProductFilter pf) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);

        Root<Product> productRoot = query.from(Product.class);
        Join<Product, Supplier> supplierJoin = productRoot.join("supplier");
        List<Predicate> predicates = new ArrayList<>();

        if(!pf.getSupplier().equals("")) {
            predicates.add(cb.equal(supplierJoin.get("name"),pf.getSupplier()));
        }

        if(!pf.getCountry().equals("")) {
            predicates.add(cb.equal(productRoot.get("country"),pf.getCountry()));
        }

        if(!pf.getCategory().equals("")) {
            predicates.add(cb.equal(productRoot.get("category"),pf.getCategory_enum()));
        }

        if(!pf.getType().equals("")) {
            predicates.add(cb.equal(productRoot.get("type"),pf.getType_enum()));
        }

        query.select(productRoot).where(cb.and(predicates.toArray(new Predicate[predicates.size()]))).distinct(true);
        TypedQuery<Product> querry = entityManager.createQuery(query);
        return querry.getResultList();
    }
}
