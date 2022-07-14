package com.cognixia.Service;

import com.cognixia.DTO.ProductAvailabilityDTO;
import com.cognixia.DTO.ProductDTO;
import com.cognixia.domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
   List<Product> getAllProducts();
   Optional<Product> getById(int productId);
   List<Product> getByCategory(String category);
   Product save(Product product);
   List<Product> getAvailabilityByProductCode(String productCode);
   boolean delete(Product product) throws Exception;
   List<String> getDiscountForMostPopularProduct();
   List<Integer> deleteLowestRating();
}
