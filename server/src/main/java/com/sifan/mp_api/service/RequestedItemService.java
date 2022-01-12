package com.sifan.mp_api.service;

import com.sifan.mp_api.dto.RequestedItemData;

import java.util.List;

public interface RequestedItemService {
    RequestedItemData saveRequestedItem(RequestedItemData requestedItemData);
    boolean deleteRequestedItemById(final Long requestedItemId);
    RequestedItemData getRequestedItemById(final Long requestedItemId);
    List<RequestedItemData> getAllRequestedItems();
    List<RequestedItemData> findRequestedItemsByLatLng(final double lat, final double lng);
}
