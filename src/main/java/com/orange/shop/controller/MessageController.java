package com.orange.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.orange.shop.base.BaseController;
import com.orange.shop.entity.Message;
import com.orange.shop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 留言管理
 */
@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;

    /**
     * 留言列表
     */
    @RequestMapping("/queryMessagePage")
    public String queryMessagePage(Message message, Model model,
                                   @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        PageInfo<Message> pagers = messageService.queryByPage(pageNum, pageSize, message);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",message);
        return "/message/message";
    }

    /**
     * 删除留言
     */
    @RequestMapping("/delete")
    public String delete(Integer id,int pageNum,int pageTotal){
        messageService.deleteById(id);
        if(pageNum!=1){
            if(pageTotal%5==0){
                pageNum=pageNum-1;
            }
        }
        return "redirect:/message/queryMessagePage?pageNum="+pageNum;
    }
    /**
     * 前端发表留言进入
     */
    @RequestMapping("/addMessage")
    public String addMessage(){
        return "/message/addMessage";
    }

    /**
     * 发表留言
     */
    @RequestMapping("/exAddMessage")
    @ResponseBody
    public String exAddMessage(Message message){
        messageService.insert(message);
        JSONObject js = new JSONObject();
        js.put("message","添加成功");
        return js.toString();
    }
}
