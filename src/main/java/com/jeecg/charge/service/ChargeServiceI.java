package com.jeecg.charge.service;
import com.jeecg.charge.entity.ChargeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ChargeServiceI extends CommonService{
	
 	public void delete(ChargeEntity entity) throws Exception;
 	
 	public Serializable save(ChargeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ChargeEntity entity) throws Exception;
 	
}
