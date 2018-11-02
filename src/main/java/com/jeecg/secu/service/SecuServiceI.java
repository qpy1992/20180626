package com.jeecg.secu.service;
import com.jeecg.secu.entity.SecuEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface SecuServiceI extends CommonService{
	
 	public void delete(SecuEntity entity) throws Exception;
 	
 	public Serializable save(SecuEntity entity) throws Exception;
 	
 	public void saveOrUpdate(SecuEntity entity) throws Exception;
 	
}
