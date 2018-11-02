package com.jeecg.hetong.service;
import com.jeecg.hetong.entity.HetongEntity;
import com.jeecg.hetong1.entity.Hetong1Entity;
import com.jeecg.hetong2.entity.Hetong2Entity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface HetongServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(HetongEntity hetong,
	        List<Hetong1Entity> hetong1List,List<Hetong2Entity> hetong2List) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(HetongEntity hetong,
	        List<Hetong1Entity> hetong1List,List<Hetong2Entity> hetong2List);
	public void delMain (HetongEntity hetong);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(HetongEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(HetongEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(HetongEntity t);
}
