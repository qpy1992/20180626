package com.jeecg.pay.service.impl;
import com.jeecg.pay.service.PayServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.pay.entity.PayEntity;
import com.jeecg.zhangdan.entity.ZhangdanEntity;

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


@Service("payService")
@Transactional
public class PayServiceImpl extends CommonServiceImpl implements PayServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((PayEntity)entity);
 	}
	
	public void addMain(PayEntity pay,
	        List<ZhangdanEntity> zhangdanList){
			//保存主信息
			this.save(pay);
		
			/**保存-应付账单明细*/
			for(ZhangdanEntity zhangdan:zhangdanList){
				//外键设置
				zhangdan.setFid(pay.getId());
				this.save(zhangdan);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(pay);
	}

	
	public void updateMain(PayEntity pay,
	        List<ZhangdanEntity> zhangdanList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(pay.getId())){
			try {
				PayEntity temp = findUniqueByProperty(PayEntity.class, "id", pay.getId());
				MyBeanUtils.copyBeanNotNull2Bean(pay, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(pay);
		}
		//===================================================================================
		//获取参数
		Object id0 = pay.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-应付账单明细
	    String hql0 = "from ZhangdanEntity where 1 = 1 AND fID = ? ";
	    List<ZhangdanEntity> zhangdanOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-应付账单明细
		if(zhangdanList!=null&&zhangdanList.size()>0){
		for(ZhangdanEntity oldE:zhangdanOldList){
			boolean isUpdate = false;
				for(ZhangdanEntity sendE:zhangdanList){
					//需要更新的明细数据-应付账单明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-应付账单明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-应付账单明细
			for(ZhangdanEntity zhangdan:zhangdanList){
				if(oConvertUtils.isEmpty(zhangdan.getId())){
					//外键设置
					zhangdan.setFid(pay.getId());
					this.save(zhangdan);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(pay);
	}

	
	public void delMain(PayEntity pay) {
		//删除主表信息
		this.delete(pay);
		//===================================================================================
		//获取参数
		Object id0 = pay.getId();
		//===================================================================================
		//删除-应付账单明细
	    String hql0 = "from ZhangdanEntity where 1 = 1 AND fID = ? ";
	    List<ZhangdanEntity> zhangdanOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(zhangdanOldList);
		for(ZhangdanEntity zhangdan:zhangdanOldList){
			this.executeSql("update z_charge set fdz='N' where id ='"+zhangdan.getCostid()+"'");
		}
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param t
	 * @return
	 */
 	public boolean doAddSql(PayEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param t
	 * @return
	 */
 	public boolean doUpdateSql(PayEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param t
	 * @return
	 */
 	public boolean doDelSql(PayEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,PayEntity t){
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
 		sql  = sql.replace("#{funitcode}",String.valueOf(t.getFunitcode()));
 		sql  = sql.replace("#{fbibie}",String.valueOf(t.getFbibie()));
 		sql  = sql.replace("#{famount}",String.valueOf(t.getFamount()));
 		sql  = sql.replace("#{fnote}",String.valueOf(t.getFnote()));
 		sql  = sql.replace("#{fstartdate}",String.valueOf(t.getFstartdate()));
 		sql  = sql.replace("#{fenddate}",String.valueOf(t.getFenddate()));
 		sql  = sql.replace("#{frange}",String.valueOf(t.getFrange()));
 		sql  = sql.replace("#{funit}",String.valueOf(t.getFunit()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}