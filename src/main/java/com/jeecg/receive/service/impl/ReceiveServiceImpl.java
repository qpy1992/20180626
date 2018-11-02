package com.jeecg.receive.service.impl;
import com.jeecg.receive.service.ReceiveServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.receive.entity.ReceiveEntity;
import com.jeecg.zhangdan1.entity.Zhangdan1Entity;

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


@Service("receiveService")
@Transactional
public class ReceiveServiceImpl extends CommonServiceImpl implements ReceiveServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ReceiveEntity)entity);
 	}
	
	public void addMain(ReceiveEntity receive,
	        List<Zhangdan1Entity> zhangdan1List){
			//保存主信息
			this.save(receive);
		
			/**保存-应收账单明细*/
			for(Zhangdan1Entity zhangdan1:zhangdan1List){
				//外键设置
				zhangdan1.setFid(receive.getId());
				this.save(zhangdan1);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(receive);
	}

	
	public void updateMain(ReceiveEntity receive,
	        List<Zhangdan1Entity> zhangdan1List) {
		//保存主表信息
		if(StringUtil.isNotEmpty(receive.getId())){
			try {
				ReceiveEntity temp = findUniqueByProperty(ReceiveEntity.class, "id", receive.getId());
				MyBeanUtils.copyBeanNotNull2Bean(receive, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(receive);
		}
		//===================================================================================
		//获取参数
		Object id0 = receive.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-应收账单明细
	    String hql0 = "from Zhangdan1Entity where 1 = 1 AND fID = ? ";
	    List<Zhangdan1Entity> zhangdan1OldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-应收账单明细
		if(zhangdan1List!=null&&zhangdan1List.size()>0){
		for(Zhangdan1Entity oldE:zhangdan1OldList){
			boolean isUpdate = false;
				for(Zhangdan1Entity sendE:zhangdan1List){
					//需要更新的明细数据-应收账单明细
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-应收账单明细
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-应收账单明细
			for(Zhangdan1Entity zhangdan1:zhangdan1List){
				if(oConvertUtils.isEmpty(zhangdan1.getId())){
					//外键设置
					zhangdan1.setFid(receive.getId());
					this.save(zhangdan1);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(receive);
	}

	
	public void delMain(ReceiveEntity receive) {
		//删除主表信息
		this.delete(receive);
		//===================================================================================
		//获取参数
		Object id0 = receive.getId();
		//===================================================================================
		//删除-应收账单明细
	    String hql0 = "from Zhangdan1Entity where 1 = 1 AND fID = ? ";
	    List<Zhangdan1Entity> zhangdan1OldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(zhangdan1OldList);
		for(Zhangdan1Entity zhangdan1:zhangdan1OldList){
			this.executeSql("update z_charge set fdz='N' where id ='"+zhangdan1.getCostid()+"'");
		}
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param t
	 * @return
	 */
 	public boolean doAddSql(ReceiveEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param t
	 * @return
	 */
 	public boolean doUpdateSql(ReceiveEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param t
	 * @return
	 */
 	public boolean doDelSql(ReceiveEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ReceiveEntity t){
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
 		sql  = sql.replace("#{funit}",String.valueOf(t.getFunit()));
 		sql  = sql.replace("#{fbibie}",String.valueOf(t.getFbibie()));
 		sql  = sql.replace("#{famount}",String.valueOf(t.getFamount()));
 		sql  = sql.replace("#{fnote}",String.valueOf(t.getFnote()));
 		sql  = sql.replace("#{fstartdate}",String.valueOf(t.getFstartdate()));
 		sql  = sql.replace("#{fenddate}",String.valueOf(t.getFenddate()));
 		sql  = sql.replace("#{frange}",String.valueOf(t.getFrange()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}