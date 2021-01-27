package com.practice.ig.service.implementation;

import com.practice.ig.entity.Tags;
import com.practice.ig.repository.interfaces.TagsRepository;
import com.practice.ig.service.interfaces.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {
    private TagsRepository tagsRepository;
    @Autowired
    public TagsServiceImpl(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }


    @Override
    @Transactional
    public List<Tags> findAll() {
        return tagsRepository.findAll();
    }

    @Override
    @Transactional
    public Tags findTagById(int id) {
        return tagsRepository.findTagById(id);
    }

    @Override
    public List<Tags> paginatedTagsList(int cursor, int limit) {
        return tagsRepository.paginatedTagsList(cursor, limit);
    }
}
