package com.example.hue.controllers;

import com.example.hue.models.dto.CartDetailDTO;
import com.example.hue.services.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cart-detail")
public class CartDetailController {
    @Autowired
    CartDetailService cartDetailService;

    @PostMapping
    public ResponseEntity<CartDetailDTO> save(@RequestBody CartDetailDTO cartDetail) {

        CartDetailDTO cartDetailDTO = cartDetailService.save(cartDetail);

        return new ResponseEntity<CartDetailDTO>(cartDetailDTO, HttpStatus.CREATED);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<List<CartDetailDTO>> getByCartId(@PathVariable("id") Long id) {

        List<CartDetailDTO> cartDetailDTOs = cartDetailService.getByCartId(id);

        return ResponseEntity.ok(cartDetailDTOs);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDetailDTO> getById(@PathVariable("id") Long id) {

        CartDetailDTO cartDetailDTO = cartDetailService.getById(id);

        return ResponseEntity.ok(cartDetailDTO);

    }

    @PutMapping
    public ResponseEntity<CartDetailDTO> update(@RequestBody CartDetailDTO cartDetail) {
        CartDetailDTO cartDetailDTO = cartDetailService.update(cartDetail);
        return ResponseEntity.ok(cartDetailDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CartDetailDTO> delete (@PathVariable("id") long id) {
        cartDetailService.delete(id);
        return ResponseEntity.ok().build();
    }

}
