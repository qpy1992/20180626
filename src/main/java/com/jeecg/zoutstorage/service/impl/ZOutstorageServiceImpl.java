package com.jeecg.zoutstorage.service.impl;
import com.jeecg.zoutstorage.service.ZOutstorageServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.zoutstorage.entity.ZOutstorageEntity;
import com.jeecg.zoutstoragedetail.entity.ZOutstoragedetailEntity;

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


@Service("zOutstorageService")
@Transactional
public class ZOutstorageServiceImpl extends CommonServiceImpl implements ZOutstorageServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ZOutstorageEntity)entity);
 	}
	
	public void addMain(ZOutstorageEntity zOutstorage,
	        List<ZOutstoragedetailEntity> zOutstoragedetailList){
			//保存主信息
			this.save(zOutstorage);
		
			/**保存-领用明细*/
			for(ZOutstoragedetailEntity zOutstoragedetail:zOutstoragedetailList){
				//外键设置
				zOutstoragedetail.setFid(zOutstorage.getId());
				this.save(zOutstoragedetail);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(zOutstorage);
	}

	
	public void updateMain(ZOutstorageEntity zOutstorage,
	        List<ZOutstoragedetailEntity> zOutstoragedetailList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(zOutstorage.getId())){
			try {
				ZOutstorageEntity temp = findUniqueByProperty(ZOutstorageEntity.class, "id", zOutstorage.getId());
				MyBeanUtils.copyBeanNotNull2Bean(zOutstorage, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(zOutstorage);
		}
		//===================================================================================
		//获取参数
		Object id0 = zOutstorage.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-领用明细
	    String hql0 = "from ZOutstoragedetailEntity where 1 = 1 AND fID = ? ";
	    List<ZOutstoragedetailEntity> zOutstoragedetailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-领用明细
		if(zOutstoragedetailList!=null&&zOutstoragedetailList.size()>0){
		for(ZOutstoragedetailEntity oldE:zOutstoragedetailOldList){
			boolean isUpdate = false;
				for(ZOutstoragedetailEntity sendE:zOutstoragedetailList){
					//需要更新的明细数据-领用明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-领用明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-领用明细
			for(ZOutstoragedetailEntity zOutstoragedetail:zOutstoragedetailList){
				if(oConvertUtils.isEmpty(zOutstoragedetail.getId())){
					//外键设置
					zOutstoragedetail.setFid(zOutstorage.getId());
					this.save(zOutstoragedetail);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(zOutstorage);
	}

	
	public void delMain(ZOutstorageEntity zOutstorage) {
		//删除主表信息
		this.delete(zOutstorage);
		//===================================================================================
		//获取参数
		Object id0 = zOutstorage.getId();
		//===================================================================================
		//删除-领用明细
	    String hql0 = "from ZOutstoragedetailEntity where 1 = 1 AND fID = ? ";
	    List<ZOutstoragedetailEntity> zOutstoragedetailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(zOutstoragedetailOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZOutstorageEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZOutstorageEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZOutstorageEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ZOutstorageEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{code}",String.valueOf(t.getCode()));
 		sql  = sql.replace("#{make_date}",String.valueOf(t.getMakeDate()));
 		sql  = sql.replace("#{make_people}",String.valueOf(t.getMakePeople()));
 		sql  = sql.replace("#{check_people}",String.valueOf(t.getCheckPeople()));
 		sql  = sql.replace("#{check_date}",String.valueOf(t.getCheckDate()));
 		sql  = sql.replace("#{carcode}",String.valueOf(t.getCarcode()));
 		sql  = sql.replace("#{driver}",String.valueOf(t.getDriver()));
 		sql  = sql.replace("#{lyperson}",String.valueOf(t.getLyperson()));
 		sql  = sql.replace("#{lytotal}",String.valueOf(t.getLytotal()));
 		sql  = sql.replace("#{note}",String.valueOf(t.getNote()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}