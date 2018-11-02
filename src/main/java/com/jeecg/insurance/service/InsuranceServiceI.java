package com.jeecg.insurance.service;
import com.jeecg.insurance.entity.InsuranceEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface InsuranceServiceI extends CommonService{
	
 	public void delete(InsuranceEntity entity) throws Exception;
 	
 	public Serializable save(InsuranceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(InsuranceEntity entity) throws Exception;
 	
}
