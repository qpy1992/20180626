package com.jeecg.zputstorage.service.impl;
import com.jeecg.zputstorage.service.ZPutstorageServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.zputstorage.entity.ZPutstorageEntity;
import com.jeecg.zputstoragedetail.entity.ZPutstorageDetailEntity;

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


@Service("zPutstorageService")
@Transactional
public class ZPutstorageServiceImpl extends CommonServiceImpl implements ZPutstorageServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ZPutstorageEntity)entity);
 	}
	
	public void addMain(ZPutstorageEntity zPutstorage,
	        List<ZPutstorageDetailEntity> zPutstorageDetailList){
			//保存主信息
			this.save(zPutstorage);
		
			/**保存-入库明细*/
			for(ZPutstorageDetailEntity zPutstorageDetail:zPutstorageDetailList){
				//外键设置
				zPutstorageDetail.setFid(zPutstorage.getId());
				this.save(zPutstorageDetail);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(zPutstorage);
	}

	
	public void updateMain(ZPutstorageEntity zPutstorage,
	        List<ZPutstorageDetailEntity> zPutstorageDetailList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(zPutstorage.getId())){
			try {
				ZPutstorageEntity temp = findUniqueByProperty(ZPutstorageEntity.class, "id", zPutstorage.getId());
				MyBeanUtils.copyBeanNotNull2Bean(zPutstorage, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(zPutstorage);
		}
		//===================================================================================
		//获取参数
		Object id0 = zPutstorage.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-入库明细
	    String hql0 = "from ZPutstorageDetailEntity where 1 = 1 AND fID = ? ";
	    List<ZPutstorageDetailEntity> zPutstorageDetailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-入库明细
		if(zPutstorageDetailList!=null&&zPutstorageDetailList.size()>0){
		for(ZPutstorageDetailEntity oldE:zPutstorageDetailOldList){
			boolean isUpdate = false;
				for(ZPutstorageDetailEntity sendE:zPutstorageDetailList){
					//需要更新的明细数据-入库明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-入库明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-入库明细
			for(ZPutstorageDetailEntity zPutstorageDetail:zPutstorageDetailList){
				if(oConvertUtils.isEmpty(zPutstorageDetail.getId())){
					//外键设置
					zPutstorageDetail.setFid(zPutstorage.getId());
					this.save(zPutstorageDetail);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(zPutstorage);
	}

	
	public void delMain(ZPutstorageEntity zPutstorage) {
		//删除主表信息
		this.delete(zPutstorage);
		//===================================================================================
		//获取参数
		Object id0 = zPutstorage.getId();
		//===================================================================================
		//删除-入库明细
	    String hql0 = "from ZPutstorageDetailEntity where 1 = 1 AND fID = ? ";
	    List<ZPutstorageDetailEntity> zPutstorageDetailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(zPutstorageDetailOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(ZPutstorageEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(ZPutstorageEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(ZPutstorageEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ZPutstorageEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{code}",String.valueOf(t.getCode()));
 		sql  = sql.replace("#{make_date}",String.valueOf(t.getMakeDate()));
 		sql  = sql.replace("#{make_people}",String.valueOf(t.getMakePeople()));
 		sql  = sql.replace("#{check_people}",String.valueOf(t.getCheckPeople()));
 		sql  = sql.replace("#{check_date}",String.valueOf(t.getCheckDate()));
 		sql  = sql.replace("#{note}",String.valueOf(t.getNote()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}