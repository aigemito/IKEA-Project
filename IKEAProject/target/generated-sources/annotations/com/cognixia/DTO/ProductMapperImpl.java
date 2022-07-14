package com.cognixia.DTO;

import com.cognixia.domain.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-13T21:31:05-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setName( product.getName() );
        productDTO.setCode( product.getCode() );
        productDTO.setQuantity( product.getQuantity() );
        productDTO.setRating( product.getRating() );

        return productDTO;
    }

    @Override
    public ProductAvailabilityDTO productToProductAvailabilityDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductAvailabilityDTO productAvailabilityDTO = new ProductAvailabilityDTO();

        productAvailabilityDTO.setQuantity( product.getQuantity() );
        productAvailabilityDTO.setInStock( product.getInStock() );

        return productAvailabilityDTO;
    }
}
