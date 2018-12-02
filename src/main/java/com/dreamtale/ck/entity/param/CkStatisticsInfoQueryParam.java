package com.dreamtale.ck.entity.param;

import com.dreamtale.ck.constant.common.BaseParam;

public class CkStatisticsInfoQueryParam extends BaseParam{

    /**
     * 统计类型 【1-月 2-年】
     */
    private Integer statisticsType = 1;

    public Integer getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(Integer statisticsType) {
        this.statisticsType = statisticsType;
    }

}
