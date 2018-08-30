package com.dreamtale.ck.controller;

import com.dreamtale.ck.service.CKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 仓库管理
 * @author dream
 */
@Controller
public class CKController {

    @Autowired
    CKService ckService;

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        return "index";
    }

    @RequestMapping("/order/list")
    public String listOrder(ModelMap modelMap){
        return "list_order";
    }

    @RequestMapping("/product/list")
    public String listProduct(ModelMap modelMap){
        return "list_product";
    }

    @RequestMapping("/user/list")
    public String listUser(ModelMap modelMap){
        return "list_user";
    }

    @RequestMapping("/district/list")
    public String listDistrict(ModelMap modelMap){
        return "list_district";
    }

    @RequestMapping("/desktop")
    public String desktop(ModelMap modelMap){
        //统计信息
        modelMap.put("statisticsInfo",ckService.queryStatisticsInfo());
        return "desktop";
    }

}
