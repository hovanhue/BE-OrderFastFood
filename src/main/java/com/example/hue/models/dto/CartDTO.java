package com.example.hue.models.dto;

import com.example.hue.models.entity.User;

import java.math.BigDecimal;
import java.util.Set;

public class CartDTO {

	private Long id;

	private BigDecimal amount;

	private User user;

	private Set<CartDetailDTO> cartDetails;

	public CartDTO() {
		super();
	}

	public Set<CartDetailDTO> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(Set<CartDetailDTO> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CartDTO(BigDecimal amount) {
		super();
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
