package com.dreamtale.ck.entity.param;

import com.dreamtale.ck.common.BaseParam;

import java.util.Date;

public class CkStatisticsQueryParam extends BaseParam {

    /**
     * 时间段 开始时间
     */
    private Date startDate;

    /**
     * 时间段 结束时间
     */
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
