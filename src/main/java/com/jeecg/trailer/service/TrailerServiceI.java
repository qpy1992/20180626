package com.jeecg.trailer.service;
import com.jeecg.trailer.entity.TrailerEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TrailerServiceI extends CommonService{
	
 	public void delete(TrailerEntity entity) throws Exception;
 	
 	public Serializable save(TrailerEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TrailerEntity entity) throws Exception;
 	
}
