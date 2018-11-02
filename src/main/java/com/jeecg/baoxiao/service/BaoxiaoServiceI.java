package com.jeecg.baoxiao.service;
import com.jeecg.baoxiao.entity.BaoxiaoEntity;
import com.jeecg.bxcost.entity.BxcostEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface BaoxiaoServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(BaoxiaoEntity baoxiao,
	        List<BxcostEntity> bxcostList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(BaoxiaoEntity baoxiao,
	        List<BxcostEntity> bxcostList);
	public void delMain (BaoxiaoEntity baoxiao);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(BaoxiaoEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(BaoxiaoEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(BaoxiaoEntity t);
}
