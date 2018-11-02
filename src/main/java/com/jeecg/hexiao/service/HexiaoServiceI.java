package com.jeecg.hexiao.service;
import com.jeecg.hexiao.entity.HexiaoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HexiaoServiceI extends CommonService{
	
 	public void delete(HexiaoEntity entity) throws Exception;
 	
 	public Serializable save(HexiaoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HexiaoEntity entity) throws Exception;
 	
}
