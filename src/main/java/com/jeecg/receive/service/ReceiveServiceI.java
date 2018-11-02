package com.jeecg.receive.service;
import com.jeecg.receive.entity.ReceiveEntity;
import com.jeecg.zhangdan1.entity.Zhangdan1Entity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface ReceiveServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ReceiveEntity receive,
	        List<Zhangdan1Entity> zhangdan1List) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ReceiveEntity receive,
	        List<Zhangdan1Entity> zhangdan1List);
	public void delMain (ReceiveEntity receive);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ReceiveEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ReceiveEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ReceiveEntity t);
}
