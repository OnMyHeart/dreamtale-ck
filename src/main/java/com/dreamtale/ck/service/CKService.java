package com.dreamtale.ck.service;

import com.alibaba.fastjson.JSONArray;
import com.dreamtale.ck.constant.common.PageResult;
import com.dreamtale.ck.entity.json.*;
import com.dreamtale.ck.entity.param.*;
import com.dreamtale.ck.entity.pojo.CkDistrict;
import com.dreamtale.ck.entity.pojo.CkOrder;
import com.dreamtale.ck.entity.pojo.CkProduct;
import com.dreamtale.ck.entity.pojo.CkUser;
import com.dreamtale.ck.mapper.CkDistrictMapper;
import com.dreamtale.ck.mapper.CkOrderMapper;
import com.dreamtale.ck.mapper.CkProductMapper;
import com.dreamtale.ck.mapper.CkUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 仓库业务处理
 * @author  dream
 */
@Service
public class CKService {

    @Autowired
    CkDistrictMapper ckDistrictMapper;

    @Autowired
    CkUserMapper ckUserMapper;

    @Autowired
    CkProductMapper ckProductMapper;

    @Autowired
    CkOrderMapper ckOrderMapper;

    public PageInfo<CkOrderListJson> queryOrderList(CkOrderListQueryParam ckOrderListQueryParam) {
        PageInfo<CkOrderListJson> pageInfo = PageHelper.offsetPage(
                ckOrderListQueryParam.getOffset(),
                ckOrderListQueryParam.getLimit()
        ).doSelectPageInfo(()->ckOrderMapper.queryCkOrderList(ckOrderListQueryParam));
        return pageInfo;
    }

    public boolean batchAddOrder(String orderListStr){
        List<CkOrderInsertParam> orderList = (List<CkOrderInsertParam>)JSONArray.parse(orderListStr);
        int  optNum = ckOrderMapper.batchInsert(orderList);
        return optNum>0;
    }

    public boolean delOrder(Long id){
        CkOrder ckOrder = new CkOrder();
        ckOrder.setStatus(2);
        ckOrder.setId(id);
        int optNum = ckOrderMapper.updateByPrimaryKeySelective(ckOrder);
        return optNum>0;
    }

    public PageInfo<CkProductJson> queryProductList(CkProductListQueryParam ckProductListQueryParam) {
        PageInfo<CkProductJson> pageInfo = PageHelper.offsetPage(
                ckProductListQueryParam.getOffset(),
                ckProductListQueryParam.getLimit()
        ).doSelectPageInfo(()->ckProductMapper.queryProductList(ckProductListQueryParam));
        return pageInfo;
    }

    public PageInfo<CkDistrict> queryDistrictList(CkDistrictListQueryParam ckDistrictListQueryParam) {
        PageInfo<CkDistrict> pageInfo = PageHelper.offsetPage(
                ckDistrictListQueryParam.getOffset(),
                ckDistrictListQueryParam.getLimit()
        ).doSelectPageInfo(()->ckDistrictMapper.queryDistrictList(ckDistrictListQueryParam));
        return pageInfo;
    }

    public PageInfo<CkUserListJson> queryUserList(CkUserListQueryParam ckUserListQueryParam) {
        PageInfo<CkUserListJson> pageInfo = PageHelper.offsetPage(
                ckUserListQueryParam.getOffset(),
                ckUserListQueryParam.getLimit()
        ).doSelectPageInfo(()->ckUserMapper.queryUserList(ckUserListQueryParam));
        return pageInfo;
    }

    public boolean addDistrict(String name){
        int optNum = ckDistrictMapper.addDistrict(name);
        return optNum>0;
    }

    public Boolean delDistrict(Long id){
        CkDistrict ckDistrict = new CkDistrict();
        ckDistrict.setId(id);
        ckDistrict.setStatus(2);
        int optNum = ckDistrictMapper.updateByPrimaryKeySelective(ckDistrict);
        return optNum>0;
    }

    public boolean addUser(CkUserInsertParam ckUserInsertParam){
        CkUser ckUser = new CkUser();
        ckUser.setName(ckUserInsertParam.getName());
        ckUser.setDistrictNo(ckUserInsertParam.getDistrictNo());
        ckUser.setPhone(ckUserInsertParam.getPhone());
        int optNum = ckUserMapper.insert(ckUser);
        return optNum>0;
    }

    public boolean delUser(Long id){
        CkUser ckUser = new CkUser();
        ckUser.setId(id);
        ckUser.setStatus(2);
        int optNum = ckUserMapper.updateByPrimaryKeySelective(ckUser);
        return optNum>0;
    }

    public boolean addProduct(CkProduct ckProduct){
        int optNum = ckProductMapper.insert(ckProduct);
        return optNum>0;
    }

    public boolean delProduct(Long id){
        CkProduct ckProduct = new CkProduct();
        ckProduct.setId(id);
        ckProduct.setStatus(2);
        int optNum = ckProductMapper.updateByPrimaryKeySelective(ckProduct);
        return optNum>0;
    }

    public CkStatisticsJson queryStatisticsInfo(){
        CkStatisticsQueryParam ckStatisticsQueryParam = new CkStatisticsQueryParam();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.AM_PM, 0);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        //查月度
        Date startDate = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        Date endDate = calendar.getTime();
        ckStatisticsQueryParam.setStartDate(startDate);
        ckStatisticsQueryParam.setEndDate(endDate);
        ckStatisticsQueryParam.setProductType("PT01");
        List<CkSalesMoneyJson> salesMoneyOfMonth = ckOrderMapper.salesMoneyByDate(ckStatisticsQueryParam);
        List<CkSalesRankingJson> salesRankingOfMonth = ckOrderMapper.salesRankingByDate(ckStatisticsQueryParam);
        ckStatisticsQueryParam.setProductType("PT02");
        List<CkSalesMoneyJson> salesMoneyOfMonth2 = ckOrderMapper.salesMoneyByDate(ckStatisticsQueryParam);
        List<CkSalesRankingJson> salesRankingOfMonth2 = ckOrderMapper.salesRankingByDate(ckStatisticsQueryParam);
        //查年度
        calendar.set(Calendar.MONTH, 0);
        startDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 1);
        endDate = calendar.getTime();
        ckStatisticsQueryParam.setStartDate(startDate);
        ckStatisticsQueryParam.setEndDate(endDate);
        ckStatisticsQueryParam.setProductType("PT01");
        List<CkSalesMoneyJson> salesMoneyOfYear = ckOrderMapper.salesMoneyByDate(ckStatisticsQueryParam);
        List<CkSalesRankingJson> salesRankingOfYear = ckOrderMapper.salesRankingByDate(ckStatisticsQueryParam);
        ckStatisticsQueryParam.setProductType("PT02");
        List<CkSalesMoneyJson> salesMoneyOfYear2 = ckOrderMapper.salesMoneyByDate(ckStatisticsQueryParam);
        List<CkSalesRankingJson> salesRankingOfYear2 = ckOrderMapper.salesRankingByDate(ckStatisticsQueryParam);

        //计算销售总额和销售总量
        BigDecimal amountOfMonth = new BigDecimal(0.00);
        for (CkSalesMoneyJson ckSalesMoneyJson : salesMoneyOfMonth){
            amountOfMonth = amountOfMonth.add(ckSalesMoneyJson.getAmount());
        }

        BigDecimal amountOfMonth2 = new BigDecimal(0.00);
        for (CkSalesMoneyJson ckSalesMoneyJson : salesMoneyOfMonth2){
            amountOfMonth2 = amountOfMonth.add(ckSalesMoneyJson.getAmount());
        }

        BigDecimal amountOfYear = new BigDecimal(0.00);
        for (CkSalesMoneyJson ckSalesMoneyJson : salesMoneyOfYear){
            amountOfYear = amountOfYear.add(ckSalesMoneyJson.getAmount());
        }

        BigDecimal amountOfYear2 = new BigDecimal(0.00);
        for (CkSalesMoneyJson ckSalesMoneyJson : salesMoneyOfYear2){
            amountOfYear2 = amountOfYear.add(ckSalesMoneyJson.getAmount());
        }

        Long countOfMonth = 0L;
        for (CkSalesRankingJson ckSalesRankingJson : salesRankingOfMonth){
            countOfMonth += ckSalesRankingJson.getProductCount();
        }

        Long countOfMonth2 = 0L;
        for (CkSalesRankingJson ckSalesRankingJson : salesRankingOfMonth2){
            countOfMonth2 += ckSalesRankingJson.getProductCount();
        }

        Long countOfYear = 0L;
        for (CkSalesRankingJson ckSalesRankingJson : salesRankingOfYear){
            countOfYear += ckSalesRankingJson.getProductCount();
        }

        Long countOfYear2 = 0L;
        for (CkSalesRankingJson ckSalesRankingJson : salesRankingOfYear2){
            countOfYear2 += ckSalesRankingJson.getProductCount();
        }

        CkStatisticsJson ckStatisticsJson = new CkStatisticsJson();
        ckStatisticsJson.setSalesMoneyOfMonth(salesMoneyOfMonth);
        ckStatisticsJson.setSalesMoneyOfYear(salesMoneyOfYear);
        ckStatisticsJson.setSalesRankingOfMonth(salesRankingOfMonth);
        ckStatisticsJson.setSalesRankingOfYear(salesRankingOfYear);

        if(salesRankingOfMonth!=null && salesRankingOfMonth.size()>0){
            ckStatisticsJson.setStarsProductOfMonth(salesRankingOfMonth.get(0));
        } else {
            CkSalesRankingJson ckSalesRankingJson = new CkSalesRankingJson();
            ckSalesRankingJson.setProductCount(0L);
            ckSalesRankingJson.setProductName("虚位以待");
            ckStatisticsJson.setStarsProductOfMonth(ckSalesRankingJson);
        }

        if(salesRankingOfYear!=null && salesRankingOfYear.size()>0) {
            ckStatisticsJson.setStarsProductOfYear(salesRankingOfYear.get(0));
        } else {
            CkSalesRankingJson ckSalesRankingJson = new CkSalesRankingJson();
            ckSalesRankingJson.setProductCount(0L);
            ckSalesRankingJson.setProductName("虚位以待");
            ckStatisticsJson.setStarsProductOfYear(ckSalesRankingJson);
        }

        if(salesMoneyOfMonth!=null && salesMoneyOfMonth.size()>0) {
            ckStatisticsJson.setStarsSalesmanOfMonth(salesMoneyOfMonth.get(0));
        } else {
            CkSalesMoneyJson ckSalesMoneyJson = new CkSalesMoneyJson();
            ckSalesMoneyJson.setAmount(new BigDecimal(0.00));
            ckSalesMoneyJson.setSalesmanCount(0L);
            ckSalesMoneyJson.setSalesmanName("虚位以待");
            ckSalesMoneyJson.setSalesmanPhone("");
            ckStatisticsJson.setStarsSalesmanOfMonth(ckSalesMoneyJson);
        }

        if(salesMoneyOfYear!=null && salesMoneyOfYear.size()>0) {
            ckStatisticsJson.setStarsSalesmanOfYear(salesMoneyOfYear.get(0));
        } else {
            CkSalesMoneyJson ckSalesMoneyJson = new CkSalesMoneyJson();
            ckSalesMoneyJson.setAmount(new BigDecimal(0.00));
            ckSalesMoneyJson.setSalesmanCount(0L);
            ckSalesMoneyJson.setSalesmanName("虚位以待");
            ckSalesMoneyJson.setSalesmanPhone("");
            ckStatisticsJson.setStarsSalesmanOfYear(ckSalesMoneyJson);
        }
        ckStatisticsJson.setCountOfMonth(countOfMonth);
        ckStatisticsJson.setCountOfYear(countOfYear);
        ckStatisticsJson.setAmountOfMonth(amountOfMonth);
        ckStatisticsJson.setAmountOfYear(amountOfYear);
        ckStatisticsJson.setSalesMoneyOfMonth2(salesMoneyOfMonth2);
        ckStatisticsJson.setSalesMoneyOfYear2(salesMoneyOfYear2);
        ckStatisticsJson.setSalesRankingOfMonth2(salesRankingOfMonth2);
        ckStatisticsJson.setSalesRankingOfYear2(salesRankingOfYear2);
        return ckStatisticsJson;
    }

    public PageResult queryStatistics(CkStatisticsInfoQueryParam ckStatisticsInfoQueryParam){
        return null;
    }

}
