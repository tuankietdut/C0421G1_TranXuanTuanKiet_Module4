package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> productMap = new HashMap<>();

    public Cart() {
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(Product product){
        if (productMap.containsKey(product)){
            productMap.put(product, productMap.get(product)+1);
        }else {
            productMap.put(product, 1);
        }
    }

    public void pullProduct(Product product){
        if (productMap.get(product) == 1){
            productMap.remove(product);
        }else {
            productMap.put(product, productMap.get(product) -1);
        }
    }

    public float totalMoneyCart(){
        float totalMoney =0;
        for (Map.Entry<Product, Integer> element: productMap.entrySet()){
            totalMoney += (element.getKey().getPrice()*element.getValue());
        }
        return totalMoney;
    }

    public Integer sumProduct(){
        int sumProduct =0;
        for (Integer element: productMap.values()){
            sumProduct += element;
        }
        return sumProduct;
    }
}
