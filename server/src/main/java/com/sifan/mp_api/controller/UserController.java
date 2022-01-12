package com.sifan.mp_api.controller;


import com.sifan.mp_api.dto.RequestedItemData;
import com.sifan.mp_api.dto.SellingItemData;
import com.sifan.mp_api.dto.UserData;
import com.sifan.mp_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/users")
    public List<UserData> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<UserData> getUserById(@PathVariable Long id) {
//        System.out.println(" === GET POST BY ID ===");
        return new ResponseEntity<UserData>(userService.getUserById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/user")
    public UserData saveUser(final @RequestBody UserData userData) {
        return userService.saveUser(userData);
    }

    @DeleteMapping("/user/{id}")
    public Boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

    @GetMapping("/user/requestedItems/{id}")
    public List<RequestedItemData> getRequestedItemsByUserId(final @PathVariable Long id) {
        return userService.getRequestedItemsByUserId(id);
    }

    @GetMapping("user/sellingItems/{id}")
    public List<SellingItemData> getSellingItemsByUserId(final @PathVariable Long id) {
        return userService.getSellingItemsByUserId(id);
    }


}
