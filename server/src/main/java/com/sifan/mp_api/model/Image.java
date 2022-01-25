package com.sifan.mp_api.model;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "images")
public class Image extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploader_id", referencedColumnName = "id")
    private User uploader;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private SellingItem item;

    public Image(){

    }
    public Image(String path, User uploader, SellingItem item){
        this.path = path;
        this.uploader = uploader;
        this.item = item;
    }

    public Long getId() {return id;}
    public String getPath() {return path;}
    public User getUploader() { return uploader;}
    public SellingItem getItem() { return item;}

    public void setId(Long id) { this.id = id;}
    public void setPath(String path) { this.path = path;}
    public void setUploader(User uploader) { this.uploader = uploader;}
    public void setItem(SellingItem item) { this.item = item;}

    @Override
    public String toString() {
        return "Image: Id: "+ id + "uploader: " + uploader.toString() + "item: " + item.toString();
    }


}
