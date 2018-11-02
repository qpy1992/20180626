package com.jeecg.z_wl.service;
import com.jeecg.z_wl.entity.ZWlEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZWlServiceI extends CommonService{
	
 	public void delete(ZWlEntity entity) throws Exception;
 	
 	public Serializable save(ZWlEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZWlEntity entity) throws Exception;
 	
}
