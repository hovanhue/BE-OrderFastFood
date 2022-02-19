package com.example.hue.services;

import com.example.hue.models.dto.OrderDetailDTO;

import java.util.List;

public interface OrderDetailsService {
    OrderDetailDTO save(OrderDetailDTO orderDetailDTO);

    List<OrderDetailDTO> getAllByOrderId(Long id);
}
