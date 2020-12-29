package com.practice.ig.service.interfaces;

import java.util.List;

public interface CommentsService {
    public List<Comments> findAll();
    public Comments findById(int id);
}
