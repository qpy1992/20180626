package com.jeecg.receive.service;
import com.jeecg.receive.entity.ZPcReceiveEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZPcReceiveServiceI extends CommonService{
	
 	public void delete(ZPcReceiveEntity entity) throws Exception;
 	
 	public Serializable save(ZPcReceiveEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZPcReceiveEntity entity) throws Exception;
 	
}
