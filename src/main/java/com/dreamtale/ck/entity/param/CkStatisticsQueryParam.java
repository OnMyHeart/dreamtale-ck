package com.dreamtale.ck.entity.param;

import com.dreamtale.ck.constant.common.BaseParam;

import java.util.Date;

public class CkStatisticsQueryParam extends BaseParam {

    /**
     * 时间段 开始时间
     */
    private Date startDate;

    /**
     * 时间段 结束时间
     */
    private Date endDate;

    /**
     * 统计类型 【1-天 2-周 3-月 4-季 5-年】
     */
    private Integer statisticsType;

    /**
     * 产品类型 【PT01：一部 PT02：二部】
     */
    private String productType;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
