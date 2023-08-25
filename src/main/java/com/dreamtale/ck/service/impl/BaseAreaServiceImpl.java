package com.dreamtale.ck.service.impl;

import com.dreamtale.ck.entity.pojo.BaseArea;
import com.dreamtale.ck.mapper.BaseAreaMapper;
import com.dreamtale.ck.service.IBaseAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BaseAreaServiceImpl implements IBaseAreaService {

    private static Logger logger = LoggerFactory.getLogger(BaseAreaServiceImpl.class);

    @Resource
    BaseAreaMapper baseAreaMapper;

    @Override
    public boolean add(BaseArea baseArea) {
        baseAreaMapper.insert(baseArea);
        return true;
    }
}
