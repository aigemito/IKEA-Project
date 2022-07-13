package com.cognixia.Service;

import com.cognixia.DTO.ProductAvailabilityDTO;
import com.cognixia.DTO.ProductDTO;
import com.cognixia.DTO.ProductMapper;
import com.cognixia.Repository.IProductRepository;
import com.cognixia.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    ProductMapper mapper;


    @Override
    public List<Product> getAllProducts() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> getById(int productId) {
        return iProductRepository.findById(productId);
    }

    @Override
    public ProductAvailabilityDTO getAvailabilityById(int productId) {
        Optional<Product> product=iProductRepository.findById(productId);
        if(product.isPresent()){
            return mapper.productToProductAvailabilityDTO(product.get());
        }
        return null;
    }

    @Override
    public List<ProductDTO>  getByCategory(String category) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product:iProductRepository.findByCategory(category)) {
            productDTOS.add(mapper.productToProductDTO(product));
        }
        return productDTOS;
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }
}
