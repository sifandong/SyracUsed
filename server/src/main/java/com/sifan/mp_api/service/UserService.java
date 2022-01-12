package com.sifan.mp_api.service;

import com.sifan.mp_api.dto.RequestedItemData;
import com.sifan.mp_api.dto.SellingItemData;
import com.sifan.mp_api.dto.UserData;
import com.sifan.mp_api.model.RequestedItem;

import java.util.List;

public interface UserService {
    UserData saveUser(UserData userData);
    boolean deleteUserById(final Long userId);
    UserData getUserById(final Long userId);
    List<UserData> getAllUsers();
    List<SellingItemData> getSellingItemsByUserId(final Long userId);
    List<RequestedItemData> getRequestedItemsByUserId(final Long userId);

}
