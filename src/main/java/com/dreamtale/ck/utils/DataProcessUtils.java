package com.dreamtale.ck.utils;

import com.dreamtale.ck.entity.json.ProductRankJson;
import com.dreamtale.ck.entity.param.CkStatisticsDetailParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessUtils {

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

    public static Long getTotalCount(String deptTypeName, List<ProductRankJson> data){
        if(data!=null && !data.isEmpty()){
            data = data.stream().filter(productRankJson -> deptTypeName.equals(productRankJson.getProductTypeName())).collect(Collectors.toList());
            if(data!=null && !data.isEmpty()){
                return data.stream().map(ProductRankJson::getCount).reduce(Long::sum).get();
            } else {
                return 0L;
            }
        } else {
            return 0L;
        }
    }

    public static BigDecimal getTotalAmount(String deptTypeName, List<ProductRankJson> data){
        if(data!=null && !data.isEmpty()){
            data = data.stream().filter(productRankJson -> deptTypeName.equals(productRankJson.getProductTypeName())).collect(Collectors.toList());
            if(data!=null && !data.isEmpty()){
                return data.stream().map(ProductRankJson::getAmount).reduce(BigDecimal::add).get();
            } else {
                return new BigDecimal(0);
            }
        } else {
            return new BigDecimal(0);
        }
    }

}
