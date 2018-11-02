package com.jeecg.custom.service;
import com.jeecg.custom.entity.CustomEntity;
import com.jeecg.cuscontact.entity.CustomContactsEntity;
import com.jeecg.cussales.entity.CustomSalesmanEntity;
import java.util.List;
import org.jeecgframework.core.common.service.CommonService;

public interface CustomServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(CustomEntity custom,
	        List<CustomContactsEntity> customContactsList,List<CustomSalesmanEntity> customSalesmanList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(CustomEntity custom,
	        List<CustomContactsEntity> customContactsList,List<CustomSalesmanEntity> customSalesmanList);
	public void delMain (CustomEntity custom);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(CustomEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(CustomEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(CustomEntity t);
}
