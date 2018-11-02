package com.jeecg.zanluo.service;
import com.jeecg.zanluo.entity.ZanluoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZanluoServiceI extends CommonService{
	
 	public void delete(ZanluoEntity entity) throws Exception;
 	
 	public Serializable save(ZanluoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZanluoEntity entity) throws Exception;
 	
}
