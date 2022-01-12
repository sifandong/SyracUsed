package com.sifan.mp_api.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "selling_items")
public class SellingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;

    @Type(type = "numeric_boolean")
    private Boolean isDollar;

    private String description;


    @Type(type = "numeric_boolean")
    private Boolean isDeliverable;

//    private String apartment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User seller;

    public SellingItem(){

    }
    public SellingItem(Double price, Boolean isDollar, String description, Double lat, Double lng, Boolean isDeliverable,String apartment, User seller ){
        this.price = price;
        this.isDollar = isDollar;
        this.description = description;

        this.isDeliverable = isDeliverable;
//        this.apartment = apartment;

    }

    public Long getId() {return id;}
    public Double getPrice() {return price;}
    public Boolean getIsDollar() {return isDollar;}
    public String getDescription() {return description;}

    public Boolean getIsDeliverable() { return isDeliverable;}
//    public String getApartment() { return apartment;}
    public User getSeller() { return seller;}

    public void setId(Long id) { this.id = id;}
    public void setPrice(Double price) {this.price = price;}
    public void setIsDollar(Boolean isDollar) {this.isDollar = isDollar;}
    public void setDescription(String description) { this.description = description;}

    public void setIsDeliverable(Boolean isDeliverable) {this.isDeliverable = isDeliverable;}
//    public void setApartment(String apartment) { this.apartment = apartment;}
    public void setSeller(User seller) { this.seller = seller;}

    @Override
    public String toString() {
        return "Selling Item: Id: " + id + "price: " + price + "description: " + description;
    }
}
