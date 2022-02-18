package com.orange.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.orange.shop.base.BaseController;
import com.orange.shop.entity.Car;
import com.orange.shop.entity.Item;
import com.orange.shop.service.CarService;
import com.orange.shop.service.ItemService;
import com.orange.shop.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 购物车
 */
@Controller
@RequestMapping("/car")
public class CarController extends BaseController {

    @Autowired
    private CarService carService;

    @Autowired
    private ItemService itemService;

    @RequestMapping("/exAddCar")
    @ResponseBody
    public String exAdd(Car car, HttpServletRequest request){
        JSONObject js = new JSONObject();
        Object attribute = request.getSession().getAttribute(Const.USERID);
        if(attribute==null){
            js.put(Const.RES,0);
            return js.toJSONString();
        }
        //保存到购物车
        Integer userId = Integer.valueOf(attribute.toString());
        car.setUserId(userId);
        Item item = itemService.load(car.getItemId());
        Float price = item.getPrice();
        car.setPrice(price);
        if(item.getDiscount()!=null){
            price = price*item.getDiscount()/10;
            car.setPrice(price);
        }
        Integer num = car.getNum();
        float t = price * num;
        car.setTotal(t);
        carService.insert(car);
        js.put(Const.RES,1);
        return js.toJSONString();
    }

    /**
     * 转向我的购物车页面
     */
    @RequestMapping("/queryCar")
    public String queryCar(Model model, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Const.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        Car car = new Car();
        car.setUserId(userId);
        List<Car> cars = carService.findByEntity(car);
        model.addAttribute("list",cars);
        return "/car/car";
    }

    /**
     * 删除购物车
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        carService.deleteById(id);
        return "success";
    }
}
