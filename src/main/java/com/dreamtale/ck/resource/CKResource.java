package com.dreamtale.ck.resource;

import com.dreamtale.ck.constant.common.ResultJson;
import com.dreamtale.ck.entity.json.*;
import com.dreamtale.ck.entity.param.*;
import com.dreamtale.ck.entity.pojo.CkDistrict;
import com.dreamtale.ck.entity.pojo.CkProduct;
import com.dreamtale.ck.constant.common.PageResult;
import com.dreamtale.ck.service.CKService;
import com.dreamtale.ck.utils.DataProcessUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 仓库业务
 * @author  dream
 */
@RestController
@RequestMapping("/admin/ck")
public class CKResource {

    @Resource
    CKService ckService;

    @GetMapping("/order/queryOrderList")
    public PageResult<CkOrderListJson> queryOrderList(CkOrderListQueryParam ckOrderListQueryParam) {
        PageInfo<CkOrderListJson> pageInfo = ckService.queryOrderList(ckOrderListQueryParam);
        PageResult<CkOrderListJson> pageResult = new PageResult<>();
        if(pageInfo!=null){
            pageResult.setPage(new Long(pageInfo.getPages()));
            pageResult.setTotal(pageInfo.getTotal());
            pageResult.setRows(pageInfo.getList());
        }
        return pageResult;
    }

    @PostMapping("/order/add")
    public ResultJson<Boolean> batchAddOrder(String orderListStr) {
        ResultJson resultJson = new ResultJson();
         if(StringUtils.isNotBlank(orderListStr)){
            resultJson.setData(true);
            resultJson.setData(ckService.batchAddOrder(orderListStr));
        } else {
            resultJson.setData(false);
        }
        return resultJson;
    }

    @GetMapping("/product/queryProductList")
    public PageResult<CkProductJson> queryProductList(CkProductListQueryParam ckProductListQueryParam) {
        PageInfo<CkProductJson> pageInfo = ckService.queryProductList(ckProductListQueryParam);
        PageResult<CkProductJson> pageResult = new PageResult<>();
        if(pageInfo!=null){
            pageResult.setPage(new Long(pageInfo.getPages()));
            pageResult.setTotal(pageInfo.getTotal());
            pageResult.setRows(pageInfo.getList());
        }
        return pageResult;
    }

    @GetMapping("/product/queryAllProduct")
    public PageResult<CkProductJson> queryAllProduct(CkProductListQueryParam ckProductListQueryParam) {
        ckProductListQueryParam.setOffset(1);
        ckProductListQueryParam.setLimit(100);
        PageInfo<CkProductJson> pageInfo = ckService.queryProductList(ckProductListQueryParam);
        PageResult<CkProductJson> pageResult = new PageResult<>();
        if(pageInfo!=null){
            pageResult.setPage(new Long(pageInfo.getPages()));
            pageResult.setTotal(pageInfo.getTotal());
            pageResult.setRows(pageInfo.getList());
        }
        return pageResult;
    }

    @GetMapping("/district/queryDistrictList")
    public PageResult<CkDistrict> queryDistrictList(CkDistrictListQueryParam ckDistrictListQueryParam) {
        PageInfo<CkDistrict> pageInfo = ckService.queryDistrictList(ckDistrictListQueryParam);
        PageResult<CkDistrict> pageResult = new PageResult<>();
        if(pageInfo!=null){
            pageResult.setPage(new Long(pageInfo.getPages()));
            pageResult.setTotal(pageInfo.getTotal());
            pageResult.setRows(pageInfo.getList());
        }
        return pageResult;
    }

    @GetMapping("/user/queryUserList")
    public PageResult<CkUserListJson> queryUserList(CkUserListQueryParam ckUserListQueryParam) {
        PageInfo<CkUserListJson> pageInfo = ckService.queryUserList(ckUserListQueryParam);
        PageResult<CkUserListJson> pageResult = new PageResult<>();
        if(pageInfo!=null){
            pageResult.setPage(new Long(pageInfo.getPages()));
            pageResult.setTotal(pageInfo.getTotal());
            pageResult.setRows(pageInfo.getList());
        }
        return pageResult;
    }

    @PostMapping("/district/add")
    public ResultJson<Boolean> addDistrict(String name){
        ResultJson resultJson = new ResultJson();
        if(StringUtils.isNotBlank(name)){
            resultJson.setData(ckService.addDistrict(name));
        } else {
            resultJson.setData(false);
        }
        return resultJson;
    }

    @GetMapping("/district/del")
    public ResultJson<Boolean> delDistrict(Long id) {
        ResultJson resultJson = new ResultJson();
        if(id==null){
            resultJson.setData(false);
        } else {
            try {
                resultJson.setData(ckService.delDistrict(id));
            } catch (Exception e){
                resultJson.setData(false);
            }
        }
        return resultJson;
    }


    @PostMapping("/user/add")
    public ResultJson<Boolean> addUser(CkUserInsertParam ckUserInsertParam) {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson.setData(ckService.addUser(ckUserInsertParam));
        } catch (Exception e){
            resultJson.setData(false);
        }
        return resultJson;
    }

    @GetMapping("/user/del")
    public ResultJson<Boolean> delUser(Long id) {
        ResultJson resultJson = new ResultJson();
        if(id==null){
            resultJson.setData(false);
        } else {
            try {
                resultJson.setData(ckService.delUser(id));
            } catch (Exception e){
                resultJson.setData(false);
            }
        }
        return resultJson;
    }

    @PostMapping("/product/add")
    public ResultJson<Boolean> addProduct(CkProduct ckProduct) {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson.setData(ckService.addProduct(ckProduct));
        } catch (Exception e){
            e.printStackTrace();
            resultJson.setData(false);
        }
        return resultJson;
    }

    @PostMapping("/product/edit")
    public ResultJson<Boolean> editProduct(CkProduct ckProduct) {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson.setData(ckService.editProduct(ckProduct));
        } catch (Exception e){
            e.printStackTrace();
            resultJson.setData(false);
        }
        return resultJson;
    }

    @GetMapping("/product/del")
    public ResultJson<Boolean> delProduct(Long id) {
        ResultJson resultJson = new ResultJson();
        if(id==null){
            resultJson.setData(false);
        } else {
            try {
                resultJson.setData(ckService.delProduct(id));
            } catch (Exception e){
                resultJson.setData(false);
            }
        }
        return resultJson;
    }

    @GetMapping("/order/del")
    public ResultJson<Boolean> delOrder(Long id) {
        ResultJson resultJson = new ResultJson();
        if(id==null){
            resultJson.setData(false);
        } else {
            try {
                resultJson.setData(ckService.delOrder(id));
            } catch (Exception e){
                resultJson.setData(false);
            }
        }
        return resultJson;
    }

    @GetMapping("/order/queryStatisticsInfo")
    public ResultJson<CkStatisticsJson> queryStatisticsInfo(){
        ResultJson resultJson = new ResultJson();
        resultJson.setCode(200);
        try{
            resultJson.setData(ckService.queryStatisticsInfo());
        } catch (Exception e) {
            resultJson.setCode(400);
            resultJson.setMessage("查询排行榜信息异常");
            resultJson.setData(null);
        }
        return resultJson;
    }

    @PostMapping("/queryStatistics")
    public PageResult queryStatistics(CkStatisticsInfoQueryParam ckStatisticsInfoQueryParam){
        return ckService.queryStatistics(ckStatisticsInfoQueryParam);
    }

    @RequestMapping("/statisticsMonthAmountAndCount")
    PageResult<CkStatisticsEachMonthJson> statisticsMonthAmountAndCount(CkStatisticsInfoQueryParam ckStatisticsInfoQueryParam){
        PageInfo<CkStatisticsEachMonthJson> pageInfo = ckService.statisticsAmountAndCount(ckStatisticsInfoQueryParam);
        PageResult<CkStatisticsEachMonthJson> pageResult = new PageResult<>();
        if(pageInfo!=null){
            pageResult.setPage(new Long(pageInfo.getPages()));
            pageResult.setTotal(pageInfo.getTotal());
            pageResult.setRows(pageInfo.getList());
        }
        return pageResult;
    }

    @RequestMapping("/statisticsYearAmountAndCount")
    PageResult<CkStatisticsEachMonthJson> statisticsYearAmountAndCount(CkStatisticsInfoQueryParam ckStatisticsInfoQueryParam){
        ckStatisticsInfoQueryParam.setStatisticsType(2);
        PageInfo<CkStatisticsEachMonthJson> pageInfo = ckService.statisticsAmountAndCount(ckStatisticsInfoQueryParam);
        PageResult<CkStatisticsEachMonthJson> pageResult = new PageResult<>();
        if(pageInfo!=null){
            pageResult.setPage(new Long(pageInfo.getPages()));
            pageResult.setTotal(pageInfo.getTotal());
            pageResult.setRows(pageInfo.getList());
        }
        return pageResult;
    }

    @GetMapping("/statisticsSalesmanDetail")
    public List<SalesmanRankJson> statisticsSalesmanDetail(CkStatisticsDetailParam ckStatisticsDetailParam){
        return ckService.statisticsSalesmanDetail(ckStatisticsDetailParam);
    }

    @GetMapping("/statisticsProductDetail")
    public List<ProductRankJson> statisticsProductDetail(CkStatisticsDetailParam ckStatisticsDetailParam){
        return ckService.statisticsProductDetail(ckStatisticsDetailParam);
    }

    @GetMapping("/statisticsProductDeptDetail")
    public ProductDeptRankJson statisticsProductDeptDetail(CkStatisticsDetailParam ckStatisticsDetailParam){
        ProductDeptRankJson productDeptRankJson = new ProductDeptRankJson();
        List<ProductRankJson> data = ckService.statisticsProductDetail(ckStatisticsDetailParam);
        productDeptRankJson.setData(data);
        Long count1 = DataProcessUtils.getTotalCount("一部",data);
        Long count2 = DataProcessUtils.getTotalCount("二部",data);
        BigDecimal amount1 = DataProcessUtils.getTotalAmount("一部",data);
        BigDecimal amount2 = DataProcessUtils.getTotalAmount("二部",data);
        productDeptRankJson.setAmount1(amount1);
        productDeptRankJson.setAmount2(amount2);
        productDeptRankJson.setCount1(count1);
        productDeptRankJson.setCount2(count2);
        return productDeptRankJson;
    }

}
