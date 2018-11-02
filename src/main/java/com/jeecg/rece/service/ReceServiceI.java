package com.jeecg.rece.service;
import com.jeecg.rece.entity.ReceEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ReceServiceI extends CommonService{
	
 	public void delete(ReceEntity entity) throws Exception;
 	
 	public Serializable save(ReceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ReceEntity entity) throws Exception;
 	
}
