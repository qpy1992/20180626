package com.jeecg.containersize.service;
import com.jeecg.containersize.entity.ContainerSizeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ContainerSizeServiceI extends CommonService{
	
 	public void delete(ContainerSizeEntity entity) throws Exception;
 	
 	public Serializable save(ContainerSizeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ContainerSizeEntity entity) throws Exception;
 	
}
