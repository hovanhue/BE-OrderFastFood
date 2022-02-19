package com.example.hue.services.impl;

import com.example.hue.common.converter.CartDetailConverter;
import com.example.hue.common.exception.ResourceNotFoundException;
import com.example.hue.models.dto.CartDetailDTO;
import com.example.hue.models.entity.CartDetail;
import com.example.hue.repositories.CartDetailRepository;
import com.example.hue.services.CartDetailService;
import com.example.hue.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    ProductService productService;

    @Autowired
    CartDetailRepository cartDetailRepository;

    @Autowired
    CartDetailConverter cartDetailConverter;

    @Override
    public CartDetailDTO save(CartDetailDTO cartDetailDTO) {
        List<CartDetail> cartDetails = cartDetailRepository.findByCartId(cartDetailDTO.getId());

        for(CartDetail cartDetail : cartDetails){

            if (cartDetail.getProduct().getId() == cartDetailDTO.getProduct().getId()) {
                cartDetail.setQuantity(cartDetail.getQuantity() + 1);
                CartDetail _cartDetail = cartDetailRepository.save(cartDetail);
                return cartDetailConverter.toDTO(_cartDetail);
            }
        }
        CartDetail _cartDetail = cartDetailRepository.save(cartDetailConverter.toEntity(cartDetailDTO));

        return cartDetailConverter.toDTO(_cartDetail);
    }

    @Override
    public CartDetailDTO update(CartDetailDTO cartDetailDTO) {
        CartDetail cartDetail = cartDetailRepository.save(cartDetailConverter.toEntity(cartDetailDTO));

        return cartDetailConverter.toDTO(cartDetail);
    }

    @Override
    public void delete(Long id) {
        cartDetailRepository.deleteById(id);
    }

    @Override
    public List<CartDetailDTO> getByCartId(Long id) {
        List<CartDetail> cartDetails = cartDetailRepository.findByCartId(id);

        List<CartDetailDTO> cartDetailDTOs = new ArrayList<CartDetailDTO>();

        for (CartDetail cartDetail : cartDetails) {
            cartDetailDTOs.add(cartDetailConverter.toDTO(cartDetail));
        }

        return cartDetailDTOs;
    }

    @Override
    public CartDetailDTO getById(Long id) {
        CartDetail cartDetail = cartDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart detail not found with id :" + id));

        return cartDetailConverter.toDTO(cartDetail);
    }
}
