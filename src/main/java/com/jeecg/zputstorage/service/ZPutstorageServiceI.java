package com.jeecg.zputstorage.service;
import com.jeecg.zputstorage.entity.ZPutstorageEntity;
import com.jeecg.zputstoragedetail.entity.ZPutstorageDetailEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface ZPutstorageServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ZPutstorageEntity zPutstorage,
	        List<ZPutstorageDetailEntity> zPutstorageDetailList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ZPutstorageEntity zPutstorage,
	        List<ZPutstorageDetailEntity> zPutstorageDetailList);
	public void delMain (ZPutstorageEntity zPutstorage);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZPutstorageEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZPutstorageEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZPutstorageEntity t);
}
