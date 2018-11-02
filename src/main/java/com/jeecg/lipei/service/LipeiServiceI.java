package com.jeecg.lipei.service;
import com.jeecg.lipei.entity.LipeiEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface LipeiServiceI extends CommonService{
	
 	public void delete(LipeiEntity entity) throws Exception;
 	
 	public Serializable save(LipeiEntity entity) throws Exception;
 	
 	public void saveOrUpdate(LipeiEntity entity) throws Exception;
 	
}
