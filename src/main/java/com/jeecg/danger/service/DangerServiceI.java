package com.jeecg.danger.service;
import com.jeecg.danger.entity.DangerEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DangerServiceI extends CommonService{
	
 	public void delete(DangerEntity entity) throws Exception;
 	
 	public Serializable save(DangerEntity entity) throws Exception;
 	
 	public void saveOrUpdate(DangerEntity entity) throws Exception;
 	
}
