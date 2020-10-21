package com.giga.repository;

import com.giga.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    EntityManager entityManager = BaseRepository.entityManager;

    @Override
    public List<Product> display() {
        TypedQuery<Product> typedQuery = entityManager.createQuery("select p from Product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void delete(String id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(getProduct(id));
        transaction.commit();
    }

    @Override
    public Product getProduct(String id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public void create(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
    }
}
