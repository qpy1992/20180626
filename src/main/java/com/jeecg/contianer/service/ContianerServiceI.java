package com.jeecg.contianer.service;
import com.jeecg.contianer.entity.ContianerEntity;
import com.jeecg.detail.entity.DetailEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface ContianerServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ContianerEntity contianer,
	        List<DetailEntity> detailList, String fsettleid) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ContianerEntity contianer,
	        List<DetailEntity> detailList);
	public void delMain (ContianerEntity contianer);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ContianerEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ContianerEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ContianerEntity t);
}
