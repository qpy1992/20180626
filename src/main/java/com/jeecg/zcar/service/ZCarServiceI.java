package com.jeecg.zcar.service;
import com.jeecg.zcar.entity.ZCarEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZCarServiceI extends CommonService{
	
 	public void delete(ZCarEntity entity) throws Exception;
 	
 	public Serializable save(ZCarEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZCarEntity entity) throws Exception;
 	
}
