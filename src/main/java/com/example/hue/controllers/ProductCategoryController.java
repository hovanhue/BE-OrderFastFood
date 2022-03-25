package com.example.hue.controllers;

import com.example.hue.models.dto.ProductCategoryDTO;
import com.example.hue.models.entity.ProductCategory;
import com.example.hue.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product-category")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping
    public List<ProductCategoryDTO> getAllProductsCategory() {
        return productCategoryService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> getAllProductsCategoryPaginate(@PathVariable("id") long id) {
        ProductCategoryDTO products = productCategoryService.findByid(id);
        return new ResponseEntity<ProductCategoryDTO>(products, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<Page<ProductCategoryDTO>> getAllProductsCategoryPaginate(@RequestParam("page") Integer page,
                                                                           @RequestParam("size") Integer size) {
        Page<ProductCategoryDTO> products = productCategoryService.getAllPaginate(page, size);

        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
    public ResponseEntity<ProductCategoryDTO> getAllProductsCategoryPaginate(@RequestParam("name") String name) {
        ProductCategoryDTO products = productCategoryService.getByName(name);
        return ResponseEntity.ok(products);
    }


    @PostMapping
    public ResponseEntity<ProductCategoryDTO> createProductCategory(@Valid @RequestBody ProductCategoryDTO product) {
        ProductCategoryDTO newProduct = productCategoryService.save(product);
        return new ResponseEntity<ProductCategoryDTO>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductCategory(@Valid @RequestBody ProductCategoryDTO categoryDTO, @PathVariable("id") long id){
        ProductCategoryDTO newDdto = productCategoryService.update(categoryDTO, id);
        return new ResponseEntity<>(newDdto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductCategory> deleteProductCategory(@PathVariable("id") long id) {
        productCategoryService.delete(id);
        return ResponseEntity.ok().build();
    }

}
