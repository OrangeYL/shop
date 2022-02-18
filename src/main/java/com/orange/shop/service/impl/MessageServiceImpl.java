package com.orange.shop.service.impl;

import com.orange.shop.base.BaseMapper;
import com.orange.shop.base.BaseServiceImpl;
import com.orange.shop.entity.Message;
import com.orange.shop.mapper.MessageMapper;
import com.orange.shop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public BaseMapper<Message> getBaseDao() {
        return messageMapper;
    }
}
