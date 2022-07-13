package com.cognixia.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class ProductDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("code")
    private String code;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("rating")
    private int rating;

    public ProductDTO() {
    }

    public ProductDTO(String name, String code, int quantity, int rating) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
