package com.example.hue.services;

import com.example.hue.models.dto.CartDetailDTO;

import java.util.List;

public interface CartDetailService {
    CartDetailDTO save(CartDetailDTO cartDetailDTO);

    CartDetailDTO update(CartDetailDTO cartDetailDTO);

    void delete(Long id);

    List<CartDetailDTO> getByCartId(Long id);

    CartDetailDTO getById(Long id);
}
