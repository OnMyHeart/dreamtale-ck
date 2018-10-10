package com.dreamtale.ck.entity.param;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 下单参数
 * @author  dream
 */
public class CkOrderInsertParam {

    private String salesmanNo;

    private Long productId;

    private Long count;

    private BigDecimal price;

    private BigDecimal amount;

    private String lowNo;

    private String batchNo;

    private Date createTime;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getSalesmanNo() {
        return salesmanNo;
    }

    public void setSalesmanNo(String salesmanNo) {
        this.salesmanNo = salesmanNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getLowNo() {
        return lowNo;
    }

    public void setLowNo(String lowNo) {
        this.lowNo = lowNo;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
