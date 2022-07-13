package com.cognixia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="Product" )
@Data
public class Product {
    @Id
    @GeneratedValue
   private int id;
   private String name;
   private String code;
   private String category;
   private Double price;
   private int quantity;
   private Boolean inStock;
   private int rating;
    public Product() {
    }
    public Product(int id, String name, String code, String category, Double price, int quantity, Boolean inStock, int rating) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.inStock = inStock;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public int getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
