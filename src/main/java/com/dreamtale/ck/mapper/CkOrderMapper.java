package com.dreamtale.ck.mapper;

import com.dreamtale.ck.entity.json.*;
import com.dreamtale.ck.entity.param.CkOrderInsertParam;
import com.dreamtale.ck.entity.param.CkOrderListQueryParam;
import com.dreamtale.ck.entity.param.CkStatisticsQueryParam;
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
    List<CkSalesMoneyJson> salesMoneyByDate(CkStatisticsQueryParam ckStatisticsQueryParam);

    /**
     * 销量排行榜
     * @param ckStatisticsQueryParam
     * @return
     */
    List<CkSalesRankingJson> salesRankingByDate(CkStatisticsQueryParam ckStatisticsQueryParam);

    /**
     * 统计每月的销量和销售额
     * @return
     */
    List<CkStatisticsEachMonthJson> statisticsEachMonthAmount();

    /**
     * 统计每月的总销量
     * @return
     */
    List<CkStatisticsEachMonthCountJson> statisticsEachMonthCount();

}