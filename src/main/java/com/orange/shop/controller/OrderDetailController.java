package com.orange.shop.controller;

import com.github.pagehelper.PageInfo;
import com.orange.shop.base.BaseController;
import com.orange.shop.entity.OrderDetail;
import com.orange.shop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 订单详情
 */
@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController extends BaseController {

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 分页查询订单详情
     * @param orderDetail
     * @param model
     * @return
     */
    @RequestMapping("/queryOrderDetailPage")
    public String queryOrderDetailPage(OrderDetail orderDetail, Model model,
                                       @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                       @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        //分页查询
        PageInfo<OrderDetail> pagers = orderDetailService.queryByPage(pageNum, pageSize, orderDetail);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",orderDetail);
        return "/orderDetail/orderDetail";
    }
}
