package com.orange.shop.controller;

import com.github.pagehelper.PageInfo;
import com.orange.shop.base.BaseController;
import com.orange.shop.entity.User;
import com.orange.shop.service.UserService;
import com.orange.shop.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户controller
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询用户列表
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/queryUserPage")
    public String queryUserPage(Model model, User user,
                                @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        PageInfo<User> pagers = userService.queryByPage(pageNum, pageSize, user);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",user);
        return "/user/user";
    }

    /**
     * 查看用户信息
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/view")
    public String view(HttpServletRequest request,Model model){
        Object attribute = request.getSession().getAttribute(Const.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User user = userService.load(userId);
        model.addAttribute("obj",user);
        return "/user/view";
    }

    /**
     * 修改用户信息
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("exUpdate")
    public String exUpdate(User user,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Const.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        user.setId(Integer.valueOf(attribute.toString()));
        userService.updateById(user);
        return "redirect:/user/view";
    }
}
