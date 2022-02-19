package com.example.hue.common.converter;

import com.example.hue.models.dto.OrderDTO;
import com.example.hue.models.dto.OrderDetailDTO;
import com.example.hue.models.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
	
	@Autowired
	ModelMapper modelMapper;
	
	public Order toEntity(OrderDTO orderDTO) {

		Order Order = modelMapper.map(orderDTO, Order.class);

		return Order;

	}

	public OrderDTO toDTO(Order order) {

		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		
		if(orderDTO.getOrderDetails() != null) {
			for (OrderDetailDTO item : orderDTO.getOrderDetails()) {
				item.setOrder(null);
			}

		}
		return orderDTO;
	}
	
	public Page<OrderDTO> toPageDto(Page<Order> objects) {
	    Page<OrderDTO> dtos  = objects.map(this::toDTO);
	    return dtos;
	}

}
