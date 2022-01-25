package com.sifan.mp_api.service.impl;


import com.sifan.mp_api.dto.ImageData;
import com.sifan.mp_api.dto.SellingItemData;
import com.sifan.mp_api.dto.UserData;
import com.sifan.mp_api.model.Image;
import com.sifan.mp_api.model.SellingItem;
import com.sifan.mp_api.model.User;
import com.sifan.mp_api.repository.ImageRepository;
import com.sifan.mp_api.repository.UserRepository;
import com.sifan.mp_api.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("imageService")
public class ImageImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepo;
    @Autowired
    private UserRepository userRepo;
    @Override
    public ImageData saveImage(ImageData imageData) {
        Image image = populateImageEntity(imageData);
        return populateImageData(imageRepo.save(image));
    }

    @Override
    public boolean deleteImageById(Long imageId) {
        imageRepo.deleteById(imageId);
        return true;
    }

    @Override
    public ImageData getImageById(Long imageId) {
        Image image = imageRepo.getById(imageId);
        return populateImageData(image);
    }

    @Override
    public List<ImageData> getAllImages() {
        List<ImageData> imageDataList = new ArrayList<>();
        List<Image> imageList = imageRepo.findAll();
        imageList.forEach(image -> {
            imageDataList.add(populateImageData(image));
        });
        return imageDataList;
    }


    public ImageData populateImageData(final Image image){
        ImageData imageData = new ImageData();
        imageData.setId(image.getId());
        imageData.setPath(image.getPath());
        imageData.setUploader(populateUserData(image.getUploader()));
        imageData.setItem(populateSellingItemData(image.getItem()));
        imageData.setUploaderId();
        imageData.setItemId();
        return imageData;
    }
    public Image populateImageEntity(final ImageData imageData){
        Image image = new Image();
        image.setId(imageData.getId());
        image.setPath(imageData.getPath());
        image.setUploader(populateUserEntity(imageData.getUploader()));
        image.setItem(populateSellingItemEntity(imageData.getItem()));
        return image;
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
    public User populateUserEntity(final UserData userData){
        User user = new User();
//        user.setId(userData.getId());
        user.setNickname(userData.getNickname());
        user.setLat(userData.getLat());
        user.setLng(userData.getLng());
        return user;
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
}
