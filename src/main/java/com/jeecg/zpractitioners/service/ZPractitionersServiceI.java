package com.jeecg.zpractitioners.service;
import com.jeecg.zpractitioners.entity.ZPractitionersEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZPractitionersServiceI extends CommonService{
	
 	public void delete(ZPractitionersEntity entity) throws Exception;
 	
 	public Serializable save(ZPractitionersEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZPractitionersEntity entity) throws Exception;
 	
}
