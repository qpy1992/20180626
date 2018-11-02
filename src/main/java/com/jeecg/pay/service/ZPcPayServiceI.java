package com.jeecg.pay.service;
import com.jeecg.pay.entity.ZPcPayEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZPcPayServiceI extends CommonService{
	
 	public void delete(ZPcPayEntity entity) throws Exception;
 	
 	public Serializable save(ZPcPayEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZPcPayEntity entity) throws Exception;
 	
}
