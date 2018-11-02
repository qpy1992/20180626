package com.jeecg.mileage.service;
import com.jeecg.mileage.entity.MileageEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface MileageServiceI extends CommonService{
	
 	public void delete(MileageEntity entity) throws Exception;
 	
 	public Serializable save(MileageEntity entity) throws Exception;
 	
 	public void saveOrUpdate(MileageEntity entity) throws Exception;
 	
}
