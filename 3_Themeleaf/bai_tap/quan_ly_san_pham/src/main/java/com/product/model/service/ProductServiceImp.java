package com.product.model.service;

import com.product.model.bean.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Kiwi", 55,"Kiwi Xanh", "USA"));
        productList.add(new Product(2, "Dưa hấu", 50,"Dưa hấu ko hạt", "Lào"));
        productList.add(new Product(3, "Mít", 75,"Mít ướt", "Trung Quốc"));
        productList.add(new Product(4, "Chuối", 85,"Chuối vàng", "Việt Nam"));
    }

    @Override
    public List<Product> getList() {
        return productList;
    }

    @Override
    public String createProduct(Product product) {
        productList.add(product);
        return "success";
    }

    @Override
    public String saveProduct(Product product) {
        Product product1 = findById(product.getId());
        int index = productList.indexOf(product1);
        productList.remove(product1);
        productList.add(index, product);
        return "success";
    }

    @Override
    public String deleteProduct(int id) {
        Product product = this.findById(id);
        if (product == null) return "cant delete";
        productList.remove(product);
        return "success";
    }

    @Override
    public Product findById(int id) {
        for (Product product: productList){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String nameProduct) {
        List<Product> products = new ArrayList<>();
        for (Product product: productList){
            if (product.getName().equals(nameProduct)){
                products.add(product);
            }
        }
        return products;
    }
}
