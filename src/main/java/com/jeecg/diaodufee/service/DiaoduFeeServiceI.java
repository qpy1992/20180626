package com.jeecg.diaodufee.service;
import com.jeecg.diaodufee.entity.DiaoduFeeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DiaoduFeeServiceI extends CommonService{
	
 	public void delete(DiaoduFeeEntity entity) throws Exception;
 	
 	public Serializable save(DiaoduFeeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(DiaoduFeeEntity entity) throws Exception;
 	
}
