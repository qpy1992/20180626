package com.jeecg.extract.service;
import com.jeecg.extract.entity.ExtractEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ExtractServiceI extends CommonService{
	
 	public void delete(ExtractEntity entity) throws Exception;
 	
 	public Serializable save(ExtractEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ExtractEntity entity) throws Exception;
 	
}
