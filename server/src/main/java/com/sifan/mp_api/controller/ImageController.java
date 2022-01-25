package com.sifan.mp_api.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ImageController {
    @PostMapping("/uploadImages")
    public void uploadImage(HttpServletRequest request, @RequestParam("file") MultipartFile[] file){
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println(request.getParameterNames());
//        System.out.println();
//        System.out.println();
//        System.out.println();
        if(file != null && file.length > 0){
            for(MultipartFile temp:file){
                try{
                    System.out.println(temp.getOriginalFilename());
                    String path = "D:/SyracUsed/server/src/main/resources/upload/"+temp.getOriginalFilename();
                    temp.transferTo(new File(path));
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }



    }
}
