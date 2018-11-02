package com.jeecg.weizhang.service;
import com.jeecg.weizhang.entity.WeizhangEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WeizhangServiceI extends CommonService{
	
 	public void delete(WeizhangEntity entity) throws Exception;
 	
 	public Serializable save(WeizhangEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WeizhangEntity entity) throws Exception;
 	
}
