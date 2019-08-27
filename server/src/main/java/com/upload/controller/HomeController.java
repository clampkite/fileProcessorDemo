package com.upload.controller;

import com.upload.utils.FileHandlers;
import com.upload.utils.StatusCodeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/process")
public class HomeController {

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Object uploadFile(@RequestParam("file") MultipartFile file) {
        return FileHandlers.uploadFile(file, uploadFolder);
    }


    @RequestMapping("/info")
    public Object info() {
        Map<String, Object> map = new HashMap<>();
        map.put("info", "hello world");
        return map;
    }

}
