package com.jeecg.zoutstorage.service;
import com.jeecg.zoutstorage.entity.ZOutstorageEntity;
import com.jeecg.zoutstoragedetail.entity.ZOutstoragedetailEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface ZOutstorageServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ZOutstorageEntity zOutstorage,
	        List<ZOutstoragedetailEntity> zOutstoragedetailList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ZOutstorageEntity zOutstorage,
	        List<ZOutstoragedetailEntity> zOutstoragedetailList);
	public void delMain (ZOutstorageEntity zOutstorage);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZOutstorageEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZOutstorageEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZOutstorageEntity t);
}
