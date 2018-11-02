package com.jeecg.zcardetail.service;
import com.jeecg.zcardetail.entity.ZCardetailEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZCardetailServiceI extends CommonService{
	
 	public void delete(ZCardetailEntity entity) throws Exception;
 	
 	public Serializable save(ZCardetailEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZCardetailEntity entity) throws Exception;
 	
}
