package com.jeecg.zdriverillegal.service;
import com.jeecg.zdriverillegal.entity.ZDriverillegalEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZDriverillegalServiceI extends CommonService{
	
 	public void delete(ZDriverillegalEntity entity) throws Exception;
 	
 	public Serializable save(ZDriverillegalEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZDriverillegalEntity entity) throws Exception;
 	
}
