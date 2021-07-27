package com.zyl.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zyl.bean.Cost;

@Mapper
public interface CostMapper {

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);
    
    int sum();
}