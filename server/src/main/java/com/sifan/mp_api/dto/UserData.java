package com.sifan.mp_api.dto;


//先不要管图片的问题
public class UserData {
    private Long id;
    private String nickname;
    private Double lat;
    private Double lng;
//    private String avatarUrl;
    public UserData(){

    }
    public Long getId() { return id; }
    public String getNickname() { return nickname;}
    public Double getLat() { return lat;}
    public Double getLng() { return lng;}

    public void setId(Long id) { this.id = id; }
    public void setNickname(String nickname) { this.nickname = nickname;}
    public void setLat(Double lat) { this.lat = lat;}
    public void setLng(Double lng) { this.lng = lng;}
    @Override
    public String toString() {return "User: Id: " + id + "nickname: "+ nickname; }
}
