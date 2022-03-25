package com.example.hue.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "image_store")
    @Lob
    private String imageStore;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "unit_in_stock")
    private int unitInStock;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToOne
    @JsonBackReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonIgnore
    private Set<OrderDetail> orderDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonIgnore
    private Set<CartDetail> cartDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonIgnore
    private Set<Rates> rates;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal unitPrice, String imageUrl, String imageStore, Boolean active, int unitInStock, Date dateCreated, Date lastUpdated, ProductCategory category, Set<OrderDetail> orderDetails, Set<CartDetail> cartDetails, Set<Rates> rates) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
        this.imageStore = imageStore;
        this.active = active;
        this.unitInStock = unitInStock;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.category = category;
        this.orderDetails = orderDetails;
        this.cartDetails = cartDetails;
        this.rates = rates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageStore() {
        return imageStore;
    }

    public void setImageStore(String imageStore) {
        this.imageStore = imageStore;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Set<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(Set<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public Set<Rates> getRates() {
        return rates;
    }

    public void setRates(Set<Rates> rates) {
        this.rates = rates;
    }
}
