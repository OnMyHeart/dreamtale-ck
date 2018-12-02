package com.dreamtale.ck.entity.param;

public class CkStatisticsDetailParam {

    /**
     * 统计类型 1-按月统计 2-按年统计 默认按月统计
     */
    private Integer statisticsType = 1;

    /**
     * 排序类型 1-按照销售额排序 2-按照销量排序 默认销售额排序
     */
    private Integer orderByType = 1;

    /**
     * 参数，默认201809
     */
    Integer yearMonth =201809;

    /**
     * 产品ID
     */
    private Long productId;


    private Long salesmanNo;


    public Integer getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(Integer statisticsType) {
        this.statisticsType = statisticsType;
    }

    public Integer getOrderByType() {
        return orderByType;
    }

    public void setOrderByType(Integer orderByType) {
        this.orderByType = orderByType;
    }

    public Integer getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSalesmanNo() {
        return salesmanNo;
    }

    public void setSalesmanNo(Long salesmanNo) {
        this.salesmanNo = salesmanNo;
    }
}
