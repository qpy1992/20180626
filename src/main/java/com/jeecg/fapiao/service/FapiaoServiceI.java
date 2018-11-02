package com.jeecg.fapiao.service;
import com.jeecg.fapiao.entity.FapiaoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface FapiaoServiceI extends CommonService{
	
 	public void delete(FapiaoEntity entity) throws Exception;
 	
 	public Serializable save(FapiaoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(FapiaoEntity entity) throws Exception;
 	
}
