package com.jeecg.pays.service;
import com.jeecg.pays.entity.PaysEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface PaysServiceI extends CommonService{
	
 	public void delete(PaysEntity entity) throws Exception;
 	
 	public Serializable save(PaysEntity entity) throws Exception;
 	
 	public void saveOrUpdate(PaysEntity entity) throws Exception;
 	
}
