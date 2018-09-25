package com.dreamtale.ck.entity.param;

import com.dreamtale.ck.constant.common.BaseParam;

import java.util.Date;

public class CkStatisticsInfoQueryParam extends BaseParam{

    /**
     * 统计类型 【1-天 2-周 3-月 4-季 5-年】
     */
    private Integer statisticsType;

    private Date time;

    /**
     * 产品类型 【PT01：一部 PT02：二部】
     */
    private String productType;

    public Integer getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(Integer statisticsType) {
        this.statisticsType = statisticsType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
