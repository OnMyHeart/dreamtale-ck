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
@RequestMapping("/admin/ck")
public class CKController {

    @Autowired
    CKService ckService;

    @RequestMapping("/index.html")
    public String index(ModelMap modelMap){
        return "index";
    }

    @RequestMapping("/order/list.html")
    public String listOrder(ModelMap modelMap){
        return "list_order";
    }

    @RequestMapping("/product/list.html")
    public String listProduct(ModelMap modelMap){
        return "list_product";
    }

    @RequestMapping("/user/list.html")
    public String listUser(ModelMap modelMap){
        return "list_user";
    }

    @RequestMapping("/district/list.html")
    public String listDistrict(ModelMap modelMap){
        return "list_district";
    }

    @RequestMapping("/desktop.html")
    public String desktop(ModelMap modelMap){
        //排行榜
        modelMap.put("statisticsInfo",ckService.queryStatisticsInfo());
        return "desktop";
    }

    @RequestMapping("/statistics.html")
    public String statisticsInfo(){
        return "statistics_info";
    }

    @RequestMapping("/year.html")
    public String statisticsYear(){
        return "statistics_year";
    }

}
