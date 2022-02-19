package com.example.hue.common.converter;

import com.example.hue.models.dto.CartDTO;
import com.example.hue.models.dto.CartDetailDTO;
import com.example.hue.models.entity.Cart;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

	@Autowired
	ModelMapper modelMapper;

	public Cart toEntity(CartDTO cartDTO) {

		Cart cart = modelMapper.map(cartDTO, Cart.class);

		return cart;

	}

	public CartDTO toDTO(Cart cart) {

		CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
		for (CartDetailDTO item : cartDTO.getCartDetails()) {
			item.setCart(null);
		}

		return cartDTO;
	}

}
