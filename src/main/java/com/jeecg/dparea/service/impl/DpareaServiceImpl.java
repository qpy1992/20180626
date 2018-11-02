package com.jeecg.dparea.service.impl;
import com.jeecg.dparea.service.DpareaServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.dparea.entity.DpareaEntity;
import com.jeecg.dp.entity.DpEntity;

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


@Service("dpareaService")
@Transactional
public class DpareaServiceImpl extends CommonServiceImpl implements DpareaServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DpareaEntity)entity);
 	}
	
	public void addMain(DpareaEntity dparea,
	        List<DpEntity> dpList){
			//保存主信息
			this.save(dparea);
		
			/**保存-门点堆场*/
			for(DpEntity dp:dpList){
				//外键设置
				dp.setFid(dparea.getId());
				this.save(dp);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(dparea);
	}

	
	public void updateMain(DpareaEntity dparea,
	        List<DpEntity> dpList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(dparea.getId())){
			try {
				DpareaEntity temp = findUniqueByProperty(DpareaEntity.class, "id", dparea.getId());
				MyBeanUtils.copyBeanNotNull2Bean(dparea, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(dparea);
		}
		//===================================================================================
		//获取参数
		Object id0 = dparea.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-门点堆场
	    String hql0 = "from DpEntity where 1 = 1 AND fID = ? ";
	    List<DpEntity> dpOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-门点堆场
		if(dpList!=null&&dpList.size()>0){
		for(DpEntity oldE:dpOldList){
			boolean isUpdate = false;
				for(DpEntity sendE:dpList){
					//需要更新的明细数据-门点堆场
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-门点堆场
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-门点堆场
			for(DpEntity dp:dpList){
				if(oConvertUtils.isEmpty(dp.getId())){
					//外键设置
					dp.setFid(dparea.getId());
					this.save(dp);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(dparea);
	}

	
	public void delMain(DpareaEntity dparea) {
		//删除主表信息
		this.delete(dparea);
		//===================================================================================
		//获取参数
		Object id0 = dparea.getId();
		//===================================================================================
		//删除-门点堆场
	    String hql0 = "from DpEntity where 1 = 1 AND fID = ? ";
	    List<DpEntity> dpOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(dpOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DpareaEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DpareaEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DpareaEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DpareaEntity t){
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
 		sql  = sql.replace("#{farea_code}",String.valueOf(t.getFareaCode()));
 		sql  = sql.replace("#{fvoid}",String.valueOf(t.getFvoid()));
 		sql  = sql.replace("#{farea_name}",String.valueOf(t.getFareaName()));
 		sql  = sql.replace("#{fproject_team}",String.valueOf(t.getFprojectTeam()));
 		sql  = sql.replace("#{finstruction}",String.valueOf(t.getFinstruction()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}