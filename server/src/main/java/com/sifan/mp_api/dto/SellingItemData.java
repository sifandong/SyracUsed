package com.sifan.mp_api.dto;

import com.sifan.mp_api.model.SellingItem;
import com.sifan.mp_api.model.User;

public class SellingItemData {
    private Long id;
    private Double price;
    private Boolean isDollar;
    private String description;

    private Boolean isDeliverable;
//    private String apartment;
    private Long sellerId;
    private UserData seller;

    public SellingItemData(){

    }
    public SellingItemData(Long id, Double price, Boolean isDollar, String description, Double lat, Double lng, Boolean isDeliverable, String apartment){
        this.id = id;
        this.price = price;
        this.isDollar = isDollar;
        this.description = description;

        this.isDeliverable = isDeliverable;
//        this.apartment = apartment;
    }

    public Long getId() {return id;}
    public Double getPrice() {return price;}
    public Boolean getIsDollar() { return isDollar;}
    public String getDescription() { return description;}

    public Boolean getIsDeliverable() { return isDeliverable;}
//    public String getApartment() { return apartment;}
    public UserData getSeller() {return seller; }
    public Long getSellerId() { return sellerId; }

    public void setId(Long id) { this.id = id;}
    public void setPrice(Double price) { this.price = price;}
    public void setIsDollar(Boolean isDollar) { this.isDollar = isDollar;}
    public void setDescription(String description) { this.description = description;}

    public void setIsDeliverable(Boolean isDeliverable) { this.isDeliverable = isDeliverable;}
//    public void setApartment(String apartment) { this.apartment = apartment;}
    public void setSeller(UserData seller) { this.seller = seller; }
    public void setSellerId(Long sellerId) {this.sellerId = sellerId;}

    @Override
    public String toString(){
        return "SellingItemData: Id: "+id+"price:"+price+"description:"+ description;
    }

}
