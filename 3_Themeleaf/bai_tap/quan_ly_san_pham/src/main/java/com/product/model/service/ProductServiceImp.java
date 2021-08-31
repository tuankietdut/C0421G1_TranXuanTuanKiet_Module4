package com.product.model.service;

import com.product.model.bean.Product;
import com.product.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getList() {
        return productRepository.getList();
    }

    @Override
    public String createProduct(Product product) {
        return productRepository.createProduct(product);
    }

    @Override
    public String saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    @Override
    public String deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }


    @Override
    public List<Product> findByNameAndPrice(String sql) {
        return productRepository.findByNameAndPrice(sql);
    }
}
