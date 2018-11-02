package com.jeecg.yunjia.service;
import com.jeecg.yunjia.entity.YunjiaEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface YunjiaServiceI extends CommonService{
	
 	public void delete(YunjiaEntity entity) throws Exception;
 	
 	public Serializable save(YunjiaEntity entity) throws Exception;
 	
 	public void saveOrUpdate(YunjiaEntity entity) throws Exception;
 	
}
