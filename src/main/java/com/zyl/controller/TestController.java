package com.zyl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyl.bean.Cost;
import com.zyl.bean.DataSourceDO;
import com.zyl.mapper.DataSourceMapper;
import com.zyl.service.CostService;

@RestController
public class TestController {
    @Autowired
    DataSourceMapper dataSourceMapper;
	@Autowired
	CostService costService;

	@PostMapping("test")
	public String test(HttpServletRequest request) {
        List<DataSourceDO> dataSourceDOList = dataSourceMapper.getAllDataSources();
        System.out.println(dataSourceDOList.size());
        {
	        Cost cost = new Cost();
	        cost.setEntCode("1");
	        cost.setMoney(101);
	        try {
	            costService.insert(cost);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
        }
        {
        	Cost cost = new Cost();
        	cost.setEntCode("2");
        	cost.setMoney(102);
        	try {
        		costService.insert(cost);
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
		return "hello,world";
	}
}
