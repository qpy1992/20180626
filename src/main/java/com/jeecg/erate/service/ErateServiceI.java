package com.jeecg.erate.service;
import com.jeecg.erate.entity.ErateEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ErateServiceI extends CommonService{
	
 	public void delete(ErateEntity entity) throws Exception;
 	
 	public Serializable save(ErateEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ErateEntity entity) throws Exception;
 	
}
