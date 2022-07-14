package com.cognixia.controller;

import com.cognixia.DTO.ProductAvailabilityDTO;
import com.cognixia.DTO.ProductDTO;
import com.cognixia.DTO.ProductMapper;
import com.cognixia.Service.ProductServiceImpl;
import com.cognixia.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ProductMapper mapper;

    //Q1: Product Detail: Print details of the Product
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    //Q2: Product Filter: Based on the product category entered, print the name, code, rating and quantity using path variables.
    @GetMapping("/products/{category}")
    public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable String category){
        List<Product> products=productService.getByCategory(category);
        List<ProductDTO> productDTOS=new ArrayList<>();
        for (Product p:
             products) {
           productDTOS.add( mapper.productToProductDTO(p));
        }
        return ResponseEntity.ok().body(productDTOS);
    }
    //Q3: Product creation: Add a new product
    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }
    //Q4: Product Availability: Display the inStock and Quantity for a product Code entered.
    @GetMapping("/products/{productCode}/available")
    public ResponseEntity<List<ProductAvailabilityDTO>> getAvailabilityById(@PathVariable String productCode){
        List<Product> products=productService.getAvailabilityByProductCode(productCode);
        List<ProductAvailabilityDTO> productAvailabilityDTOS=new ArrayList<>();
        for (Product p:
                products) {
           productAvailabilityDTOS.add(mapper.productToProductAvailabilityDTO(p));
        }
        return ResponseEntity.ok(productAvailabilityDTOS);
    }
    //Q5: Product Cost: Display the cost of the product along with 13% tax.
    @GetMapping("/products/{productCategory}/cost")
    public ResponseEntity<?> getCostByCategory(@PathVariable String productCategory){
       List<Product> products= productService.getByCategory(productCategory);
        List<String> result=new ArrayList<>();
        for (Product p:
             products) {
           NumberFormat formatter = NumberFormat.getCurrencyInstance();
           double cost= p.getPrice() + p.getPrice() * 0.13;
           result.add(String.format("Cost of product for %s after 13 percentage tax is %s",p.getId(),formatter.format(cost)));
       }
        return ResponseEntity.ok(result);
    }
    //Q6: Product Discount: Using a template, print a user friendly message for a 10% discount on the product for the most popular product.
    @GetMapping("/products/discount")
    public ResponseEntity<?> getDiscountForMostPopularProduct(){
        List<String> output = productService.getDiscountForMostPopularProduct();
        return ResponseEntity.ok(output);
    }


    //Q7: Product Update: Modify the Price of products for a product Id using request parameters.
   @PutMapping("/products/{productId}")
   public ResponseEntity<?> updateProduct(@PathVariable int productId,@RequestParam double price){
       Optional<Product> oldproduct= productService.getById(productId);
       String result=null;
       if(oldproduct.isPresent()){
           oldproduct.get().setPrice(price);
           productService.save(oldproduct.get());
       }
       return ResponseEntity.ok(oldproduct);
   }
    // Q8: Product Purge: Delete products that have lowest rating.
    @DeleteMapping("/products/lowestRating")
    public ResponseEntity<?> deleteLowestRating() throws Exception {
        List<Integer> productIdsDeleted = productService.deleteLowestRating();
        return ResponseEntity.status(HttpStatus.OK).body("Those products with lowest rating are got deleted. Those are the Id's : " + productIdsDeleted);
    }

}
