package com.orange.shop.controller;


import com.github.pagehelper.PageInfo;
import com.orange.shop.base.BaseController;
import com.orange.shop.entity.News;
import com.orange.shop.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * 公告管理
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    /**
     * 公告列表
     * @param news
     * @param model
     * @return
     */
    @RequestMapping("/queryNewsPage")
    public String queryNewsPage(News news, Model model,
                                @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        PageInfo<News> pagers = newsService.queryByPage(pageNum, pageSize, news);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",news);
        return "/news/news";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        return "/news/add";
    }

    /**
     * 添加执行
     */
    @RequestMapping("/exAdd")
    public String exAdd(News news){
        news.setAddTime(new Date());
        newsService.insert(news);
        return "redirect:/news/queryNewsPage";
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        News obj = newsService.load(id);
        model.addAttribute("obj",obj);
        return "/news/update";
    }

    /**
     * 修改执行
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(News news){
        newsService.updateById(news);
        return "redirect:/news/queryNewsPage";
    }

    /**
     * 删除公告
     */
    @RequestMapping("/delete")
    public String delete(Integer id,int pageNum,int pageTotal){
        newsService.deleteById(id);
        if(pageNum!=1){
            if(pageTotal%5==0){
                pageNum=pageNum-1;
            }
        }
        return "redirect:/news/queryNewsPage?pageNum="+pageNum;
    }

    /**
     * 前端公告列表
     * @param
     * @param model
     * @return
     */
    @RequestMapping("/newsList")
    public String newsList(Model model,
                           @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                           @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        PageInfo<News> pagers = newsService.queryByPage(pageNum, pageSize, new News());
        model.addAttribute("pagers",pagers);
        return "/news/newsList";
    }

    /**
     * 前端公告详情页面
     */
    @RequestMapping("/view")
    public String view(Integer id,Model model){
        News obj = newsService.load(id);
        model.addAttribute("obj",obj);
        return "/news/view";
    }

}
