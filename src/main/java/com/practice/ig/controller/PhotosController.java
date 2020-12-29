package com.practice.ig.controller;

import com.practice.ig.entity.Photos;
import com.practice.ig.service.interfaces.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhotosController {
    private PhotosService photosService;
    @Autowired
    public PhotosController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/photos")
    public List<Photos> findAllPhotos() {
        return photosService.findAll();
    }

    @GetMapping("/photos/{photoId}")
    public Photos findPhotoById(@PathVariable int photoId) {
        Photos photo = photosService.findPhotoById(photoId);
        return photo;
    }

    @PostMapping("/photos")
    public Photos savePhoto(@RequestBody Photos photo) {
        System.out.println(photo.toString());
        photosService.savePhoto(photo);
        return photo;
    }


}
