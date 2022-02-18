package com.orange.shop.controller;

import com.orange.shop.base.BaseController;
import com.orange.shop.entity.Comment;
import com.orange.shop.service.CommentService;
import com.orange.shop.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 评论
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加执行
     */
    @RequestMapping("/addComment")
    public String addComment(Comment comment, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Const.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        comment.setAddTime(new Date());
        comment.setUserId(userId);
        commentService.insert(comment);
        return "redirect:/itemOrder/myOrder";
    }

}
