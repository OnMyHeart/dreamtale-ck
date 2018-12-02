package com.dreamtale.ck.entity.param;

import com.dreamtale.ck.constant.common.BaseParam;

public class CkStatisticsQueryParam extends BaseParam {

    private Integer yearMonth = 201809;

    /**
     * 统计类型 【1-月 2-年】
     */
    private Integer statisticsType = 1;

    /**
     * 产品类型 【PT01：一部 PT02：二部】
     */
    private String productType;

    public Integer getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Integer getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(Integer statisticsType) {
        this.statisticsType = statisticsType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
