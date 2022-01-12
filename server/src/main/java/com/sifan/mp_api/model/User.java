package com.sifan.mp_api.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
//    private String avatarUrl;
    private Double lat;
    private Double lng;
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SellingItem> sellingItems;

    @OneToMany(mappedBy = "requester", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RequestedItem> requestedItems;

    public User() {

    }

    public User(String nickname, Double lat, Double lng) {
        this.nickname = nickname;
        this.lat = lat;
        this.lng = lng;
    }

    public Long getId() {
        return id;
    }
    public Double getLat() {return lat;}
    public Double getLng() {return lng;}
    public Set<SellingItem> getSellingItems() {
        return sellingItems;
    }

    public Set<RequestedItem> getRequestedItems() {
        return requestedItems;
    }

    public String getNickname() {
        return nickname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSellingItems(Set<SellingItem> sellingItems) {
        this.sellingItems = sellingItems;
    }

    public void setRequestedItems(Set<RequestedItem> requestedItems) {
        this.requestedItems = requestedItems;
    }
    public void setLat(Double lat) { this.lat = lat;}
    public void setLng(Double lng) { this.lng = lng;}

    @Override
    public String toString() {
        return "User: Id: " + id + "nickname: " + nickname;
    }
}
