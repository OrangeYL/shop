package com.orange.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.orange.shop.base.BaseController;
import com.orange.shop.entity.*;
import com.orange.shop.service.*;
import com.orange.shop.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单管理
 */
@Controller
@RequestMapping("/itemOrder")
public class ItemOrderController extends BaseController {

    @Autowired
    private ItemOrderService itemOrderService;
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private ItemService itemService;


    /**
     * 分页查询订单列表
     * @param model
     * @param itemOrder
     * @return
     */
    @RequestMapping("/queryItemOrderPage")
    public String queryItemOrderPage(Model model, ItemOrder itemOrder,
                                     @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize){
        PageInfo<ItemOrder> pagers = itemOrderService.queryByPage(pageNum, pageSize, itemOrder);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",itemOrder);
        return "/itemOrder/itemOrder";
    }

    /**
     * 我的订单
     */
    @RequestMapping("/myOrder")
    public String my(Model model, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Const.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        //全部订单
        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setUserId(userId);
        List<ItemOrder> all = itemOrderService.findByEntity(itemOrder);
        //待发货
        itemOrder.setStatus(new Byte("0"));
        List<ItemOrder> dfh = itemOrderService.findByEntity(itemOrder);

        //已取消
        itemOrder.setStatus(new Byte("1"));
        List<ItemOrder> yqx = itemOrderService.findByEntity(itemOrder);
        //已发货
        itemOrder.setStatus(new Byte("2"));
        List<ItemOrder> dsh = itemOrderService.findByEntity(itemOrder);
        //已收货
        itemOrder.setStatus(new Byte("3"));
        List<ItemOrder> ysh = itemOrderService.findByEntity(itemOrder);
        model.addAttribute("all",all);
        model.addAttribute("dfh",dfh);
        model.addAttribute("yqx",yqx);
        model.addAttribute("dsh",dsh);
        model.addAttribute("ysh",ysh);
        return "/itemOrder/myOrder";
    }

    /**
     * 购物车结算提交
     */
    @RequestMapping("/exAdd")
    @ResponseBody
    public String exAdd(@RequestBody List<CarDto> list, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Const.USERID);
        JSONObject js = new JSONObject();
        if(attribute==null){
            js.put(Const.RES,0);
            return js.toJSONString();
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User byId = userService.load(userId);
        if(StringUtils.isEmpty(byId.getAddress())){
            js.put(Const.RES,2);
            return js.toJSONString();
        }
        List<Integer> ids = new ArrayList<>();
        float total = 0;
        for(CarDto c:list){
            ids.add(c.getId());
            Car load = carService.load(c.getId());
            total += load.getPrice() * c.getNum();
        }
        ItemOrder order = new ItemOrder();
        order.setStatus(new Byte("0"));
        order.setCode(getOrderNo());
        order.setIsDelete(new Byte("0"));
        order.setTotal(total);
        order.setUserId(userId);
        order.setAddTime(new Date());
        itemOrderService.insert(order);

        //订单详情放入orderDetail，删除购物车
        if(!CollectionUtils.isEmpty(ids)){
            for(CarDto c:list){
                Car load = carService.load(c.getId());
                OrderDetail de = new OrderDetail();
                de.setItemId(load.getItemId());
                de.setOrderId(order.getId());
                de.setStatus(0);
                de.setNum(c.getNum());
                de.setTotal(c.getNum()*load.getPrice());
                orderDetailService.insert(de);
                //修改成交数
                Item load2 = itemService.load(load.getItemId());
                load2.setBuyNum(load2.getBuyNum()+c.getNum());
                itemService.updateById(load2);
                //删除购物车
                carService.deleteById(c.getId());
            }
        }
        js.put(Const.RES,1);
        return js.toJSONString();
    }

    /**
     * 生成订单号
     */
    private static String date;
    private static long orderNum = 0L;
    public static synchronized String getOrderNo(){
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        if(date==null||!date.equals(str)){
            date = str;
            orderNum = 0L;
        }
        orderNum++;
        long orderNO = Long.parseLong(date)*10000;
        orderNO += orderNum;
        return orderNO+"";
    }

    /**
     * 取消订单
     */
    @RequestMapping("/cancel")
    public String cancel(Integer id,Model model){
        ItemOrder obj =itemOrderService.load(id);
        obj.setStatus((byte) 1);
        itemOrderService.updateById(obj);
        model.addAttribute("obj",obj);
        return "redirect:/itemOrder/myOrder";
    }

    /**
     * 后台发货
     */
    @RequestMapping("/send")
    public String send(Integer id,Model model){
        ItemOrder obj =itemOrderService.load(id);
        obj.setStatus((byte) 2);
        itemOrderService.updateById(obj);
        model.addAttribute("obj",obj);
        return "redirect:/itemOrder/queryItemOrderPage";
    }

    /**
     * 用户收货
     */
    @RequestMapping("/receipt")
    public String receipt(Integer id,Model model){
        ItemOrder obj =itemOrderService.load(id);
        obj.setStatus((byte) 3);
        itemOrderService.updateById(obj);
        model.addAttribute("obj",obj);
        return "redirect:/itemOrder/myOrder";
    }

    /**
     * 用户评价入口
     */
    @RequestMapping("/appraise")
    public String pj(Integer id,Model model){
        model.addAttribute("id",id);
        return "/itemOrder/appraise";
    }
}
