package com.cognixia.DTO;

import com.cognixia.domain.Product;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);
    ProductAvailabilityDTO productToProductAvailabilityDTO(Product product);
}
