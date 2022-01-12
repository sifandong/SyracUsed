package com.sifan.mp_api.service;

import com.sifan.mp_api.dto.SellingItemData;
import com.sifan.mp_api.model.SellingItem;

import java.util.List;

public interface SellingItemService {
    SellingItemData saveSellingItem(SellingItemData sellingItemData);
    boolean deleteSellingItemById(final Long sellingItemId);
    SellingItemData getSellingItemById(final Long sellingItemId);
    List<SellingItemData> getAllSellingItems();
    List<SellingItemData> findSellingItemsByLatLng(final double lat, final double lng);
}
