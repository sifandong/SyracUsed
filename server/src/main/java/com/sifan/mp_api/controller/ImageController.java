package com.sifan.mp_api.controller;


import com.sifan.mp_api.dto.ImageData;
import com.sifan.mp_api.model.Image;
import com.sifan.mp_api.model.SellingItem;
import com.sifan.mp_api.repository.ImageRepository;
import com.sifan.mp_api.repository.SellingItemRepository;
import com.sifan.mp_api.service.ImageService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ImageController {
    @Resource(name = "imageService")
    private ImageService imageService;
    @Autowired
    private ImageRepository imageRepo;
    @Autowired
    private SellingItemRepository sellingItemRepo;
    @PostMapping("/uploadImages")
    public ImageData uploadImage(HttpServletRequest request, @RequestParam("file") MultipartFile[] file){
//        String path = new String();
        String absPath = new String();
        if(file != null && file.length > 0){
            for(MultipartFile temp:file){
                try{
                    System.out.println(temp.getOriginalFilename());
                    String path = "D:/SyracUsed/server/src/main/resources/upload/"+temp.getOriginalFilename();
                    absPath = path;
                    temp.transferTo(new File(path));
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        String tmpString = request.getParameter("uploaderId");
        Long uploaderId = Long.parseLong(tmpString);
        ImageData imageData = new ImageData();
        imageData.setUploaderId(uploaderId);
        imageData.setPath(absPath);
        Long dummy = new Long(1);
        imageData.setItemId(dummy);


        return imageService.saveImage(imageData);




    }

    @PutMapping("/updateImage")
    public ImageData updateImageInfo(
            @RequestParam(value = "imageId") Long imageId,
            @RequestParam(value = "itemId") Long itemId
    ){
        System.out.println(imageId);
        System.out.println(itemId);
       return imageService.updateImage(imageId, itemId);
    }
}
