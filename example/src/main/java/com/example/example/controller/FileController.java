package com.example.example.controller;

import dto.DefaultUploadContent;
import dto.UploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import service.FileService;

/**
 * @author wei.li
 * @date 2018/11/18 16:23
 * @desc
 */
@RestController
@RequestMapping("file")
public class FileController {
    @Autowired
    private FileService fileService;
    @PostMapping("/upload")
    public UploadResult upload(MultipartFile file)throws Exception{
        return fileService.upload(new DefaultUploadContent(file.getInputStream()));
    }
}
