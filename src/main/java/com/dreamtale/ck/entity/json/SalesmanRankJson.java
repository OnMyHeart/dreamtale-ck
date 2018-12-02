package com.dreamtale.ck.entity.json;

import java.math.BigDecimal;

/**
 * 业务员排行榜
 */
public class SalesmanRankJson {

    private Long salesmanNo;

    private String salesmanName;

    private String salesmanPhone;

    private Integer salesmanStatus;

    private BigDecimal amount;

    private Long count;

    private String salesmanDistrictname;

    public Long getSalesmanNo() {
        return salesmanNo;
    }

    public void setSalesmanNo(Long salesmanNo) {
        this.salesmanNo = salesmanNo;
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

    public Integer getSalesmanStatus() {
        return salesmanStatus;
    }

    public void setSalesmanStatus(Integer salesmanStatus) {
        this.salesmanStatus = salesmanStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getSalesmanDistrictname() {
        return salesmanDistrictname;
    }

    public void setSalesmanDistrictname(String salesmanDistrictname) {
        this.salesmanDistrictname = salesmanDistrictname;
    }
}
