package com.jeecg.doorpoint.service.impl;
import com.jeecg.doorpoint.service.DoorPointServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.doorpoint.entity.DoorPointEntity;
import com.jeecg.dprate.entity.DpRateEntity;
import com.jeecg.dpcontact.entity.DpContactEntity;

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


@Service("doorPointService")
@Transactional
public class DoorPointServiceImpl extends CommonServiceImpl implements DoorPointServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DoorPointEntity)entity);
 	}
	
	public void addMain(DoorPointEntity doorPoint,
	        List<DpRateEntity> dpRateList,List<DpContactEntity> dpContactList){
			//保存主信息
			this.save(doorPoint);
		
			/**保存-门点费率*/
			for(DpRateEntity dpRate:dpRateList){
				//外键设置
				dpRate.setFid(doorPoint.getId());
				this.save(dpRate);
			}
			/**保存-门点联系人*/
			if(dpContactList.size()!=0) {
				dpContactList.get(0).setFdefault("Y");
			}
			for(DpContactEntity dpContact:dpContactList){
				//外键设置
				dpContact.setFid(doorPoint.getId());
				this.save(dpContact);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(doorPoint);
	}

	
	public void updateMain(DoorPointEntity doorPoint,
	        List<DpRateEntity> dpRateList,List<DpContactEntity> dpContactList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(doorPoint.getId())){
			try {
				DoorPointEntity temp = findUniqueByProperty(DoorPointEntity.class, "id", doorPoint.getId());
				MyBeanUtils.copyBeanNotNull2Bean(doorPoint, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(doorPoint);
		}
		//===================================================================================
		//获取参数
		Object id0 = doorPoint.getId();
		Object id1 = doorPoint.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-门点费率
	    String hql0 = "from DpRateEntity where 1 = 1 AND fID = ? ";
	    List<DpRateEntity> dpRateOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-门点费率
		if(dpRateList!=null&&dpRateList.size()>0){
		for(DpRateEntity oldE:dpRateOldList){
			boolean isUpdate = false;
				for(DpRateEntity sendE:dpRateList){
					//需要更新的明细数据-门点费率
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-门点费率
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-门点费率
			for(DpRateEntity dpRate:dpRateList){
				if(oConvertUtils.isEmpty(dpRate.getId())){
					//外键设置
					dpRate.setFid(doorPoint.getId());
					this.save(dpRate);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-门点联系人
	    String hql1 = "from DpContactEntity where 1 = 1 AND fID = ? ";
	    List<DpContactEntity> dpContactOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-门点联系人
		if(dpContactList!=null&&dpContactList.size()>0){
		for(DpContactEntity oldE:dpContactOldList){
			boolean isUpdate = false;
				for(DpContactEntity sendE:dpContactList){
					//需要更新的明细数据-门点联系人
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-门点联系人
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-门点联系人
			for(DpContactEntity dpContact:dpContactList){
				if(oConvertUtils.isEmpty(dpContact.getId())){
					//外键设置
					dpContact.setFid(doorPoint.getId());
					this.save(dpContact);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(doorPoint);
	}

	
	public void delMain(DoorPointEntity doorPoint) {
		//删除主表信息
		this.delete(doorPoint);
		//===================================================================================
		//获取参数
		Object id0 = doorPoint.getId();
		Object id1 = doorPoint.getId();
		//===================================================================================
		//删除-门点费率
	    String hql0 = "from DpRateEntity where 1 = 1 AND fID = ? ";
	    List<DpRateEntity> dpRateOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(dpRateOldList);
		//===================================================================================
		//删除-门点联系人
	    String hql1 = "from DpContactEntity where 1 = 1 AND fID = ? ";
	    List<DpContactEntity> dpContactOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(dpContactOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param t
	 * @return
	 */
 	public boolean doAddSql(DoorPointEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param t
	 * @return
	 */
 	public boolean doUpdateSql(DoorPointEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param t
	 * @return
	 */
 	public boolean doDelSql(DoorPointEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DoorPointEntity t){
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
 		sql  = sql.replace("#{fdp_code}",String.valueOf(t.getFdpCode()));
 		sql  = sql.replace("#{fproject_team}",String.valueOf(t.getFprojectTeam()));
 		sql  = sql.replace("#{fvoid}",String.valueOf(t.getFvoid()));
 		sql  = sql.replace("#{fdp_name}",String.valueOf(t.getFdpName()));
 		sql  = sql.replace("#{fdeliver_unit}",String.valueOf(t.getFdeliverUnit()));
 		sql  = sql.replace("#{finstruction}",String.valueOf(t.getFinstruction()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}