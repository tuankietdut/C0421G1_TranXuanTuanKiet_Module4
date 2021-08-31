package com.product.model.service;

import com.product.model.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> getList();
    String createProduct(Product product);
    String saveProduct(Product product);
    String deleteProduct(int id);
    Product findById(int id);
    List<Product> findByNameAndPrice (String sql);
}
