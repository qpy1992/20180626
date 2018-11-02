package com.jeecg.z_wp.service;
import com.jeecg.z_wp.entity.ZWpEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZWpServiceI extends CommonService{
	
 	public void delete(ZWpEntity entity) throws Exception;
 	
 	public Serializable save(ZWpEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZWpEntity entity) throws Exception;
 	
}
