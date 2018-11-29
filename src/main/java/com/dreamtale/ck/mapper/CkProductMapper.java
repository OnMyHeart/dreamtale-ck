package com.dreamtale.ck.mapper;

import com.dreamtale.ck.entity.param.CkProductListQueryParam;
import com.dreamtale.ck.entity.pojo.CkProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CkProductMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CkProduct record);

    int insertSelective(CkProduct record);

    CkProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CkProduct record);

    int updateByPrimaryKey(CkProduct record);

    List<CkProduct> queryProductList(CkProductListQueryParam ckProductListQueryParam);

}