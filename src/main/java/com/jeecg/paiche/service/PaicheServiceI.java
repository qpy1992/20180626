package com.jeecg.paiche.service;
import com.jeecg.paiche.entity.PaicheEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface PaicheServiceI extends CommonService{
	
 	public void delete(PaicheEntity entity) throws Exception;
 	
 	public Serializable save(PaicheEntity entity) throws Exception;
 	
 	public void saveOrUpdate(PaicheEntity entity) throws Exception;
 	
}
