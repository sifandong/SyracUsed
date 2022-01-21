package com.sifan.mp_api.model;


import javax.persistence.*;

@Entity
@Table(name = "requested_items")
public class RequestedItem extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id",referencedColumnName = "id")
    private User requester;

    public RequestedItem() {

    }
    public RequestedItem(String description){
        this.description = description;
    }

    public Long getId() { return id;}
    public String getDescription() {return description; }
    public User getRequester() {return requester;}

    public void setId(Long id) { this.id = id;}
    public void setDescription(String description) { this.description = description;}
    public void setRequester(User requester) { this.requester = requester;}

    @Override
    public String toString(){
        return "RequestedItem: Id : "+id+"description: " + description;
    }
}
