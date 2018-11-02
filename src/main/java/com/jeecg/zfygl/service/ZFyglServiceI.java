package com.jeecg.zfygl.service;
import com.jeecg.zfygl.entity.ZFyglEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZFyglServiceI extends CommonService{
	
 	public void delete(ZFyglEntity entity) throws Exception;
 	
 	public Serializable save(ZFyglEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZFyglEntity entity) throws Exception;
 	
}
