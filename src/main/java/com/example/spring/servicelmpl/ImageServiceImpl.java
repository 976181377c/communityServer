package com.example.spring.servicelmpl;

import com.example.spring.mapper.InsertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Service
public class ImageServiceImpl {
    @Autowired
    private InsertMapper insertMapper;
    public HashMap<String, Object> upload(HttpServletRequest req, MultipartFile file,String uid) {
        HashMap<String, Object> result = new HashMap<>();
        if(file == null){
            result.put("status", 500);
            result.put("data", "");
            result.put("msg", "文件为空!");
            return result;
        }
        try {
            // 根据时间戳重组文件名
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            // 文件保存路径
            String destFileName = File.separator+"var"+File.separator+"www"+File.separator+"html"+File.separator+"img"+ File.separator + fileName;
            File destFile = new File(destFileName);
            // 不存在文件夹则创建
            if(!destFile.getParentFile().exists()){
                boolean flag = destFile.getParentFile().mkdirs();
                if(!flag){
                    result.put("status", 500);
                    result.put("data", "");
                    result.put("msg", "无法创建文件夹!");
                    return result;
                }
            }
            // 复制文件到指定文件夹
            file.transferTo(destFile);
            insertMapper.saveImage(uid,fileName);
            result.put("status", 200);
            result.put("msg", "上传成功!");
            result.put("data", fileName);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            result.put("status", 500);
            result.put("data", "");
            result.put("msg", e);
            return result;
        }
    }
}
