package com.dreamtale.ck.mapper;

import com.dreamtale.ck.entity.json.CkSalesMoneyJson;
import com.dreamtale.ck.entity.json.CkSalesRankingJson;
import com.dreamtale.ck.entity.param.CkStatisticsQueryParam;

import java.util.List;

public interface CkStatisticsMapper {


    /**
     * 销售额排行榜
     * @param ckStatisticsQueryParam
     * @return
     */
    List<CkSalesMoneyJson> queryStatisticsMoney(CkStatisticsQueryParam ckStatisticsQueryParam);

    /**
     * 销量排行榜
     * @param ckStatisticsQueryParam
     * @return
     */
    List<CkSalesRankingJson> queryStatisticsRanking(CkStatisticsQueryParam ckStatisticsQueryParam);
}
