package com.dreamtale.ck.entity.json;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 排行榜
 * @author  dream
 */
public class CkStatisticsJson implements Serializable {

    /**
     * 年度业务员销售额排行榜
     */
    private List<CkSalesMoneyJson> salesMoneyOfYear;
    /**
     * 月度业务员销售额排行榜
     */
    private List<CkSalesMoneyJson> salesMoneyOfMonth;
    /**
     * 年度产品销量排行榜
     */
    private List<CkSalesRankingJson> salesRankingOfYear;
    /**
     * 月度产品销量排行榜
     */
    private List<CkSalesRankingJson> salesRankingOfMonth;

    /**
     * 年度业务员销售额排行榜
     */
    private List<CkSalesMoneyJson> salesMoneyOfYear2;
    /**
     * 月度业务员销售额排行榜
     */
    private List<CkSalesMoneyJson> salesMoneyOfMonth2;
    /**
     * 年度产品销量排行榜
     */
    private List<CkSalesRankingJson> salesRankingOfYear2;
    /**
     * 月度产品销量排行榜
     */
    private List<CkSalesRankingJson> salesRankingOfMonth2;

    /**
     * 月度明星产品
     */
    private CkSalesRankingJson starsProductOfMonth;

    /**
     * 年度明星产品
     */
    private CkSalesRankingJson starsProductOfYear;

    /**
     * 月度明星业务员
     */
    private CkSalesMoneyJson starsSalesmanOfMonth;

    /**
     * 年度明星业务员
     *
     */
    private CkSalesMoneyJson starsSalesmanOfYear;

    /**
     * 月度总销售额
     */
    private BigDecimal amountOfMonth;

    /**
     * 年度总销售额
     */
    private BigDecimal amountOfYear;

    /**
     * 月度总销量
     */
    private Long countOfMonth;

    /**
     * 年度总销量
     */
    private Long countOfYear;

    public List<CkSalesMoneyJson> getSalesMoneyOfYear() {
        return salesMoneyOfYear;
    }

    public void setSalesMoneyOfYear(List<CkSalesMoneyJson> salesMoneyOfYear) {
        this.salesMoneyOfYear = salesMoneyOfYear;
    }

    public List<CkSalesMoneyJson> getSalesMoneyOfMonth() {
        return salesMoneyOfMonth;
    }

    public void setSalesMoneyOfMonth(List<CkSalesMoneyJson> salesMoneyOfMonth) {
        this.salesMoneyOfMonth = salesMoneyOfMonth;
    }

    public List<CkSalesRankingJson> getSalesRankingOfYear() {
        return salesRankingOfYear;
    }

    public void setSalesRankingOfYear(List<CkSalesRankingJson> salesRankingOfYear) {
        this.salesRankingOfYear = salesRankingOfYear;
    }

    public List<CkSalesRankingJson> getSalesRankingOfMonth() {
        return salesRankingOfMonth;
    }

    public void setSalesRankingOfMonth(List<CkSalesRankingJson> salesRankingOfMonth) {
        this.salesRankingOfMonth = salesRankingOfMonth;
    }

    public CkSalesRankingJson getStarsProductOfMonth() {
        return starsProductOfMonth;
    }

    public void setStarsProductOfMonth(CkSalesRankingJson starsProductOfMonth) {
        this.starsProductOfMonth = starsProductOfMonth;
    }

    public CkSalesRankingJson getStarsProductOfYear() {
        return starsProductOfYear;
    }

    public void setStarsProductOfYear(CkSalesRankingJson starsProductOfYear) {
        this.starsProductOfYear = starsProductOfYear;
    }

    public CkSalesMoneyJson getStarsSalesmanOfMonth() {
        return starsSalesmanOfMonth;
    }

    public void setStarsSalesmanOfMonth(CkSalesMoneyJson starsSalesmanOfMonth) {
        this.starsSalesmanOfMonth = starsSalesmanOfMonth;
    }

    public CkSalesMoneyJson getStarsSalesmanOfYear() {
        return starsSalesmanOfYear;
    }

    public void setStarsSalesmanOfYear(CkSalesMoneyJson starsSalesmanOfYear) {
        this.starsSalesmanOfYear = starsSalesmanOfYear;
    }

    public BigDecimal getAmountOfMonth() {
        return amountOfMonth;
    }

    public void setAmountOfMonth(BigDecimal amountOfMonth) {
        this.amountOfMonth = amountOfMonth;
    }

    public BigDecimal getAmountOfYear() {
        return amountOfYear;
    }

    public void setAmountOfYear(BigDecimal amountOfYear) {
        this.amountOfYear = amountOfYear;
    }

    public Long getCountOfMonth() {
        return countOfMonth;
    }

    public void setCountOfMonth(Long countOfMonth) {
        this.countOfMonth = countOfMonth;
    }

    public Long getCountOfYear() {
        return countOfYear;
    }

    public void setCountOfYear(Long countOfYear) {
        this.countOfYear = countOfYear;
    }

    public List<CkSalesMoneyJson> getSalesMoneyOfYear2() {
        return salesMoneyOfYear2;
    }

    public void setSalesMoneyOfYear2(List<CkSalesMoneyJson> salesMoneyOfYear2) {
        this.salesMoneyOfYear2 = salesMoneyOfYear2;
    }

    public List<CkSalesMoneyJson> getSalesMoneyOfMonth2() {
        return salesMoneyOfMonth2;
    }

    public void setSalesMoneyOfMonth2(List<CkSalesMoneyJson> salesMoneyOfMonth2) {
        this.salesMoneyOfMonth2 = salesMoneyOfMonth2;
    }

    public List<CkSalesRankingJson> getSalesRankingOfYear2() {
        return salesRankingOfYear2;
    }

    public void setSalesRankingOfYear2(List<CkSalesRankingJson> salesRankingOfYear2) {
        this.salesRankingOfYear2 = salesRankingOfYear2;
    }

    public List<CkSalesRankingJson> getSalesRankingOfMonth2() {
        return salesRankingOfMonth2;
    }

    public void setSalesRankingOfMonth2(List<CkSalesRankingJson> salesRankingOfMonth2) {
        this.salesRankingOfMonth2 = salesRankingOfMonth2;
    }
}
