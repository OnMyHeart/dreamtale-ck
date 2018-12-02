package com.dreamtale.ck.mapper;

import com.dreamtale.ck.entity.json.*;
import com.dreamtale.ck.entity.param.*;
import com.dreamtale.ck.entity.pojo.CkOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CkOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CkOrder record);

    int insertSelective(CkOrder record);

    CkOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CkOrder record);

    int updateByPrimaryKey(CkOrder record);

    /**
     * 查询订单列表
     * @param ckOrderListQueryParam
     * @return
     */
    List<CkOrderListJson> queryCkOrderList(CkOrderListQueryParam ckOrderListQueryParam);

    /**
     * 批量插入订单
     * @param orderList
     * @return
     */
    int batchInsert(@Param("orderList") List<CkOrderInsertParam> orderList);

    /**
     * 销售额排行榜
     * @param ckStatisticsQueryParam
     * @return
     */
    List<CkSalesMoneyJson> salesAmountRank(CkStatisticsQueryParam ckStatisticsQueryParam);

    /**
     * 销量排行榜
     * @param ckStatisticsQueryParam
     * @return
     */
    List<CkSalesRankingJson> salesCountRank(CkStatisticsQueryParam ckStatisticsQueryParam);

    /**
     * 统计每月的销量和销售额
     * @return
     */
    List<CkStatisticsEachMonthJson> statisticsAmountAndCount(CkStatisticsInfoQueryParam ckStatisticsInfoQueryParam);

    List<SalesmanRankJson> statisticsSalesmanDetail(CkStatisticsDetailParam ckStatisticsDetailParam);

    List<ProductRankJson> statisticsProductDetail(CkStatisticsDetailParam ckStatisticsDetailParam);

}