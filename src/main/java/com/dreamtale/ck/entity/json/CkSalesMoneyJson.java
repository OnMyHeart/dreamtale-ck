package com.dreamtale.ck.entity.json;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 业务员纬度的销售额排行榜
 * @author  dream
 */
public class CkSalesMoneyJson implements Serializable {

    /**
     * 销售额
     */
    private BigDecimal amount;

    /**
     * 业务员ID
     */
    private Long salesmanId;

    /**
     * 业务员姓名
     */
    private String salesmanName;

    /**
     * 业务员电话
     */
    private String salesmanPhone;

    /**
     * 业务员总销量
     */
    private Long salesmanCount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Long salesmanId) {
        this.salesmanId = salesmanId;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getSalesmanPhone() {
        return salesmanPhone;
    }

    public void setSalesmanPhone(String salesmanPhone) {
        this.salesmanPhone = salesmanPhone;
    }

    public Long getSalesmanCount() {
        return salesmanCount;
    }

    public void setSalesmanCount(Long salesmanCount) {
        this.salesmanCount = salesmanCount;
    }
}
