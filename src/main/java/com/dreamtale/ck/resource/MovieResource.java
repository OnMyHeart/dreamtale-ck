package com.dreamtale.ck.resource;

import com.dreamtale.ck.constant.common.PageResult;
import com.dreamtale.ck.constant.common.ResultJson;
import com.dreamtale.ck.entity.json.CkOrderListJson;
import com.dreamtale.ck.entity.json.FileAttributesJson;
import com.dreamtale.ck.entity.param.CkOrderListQueryParam;
import com.dreamtale.ck.utils.FileSystemUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/movie")
public class MovieResource {

    @GetMapping("/getMovieList")
    public ResultJson<List<FileAttributesJson>> getMovieList() {
        try {
            return ResultJson.ok(FileSystemUtils.getFileList("/home/dreamtale/movie/dreamtale/movie"));
        } catch (Exception e) {
            return ResultJson.badRequest("读取电影异常");
        }
    }
}
