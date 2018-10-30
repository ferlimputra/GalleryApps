package com.medium.microservice.training.GalleryService.controller;

import java.util.List;

import com.medium.microservice.training.GalleryService.client.ImageServiceClient;
import com.medium.microservice.training.GalleryService.dto.ImageData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GalleryController
 */
@RefreshScope
@RestController
public class GalleryController {

    @Autowired
    private ImageServiceClient imageServiceClient;
    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping("images")
    public List<ImageData> getImages() {
        return imageServiceClient.getImages();
    }

    @RequestMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }
}