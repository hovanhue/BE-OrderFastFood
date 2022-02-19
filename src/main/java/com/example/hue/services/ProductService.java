package com.example.hue.services;

import com.example.hue.models.dto.ProductDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    Page<ProductDTO> getAllPaginate(Integer page, Integer size);

    Page<ProductDTO> getByName(String name, Integer page, Integer size);

    Page<ProductDTO> getByCategory(Long id, Integer page, Integer size);

    List<ProductDTO> getByCategoryid(Long id);

    Page<ProductDTO> getNewProduct( Integer page, Integer size);

    Page<ProductDTO> getByPriceDesc( Integer page, Integer size);

    Page<ProductDTO> getByPriceAsc( Integer page, Integer size);

    Page<ProductDTO> findByNameAndCategory(Long id, String name, Integer page, Integer size);

    ProductDTO getById(Long id);

    ProductDTO save(ProductDTO product);

    ProductDTO update(ProductDTO product, Long id);

    void delete(Long id);
}
