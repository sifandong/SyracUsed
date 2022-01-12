package com.sifan.mp_api.dto;

public class RequestedItemData {
    private Long id;
    private String description;
    private Long requesterId;
    private UserData requester;
    public RequestedItemData(){

    }
    public RequestedItemData(Long id, String description, Long requester_id){
        this.id = id;
        this.description =description;
        this.requesterId = requester_id;
    }

    public Long getId() { return id;}
    public String getDescription() { return description;}
    public Long getRequesterId() { return requesterId;}
    public UserData getRequester() { return requester;}

    public void setId(Long id) { this.id = id;}
    public void setDescription(String description) { this.description = description;}
    public void setRequesterId(Long requesterId) { this.requesterId = requesterId;}
    public void setRequester(UserData requester) { this.requester = requester;}
    @Override
    public String toString(){
        return "RequestedItemData: Id: " + id + "description: " + description + "requesterId: " + requesterId;
    }
}
