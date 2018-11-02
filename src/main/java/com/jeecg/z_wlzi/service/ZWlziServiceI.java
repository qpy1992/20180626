package com.jeecg.z_wlzi.service;
import com.jeecg.z_wlzi.entity.ZWlziEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZWlziServiceI extends CommonService{
	
 	public void delete(ZWlziEntity entity) throws Exception;
 	
 	public Serializable save(ZWlziEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZWlziEntity entity) throws Exception;
 	
}
