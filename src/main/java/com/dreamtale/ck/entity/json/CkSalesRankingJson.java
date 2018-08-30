package com.dreamtale.ck.entity.json;

import java.io.Serializable;

/***
 * 产品纬度的销量排行榜
 * @author  dream
 */
public class CkSalesRankingJson implements Serializable {

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品销量
     */
    private Long productCount;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }
}
