package com.orange.shop.service.impl;


import com.orange.shop.base.BaseMapper;
import com.orange.shop.base.BaseServiceImpl;
import com.orange.shop.entity.Comment;
import com.orange.shop.mapper.CommentMapper;
import com.orange.shop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public BaseMapper<Comment> getBaseDao() {
        return commentMapper;
    }
}
