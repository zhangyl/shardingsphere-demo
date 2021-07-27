package com.zyl.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestShardingAlgorithm implements StandardShardingAlgorithm<String> {
	private final Logger log = LoggerFactory.getLogger(TestShardingAlgorithm.class);
	
    private static Map<String, String> dataSourceMap = new HashMap<String, String>();

    static {
    	//初始化所有数据源，value和spring.shardingsphere.datasource.names配置对应
        dataSourceMap.put("0", "db0");
        dataSourceMap.put("1", "db1");
        dataSourceMap.put("2", "db2");
    }
    
	@Override
	public String getType() {
		return "TestShardingAlgorithm";
	}

	@Override
	public Properties getProps() {
		return null;
	}

	@Override
	public void setProps(Properties props) {
		
	}

	@Override
	public void init() {
		
	}

	/**
	 * 自定义精确路由
	 */
	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
		String selectedDB = dataSourceMap.get(shardingValue.getValue());
		if (selectedDB == null) {
			//自定义默认db0
			selectedDB = dataSourceMap.get("0");
		}
		log.info("-------------------zyl selectedDB={}", selectedDB);
		return selectedDB;
	}

	@Override
	public Collection<String> doSharding(Collection<String> availableTargetNames,
			RangeShardingValue<String> shardingValue) {

		return availableTargetNames;
	}

}
