package com.orange.shop.mapper;


import com.orange.shop.base.BaseMapper;
import com.orange.shop.entity.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * 留言
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
