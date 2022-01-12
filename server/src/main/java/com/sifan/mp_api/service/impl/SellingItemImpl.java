package com.sifan.mp_api.service.impl;


import com.sifan.mp_api.dto.RequestedItemData;
import com.sifan.mp_api.dto.SellingItemData;
import com.sifan.mp_api.dto.UserData;
import com.sifan.mp_api.model.SellingItem;
import com.sifan.mp_api.model.User;
import com.sifan.mp_api.repository.SellingItemRepository;
import com.sifan.mp_api.repository.UserRepository;
import com.sifan.mp_api.service.SellingItemService;
import com.sifan.mp_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;



@Service("sellingItemService")
public class SellingItemImpl implements SellingItemService {
    @Autowired
    private SellingItemRepository sellingItemRepo;
    @Autowired
    private UserRepository userRepo;
    @Resource(name = "userService")
    private UserService userService;
    @Override
    public SellingItemData saveSellingItem(SellingItemData sellingItemData){
        SellingItem sellingItem = populateSellingItemEntity(sellingItemData);
        return populateSellingItemData(sellingItemRepo.save(sellingItem));
    }
    @Override
    public boolean deleteSellingItemById(final Long sellingItemId){
        sellingItemRepo.deleteById(sellingItemId);
        return true;
    }
    @Override
    public SellingItemData getSellingItemById(final Long sellingItemId){
        SellingItem sellingItem = sellingItemRepo.getById(sellingItemId);
        return populateSellingItemData(sellingItem);
    }
    @Override
    public List<SellingItemData> getAllSellingItems(){
        List<SellingItemData> sellingItemDataList = new ArrayList<>();
        List<SellingItem> sellingItemList = sellingItemRepo.findAll();
        sellingItemList.forEach(sellingItem -> {
            sellingItemDataList.add(populateSellingItemData(sellingItem));
        });
        return sellingItemDataList;
    }

    @Override
    public List<SellingItemData> findSellingItemsByLatLng(final double lat, final double lng){
        List<SellingItemData> sellingItemDataList = new ArrayList<>();
        List<User> userList = userRepo.findByLatBetweenAndLngBetween(lat-0.01, lat+0.01,lng-0.01,lng+0.01);
        userList.forEach(user -> {
            userService.getSellingItemsByUserId(user.getId()).forEach(sellingItemData -> {
                sellingItemDataList.add(sellingItemData);
            });
        });
        return sellingItemDataList;
    }
    public UserData populateUserData(final User user){
        UserData userData = new UserData();
        userData.setId(user.getId());
        userData.setNickname(user.getNickname());
        userData.setLat(user.getLat());
        userData.setLng(user.getLng());
        return userData;
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

    public SellingItem populateSellingItemEntity(final SellingItemData sellingItemData){
        SellingItem sellingItem = new SellingItem();
//        sellingItem.setId(sellingItemData.getId());
        sellingItem.setPrice(sellingItemData.getPrice());
        sellingItem.setIsDollar(sellingItemData.getIsDollar());
        sellingItem.setDescription(sellingItemData.getDescription());

        sellingItem.setIsDeliverable(sellingItemData.getIsDeliverable());
//        sellingItem.setApartment(sellingItemData.getApartment());
        User seller = userRepo.getById(sellingItemData.getSellerId());
        sellingItem.setSeller(seller);
        return sellingItem;
    }

//    private SellingItemData populateSellingItemData(final SellingItem sellingItem){
//        SellingItemData sellingItemData = new SellingItemData();
//        sellingItemData.setId(sellingItem.getId());
//        sellingItemData.setPrice(sellingItem.getPrice());
//        sellingItemData.setIsDollar(sellingItem.getIsDollar());
//        sellingItemData.setDescription(sellingItem.getDescription());
//
//        sellingItemData.setIsDeliverable(sellingItem.getIsDeliverable());
////        sellingItemData.setApartment(sellingItem.getApartment());
//        UserData sellerData = populateUserData(sellingItem.getSeller());
//        sellingItemData.setSeller(sellerData);
//        sellingItemData.setSellerId(sellerData.getId());
//        return sellingItemData;
//    }
//    private UserData populateUserData(final User user){
//        UserData userData = new UserData();
//        userData.setId(user.getId());
//        userData.setNickname(user.getNickname());
//
//        return userData;
//    }
//
//    private SellingItem populateSellingItemEntity(final SellingItemData sellingItemData){
//        SellingItem sellingItem = new SellingItem();
//        sellingItem.setId(sellingItemData.getId());
//        sellingItem.setPrice(sellingItemData.getPrice());
//        sellingItem.setIsDollar(sellingItemData.getIsDollar());
//        sellingItem.setDescription(sellingItemData.getDescription());
//
//        sellingItem.setIsDeliverable(sellingItemData.getIsDeliverable());
////        sellingItem.setApartment(sellingItemData.getApartment());
//        sellingItem.setSeller(populateUserEntity(sellingItemData.getSeller()));
//        return sellingItem;
//    }
//
//    private User populateUserEntity(final UserData userData){
//        User user = new User();
//        user.setId(userData.getId());
//        user.setNickname(userData.getNickname());
//        return user;
//    }

}
