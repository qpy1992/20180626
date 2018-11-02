package com.jeecg.hetong.service.impl;
import com.jeecg.hetong.service.HetongServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.hetong.entity.HetongEntity;
import com.jeecg.hetong1.entity.Hetong1Entity;
import com.jeecg.hetong2.entity.Hetong2Entity;

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


@Service("hetongService")
@Transactional
public class HetongServiceImpl extends CommonServiceImpl implements HetongServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((HetongEntity)entity);
 	}
	
	public void addMain(HetongEntity hetong,
	        List<Hetong1Entity> hetong1List,List<Hetong2Entity> hetong2List){
			//保存主信息
			this.save(hetong);
		
			/**保存-门点信息*/
			for(Hetong1Entity hetong1:hetong1List){
				//外键设置
				hetong1.setFid(hetong.getId());
				this.save(hetong1);
			}
			/**保存-价格要素及费率*/
			for(Hetong2Entity hetong2:hetong2List){
				//外键设置
				hetong2.setFid(hetong.getId());
				this.save(hetong2);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(hetong);
	}

	
	public void updateMain(HetongEntity hetong,
	        List<Hetong1Entity> hetong1List,List<Hetong2Entity> hetong2List) {
		//保存主表信息
		if(StringUtil.isNotEmpty(hetong.getId())){
			try {
				HetongEntity temp = findUniqueByProperty(HetongEntity.class, "id", hetong.getId());
				MyBeanUtils.copyBeanNotNull2Bean(hetong, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(hetong);
		}
		//===================================================================================
		//获取参数
		Object id0 = hetong.getId();
		Object id1 = hetong.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-门点信息
	    String hql0 = "from Hetong1Entity where 1 = 1 AND fID = ? ";
	    List<Hetong1Entity> hetong1OldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-门点信息
		if(hetong1List!=null&&hetong1List.size()>0){
		for(Hetong1Entity oldE:hetong1OldList){
			boolean isUpdate = false;
				for(Hetong1Entity sendE:hetong1List){
					//需要更新的明细数据-门点信息
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-门点信息
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-门点信息
			for(Hetong1Entity hetong1:hetong1List){
				if(oConvertUtils.isEmpty(hetong1.getId())){
					//外键设置
					hetong1.setFid(hetong.getId());
					this.save(hetong1);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-价格要素及费率
	    String hql1 = "from Hetong2Entity where 1 = 1 AND fID = ? ";
	    List<Hetong2Entity> hetong2OldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-价格要素及费率
		if(hetong2List!=null&&hetong2List.size()>0){
		for(Hetong2Entity oldE:hetong2OldList){
			boolean isUpdate = false;
				for(Hetong2Entity sendE:hetong2List){
					//需要更新的明细数据-价格要素及费率
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-价格要素及费率
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-价格要素及费率
			for(Hetong2Entity hetong2:hetong2List){
				if(oConvertUtils.isEmpty(hetong2.getId())){
					//外键设置
					hetong2.setFid(hetong.getId());
					this.save(hetong2);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(hetong);
	}

	
	public void delMain(HetongEntity hetong) {
		//删除主表信息
		this.delete(hetong);
		//===================================================================================
		//获取参数
		Object id0 = hetong.getId();
		Object id1 = hetong.getId();
		//===================================================================================
		//删除-门点信息
	    String hql0 = "from Hetong1Entity where 1 = 1 AND fID = ? ";
	    List<Hetong1Entity> hetong1OldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(hetong1OldList);
		//===================================================================================
		//删除-价格要素及费率
	    String hql1 = "from Hetong2Entity where 1 = 1 AND fID = ? ";
	    List<Hetong2Entity> hetong2OldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(hetong2OldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(HetongEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(HetongEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(HetongEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,HetongEntity t){
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
 		sql  = sql.replace("#{fbillno}",String.valueOf(t.getFbillno()));
 		sql  = sql.replace("#{ftype}",String.valueOf(t.getFtype()));
 		sql  = sql.replace("#{fkind}",String.valueOf(t.getFkind()));
 		sql  = sql.replace("#{fsettle}",String.valueOf(t.getFsettle()));
 		sql  = sql.replace("#{fsettle_name}",String.valueOf(t.getFsettleName()));
 		sql  = sql.replace("#{fchargetype}",String.valueOf(t.getFchargetype()));
 		sql  = sql.replace("#{fstart_date}",String.valueOf(t.getFstartDate()));
 		sql  = sql.replace("#{fenddate}",String.valueOf(t.getFenddate()));
 		sql  = sql.replace("#{fnote}",String.valueOf(t.getFnote()));
 		sql  = sql.replace("#{fbrno}",String.valueOf(t.getFbrno()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}