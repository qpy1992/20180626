package com.jeecg.bxcost.service;
import com.jeecg.bxcost.entity.BxcostEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BxcostServiceI extends CommonService{
	
 	public void delete(BxcostEntity entity) throws Exception;
 	
 	public Serializable save(BxcostEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BxcostEntity entity) throws Exception;
 	
}
