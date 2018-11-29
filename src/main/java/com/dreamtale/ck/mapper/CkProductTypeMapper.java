package com.dreamtale.ck.mapper;

import com.dreamtale.ck.entity.param.CkProductTypeListQueryParam;
import com.dreamtale.ck.entity.pojo.CkProductType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CkProductTypeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CkProductType record);

    int insertSelective(CkProductType record);

    CkProductType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CkProductType record);

    int updateByPrimaryKey(CkProductType record);

    List<CkProductType> queryProductTypeList(CkProductTypeListQueryParam ckProductTypeListQueryParam);

}
