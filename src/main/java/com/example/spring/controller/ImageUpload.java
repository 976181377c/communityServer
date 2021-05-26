package com.example.spring.controller;

import com.example.spring.servicelmpl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = " ",maxAge = 3600)
public class ImageUpload {
    @Autowired
    ImageServiceImpl iImageService;
    @PostMapping("/image/upload")
    public HashMap uploadImage(HttpServletRequest req, @RequestParam("file") MultipartFile file,@RequestParam("uid") String uid) {
        HashMap<String,Object> result = iImageService.upload(req,file,uid);
        return result;
//        if((boolean) result.get("flag")){
//            return Methods.success("上传成功");
//        }else{
//            return Methods.error("上传失败");
//        }
    }
}
