package com.example.hue.common.converter;

import com.example.hue.models.dto.ProductCategoryDTO;
import com.example.hue.models.entity.ProductCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryConverter {
	@Autowired
	ModelMapper modelMapper;

	public ProductCategory toEntity(ProductCategoryDTO categoryDTO) {

		ProductCategory category = modelMapper.map(categoryDTO, ProductCategory.class);

		return category;

	}

	public ProductCategoryDTO toDTO(ProductCategory category) {

		ProductCategoryDTO productCategoryDTO = modelMapper.map(category, ProductCategoryDTO.class);

		return productCategoryDTO;
	}
	
	public Page<ProductCategoryDTO> toPageProductDto(Page<ProductCategory> objects) {
	    Page<ProductCategoryDTO> dtos  = objects.map(this::toDTO);
	    return dtos;
	}


}
