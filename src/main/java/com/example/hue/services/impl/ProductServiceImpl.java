package com.example.hue.services.impl;

import com.example.hue.common.converter.ProductConverter;
import com.example.hue.models.dto.ProductDTO;
import com.example.hue.repositories.ProductRepository;
import com.example.hue.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductConverter productConverter;

    @Override
    public List<ProductDTO> getAll() {
        return null;
    }

    @Override
    public Page<ProductDTO> getAllPaginate(Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<ProductDTO> getByName(String name, Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<ProductDTO> getByCategory(Long id, Integer page, Integer size) {
        return null;
    }

    @Override
    public List<ProductDTO> getByCategoryid(Long id) {
        return null;
    }

    @Override
    public Page<ProductDTO> getNewProduct(Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<ProductDTO> getByPriceDesc(Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<ProductDTO> getByPriceAsc(Integer page, Integer size) {
        return null;
    }

    @Override
    public Page<ProductDTO> findByNameAndCategory(Long id, String name, Integer page, Integer size) {
        return null;
    }

    @Override
    public ProductDTO getById(Long id) {
        return null;
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        return null;
    }

    @Override
    public ProductDTO update(ProductDTO product, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
