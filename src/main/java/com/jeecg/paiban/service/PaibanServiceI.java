package com.jeecg.paiban.service;
import com.jeecg.paiban.entity.PaibanEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface PaibanServiceI extends CommonService{
	
 	public void delete(PaibanEntity entity) throws Exception;
 	
 	public Serializable save(PaibanEntity entity) throws Exception;
 	
 	public void saveOrUpdate(PaibanEntity entity) throws Exception;
 	
}
