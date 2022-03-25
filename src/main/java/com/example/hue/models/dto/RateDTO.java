package com.example.hue.models.dto;

import java.util.Date;

public class RateDTO {

	private Integer id;

	private Double start;

	private String comment;

	private Date dateRate;

	private Long userId;

	private Long productId;

	public RateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getStart() {
		return start;
	}

	public void setStart(Double start) {
		this.start = start;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateRate() {
		return dateRate;
	}

	public void setDateRate(Date dateRate) {
		this.dateRate = dateRate;
	}

	// private User user;

	// private Product product;

}
