package com.dreamtale.ck.controller;

import com.dreamtale.ck.entity.param.CkStatisticsDetailParam;
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

    @RequestMapping("/statisticsEachMonth.html")
    public String statisticsEachMonth(){
        return "statistics_month";
    }

    @RequestMapping("/statisticsEachYear.html")
    public String statisticsEachYear(){
        return "statistics_year";
    }

    @RequestMapping("/statisticsProductList.html")
    public String statisticsMonthProductDetail(ModelMap modelMap, Integer yearMonth){
        modelMap.put("result",ckService.statisticsProductDetail(getStatisticsMonthQueryParam(yearMonth)));
        return "statistics_product_list";
    }

    @RequestMapping("/statisticsSalesmanList.html")
    public String statisticsMonthSalesmanDetail(ModelMap modelMap, Integer yearMonth){
        modelMap.put("result",ckService.statisticsSalesmanDetail(getStatisticsMonthQueryParam(yearMonth)));
        return "statistics_salesman_list";
    }

    public static CkStatisticsDetailParam getStatisticsMonthQueryParam(Integer yearMonth){
        CkStatisticsDetailParam ckStatisticsDetailParam = new CkStatisticsDetailParam();
        ckStatisticsDetailParam.setYearMonth(yearMonth);
        if(yearMonth!=null && yearMonth>9999){
            ckStatisticsDetailParam.setStatisticsType(1);
        } else if(yearMonth!=null && yearMonth<=9999){
            ckStatisticsDetailParam.setStatisticsType(2);
        }
        return ckStatisticsDetailParam;
    }

}
