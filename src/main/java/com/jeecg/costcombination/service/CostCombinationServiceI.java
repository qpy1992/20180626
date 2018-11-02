package com.jeecg.costcombination.service;
import com.jeecg.costcombination.entity.CostCombinationEntity;
import com.jeecg.costdetail.entity.CostdetailEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface CostCombinationServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CostCombinationEntity costCombination,
	        List<CostdetailEntity> costdetailList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CostCombinationEntity costCombination,
	        List<CostdetailEntity> costdetailList);
	public void delMain (CostCombinationEntity costCombination);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CostCombinationEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CostCombinationEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CostCombinationEntity t);
}
