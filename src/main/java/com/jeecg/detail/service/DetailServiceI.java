package com.jeecg.detail.service;
import com.jeecg.detail.entity.DetailEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DetailServiceI extends CommonService{
	
 	public void delete(DetailEntity entity) throws Exception;
 	
 	public Serializable save(DetailEntity entity) throws Exception;
 	
 	public void saveOrUpdate(DetailEntity entity) throws Exception;
 	
}
