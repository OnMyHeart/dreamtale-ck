package com.dreamtale.ck.mapper;

import com.dreamtale.ck.entity.pojo.BaseArea;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BaseAreaMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BaseArea record);

    int insertSelective(BaseArea record);

    BaseArea selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseArea record);

    int updateByPrimaryKey(BaseArea record);
}