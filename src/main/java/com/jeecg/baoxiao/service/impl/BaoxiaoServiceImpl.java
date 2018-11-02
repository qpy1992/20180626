package com.jeecg.baoxiao.service.impl;
import com.jeecg.baoxiao.service.BaoxiaoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.baoxiao.entity.BaoxiaoEntity;
import com.jeecg.bxcost.entity.BxcostEntity;

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


@Service("baoxiaoService")
@Transactional
public class BaoxiaoServiceImpl extends CommonServiceImpl implements BaoxiaoServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((BaoxiaoEntity)entity);
 	}
	
	public void addMain(BaoxiaoEntity baoxiao,
	        List<BxcostEntity> bxcostList){
			//保存主信息
			this.save(baoxiao);
		    Double sfs = 0.00;
			/**保存-报销费用明细*/
			for(BxcostEntity bxcost:bxcostList){
				//外键设置
				bxcost.setFid(baoxiao.getId());
				this.save(bxcost);
				Double sf = bxcost.getFsfamount();
				sfs = sfs + sf;
			}
			baoxiao.setFamount(sfs);
			//执行新增操作配置的sql增强
 			this.doAddSql(baoxiao);
	}

	
	public void updateMain(BaoxiaoEntity baoxiao,
	        List<BxcostEntity> bxcostList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(baoxiao.getId())){
			try {
				BaoxiaoEntity temp = findUniqueByProperty(BaoxiaoEntity.class, "id", baoxiao.getId());
				MyBeanUtils.copyBeanNotNull2Bean(baoxiao, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(baoxiao);
		}
		//===================================================================================
		//获取参数
		Object id0 = baoxiao.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-报销费用明细
	    String hql0 = "from BxcostEntity where 1 = 1 AND fID = ? ";
	    List<BxcostEntity> bxcostOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-报销费用明细
		if(bxcostList!=null&&bxcostList.size()>0){
		for(BxcostEntity oldE:bxcostOldList){
			boolean isUpdate = false;
				for(BxcostEntity sendE:bxcostList){
					//需要更新的明细数据-报销费用明细
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-报销费用明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-报销费用明细
			for(BxcostEntity bxcost:bxcostList){
				if(oConvertUtils.isEmpty(bxcost.getId())){
					//外键设置
					bxcost.setFid(baoxiao.getId());
					this.save(bxcost);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(baoxiao);
	}

	
	public void delMain(BaoxiaoEntity baoxiao) {
		//删除主表信息
		this.delete(baoxiao);
		//===================================================================================
		//获取参数
		Object id0 = baoxiao.getId();
		//===================================================================================
		//删除-报销费用明细
	    String hql0 = "from BxcostEntity where 1 = 1 AND fID = ? ";
	    List<BxcostEntity> bxcostOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(bxcostOldList);
		for(BxcostEntity bxcost:bxcostOldList){
			this.executeSql("update z_charge set fbx='N' where id ='"+bxcost.getCostid()+"'");
		}
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param t
	 * @return
	 */
 	public boolean doAddSql(BaoxiaoEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param t
	 * @return
	 */
 	public boolean doUpdateSql(BaoxiaoEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param t
	 * @return
	 */
 	public boolean doDelSql(BaoxiaoEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,BaoxiaoEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{bpm_status}",String.valueOf(t.getBpmStatus()));
 		sql  = sql.replace("#{fbxno}",String.valueOf(t.getFbxno()));
 		sql  = sql.replace("#{fapplyer}",String.valueOf(t.getFapplyer()));
 		sql  = sql.replace("#{fapplydate}",String.valueOf(t.getFapplydate()));
 		sql  = sql.replace("#{fcheck}",String.valueOf(t.getFcheck()));
 		sql  = sql.replace("#{fchecker}",String.valueOf(t.getFchecker()));
 		sql  = sql.replace("#{fcheckdate}",String.valueOf(t.getFcheckdate()));
 		sql  = sql.replace("#{famount}",String.valueOf(t.getFamount()));
 		sql  = sql.replace("#{fhxamount}",String.valueOf(t.getFhxamount()));
 		sql  = sql.replace("#{fhxstatus}",String.valueOf(t.getFhxstatus()));
 		sql  = sql.replace("#{fbxman}",String.valueOf(t.getFbxman()));
 		sql  = sql.replace("#{fcurrency}",String.valueOf(t.getFcurrency()));
 		sql  = sql.replace("#{fnote}",String.valueOf(t.getFnote()));
 		sql  = sql.replace("#{fpcno}",String.valueOf(t.getFpcno()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}