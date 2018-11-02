package com.jeecg.dparea.service;
import com.jeecg.dparea.entity.DpareaEntity;
import com.jeecg.dp.entity.DpEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface DpareaServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(DpareaEntity dparea,
	        List<DpEntity> dpList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(DpareaEntity dparea,
	        List<DpEntity> dpList);
	public void delMain (DpareaEntity dparea);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DpareaEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DpareaEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DpareaEntity t);
}
