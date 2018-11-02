package com.jeecg.currency.service;
import com.jeecg.currency.entity.CurrencyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CurrencyServiceI extends CommonService{
	
 	public void delete(CurrencyEntity entity) throws Exception;
 	
 	public Serializable save(CurrencyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CurrencyEntity entity) throws Exception;
 	
}
