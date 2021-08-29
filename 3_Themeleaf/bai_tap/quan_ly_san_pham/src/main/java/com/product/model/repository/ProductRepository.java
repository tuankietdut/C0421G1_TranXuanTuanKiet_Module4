package com.product.model.repository;

import com.product.model.bean.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getList();
    String createProduct(Product product);
    String saveProduct(Product product);
    String deleteProduct(int id);
    Product findById(int id);
    List<Product> findByName(String nameProduct);
}
