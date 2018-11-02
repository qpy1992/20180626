package com.jeecg.zstore.service;
import com.jeecg.zstore.entity.ZStoreEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZStoreServiceI extends CommonService{
	
 	public void delete(ZStoreEntity entity) throws Exception;
 	
 	public Serializable save(ZStoreEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZStoreEntity entity) throws Exception;
 	
}
