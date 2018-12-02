package com.dreamtale.ck.entity.json;

import java.util.List;

public class CkStatisticsDetailJson {

    private List<ProductRankJson> productRankJsonSalesNum;

    private List<ProductRankJson> productRankJsonSalesMoney;

    private List<SalesmanRankJson> salesmanRankJsonSalesNum;

    private List<SalesmanRankJson> salesmanRankJsonSalesMoney;

    public List<ProductRankJson> getProductRankJsonSalesNum() {
        return productRankJsonSalesNum;
    }

    public void setProductRankJsonSalesNum(List<ProductRankJson> productRankJsonSalesNum) {
        this.productRankJsonSalesNum = productRankJsonSalesNum;
    }

    public List<ProductRankJson> getProductRankJsonSalesMoney() {
        return productRankJsonSalesMoney;
    }

    public void setProductRankJsonSalesMoney(List<ProductRankJson> productRankJsonSalesMoney) {
        this.productRankJsonSalesMoney = productRankJsonSalesMoney;
    }

    public List<SalesmanRankJson> getSalesmanRankJsonSalesNum() {
        return salesmanRankJsonSalesNum;
    }

    public void setSalesmanRankJsonSalesNum(List<SalesmanRankJson> salesmanRankJsonSalesNum) {
        this.salesmanRankJsonSalesNum = salesmanRankJsonSalesNum;
    }

    public List<SalesmanRankJson> getSalesmanRankJsonSalesMoney() {
        return salesmanRankJsonSalesMoney;
    }

    public void setSalesmanRankJsonSalesMoney(List<SalesmanRankJson> salesmanRankJsonSalesMoney) {
        this.salesmanRankJsonSalesMoney = salesmanRankJsonSalesMoney;
    }
}
