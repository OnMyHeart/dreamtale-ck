package com.dreamtale.ck.resource;

import com.dreamtale.ck.constant.common.PageResult;
import com.dreamtale.ck.constant.common.ResultJson;
import com.dreamtale.ck.entity.json.CkOrderListJson;
import com.dreamtale.ck.entity.param.CkOrderListQueryParam;
import com.dreamtale.ck.entity.pojo.BaseArea;
import com.dreamtale.ck.service.IBaseAreaService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/base/area")
public class BaseAreaResource {

    @Resource
    IBaseAreaService baseAreaService;

    @PostMapping("/add")
    public ResultJson<Boolean> add(@RequestBody BaseArea baseArea) {
        try {
            return ResultJson.ok(baseAreaService.add(baseArea));
        } catch (Exception e) {
            return ResultJson.badRequest(e.getMessage());
        }
    }

}
