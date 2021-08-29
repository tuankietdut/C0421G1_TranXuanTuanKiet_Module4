package com.product.model.repository;

import com.product.model.bean.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImp implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getList() {
        TypedQuery<Product> typedQuery = entityManager.createQuery("SELECT p FROM Product AS p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public String createProduct(Product product) {
        entityManager.persist(product);
        return "success";
    }

    @Override
    public String saveProduct(Product product) {
        if (findById(product.getId()) != null){
            entityManager.remove(findById(product.getId()));
            return "success";
        }
        return "cant not find Product";
    }

    @Override
    public String deleteProduct(int id) {
        if (findById(id) != null){
            entityManager.remove(findById(id));
            return "success";
        }
        return "cant not find Product";
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findByName(String nameProduct) {
//        return entityManager.find(Product.class, nameProduct);
        return null;
    }
}
