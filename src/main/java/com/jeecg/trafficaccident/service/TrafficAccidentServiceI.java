package com.jeecg.trafficaccident.service;
import com.jeecg.trafficaccident.entity.TrafficAccidentEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TrafficAccidentServiceI extends CommonService{
	
 	public void delete(TrafficAccidentEntity entity) throws Exception;
 	
 	public Serializable save(TrafficAccidentEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TrafficAccidentEntity entity) throws Exception;
 	
}
