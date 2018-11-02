package com.jeecg.container.service;
import com.jeecg.container.entity.ContainerEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ContainerServiceI extends CommonService{
	
 	public void delete(ContainerEntity entity) throws Exception;
 	
 	public Serializable save(ContainerEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ContainerEntity entity) throws Exception;
 	
}
