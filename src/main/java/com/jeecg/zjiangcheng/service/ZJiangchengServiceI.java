package com.jeecg.zjiangcheng.service;
import com.jeecg.zjiangcheng.entity.ZJiangchengEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ZJiangchengServiceI extends CommonService{
	
 	public void delete(ZJiangchengEntity entity) throws Exception;
 	
 	public Serializable save(ZJiangchengEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ZJiangchengEntity entity) throws Exception;
 	
}
