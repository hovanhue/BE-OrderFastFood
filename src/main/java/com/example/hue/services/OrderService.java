package com.example.hue.services;

import com.example.hue.models.dto.OrderDTO;
import org.springframework.data.domain.Page;

public interface OrderService {

    OrderDTO save(OrderDTO orderDTO);

    OrderDTO update(OrderDTO orderDTO);

    Page<OrderDTO> getByUserId(Long id, Integer page, Integer size);

    OrderDTO getById(Long id);

    Page<OrderDTO> getAll(Integer page, Integer size);
}
