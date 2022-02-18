package com.orange.shop.service.impl;

import com.orange.shop.base.BaseMapper;
import com.orange.shop.base.BaseServiceImpl;
import com.orange.shop.entity.Collect;
import com.orange.shop.mapper.CollectMapper;
import com.orange.shop.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl extends BaseServiceImpl<Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public BaseMapper<Collect> getBaseDao() {
        return collectMapper;
    }
}
