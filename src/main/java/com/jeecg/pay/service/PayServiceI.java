package com.jeecg.pay.service;
import com.jeecg.pay.entity.PayEntity;
import com.jeecg.zhangdan.entity.ZhangdanEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface PayServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(PayEntity pay,
	        List<ZhangdanEntity> zhangdanList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(PayEntity pay,
	        List<ZhangdanEntity> zhangdanList);
	public void delMain (PayEntity pay);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(PayEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(PayEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(PayEntity t);
}
