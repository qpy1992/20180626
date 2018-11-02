package com.jeecg.schdaily.service;
import com.jeecg.schdaily.entity.SchdailyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface SchdailyServiceI extends CommonService{
	
 	public void delete(SchdailyEntity entity) throws Exception;
 	
 	public Serializable save(SchdailyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(SchdailyEntity entity) throws Exception;
 	
}
