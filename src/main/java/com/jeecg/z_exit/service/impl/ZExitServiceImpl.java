package com.jeecg.z_exit.service.impl;
import com.jeecg.z_exit.service.ZExitServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.z_exit.entity.ZExitEntity;
import com.jeecg.z_exitdetail.entity.ZExitdetailEntity;

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


@Service("zExitService")
@Transactional
public class ZExitServiceImpl extends CommonServiceImpl implements ZExitServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ZExitEntity)entity);
 	}
	
	public void addMain(ZExitEntity zExit,
	        List<ZExitdetailEntity> zExitdetailList){
			//保存主信息
			this.save(zExit);
		
			/**保存-出库明细表*/
			for(ZExitdetailEntity zExitdetail:zExitdetailList){
				//外键设置
				zExitdetail.setZExitId(zExit.getId());
				this.save(zExitdetail);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(zExit);
	}

	
	public void updateMain(ZExitEntity zExit,
	        List<ZExitdetailEntity> zExitdetailList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(zExit.getId())){
			try {
				ZExitEntity temp = findUniqueByProperty(ZExitEntity.class, "id", zExit.getId());
				MyBeanUtils.copyBeanNotNull2Bean(zExit, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(zExit);
		}
		//===================================================================================
		//获取参数
		Object id0 = zExit.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-出库明细表
	    String hql0 = "from ZExitdetailEntity where 1 = 1 AND z_EXIT_ID = ? ";
	    List<ZExitdetailEntity> zExitdetailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-出库明细表
		if(zExitdetailList!=null&&zExitdetailList.size()>0){
		for(ZExitdetailEntity oldE:zExitdetailOldList){
			boolean isUpdate = false;
				for(ZExitdetailEntity sendE:zExitdetailList){
					//需要更新的明细数据-出库明细表
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-出库明细表
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-出库明细表
			for(ZExitdetailEntity zExitdetail:zExitdetailList){
				if(oConvertUtils.isEmpty(zExitdetail.getId())){
					//外键设置
					zExitdetail.setZExitId(zExit.getId());
					this.save(zExitdetail);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(zExit);
	}

	
	public void delMain(ZExitEntity zExit) {
		//删除主表信息
		this.delete(zExit);
		//===================================================================================
		//获取参数
		Object id0 = zExit.getId();
		//===================================================================================
		//删除-出库明细表
	    String hql0 = "from ZExitdetailEntity where 1 = 1 AND z_EXIT_ID = ? ";
	    List<ZExitdetailEntity> zExitdetailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(zExitdetailOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZExitEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZExitEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZExitEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ZExitEntity t){
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
 		sql  = sql.replace("#{z_lsbm}",String.valueOf(t.getZLsbm()));
 		sql  = sql.replace("#{z_zddate}",String.valueOf(t.getZZddate()));
 		sql  = sql.replace("#{z_zdpeople}",String.valueOf(t.getZZdpeople()));
 		sql  = sql.replace("#{z_checkpeople}",String.valueOf(t.getZCheckpeople()));
 		sql  = sql.replace("#{z_checktime}",String.valueOf(t.getZChecktime()));
 		sql  = sql.replace("#{z_ch}",String.valueOf(t.getZCh()));
 		sql  = sql.replace("#{z_jsy}",String.valueOf(t.getZJsy()));
 		sql  = sql.replace("#{z_exitpeople}",String.valueOf(t.getZExitpeople()));
 		sql  = sql.replace("#{z_exittotal}",String.valueOf(t.getZExittotal()));
 		sql  = sql.replace("#{z_bz}",String.valueOf(t.getZBz()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}