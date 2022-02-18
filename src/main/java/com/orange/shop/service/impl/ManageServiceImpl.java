package com.orange.shop.service.impl;

import com.orange.shop.base.BaseMapper;
import com.orange.shop.base.BaseServiceImpl;
import com.orange.shop.entity.Manage;
import com.orange.shop.mapper.ManageMapper;
import com.orange.shop.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageServiceImpl extends BaseServiceImpl<Manage> implements ManageService {

    @Autowired
    private ManageMapper managerMapper;

    @Override
    public BaseMapper<Manage> getBaseDao() {
        return  managerMapper;
    }
}
