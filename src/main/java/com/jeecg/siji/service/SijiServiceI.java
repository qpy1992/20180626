package com.jeecg.siji.service;
import com.jeecg.siji.entity.SijiEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface SijiServiceI extends CommonService{
	
 	public void delete(SijiEntity entity) throws Exception;
 	
 	public Serializable save(SijiEntity entity) throws Exception;
 	
 	public void saveOrUpdate(SijiEntity entity) throws Exception;
 	
}
