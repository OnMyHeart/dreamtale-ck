package com.dreamtale.ck.entity.json;

import java.math.BigDecimal;

public class CkStatisticsEachMonthJson {

    private Integer yearMonth;

    private BigDecimal amount;

    private  Long count;

    public Integer getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
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
}
