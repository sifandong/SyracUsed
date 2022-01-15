package com.sifan.mp_api.controller;


import com.sifan.mp_api.dto.RequestedItemData;
import com.sifan.mp_api.dto.SellingItemData;
import com.sifan.mp_api.service.SellingItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SellingItemController {

    @Resource(name = "sellingItemService")
    private SellingItemService sellingItemService;

    @GetMapping("/sellingItems")
    public List<SellingItemData> getAllSellingItems() {
        return sellingItemService.getAllSellingItems();
    }

    @GetMapping("/sellingItem/{id}")
    public SellingItemData getSellingItemById(final @PathVariable Long id) {
        return sellingItemService.getSellingItemById(id);
    }

    @PostMapping("/sellingItem")
    public SellingItemData saveSellingItem(final @RequestBody SellingItemData sellingItemData){
        return sellingItemService.saveSellingItem(sellingItemData);
    }

    @DeleteMapping("/sellingItem/{id}")
    public Boolean deleteSellingItem(final @PathVariable Long id){
        return sellingItemService.deleteSellingItemById(id);
    }
    @GetMapping("/sellingItemsNearMe")
    public List<SellingItemData> findSellingItemsByLatLng(
            @RequestParam(value = "lat") double lat,
            @RequestParam(value = "lng") double lng
    ) {
        return sellingItemService.findSellingItemsByLatLng(lat, lng);
    }
}
