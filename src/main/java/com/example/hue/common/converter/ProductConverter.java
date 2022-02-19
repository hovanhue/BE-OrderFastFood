package com.example.hue.common.converter;

import com.example.hue.models.dto.ProductDTO;
import com.example.hue.models.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

	@Autowired
	ModelMapper modelMapper;

	public Product toEntity(ProductDTO productDTO) {

		Product product = modelMapper.map(productDTO, Product.class);

		return product;

	}

	public ProductDTO toDTO(Product product) {
		
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		
//		if(productDTO.getRates() != null) {
//			for (RateDTO rate : productDTO.getRates()) {
//				rate.setProduct(null);
//			} 
//		}
		
		
		

		return productDTO;
	}
	
	
	public Page<ProductDTO> toPageProductDto(Page<Product> objects) {
	    Page<ProductDTO> dtos  = objects.map(this::toDTO);
	    return dtos;
	}
	

	

}
