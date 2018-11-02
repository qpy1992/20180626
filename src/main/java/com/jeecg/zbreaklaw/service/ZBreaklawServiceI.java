package com.jeecg.zbreaklaw.service;
import com.jeecg.zbreaklaw.entity.ZBreaklawEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZBreaklawServiceI extends CommonService{
	
 	public void delete(ZBreaklawEntity entity) throws Exception;
 	
 	public Serializable save(ZBreaklawEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZBreaklawEntity entity) throws Exception;
 	
}
