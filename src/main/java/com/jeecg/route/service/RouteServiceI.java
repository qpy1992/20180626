package com.jeecg.route.service;
import com.jeecg.route.entity.RouteEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface RouteServiceI extends CommonService{
	
 	public void delete(RouteEntity entity) throws Exception;
 	
 	public Serializable save(RouteEntity entity) throws Exception;
 	
 	public void saveOrUpdate(RouteEntity entity) throws Exception;
 	
}
