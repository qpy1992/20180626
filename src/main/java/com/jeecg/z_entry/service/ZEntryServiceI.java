package com.jeecg.z_entry.service;
import com.jeecg.z_entry.entity.ZEntryEntity;
import com.jeecg.z_entrydetail.entity.ZEntrydetailEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface ZEntryServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ZEntryEntity zEntry,
	        List<ZEntrydetailEntity> zEntrydetailList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ZEntryEntity zEntry,
	        List<ZEntrydetailEntity> zEntrydetailList);
	public void delMain (ZEntryEntity zEntry);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZEntryEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZEntryEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZEntryEntity t);
}
