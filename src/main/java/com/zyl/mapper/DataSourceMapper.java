
package com.zyl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zyl.bean.DataSourceDO;

@Mapper
public interface DataSourceMapper {

    List<DataSourceDO> getAllDataSources();

}
