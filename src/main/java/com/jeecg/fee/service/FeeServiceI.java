package com.jeecg.fee.service;
import com.jeecg.fee.entity.FeeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface FeeServiceI extends CommonService{
	
 	public void delete(FeeEntity entity) throws Exception;
 	
 	public Serializable save(FeeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(FeeEntity entity) throws Exception;
 	
}
