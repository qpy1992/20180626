package com.jeecg.custom.service.impl;
import com.jeecg.custom.service.CustomServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.custom.entity.CustomEntity;
import com.jeecg.cuscontact.entity.CustomContactsEntity;
import com.jeecg.cussales.entity.CustomSalesmanEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.UUID;


@Service("customService")
@Transactional
public class CustomServiceImpl extends CommonServiceImpl implements CustomServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((CustomEntity)entity);
 	}
	
	public void addMain(CustomEntity custom,
	        List<CustomContactsEntity> customContactsList,List<CustomSalesmanEntity> customSalesmanList){
			//保存主信息
			this.save(custom);
		
			/**保存-联系人*/
			for(CustomContactsEntity customContacts:customContactsList){
				//外键设置
				customContacts.setFid(custom.getId());
				this.save(customContacts);
			}
			/**保存-业务员*/
			for(CustomSalesmanEntity customSalesman:customSalesmanList){
				//外键设置
				customSalesman.setFid(custom.getId());
				this.save(customSalesman);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(custom);
	}

	
	public void updateMain(CustomEntity custom,
	        List<CustomContactsEntity> customContactsList,List<CustomSalesmanEntity> customSalesmanList) {
		//保存主表信息
		if(StringUtil.isNotEmpty(custom.getId())){
			try {
				CustomEntity temp = findUniqueByProperty(CustomEntity.class, "id", custom.getId());
				MyBeanUtils.copyBeanNotNull2Bean(custom, temp);
				this.saveOrUpdate(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(custom);
		}
		//===================================================================================
		//获取参数
		Object id0 = custom.getId();
		Object id1 = custom.getId();
		Object id2 = custom.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-联系人
	    String hql0 = "from CustomContactsEntity where 1 = 1 AND fID = ? ";
	    List<CustomContactsEntity> customContactsOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-联系人
		if(customContactsList!=null&&customContactsList.size()>0){
		for(CustomContactsEntity oldE:customContactsOldList){
			boolean isUpdate = false;
				for(CustomContactsEntity sendE:customContactsList){
					//需要更新的明细数据-联系人
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-联系人
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-联系人
			for(CustomContactsEntity customContacts:customContactsList){
				if(oConvertUtils.isEmpty(customContacts.getId())){
					//外键设置
					customContacts.setFid(custom.getId());
					this.save(customContacts);
				}
			}
		}
		//===================================================================================
		//1.查询出数据库的明细数据-业务员
	    String hql1 = "from CustomSalesmanEntity where 1 = 1 AND fID = ? ";
	    List<CustomSalesmanEntity> customSalesmanOldList = this.findHql(hql1,id1);
		//2.筛选更新明细数据-业务员
		if(customSalesmanList!=null&&customSalesmanList.size()>0){
		for(CustomSalesmanEntity oldE:customSalesmanOldList){
			boolean isUpdate = false;
				for(CustomSalesmanEntity sendE:customSalesmanList){
					//需要更新的明细数据-业务员
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
		    		//如果数据库存在的明细，前台没有传递过来则是删除-业务员
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-业务员
			for(CustomSalesmanEntity customSalesman:customSalesmanList){
				if(oConvertUtils.isEmpty(customSalesman.getId())){
					//外键设置
					customSalesman.setFid(custom.getId());
					this.save(customSalesman);
				}
			}
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(custom);
	}

	
	public void delMain(CustomEntity custom) {
		//删除主表信息
		this.delete(custom);
		//===================================================================================
		//获取参数
		Object id0 = custom.getId();
		Object id1 = custom.getId();
		Object id2 = custom.getId();
		//===================================================================================
		//删除-联系人
	    String hql0 = "from CustomContactsEntity where 1 = 1 AND fID = ? ";
	    List<CustomContactsEntity> customContactsOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(customContactsOldList);
		//===================================================================================
		//删除-业务员
	    String hql1 = "from CustomSalesmanEntity where 1 = 1 AND fID = ? ";
	    List<CustomSalesmanEntity> customSalesmanOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(customSalesmanOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param t
	 * @return
	 */
 	public boolean doAddSql(CustomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param t
	 * @return
	 */
 	public boolean doUpdateSql(CustomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param t
	 * @return
	 */
 	public boolean doDelSql(CustomEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,CustomEntity t){
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
 		sql  = sql.replace("#{fcompany_type}",String.valueOf(t.getFcompanyType()));
 		sql  = sql.replace("#{fcustom_code}",String.valueOf(t.getFcustomCode()));
 		sql  = sql.replace("#{fabbr}",String.valueOf(t.getFabbr()));
 		sql  = sql.replace("#{fduty_para}",String.valueOf(t.getFdutyPara()));
 		sql  = sql.replace("#{fcn_name}",String.valueOf(t.getFcnName()));
 		sql  = sql.replace("#{fen_name}",String.valueOf(t.getFenName()));
 		sql  = sql.replace("#{finance_code}",String.valueOf(t.getFinanceCode()));
 		sql  = sql.replace("#{fcredit_rate}",String.valueOf(t.getFcreditRate()));
 		sql  = sql.replace("#{fcontract_start}",String.valueOf(t.getFcontractStart()));
 		sql  = sql.replace("#{fcontract_end}",String.valueOf(t.getFcontractEnd()));
 		sql  = sql.replace("#{fproject_team}",String.valueOf(t.getFprojectTeam()));
 		sql  = sql.replace("#{fcountry}",String.valueOf(t.getFcountry()));
 		sql  = sql.replace("#{faddress}",String.valueOf(t.getFaddress()));
 		sql  = sql.replace("#{fzipcode}",String.valueOf(t.getFzipcode()));
 		sql  = sql.replace("#{fmobile}",String.valueOf(t.getFmobile()));
 		sql  = sql.replace("#{fax}",String.valueOf(t.getFax()));
 		sql  = sql.replace("#{fkeyword}",String.valueOf(t.getFkeyword()));
 		sql  = sql.replace("#{fcompany_website}",String.valueOf(t.getFcompanyWebsite()));
 		sql  = sql.replace("#{femail}",String.valueOf(t.getFemail()));
 		sql  = sql.replace("#{fticket_rate}",String.valueOf(t.getFticketRate()));
 		sql  = sql.replace("#{finstruction}",String.valueOf(t.getFinstruction()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}