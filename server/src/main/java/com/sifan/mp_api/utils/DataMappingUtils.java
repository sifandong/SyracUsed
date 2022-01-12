//package com.sifan.mp_api.utils;
//
//
//import com.sifan.mp_api.dto.RequestedItemData;
//import com.sifan.mp_api.dto.SellingItemData;
//import com.sifan.mp_api.dto.UserData;
//import com.sifan.mp_api.model.RequestedItem;
//import com.sifan.mp_api.model.SellingItem;
//import com.sifan.mp_api.model.User;
//import com.sifan.mp_api.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class DataMappingUtils {
//
//    @Autowired
//    private UserRepository userRepo;
//
//    public static UserData populateUserData(final User user){
//        UserData userData = new UserData();
//        userData.setId(user.getId());
//        userData.setNickname(user.getNickname());
//        userData.setLat(user.getLat());
//        userData.setLng(user.getLng());
//        return userData;
//    }
//
//    public static User populateUserEntity(final UserData userData){
//        User user = new User();
////        user.setId(userData.getId());
//        user.setNickname(userData.getNickname());
//        user.setLat(userData.getLat());
//        user.setLng(userData.getLng());
//        return user;
//    }
//
//    public static RequestedItemData populateRequestedItemData(final RequestedItem requestedItem){
//        RequestedItemData requestedItemData = new RequestedItemData();
//        requestedItemData.setId(requestedItem.getId());
//        requestedItemData.setDescription(requestedItem.getDescription());
//        requestedItemData.setRequesterId(requestedItem.getRequester().getId());
//        return requestedItemData;
//    }
//
//    public static RequestedItem populateRequestedItemEntity(final RequestedItemData requestedItemData){
//        RequestedItem requestedItem = new RequestedItem();
////        requestedItem.setId(requestedItemData.getId());
//        requestedItem.setDescription(requestedItemData.getDescription());
//        User requester = userRepo.getById(requestedItemData.getRequesterId());
//        requestedItem.setRequester(requester);
//        return requestedItem;
//    }
//
//    public static SellingItemData populateSellingItemData(final SellingItem sellingItem){
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
//
//    public static SellingItem populateSellingItemEntity(final SellingItemData sellingItemData){
//        SellingItem sellingItem = new SellingItem();
////        sellingItem.setId(sellingItemData.getId());
//        sellingItem.setPrice(sellingItemData.getPrice());
//        sellingItem.setIsDollar(sellingItemData.getIsDollar());
//        sellingItem.setDescription(sellingItemData.getDescription());
//
//        sellingItem.setIsDeliverable(sellingItemData.getIsDeliverable());
////        sellingItem.setApartment(sellingItemData.getApartment());
//        User seller = userRepo.getById(sellingItemData.getSellerId());
//        sellingItem.setSeller(seller);
//        return sellingItem;
//    }
//}

