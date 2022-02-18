package com.orange.shop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orange.shop.base.BaseController;
import com.orange.shop.entity.Item;
import com.orange.shop.entity.ItemCategory;
import com.orange.shop.service.ItemCategoryService;
import com.orange.shop.service.ItemService;
import com.orange.shop.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 商品controller
 */
@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemCategoryService itemCategoryService;

    /**
     * 分页查询商品列表
     * @param item
     * @param model
     * @return
     */
    @RequestMapping("/queryItemPage")
    public String queryItemPage(Item item, Model model,
                                @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        PageInfo<Item> pagers = itemService.queryByPage(pageNum, pageSize, item);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",item);
        return "/item/item";
    }

    /**
     * 转向新增商品页面
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String add(Model model){
        List<ItemCategory> itemCategories = itemCategoryService.querySubItemCategory();
        model.addAttribute("types",itemCategories);
        return "/item/add";
    }

    /**
     * 执行添加商品
     */
    @RequestMapping("/exAdd")
    public String exAdd(Item item, @RequestParam("file")MultipartFile[] files, HttpServletRequest request) throws IOException {
        itemCommon(item, files, request);
        item.setBuyNum(0);
        item.setCollectNum(0);
        item.setIsDelete(0);
        itemService.insert(item);
        return "redirect:/item/queryItemPage";
    }

    /**
     * 修改商品入口
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        Item obj = itemService.load(id);
        List<ItemCategory> itemCategories = itemCategoryService.querySubItemCategory();
        model.addAttribute("types",itemCategories);
        model.addAttribute("obj",obj);
        return "/item/update";
    }

    /**
     *  执行修改商品
     * @param item
     * @param files
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(Item item, @RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws IOException {
        itemCommon(item, files, request);
        itemService.updateById(item);
        return "redirect:/item/queryItemPage";
    }

    /**
     * 商品下架
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String update(Integer id,int pageNum,int pageTotal){
        Item obj = itemService.load(id);
        obj.setIsDelete(1);
        int i = itemService.PageDelete(obj, pageNum, pageTotal);
        return "redirect:/item/queryItemPage?pageNum="+i;
    }

    /**
     * 新增和更新的公共方法
     */
    private void itemCommon(Item item, @RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws IOException {
        if(files.length>0) {
            for (int s = 0; s < files.length; s++) {
                String n=UUIDUtils.create();
                String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"upload";
                File file1 = new File(filePath);
                if(!file1.exists()){
                    file1.mkdir();
                }
                File dest = new File(filePath + System.getProperty("file.separator") + n + files[s].getOriginalFilename());
                //通过MultipartFile的方法直接写文件
                files[s].transferTo(dest);
                if (s == 0) {
                    if(!isEmpty(files[s].getOriginalFilename())){
                        item.setUrl1("/upload/"+n + files[s].getOriginalFilename());
                    }
                    item.setUrl1(item.getUrl1());
                }
                if (s == 1) {
                    if(!isEmpty(files[s].getOriginalFilename())){
                        item.setUrl2("/upload/"+n + files[s].getOriginalFilename());
                    }
                    item.setUrl2(item.getUrl2());
                }
                if (s == 2) {
                    if(!isEmpty(files[s].getOriginalFilename())){
                        item.setUrl3("/upload/"+n + files[s].getOriginalFilename());
                    }
                    item.setUrl3(item.getUrl3());
                }
                if (s == 3) {
                    if(!isEmpty(files[s].getOriginalFilename())){
                        item.setUrl4("/upload/"+n + files[s].getOriginalFilename());
                    }
                    item.setUrl4(item.getUrl4());
                }
                if (s == 4) {
                    if(!isEmpty(files[s].getOriginalFilename())){
                        item.setUrl5("/upload/"+n + files[s].getOriginalFilename());
                    }
                    item.setUrl5(item.getUrl5());
                }
            }
        }
        ItemCategory byId = itemCategoryService.load(item.getCategoryIdTwo());
        item.setCategoryIdOne(byId.getPid());
    }

    /**
     * 按关键字或者二级分类查询 分页
     * @param item
     * @param model
     * @param condition
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/shopList")
    public String shopList(Item item,Model model, String condition,
                           @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                           @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Item> items = itemService.querySubOrKey(item,condition);
        PageInfo<Item> pagers = new PageInfo<>(items);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",item);
        if(condition!=null){
            model.addAttribute("condition",condition);
        }
       return "/item/shopList";
    }

    /**
     * 商品详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/view")
    public String view(Integer id,Model model){
        Item obj = itemService.load(id);
        model.addAttribute("obj",obj);
        return "/item/view";
    }
}
