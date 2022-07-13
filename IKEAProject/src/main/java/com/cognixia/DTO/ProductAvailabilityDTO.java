package com.cognixia.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductAvailabilityDTO {
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("inStock")
    private Boolean inStock;

    public ProductAvailabilityDTO() {

    }

    public ProductAvailabilityDTO(int quantity, Boolean inStock) {
        this.quantity = quantity;
        this.inStock = inStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }
}
