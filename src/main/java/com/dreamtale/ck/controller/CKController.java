package com.dreamtale.ck.controller;

import com.dreamtale.ck.entity.json.ProductRankJson;
import com.dreamtale.ck.entity.json.SalesmanRankJson;
import com.dreamtale.ck.entity.param.CkStatisticsDetailParam;
import com.dreamtale.ck.service.CKService;
import com.dreamtale.ck.utils.DataProcessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

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
        CkStatisticsDetailParam ckStatisticsDetailParam = DataProcessUtils.getStatisticsMonthQueryParam(yearMonth);
        List<ProductRankJson>data = ckService.statisticsProductDetail(ckStatisticsDetailParam);

        Long count1 = DataProcessUtils.getTotalCount("一部",data);
        Long count2 = DataProcessUtils.getTotalCount("二部",data);
        BigDecimal amount1 = DataProcessUtils.getTotalAmount("一部",data);
        BigDecimal amount2 = DataProcessUtils.getTotalAmount("二部",data);
        modelMap.put("result",data);
        modelMap.put("count1",count1);
        modelMap.put("count2",count2);
        modelMap.put("amount1",amount1);
        modelMap.put("amount2",amount2);
        modelMap.put("yearMonth", ckStatisticsDetailParam.getYearMonth());
        modelMap.put("sType", ckStatisticsDetailParam.getStatisticsType());
        return "statistics_product_list";
    }

    @RequestMapping("/statisticsSalesmanList.html")
    public String statisticsMonthSalesmanDetail(ModelMap modelMap, Integer yearMonth){
        CkStatisticsDetailParam ckStatisticsDetailParam = DataProcessUtils.getStatisticsMonthQueryParam(yearMonth);
        List<SalesmanRankJson> data = ckService.statisticsSalesmanDetail(ckStatisticsDetailParam);
        modelMap.put("result",data);
        modelMap.put("yearMonth", ckStatisticsDetailParam.getYearMonth());
        modelMap.put("sType", ckStatisticsDetailParam.getStatisticsType());
        return "statistics_salesman_list";
    }

}
