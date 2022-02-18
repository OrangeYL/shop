package com.orange.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.orange.shop.base.BaseController;
import com.orange.shop.entity.*;
import com.orange.shop.service.ItemCategoryService;
import com.orange.shop.service.ItemService;
import com.orange.shop.service.ManageService;
import com.orange.shop.service.UserService;
import com.orange.shop.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 登录相关controller
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private ManageService managerService;
    @Autowired
    private ItemCategoryService itemCategoryService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;

    /**
     * 转向后台管理员登录页面
     * @return
     */
    @RequestMapping("/mLogin")
    public String mLogin(){
        return "/login/mLogin";
    }

    /**
     * 管理员登录验证
     * @param manager
     * @param request
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(Manage manager, HttpServletRequest request){
        Manage entity = managerService.getByEntity(manager);
        if(entity==null){
            return "redirect:/login/mLogin";
        }
        request.getSession().setAttribute(Const.MANAGE,entity);
        return "/login/mIndex";
    }

    /**
     * 管理员退出登录
     * @param request
     * @return
     */
    @RequestMapping("/mLogout")
    public String mLogout(HttpServletRequest request){
        request.getSession().setAttribute(Const.MANAGE,null);
        return "/login/mLogin";
    }

    /**
     * 前端首页
     * @param item
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/uIndex")
    public String uIndex(Item item, Model model, HttpServletRequest request){
        List<ItemCategory> categories = itemCategoryService.findByEntity(null);
        ArrayList<CategoryDto> list = new ArrayList<>();
        if(!CollectionUtils.isEmpty(categories)){
            for(ItemCategory ic:categories){
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setFather(ic);
                Integer id = ic.getId();
                ItemCategory itemCategory = new ItemCategory();
                itemCategory.setPid(id);
                List<ItemCategory> itemCategories = itemCategoryService.querySubItemCategoryPage(itemCategory);
                categoryDto.setChildrens(itemCategories);
                list.add(categoryDto);
                model.addAttribute("lbs",list);
            }
        }
        List<Item> zks = itemService.queryDiscountItem();
        model.addAttribute("zks",zks);
        List<Item> rxs = itemService.queryHotSellItem();
        model.addAttribute("rxs",rxs);
        return "/login/uIndex";
    }

    /**
     * 前端用户注册
     * @return
     */
    @RequestMapping("/res")
    public String register(){
        return "/login/register";
    }

    /**
     * 执行前端用户注册
     * @param user
     * @return
     */
    @RequestMapping("/toRes")
    public String toRegister(User user){
        userService.insert(user);
        return "/login/uLogin";
    }

    /**
     * 普通用户登录入口
     */
    @RequestMapping("/uLogin")
    public String uLogin(){
        return "/login/uLogin";
    }

    /**
     * 执行普通用户登录
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/utoLogin")
    public String utoLogin(User user,HttpServletRequest request){
        User byEntity = userService.getByEntity(user);
        if(byEntity==null){
            return "redirect:/login/res";
        }else {
            request.getSession().setAttribute("role",2);
            request.getSession().setAttribute(Const.USERNAME,byEntity.getUserName());
            request.getSession().setAttribute(Const.USERID,byEntity.getId());
            return "redirect:/login/uIndex";
        }
    }

    /**前端用户退出*/
    @RequestMapping("/uLogout")
    public String uLogout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login/uIndex";
    }

    /**
     * 修改密码入口
     */
    @RequestMapping("/pass")
    public String pass(HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Const.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User load = userService.load(userId);
        request.setAttribute("obj",load);
        return "/login/pass";
    }

    /**
     * 修改密码操作
     */
    @RequestMapping("/updatePassword")
    @ResponseBody
    public String updatePassword(String password,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Const.USERID);
        JSONObject js = new JSONObject();
        if(attribute==null){
            js.put(Const.RES,0);
            return js.toString();
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User load = userService.load(userId);
        load.setPassword(password);
        userService.updateById(load);
        js.put(Const.RES,1);
        return js.toString();
    }
}
