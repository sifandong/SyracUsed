package com.sifan.mp_api.service.impl;


import com.sifan.mp_api.dto.RequestedItemData;
import com.sifan.mp_api.dto.UserData;
import com.sifan.mp_api.model.RequestedItem;
import com.sifan.mp_api.model.User;
import com.sifan.mp_api.repository.RequestedItemRepository;
import com.sifan.mp_api.repository.UserRepository;
import com.sifan.mp_api.service.RequestedItemService;
import com.sifan.mp_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;



@Service("requestedItemService")
public class RequestedItemImpl implements RequestedItemService {
    @Autowired
    private RequestedItemRepository requestedItemRepo;
    @Autowired
    private UserRepository userRepo;
    @Resource(name = "userService")
    private UserService userService;

    @Override
    public RequestedItemData saveRequestedItem(RequestedItemData requestedItemData){
        RequestedItem requestedItem = populateRequestedItemEntity(requestedItemData);
        return populateRequestedItemData(requestedItemRepo.save(requestedItem));
    }
    @Override
    public boolean deleteRequestedItemById(final Long requestedItemId){
        requestedItemRepo.deleteById(requestedItemId);
        return true;
    }
    @Override
    public RequestedItemData getRequestedItemById(final Long requestedItemId){
        RequestedItem requestedItem = requestedItemRepo.getById(requestedItemId);
        return populateRequestedItemData(requestedItem);
    }
    @Override
    public List<RequestedItemData> getAllRequestedItems(){
        List<RequestedItemData> requestedItemDataList = new ArrayList<>();
        List<RequestedItem> requestedItemList = requestedItemRepo.findAll();
        requestedItemList.forEach(requestedItem -> {
            requestedItemDataList.add(populateRequestedItemData(requestedItem));
        });
        return requestedItemDataList;
    }
    @Override
    public List<RequestedItemData> findRequestedItemsByLatLng(final double lat, final double lng) {

        List<RequestedItemData> requestedItemDataList = new ArrayList<>();
        List<User> userList = userRepo.findByLatBetweenAndLngBetween(lat-0.01, lat+0.01,lng-0.01,lng+0.01);
        userList.forEach(user -> {
            userService.getRequestedItemsByUserId(user.getId()).forEach(requestedItemData -> {
                requestedItemDataList.add(requestedItemData);
            });
        });
        return requestedItemDataList;


    }
    public RequestedItemData populateRequestedItemData(final RequestedItem requestedItem){
        RequestedItemData requestedItemData = new RequestedItemData();
        requestedItemData.setId(requestedItem.getId());
        requestedItemData.setDescription(requestedItem.getDescription());
        requestedItemData.setRequesterId(requestedItem.getRequester().getId());
        User requester = userRepo.getById(requestedItemData.getRequesterId());
        requestedItemData.setRequester(populateUserData(requester));
        return requestedItemData;
    }

    public RequestedItem populateRequestedItemEntity(final RequestedItemData requestedItemData){
        RequestedItem requestedItem = new RequestedItem();
//        requestedItem.setId(requestedItemData.getId());
        requestedItem.setDescription(requestedItemData.getDescription());
        User requester = userRepo.getById(requestedItemData.getRequesterId());
        requestedItem.setRequester(requester);
        return requestedItem;
    }

    public UserData populateUserData(final User user){
        UserData userData = new UserData();
        userData.setId(user.getId());
        userData.setNickname(user.getNickname());
        userData.setLat(user.getLat());
        userData.setLng(user.getLng());
        return userData;
    }

//    private RequestedItemData populateRequestedItemData(final RequestedItem requestedItem){
//        RequestedItemData requestedItemData = new RequestedItemData();
//        requestedItemData.setId(requestedItem.getId());
//        requestedItemData.setDescription(requestedItem.getDescription());
//        requestedItemData.setRequesterId(requestedItem.getRequester().getId());
//        return requestedItemData;
//    }
//    private User populateUserEntity(final UserData userData){
//        User user = new User();
//        user.setId(userData.getId());
//        user.setNickname(userData.getNickname());
//        return user;
//    }
//    private RequestedItem populateRequestedItemEntity(final RequestedItemData requestedItemData){
//        RequestedItem requestedItem = new RequestedItem();
//        requestedItem.setId(requestedItemData.getId());
//        requestedItem.setDescription(requestedItemData.getDescription());
//        User requester = populateUserEntity(requestedItemData.getRequester());
//        requestedItem.setRequester(requester);
//        return requestedItem;
//    }
}
