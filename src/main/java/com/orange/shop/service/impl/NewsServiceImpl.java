package com.orange.shop.service.impl;

import com.orange.shop.base.BaseMapper;
import com.orange.shop.base.BaseServiceImpl;
import com.orange.shop.entity.News;
import com.orange.shop.mapper.NewsMapper;
import com.orange.shop.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public BaseMapper<News> getBaseDao() {
        return newsMapper;
    }
}
