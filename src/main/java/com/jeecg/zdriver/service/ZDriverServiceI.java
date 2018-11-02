package com.jeecg.zdriver.service;
import com.jeecg.zdriver.entity.ZDriverEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZDriverServiceI extends CommonService{
	
 	public void delete(ZDriverEntity entity) throws Exception;
 	
 	public Serializable save(ZDriverEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZDriverEntity entity) throws Exception;
 	
}
