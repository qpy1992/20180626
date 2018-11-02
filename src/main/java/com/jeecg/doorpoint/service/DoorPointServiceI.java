package com.jeecg.doorpoint.service;
import com.jeecg.doorpoint.entity.DoorPointEntity;
import com.jeecg.dprate.entity.DpRateEntity;
import com.jeecg.dpcontact.entity.DpContactEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface DoorPointServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(DoorPointEntity doorPoint,
	        List<DpRateEntity> dpRateList,List<DpContactEntity> dpContactList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(DoorPointEntity doorPoint,
	        List<DpRateEntity> dpRateList,List<DpContactEntity> dpContactList);
	public void delMain (DoorPointEntity doorPoint);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DoorPointEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DoorPointEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DoorPointEntity t);
}
