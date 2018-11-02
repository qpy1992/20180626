package com.jeecg.zzhengjian.service;
import com.jeecg.zzhengjian.entity.ZZhengjianEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZZhengjianServiceI extends CommonService{
	
 	public void delete(ZZhengjianEntity entity) throws Exception;
 	
 	public Serializable save(ZZhengjianEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZZhengjianEntity entity) throws Exception;
 	
}
