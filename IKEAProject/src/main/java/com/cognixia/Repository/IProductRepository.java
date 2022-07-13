package com.cognixia.Repository;

import com.cognixia.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
  List<Product> findByCategory(String category);
}
