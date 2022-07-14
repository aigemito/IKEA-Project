package com.cognixia.Service;

import com.cognixia.DTO.ProductAvailabilityDTO;
import com.cognixia.DTO.ProductDTO;
import com.cognixia.DTO.ProductMapper;
import com.cognixia.Repository.IProductRepository;
import com.cognixia.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> getAllProducts() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> getById(int productId) {
        return iProductRepository.findById(productId);
    }

    @Override
    public List<Product> getAvailabilityByProductCode(String productCode) {
        return iProductRepository.findByCode(productCode);
    }

    @Override
    public boolean delete(Product product) throws Exception {
        Boolean flag=true;
        try{
            iProductRepository.delete(product);
        }catch (Exception e){
            flag=false;
            throw new Exception(e);
        }
        return flag;
    }

    @Override
    public List<String> getDiscountForMostPopularProduct() {
        List<Product> products= getAllProducts();

        Map<Integer, List<Product>> result = products.stream().collect(Collectors.groupingBy(Product::getRating));

        List<Product> mostPopularProducts = result.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        double discount=0;
        List<String> output=new ArrayList<>();
        for (Product p:
                mostPopularProducts ) {
            discount= p.getPrice() - p.getPrice() * 0.10;
            output.add(String.format("10 percentage product discount for %s is %s",p.getId(),formatter.format(discount)));
        }
        return output;
    }

    @Override
    public List<Integer> deleteLowestRating() {
        List<Product> products= getAllProducts();

        Map<Integer, List<Product>> result = products.stream().collect(Collectors.groupingBy(Product::getRating));

        List<Product> allMinRating = result.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList());

        List<Integer> productIdsDeleted=new ArrayList<Integer>();
        for (Product p:
                allMinRating) {
            productIdsDeleted.add(p.getId());
            iProductRepository.delete(p);
        }
        return productIdsDeleted;
    }

    @Override
    public List<Product>  getByCategory(String category) {
        return iProductRepository.findByCategory(category);
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }
}
