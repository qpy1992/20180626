package com.jeecg.costcombination.service.impl;
import com.jeecg.costcombination.service.CostCombinationServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.costcombination.entity.CostCombinationEntity;
import com.jeecg.costdetail.entity.CostdetailEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("costCombinationService")
@Transactional
public class CostCombinationServiceImpl extends CommonServiceImpl implements CostCombinationServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CostCombinationEntity)entity);
 	}
	
	public void addMain(CostCombinationEntity costCombination,
	        List<CostdetailEntity> costdetailList){
			//保存主信息
			this.save(costCombination);

			Double fee = 0.0;
			/**保存-费用详情*/
			for (CostdetailEntity costdetail : costdetailList) {
				//外键设置
				costdetail.setFid(costCombination.getId());
				if(costdetail.getFee()!=null) {
					fee = fee + costdetail.getFee();
				}
				this.save(costdetail);
			}
			costCombination.setFcost(fee);
			//执行新增操作配置的sql增强
 			this.doAddSql(costCombination);
	}

	
	public void updateMain(CostCombinationEntity costCombination,
	        List<CostdetailEntity> costdetailList) {
 		Double fee = 0.0;
		//保存主表信息
		if(StringUtil.isNotEmpty(costCombination.getId())){
			try {
				CostCombinationEntity temp = findUniqueByProperty(CostCombinationEntity.class, "id", costCombination.getId());
				MyBeanUtils.copyBeanNotNull2Bean(costCombination, temp);
				this.saveOrUpdate(temp);
				fee = temp.getFcost();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(costCombination);
			fee = costCombination.getFcost();
		}
		//===================================================================================
		//获取参数
		Object id0 = costCombination.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-费用详情
	    String hql0 = "from CostdetailEntity where 1 = 1 AND fID = ? ";
	    List<CostdetailEntity> costdetailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-费用详情
		if(costdetailList!=null&&costdetailList.size()>0){
		for(CostdetailEntity oldE:costdetailOldList){
			boolean isUpdate = false;
				for(CostdetailEntity sendE:costdetailList){
					//需要更新的明细数据-费用详情
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							fee = fee + sendE.getFee() - oldE.getFee();
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-费用详情
					fee = fee - oldE.getFee();
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-费用详情
			for(CostdetailEntity costdetail:costdetailList){
				if(oConvertUtils.isEmpty(costdetail.getId())){
					//外键设置
					costdetail.setFid(costCombination.getId());
					fee = fee + costdetail.getFee();
					this.save(costdetail);
				}
			}
		}
		this.executeSql("update z_cost_combination set fcost=? where id=?",new Object[]{fee,costCombination.getId()});
		//执行更新操作配置的sql增强
 		this.doUpdateSql(costCombination);
	}

	
	public void delMain(CostCombinationEntity costCombination) {
		//删除主表信息
		this.delete(costCombination);
		//===================================================================================
		//获取参数
		Object id0 = costCombination.getId();
		//===================================================================================
		//删除-费用详情
	    String hql0 = "from CostdetailEntity where 1 = 1 AND fID = ? ";
	    List<CostdetailEntity> costdetailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(costdetailOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param t
	 * @return
	 */
 	public boolean doAddSql(CostCombinationEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param t
	 * @return
	 */
 	public boolean doUpdateSql(CostCombinationEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param t
	 * @return
	 */
 	public boolean doDelSql(CostCombinationEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CostCombinationEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{ftxyard}",String.valueOf(t.getFtxyard()));
 		sql  = sql.replace("#{fload}",String.valueOf(t.getFload()));
 		sql  = sql.replace("#{fdischarge}",String.valueOf(t.getFdischarge()));
 		sql  = sql.replace("#{fhxyard}",String.valueOf(t.getFhxyard()));
 		sql  = sql.replace("#{fcost}",String.valueOf(t.getFcost()));
 		sql  = sql.replace("#{fstart}",String.valueOf(t.getFstart()));
 		sql  = sql.replace("#{fnote}",String.valueOf(t.getFnote()));
 		sql  = sql.replace("#{fid}",String.valueOf(t.getFid()));
 		sql  = sql.replace("#{ftxid}",String.valueOf(t.getFtxid()));
 		sql  = sql.replace("#{fzhid}",String.valueOf(t.getFzhid()));
 		sql  = sql.replace("#{fxhid}",String.valueOf(t.getFxhid()));
 		sql  = sql.replace("#{fhxid}",String.valueOf(t.getFhxid()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}