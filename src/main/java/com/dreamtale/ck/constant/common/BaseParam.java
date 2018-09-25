package com.dreamtale.ck.constant.common;

import java.io.Serializable;

public class BaseParam implements Serializable {

    private Integer offset = 0;

    private Integer limit = 10;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if(limit>100){
            this.limit = 100;
        } else {
            this.limit = limit;
        }
    }
}
