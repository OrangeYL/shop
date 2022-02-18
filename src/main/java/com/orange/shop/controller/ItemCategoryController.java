package com.orange.shop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orange.shop.base.BaseController;
import com.orange.shop.entity.ItemCategory;
import com.orange.shop.service.ItemCategoryService;
import com.orange.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 类目controller
 */
@Controller
@RequestMapping("/itemCategory")
public class ItemCategoryController extends BaseController {

    @Autowired
    private ItemCategoryService itemCategoryService;
    @Autowired
    private ItemService itemService;


    /**
     * 分页查询一级类目
     * @param model
     * @return
     */
    @RequestMapping("/queryItemCategoryPage")
    public String queryItemCategoryPage(Model model,ItemCategory itemCategory,
                                        @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        PageInfo<ItemCategory> pagers = itemCategoryService.queryByPage(pageNum, pageSize, itemCategory);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",itemCategory);
        return "/itemCategory/itemCategory";
    }

    /**
     * 转向新增一级类目页面
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        return "/itemCategory/add";
    }

    /**
     * 新增一级类目
     * @param itemCategory
     * @return
     */
    @RequestMapping("/exAdd")
    public String exAdd(ItemCategory itemCategory){
        itemCategory.setIsDelete(new Byte("0"));
        itemCategoryService.insert(itemCategory);
        return "redirect:/itemCategory/queryItemCategoryPage";
    }

    /**
     * 转向一级类目修改页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/update")
    public String update(Model model,Integer id){
        ItemCategory obj = itemCategoryService.load(id);
        model.addAttribute("obj",obj);
        return "/itemCategory/update";
    }

    /**
     * 修改一级类目
     * @param itemCategory
     * @return
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(ItemCategory itemCategory){
        itemCategoryService.updateById(itemCategory);
        return "redirect:/itemCategory/queryItemCategoryPage";
    }

    /**
     * 删除一级类目以及对应的二级目录
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer id,int pageNum,int pageTotal){
        //删除一级类目
        ItemCategory category = itemCategoryService.load(id);
        category.setIsDelete(new Byte("1"));
        //删除二级类目
        itemCategoryService.deleteByItemCategoryId(id);
        int i = itemCategoryService.PageDelete(category, pageNum, pageTotal);
        return "redirect:/itemCategory/queryItemCategoryPage?pageNum="+i;
    }

    /**
     * 根据一级类目查看二级类目
     * @param itemCategory
     * @param model
     * @return
     */
    @RequestMapping("/querySubItemCategoryPage")
    public String querySubItemCategoryPage(ItemCategory itemCategory, Model model,
                                           @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                           @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<ItemCategory> itemCategories = itemCategoryService.querySubItemCategoryPage(itemCategory);
        PageInfo<ItemCategory> pagers = new PageInfo<>(itemCategories);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",itemCategory);
        return "/itemCategory/itemSubCategory";
    }

    /**
     * 转向新增二级类目页面
     * @param pid
     * @param model
     * @return
     */
    @RequestMapping("/addSubItemCategory")
    public String addSubItemCategory(int pid,Model model){
        model.addAttribute("pid",pid);
        return "/itemCategory/addSubItemCategory";
    }

    /**
     * 新增二级类目
     * @param itemCategory
     * @return
     */
    @RequestMapping("/exAddSubItemCategory")
    public String exAddSubItemCategory(ItemCategory itemCategory){
        itemCategory.setIsDelete(new Byte("0"));
        itemCategoryService.insert(itemCategory);
        return "redirect:/itemCategory/querySubItemCategoryPage?pid="+itemCategory.getPid();
    }

    /**
     * 转向到修改二级类目页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateSubItemCategory")
    public String updateSubItemCategory(Integer id,Model model){
        ItemCategory obj = itemCategoryService.load(id);
        model.addAttribute("obj",obj);
        return "/itemCategory/updateSubItemCategory";
    }

    /**
     *  修改二级类目
     * @param itemCategory
     * @return
     */
    @RequestMapping("/exUpdateSubItemCategory")
    public String exUpdateSubItemCategory(ItemCategory itemCategory){
        itemCategoryService.updateById(itemCategory);
        return "redirect:/itemCategory/querySubItemCategoryPage?pid="+itemCategory.getPid();
    }

    /**
     * 删除二级类目
     */
    @RequestMapping("/deleteSubItemCategory")
    public String deleteSubItemCategory(Integer id,Integer pid,int pageNum,int pageTotal){
        //删除本身
        ItemCategory load = itemCategoryService.load(id);
        load.setIsDelete(new Byte("1"));
        int i = itemCategoryService.PageDelete(load, pageNum, pageTotal);
        return "redirect:/itemCategory/querySubItemCategoryPage?pid="+pid+"&&pageNum="+i;
    }
}
