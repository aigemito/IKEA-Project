package com.cognixia.Service;

import com.cognixia.DTO.ProductAvailabilityDTO;
import com.cognixia.DTO.ProductDTO;
import com.cognixia.domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public abstract List<Product> getAllProducts();
    public abstract Optional<Product> getById(int productId);
    public abstract ProductAvailabilityDTO getAvailabilityById(int productId);
    public abstract List<ProductDTO> getByCategory(String category);
    public abstract Product save(Product product);

}
