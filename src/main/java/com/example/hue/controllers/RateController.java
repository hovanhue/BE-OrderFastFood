package com.example.hue.controllers;

import com.example.hue.models.dto.RateDTO;
import com.example.hue.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/rate")
public class RateController {
    @Autowired
    RateService rateService;

    @PostMapping
    public ResponseEntity<RateDTO> save(@RequestBody RateDTO rateDTO) {
        RateDTO _rateDTO = rateService.save(rateDTO);
        return new ResponseEntity<RateDTO>(_rateDTO, HttpStatus.CREATED);
    }
}
