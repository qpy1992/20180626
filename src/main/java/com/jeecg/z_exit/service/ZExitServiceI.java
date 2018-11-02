package com.jeecg.z_exit.service;
import com.jeecg.z_exit.entity.ZExitEntity;
import com.jeecg.z_exitdetail.entity.ZExitdetailEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface ZExitServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(ZExitEntity zExit,
	        List<ZExitdetailEntity> zExitdetailList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(ZExitEntity zExit,
	        List<ZExitdetailEntity> zExitdetailList);
	public void delMain (ZExitEntity zExit);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZExitEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZExitEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZExitEntity t);
}
