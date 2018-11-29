package com.dreamtale.ck.mapper;


import com.dreamtale.ck.entity.json.CkUserListJson;
import com.dreamtale.ck.entity.param.CkUserListQueryParam;
import com.dreamtale.ck.entity.pojo.CkUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CkUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CkUser record);

    int insertSelective(CkUser record);

    CkUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CkUser record);

    int updateByPrimaryKey(CkUser record);

    List<CkUserListJson> queryUserList(CkUserListQueryParam ckUserListQueryParam);
}