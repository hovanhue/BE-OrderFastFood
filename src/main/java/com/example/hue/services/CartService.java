package com.example.hue.services;

import com.example.hue.models.dto.CartDTO;

import java.util.List;

public interface CartService {
    List<CartDTO> findByUserId(Long id);
}
