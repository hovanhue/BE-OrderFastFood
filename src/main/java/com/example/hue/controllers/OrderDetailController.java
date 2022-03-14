package com.example.hue.controllers;

import com.example.hue.models.dto.OrderDetailDTO;
import com.example.hue.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/order-detail")
public class OrderDetailController {
    @Autowired
    OrderDetailsService orderDetailService;

    @PostMapping
    public ResponseEntity<OrderDetailDTO> save(@RequestBody OrderDetailDTO orderDetailDTO ) {
        OrderDetailDTO _orderDetailDTO = orderDetailService.save(orderDetailDTO);
        return new ResponseEntity<OrderDetailDTO>(_orderDetailDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderDetailDTO>> findById(@PathVariable(value = "id") long id) {

        List<OrderDetailDTO> _orderDetailDTO = this.orderDetailService.getAllByOrderId(id);

        return ResponseEntity.ok(_orderDetailDTO);
    }
}
