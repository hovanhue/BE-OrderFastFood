package com.example.hue.common.converter;

import com.example.hue.models.dto.RateDTO;
import com.example.hue.models.entity.Rates;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RateConverter {

	@Autowired
	ModelMapper modelMapper;

	public Rates toEntity(RateDTO rateDTO) {

		Rates rates = modelMapper.map(rateDTO, Rates.class);

		return rates;

	}

	public RateDTO toDTO(Rates rates) {

		RateDTO rateDTO = modelMapper.map(rates, RateDTO.class);
		
		//rateDTO.setProduct(null);

		return rateDTO;
	}

}
