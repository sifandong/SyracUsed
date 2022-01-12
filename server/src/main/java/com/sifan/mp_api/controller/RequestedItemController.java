package com.sifan.mp_api.controller;


import com.sifan.mp_api.dto.RequestedItemData;
import com.sifan.mp_api.model.RequestedItem;
import com.sifan.mp_api.service.RequestedItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RequestedItemController {

    @Resource(name = "requestedItemService")
    private RequestedItemService requestedItemService;

    @GetMapping("/requestedItems")
    public List<RequestedItemData> getAllRequestedItems() {
        return requestedItemService.getAllRequestedItems();
    }

    @GetMapping("/requestedItem/{id}")
    public RequestedItemData getRequestedItemById(final @PathVariable Long id) {
        return requestedItemService.getRequestedItemById(id);
    }

    @PostMapping("/requestedItem")
    public RequestedItemData saveRequestedItem(final @RequestBody RequestedItemData requestedItemData) {
        return requestedItemService.saveRequestedItem(requestedItemData);
    }

    @DeleteMapping("/requestedItem/{id}")
    public Boolean deleteRequestedItem(@PathVariable Long id) {
        return requestedItemService.deleteRequestedItemById(id);
    }

    @GetMapping("/requestedItemsNearMe")
    public List<RequestedItemData> findRequestedItemsByLatLng(
            @RequestParam(value = "lat") double lat,
            @RequestParam(value = "lng") double lng
    ) {
        return requestedItemService.findRequestedItemsByLatLng(lat, lng);
    }
}
