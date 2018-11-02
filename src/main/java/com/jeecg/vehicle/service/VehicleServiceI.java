package com.jeecg.vehicle.service;
import com.jeecg.vehicle.entity.VehicleEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VehicleServiceI extends CommonService{
	
 	public void delete(VehicleEntity entity) throws Exception;
 	
 	public Serializable save(VehicleEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VehicleEntity entity) throws Exception;
 	
}
