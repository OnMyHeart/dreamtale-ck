package com.dreamtale.ck.entity.json;

import java.math.BigDecimal;
import java.util.List;

public class ProductDeptRankJson {

    private BigDecimal amount1;

    private BigDecimal amount2;

    private Long count1;

    private Long count2;

    List<ProductRankJson> data;

    public BigDecimal getAmount1() {
        return amount1;
    }

    public void setAmount1(BigDecimal amount1) {
        this.amount1 = amount1;
    }

    public BigDecimal getAmount2() {
        return amount2;
    }

    public void setAmount2(BigDecimal amount2) {
        this.amount2 = amount2;
    }

    public Long getCount1() {
        return count1;
    }

    public void setCount1(Long count1) {
        this.count1 = count1;
    }

    public Long getCount2() {
        return count2;
    }

    public void setCount2(Long count2) {
        this.count2 = count2;
    }

    public List<ProductRankJson> getData() {
        return data;
    }

    public void setData(List<ProductRankJson> data) {
        this.data = data;
    }
}
