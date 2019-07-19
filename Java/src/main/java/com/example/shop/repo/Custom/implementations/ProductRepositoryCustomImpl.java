package com.example.shop.repo.Custom.implementations;

import com.example.shop.model.Product;
import com.example.shop.model.Supplier;
import com.example.shop.repo.Custom.interfaces.ProductRepositoryCustom;

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
    public List<Product> findProductBySupplierNameAndCountry(String supplier, String country) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);

        Root<Product> productRoot = query.from(Product.class);
        Root<Supplier> supplierRoot = query.from(Supplier.class);

        Join<Product, Supplier> supplierJoin = productRoot.join("suppliers",JoinType.INNER);

        List<Predicate> predicates = new ArrayList<>();
//        for(String supplier: suppliers) {
//            predicates.add(cb.equal(supplierPath, supplier));
//        }

        if(!supplier.equals(""))
        {
            Predicate supplierNamePredicate = cb.equal(supplierRoot.get("name"), supplier);
        }
        Predicate countryNamePredicate = cb.equal(productRoot.get("country"),country);
        query.where(countryNamePredicate);
//        query.select(productRoot).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        TypedQuery<Product> querry = entityManager.createQuery(query);
        return querry.getResultList();
    }
}
