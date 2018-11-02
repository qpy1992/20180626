package com.jeecg.operator.service;
import com.jeecg.operator.entity.OperatorEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface OperatorServiceI extends CommonService{
	
 	public void delete(OperatorEntity entity) throws Exception;
 	
 	public Serializable save(OperatorEntity entity) throws Exception;
 	
 	public void saveOrUpdate(OperatorEntity entity) throws Exception;
 	
}
