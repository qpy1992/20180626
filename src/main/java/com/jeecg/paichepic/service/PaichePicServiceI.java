package com.jeecg.paichepic.service;
import com.jeecg.paichepic.entity.PaichePicEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface PaichePicServiceI extends CommonService{
	
 	public void delete(PaichePicEntity entity) throws Exception;
 	
 	public Serializable save(PaichePicEntity entity) throws Exception;
 	
 	public void saveOrUpdate(PaichePicEntity entity) throws Exception;
 	
}
