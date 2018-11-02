package com.jeecg.z_entry.service.impl;
import com.jeecg.z_entry.service.ZEntryServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.z_entry.entity.ZEntryEntity;
import com.jeecg.z_entrydetail.entity.ZEntrydetailEntity;

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


@Service("zEntryService")
@Transactional
public class ZEntryServiceImpl extends CommonServiceImpl implements ZEntryServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ZEntryEntity)entity);
 	}
	
	public void addMain(ZEntryEntity zEntry,
	        List<ZEntrydetailEntity> zEntrydetailList){
			//保存主信息
			this.save(zEntry);
		
			/**保存-入库明细表*/
			for(ZEntrydetailEntity zEntrydetail:zEntrydetailList){
				//外键设置
				zEntrydetail.setZId(zEntry.getId());
				this.save(zEntrydetail);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(zEntry);
	}

	
	public void updateMain(ZEntryEntity zEntry,
	        List<ZEntrydetailEntity> zEntrydetailList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(zEntry.getId())){
			try {
				ZEntryEntity temp = findUniqueByProperty(ZEntryEntity.class, "id", zEntry.getId());
				MyBeanUtils.copyBeanNotNull2Bean(zEntry, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(zEntry);
		}
		//===================================================================================
		//获取参数
		Object id0 = zEntry.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-入库明细表
	    String hql0 = "from ZEntrydetailEntity where 1 = 1 AND z_ID = ? ";
	    List<ZEntrydetailEntity> zEntrydetailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-入库明细表
		if(zEntrydetailList!=null&&zEntrydetailList.size()>0){
		for(ZEntrydetailEntity oldE:zEntrydetailOldList){
			boolean isUpdate = false;
				for(ZEntrydetailEntity sendE:zEntrydetailList){
					//需要更新的明细数据-入库明细表
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-入库明细表
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-入库明细表
			for(ZEntrydetailEntity zEntrydetail:zEntrydetailList){
				if(oConvertUtils.isEmpty(zEntrydetail.getId())){
					//外键设置
					zEntrydetail.setZId(zEntry.getId());
					this.save(zEntrydetail);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(zEntry);
	}

	
	public void delMain(ZEntryEntity zEntry) {
		//删除主表信息
		this.delete(zEntry);
		//===================================================================================
		//获取参数
		Object id0 = zEntry.getId();
		//===================================================================================
		//删除-入库明细表
	    String hql0 = "from ZEntrydetailEntity where 1 = 1 AND z_ID = ? ";
	    List<ZEntrydetailEntity> zEntrydetailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(zEntrydetailOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZEntryEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZEntryEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZEntryEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ZEntryEntity t){
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
// 		sql  = sql.replace("#{z_ls}",String.valueOf(t.getZLs()));
 		sql  = sql.replace("#{z_zddate}",String.valueOf(t.getZZddate()));
 		sql  = sql.replace("#{z_people}",String.valueOf(t.getZPeople()));
 		sql  = sql.replace("#{z_checkpeople}",String.valueOf(t.getZCheckpeople()));
 		sql  = sql.replace("#{z_checkdatetime}",String.valueOf(t.getZCheckdatetime()));
 		sql  = sql.replace("#{z_bz}",String.valueOf(t.getZBz()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}