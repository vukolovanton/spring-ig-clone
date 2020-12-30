package com.practice.ig.service.implementation;

import com.practice.ig.entity.Photos;
import com.practice.ig.repository.interfaces.PhotosRepository;
import com.practice.ig.repository.interfaces.UserRepository;
import com.practice.ig.service.interfaces.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PhotosServiceImpl implements PhotosService {
    private PhotosRepository photosRepository;
    private UserRepository userRepository;
    @Autowired
    public PhotosServiceImpl(PhotosRepository photosRepository, UserRepository userRepository) {
        this.photosRepository = photosRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<Photos> findAll() {
        return photosRepository.findAll();
    }

    @Override
    @Transactional
    public Photos findPhotoById(int id) {
        return photosRepository.findPhotoById(id);
    }

    @Override
    @Transactional
    public void savePhoto(Photos photo) {
        photosRepository.savePhoto(photo);
    }

    @Override
    public List<Photos> getOldestPhotos(Timestamp time) {
        return photosRepository.getOldestPhotos(time);
    }
}
