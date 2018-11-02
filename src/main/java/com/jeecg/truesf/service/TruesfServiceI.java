package com.jeecg.truesf.service;
import com.jeecg.truesf.entity.TruesfEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TruesfServiceI extends CommonService{
	
 	public void delete(TruesfEntity entity) throws Exception;
 	
 	public Serializable save(TruesfEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TruesfEntity entity) throws Exception;
 	
}
