package com.practice.ig.service.interfaces;

import com.practice.ig.entity.Photos;

import java.util.List;

public interface PhotosService {
    public List<Photos> findAll();
    public Photos findPhotoById(int id);
    public void savePhoto(Photos photo);
}
