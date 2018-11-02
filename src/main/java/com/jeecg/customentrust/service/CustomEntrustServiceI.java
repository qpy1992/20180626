package com.jeecg.customentrust.service;
import com.jeecg.customentrust.entity.CustomEntrustEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CustomEntrustServiceI extends CommonService{
	
 	public void delete(CustomEntrustEntity entity) throws Exception;
 	
 	public Serializable save(CustomEntrustEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CustomEntrustEntity entity) throws Exception;
 	
}
