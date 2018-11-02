package com.jeecg.item.service;
import com.jeecg.item.entity.ItemEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ItemServiceI extends CommonService{
	
 	public void delete(ItemEntity entity) throws Exception;
 	
 	public Serializable save(ItemEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ItemEntity entity) throws Exception;
 	
}
