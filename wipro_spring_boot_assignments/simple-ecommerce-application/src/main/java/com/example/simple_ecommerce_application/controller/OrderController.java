package com.example.simple_ecommerce_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.simple_ecommerce_application.model.CartItem;
import com.example.simple_ecommerce_application.model.Order;
import com.example.simple_ecommerce_application.model.Product;
import com.example.simple_ecommerce_application.service.OrderService;
import com.example.simple_ecommerce_application.service.ProductService;

import java.util.*;
@Controller
@RequestMapping("/orders")
public class OrderController {
@Autowired
private OrderService orderService;
@Autowired
private ProductService productService;
private List<CartItem> cart = new ArrayList<>();
@PostMapping("/add-to-cart")
public String addToCart(@RequestParam("productId") Long productId, @RequestParam("quantity") int quantity) {
Product product = productService.getProductById(productId);
cart.add(new CartItem(product, quantity));
return "redirect:/cart";
}
@GetMapping("/cart")
public String showCart(Model model) {
model.addAttribute("cart", cart);
return "cart";
}
@PostMapping("/checkout")
public String checkout(Model model) {
Order order = orderService.placeOrder(cart);
cart.clear(); // Empty the cart after placing the order
model.addAttribute("order", order);
return "order-confirmation";
}
}