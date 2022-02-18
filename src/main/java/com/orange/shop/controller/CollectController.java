package com.orange.shop.controller;

import com.github.pagehelper.PageInfo;
import com.orange.shop.base.BaseController;
import com.orange.shop.entity.Collect;
import com.orange.shop.entity.Item;
import com.orange.shop.service.CollectService;
import com.orange.shop.service.ItemService;
import com.orange.shop.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 收藏
 */
@Controller
@RequestMapping("/collect")
public class CollectController extends BaseController {

    @Autowired
    private CollectService collectService;

    @Autowired
    private ItemService itemService;

    /**
     * 根据用户id查询收藏列表
     * @param model
     * @param request
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryCollectPage")
    public String queryCollectPage(Model model, HttpServletRequest request,
                                   @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        Object attribute = request.getSession().getAttribute(Const.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        Collect collect = new Collect();
        collect.setUserId(Integer.valueOf(attribute.toString()));
        PageInfo<Collect> pagers = collectService.queryByPage(pageNum, pageSize, collect);
        model.addAttribute("pagers",pagers);
        return "/collect/myCollect";
    }

    /**
     * 添加收藏
     * @param collect
     * @param request
     * @return
     */
    @RequestMapping("/addCollect")
    public String addCollect(Collect collect,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Const.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        //添加收藏
        Integer userId = Integer.valueOf(attribute.toString());
        collect.setUserId(userId);
        collectService.insert(collect);
        //收藏数加1
        Item item = itemService.load(collect.getItemId());
        item.setCollectNum(item.getCollectNum()+1);
        itemService.updateById(item);
        return "redirect:/collect/queryCollectPage";
    }

    /**
     * 取消收藏
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer id,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Const.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        collectService.deleteById(id);
        return "redirect:/collect/queryCollectPage";
    }
}
