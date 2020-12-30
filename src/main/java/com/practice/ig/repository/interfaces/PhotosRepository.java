package com.practice.ig.repository.interfaces;

import com.practice.ig.entity.Photos;

import java.sql.Timestamp;
import java.util.List;

public interface PhotosRepository {
    public List<Photos> findAll();
    public Photos findPhotoById(int id);
    public void savePhoto(Photos photo);
    public List<Photos> getOldestPhotos(Timestamp time);
}
