package com.sifan.mp_api.service.impl;


import com.sifan.mp_api.dto.RequestedItemData;
import com.sifan.mp_api.dto.SellingItemData;
import com.sifan.mp_api.dto.UserData;
import com.sifan.mp_api.model.RequestedItem;
import com.sifan.mp_api.model.SellingItem;
import com.sifan.mp_api.model.User;
import com.sifan.mp_api.repository.UserRepository;
import com.sifan.mp_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;




@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserData saveUser(UserData userData) {
        User userInstance = populateUserEntity(userData);
        return populateUserData((userRepo.save(userInstance)));
    }

    @Override
    public boolean deleteUserById(final Long userId){
        userRepo.deleteById(userId);
        return true;
    }

    @Override
    public UserData getUserById(final Long userId){
        User user = userRepo.findById(userId).orElseThrow(()->
                new EntityNotFoundException("User Not Found"));
        return populateUserData(user);
    }

    @Override
    public List<UserData> getAllUsers(){
        List<UserData> userDataList = new ArrayList<>();
        List<User> userList = userRepo.findAll();
        userList.forEach(user -> {
            userDataList.add(populateUserData(user));
        });
        return userDataList;
    }

    @Override
    public List<SellingItemData> getSellingItemsByUserId(final Long userId){
        List<SellingItemData> sellingItemDataList = new ArrayList<>();
        User user = userRepo.getById(userId);
        Set<SellingItem> sellingItemSet = user.getSellingItems();
        sellingItemSet.forEach(sellingItem -> {
            sellingItemDataList.add(populateSellingItemData(sellingItem));
        });

        return sellingItemDataList;
    }
    @Override
    public List<RequestedItemData> getRequestedItemsByUserId(final Long userId){
        List<RequestedItemData> requestedItemDataList = new ArrayList<>();
        User user = userRepo.getById(userId);
        Set<RequestedItem> requestedItemDataSet = user.getRequestedItems();
        requestedItemDataSet.forEach(requestedItem -> {
            requestedItemDataList.add(populateRequestedItemData(requestedItem));
        });

        return requestedItemDataList;
    }

    public UserData populateUserData(final User user){
        UserData userData = new UserData();
        userData.setId(user.getId());
        userData.setNickname(user.getNickname());
        userData.setLat(user.getLat());
        userData.setLng(user.getLng());
        return userData;
    }

    public User populateUserEntity(final UserData userData){
        User user = new User();
//        user.setId(userData.getId());
        user.setNickname(userData.getNickname());
        user.setLat(userData.getLat());
        user.setLng(userData.getLng());
        return user;
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
    public SellingItemData populateSellingItemData(final SellingItem sellingItem){
        SellingItemData sellingItemData = new SellingItemData();
        sellingItemData.setId(sellingItem.getId());
        sellingItemData.setPrice(sellingItem.getPrice());
        sellingItemData.setIsDollar(sellingItem.getIsDollar());
        sellingItemData.setDescription(sellingItem.getDescription());
        sellingItemData.setIsDeliverable(sellingItem.getIsDeliverable());
//        sellingItemData.setApartment(sellingItem.getApartment());
        UserData sellerData = populateUserData(sellingItem.getSeller());
        sellingItemData.setSeller(sellerData);
        sellingItemData.setSellerId(sellerData.getId());
        return sellingItemData;
    }



//    private UserData populateUserData(final User user){
//        UserData userData = new UserData();
//        userData.setId(user.getId());
//        userData.setNickname(user.getNickname());
//
//        return userData;
//    }
//
//    private User populateUserEntity(final UserData userData){
//        User user = new User();
//        user.setId(userData.getId());
//        user.setNickname(userData.getNickname());
//        return user;
//    }
//    private SellingItemData populateSellingItemData(final SellingItem sellingItem){
//        SellingItemData sellingItemData = new SellingItemData();
//        sellingItemData.setId(sellingItem.getId());
//        sellingItemData.setPrice(sellingItem.getPrice());
//        sellingItemData.setIsDollar(sellingItem.getIsDollar());
//        sellingItemData.setDescription(sellingItem.getDescription());
//        sellingItemData.setLat(sellingItem.getLat());
//        sellingItemData.setLng(sellingItem.getLng());
//        sellingItemData.setIsDeliverable(sellingItem.getIsDeliverable());
//        sellingItemData.setApartment(sellingItem.getApartment());
//        UserData sellerData = populateUserData(sellingItem.getSeller());
//        sellingItemData.setSeller(sellerData);
//        sellingItemData.setSellerId(sellerData.getId());
//        return sellingItemData;
//    }
//
//    private RequestedItemData populateRequestedItemData(final RequestedItem requestedItem){
//        RequestedItemData requestedItemData = new RequestedItemData();
//        requestedItemData.setId(requestedItem.getId());
//        requestedItemData.setDescription(requestedItem.getDescription());
//        requestedItemData.setRequesterId(requestedItem.getRequester().getId());
//        return requestedItemData;
//    }
}
