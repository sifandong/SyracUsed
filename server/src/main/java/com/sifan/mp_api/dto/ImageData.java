package com.sifan.mp_api.dto;

public class ImageData {
    private Long id;
    private String path;
    private UserData uploader;
    private Long uploaderId;
    private SellingItemData item;
    private Long itemId;

    public ImageData() {

    }
    public ImageData(Long id, String path, UserData uploader, SellingItemData item){
        this.id = id;
        this.path = path;
        this.uploader = uploader;
        this.uploaderId = uploader.getId();
        this.item = item;
        this.itemId = item.getId();
    }


    public Long getId() { return id;}
    public String getPath() { return path;}
    public UserData getUploader() { return uploader;}
    public Long getUploaderId() { return uploaderId;}
    public SellingItemData getItem() {return item;}
    public Long getItemId() { return itemId;}

    public void setId(Long id) {this.id = id;}
    public void setPath(String path) {this.path = path;}
    public void setUploader(UserData uploader) { this.uploader = uploader;}
    public void setItem(SellingItemData item) { this.item = item;}
    public void setUploaderId(Long uploaderId) {this.uploaderId = uploaderId;}
    public void setItemId(Long itemId) { this.itemId = itemId;}
    @Override
    public String toString(){
        return "ImageData: Id: " + id + "path: "+ path+ "uploader: "+ uploader.toString()+ "item: "+ item.toString();
    }





}
