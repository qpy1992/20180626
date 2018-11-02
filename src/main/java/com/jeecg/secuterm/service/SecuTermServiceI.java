package com.jeecg.secuterm.service;
import com.jeecg.secuterm.entity.SecuTermEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface SecuTermServiceI extends CommonService{
	
 	public void delete(SecuTermEntity entity) throws Exception;
 	
 	public Serializable save(SecuTermEntity entity) throws Exception;
 	
 	public void saveOrUpdate(SecuTermEntity entity) throws Exception;
 	
}
