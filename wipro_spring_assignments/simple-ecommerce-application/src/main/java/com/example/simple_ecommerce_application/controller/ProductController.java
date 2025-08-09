package com.example.simple_ecommerce_application.controller;

import org.springframework.beans.factory.annotation.Autowired;

 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;

import com.example.simple_ecommerce_application.model.Product;
import com.example.simple_ecommerce_application.service.ProductService;
 @Controller
 public class ProductController {
 @Autowired
 private ProductService productService;
 @GetMapping("/products")
 public String showProducts(Model model) {
 model.addAttribute("products", productService.getAllProducts());
 return "products";
 }
 @GetMapping("/products/{id}")
 public String showProductDetails(@PathVariable("id") Long id, Model model) {
 Product product = productService.getProductById(id);
 model.addAttribute("product", product);
 return "product-details";
 }
 }
