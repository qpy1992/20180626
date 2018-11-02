package com.jeecg.zdriverdetail.service;
import com.jeecg.zdriverdetail.entity.ZDriverdetailEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZDriverdetailServiceI extends CommonService{
	
 	public void delete(ZDriverdetailEntity entity) throws Exception;
 	
 	public Serializable save(ZDriverdetailEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZDriverdetailEntity entity) throws Exception;
 	
}
