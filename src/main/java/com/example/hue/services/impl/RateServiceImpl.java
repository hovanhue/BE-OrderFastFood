package com.example.hue.services.impl;

import com.example.hue.common.converter.RateConverter;
import com.example.hue.common.exception.ResourceNotFoundException;
import com.example.hue.models.dto.RateDTO;
import com.example.hue.models.entity.Product;
import com.example.hue.models.entity.Rates;
import com.example.hue.models.entity.User;
import com.example.hue.repositories.ProductRepository;
import com.example.hue.repositories.RateRepository;
import com.example.hue.repositories.UserRepository;
import com.example.hue.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl  implements RateService {

    @Autowired
    RateRepository rateRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RateConverter rateConverter;

    @Autowired
    UserRepository userRepository;

    @Override
    public RateDTO save(RateDTO rateDTO) {
        Product product = productRepository.findById(rateDTO.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found with id :" + rateDTO.getProductId()));
        User user = userRepository.getById(rateDTO.getUserId());
        Rates rates = rateConverter.toEntity(rateDTO);
        rates.setProduct(product);
        rates.setUser(user);
        Rates _rates = rateRepository.save(rates);
        return rateConverter.toDTO(_rates);

    }
}
