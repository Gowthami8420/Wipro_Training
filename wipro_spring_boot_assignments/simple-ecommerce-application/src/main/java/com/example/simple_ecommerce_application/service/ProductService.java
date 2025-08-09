package com.example.simple_ecommerce_application.service;

import org.springframework.stereotype.Service;

import com.example.simple_ecommerce_application.model.Product;

import java.util.*;
 @Service
public class ProductService {
 private List<Product> products = new ArrayList<>();
 public ProductService() {
 // Sample products
 products.add(new Product(1L, "Laptop", 1200));
 products.add(new Product(2L, "Smartphone", 800));
 }
 public List<Product> getAllProducts() {
 return products;
 }
 public Product getProductById(Long id) {
 return products.stream().filter(p-> p.getId().equals(id)).findFirst().orElse(null);
 }
 }