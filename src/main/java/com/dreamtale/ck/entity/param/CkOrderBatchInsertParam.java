package com.dreamtale.ck.entity.param;

import java.util.List;

public class CkOrderBatchInsertParam {

    private List<CkOrderInsertParam> orderList;

    public List<CkOrderInsertParam> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<CkOrderInsertParam> orderList) {
        this.orderList = orderList;
    }
}
