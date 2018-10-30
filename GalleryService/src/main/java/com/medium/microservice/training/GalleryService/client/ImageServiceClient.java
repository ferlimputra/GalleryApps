package com.medium.microservice.training.GalleryService.client;

import java.util.List;

import com.medium.microservice.training.GalleryService.dto.ImageData;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ImageServiceClient
 */
@FeignClient("ImageService")
public interface ImageServiceClient {

    @RequestMapping("images")
    public List<ImageData> getImages();
}