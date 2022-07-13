package com.cognixia.controller;

import com.cognixia.DTO.ProductAvailabilityDTO;
import com.cognixia.DTO.ProductDTO;
import com.cognixia.Service.ProductServiceImpl;
import com.cognixia.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    //Q1: Product Detail: Print details of the Product
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    //Q2: Product Filter: Based on the product category entered, print the name, code, rating and quantity using path variables.
    @GetMapping("/products/{category}")
    public ResponseEntity<List<ProductDTO>> getAll(@PathVariable String category){
        return ResponseEntity.ok().body(productService.getByCategory(category));
    }
    //Q3: Product creation: Add a new product
    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }
    //Q4: Product Availability: Display the inStock and Quantity
    @GetMapping("/products/{productId}/available")
    public ResponseEntity<ProductAvailabilityDTO> getAvailabilityById(@PathVariable int productId){
        return ResponseEntity.ok(productService.getAvailabilityById(productId));
    }
    //Q5: Product Cost: Display the cost of the product along with 13% tax.
    @GetMapping("/products/{productId}/cost")
    public ResponseEntity<?> getCostById(@PathVariable int productId){
       Optional<Product> product= productService.getById(productId);
        String result=null;
       if(product.isPresent()){
           NumberFormat formatter = NumberFormat.getCurrencyInstance();
           double cost= product.get().getPrice() + product.get().getPrice() * 0.13;
           result=String.format("Cost of product for %s after 13 percentage tax is %s",product.get().getId(),formatter.format(cost));
       }
        return ResponseEntity.ok(result);
    }
    //Q6: Product Discount: Using a template, print a user friendly message for a 10% discount on the product
    @GetMapping("/products/{productId}/discount")
    public ResponseEntity<?> getDiscountById(@PathVariable int productId){
        Optional<Product> product= productService.getById(productId);
        String result=null;
        if(product.isPresent()){
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            double discount= product.get().getPrice() - product.get().getPrice() * 0.10;
            result=String.format("10 percentage product discount for %s is %s",product.get().getId(),formatter.format(discount));
        }
        return ResponseEntity.ok(result);
    }
}
