package com.example.hue.repositories;

import com.example.hue.models.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    List<ProductCategory> findByActiveTrue();

    Page<ProductCategory> findByActiveTrue(Pageable pageable);

    ProductCategory findByCategoryNameAndActiveTrue(String name);

    ProductCategory findByIdAndActiveTrue(Long id);
}
