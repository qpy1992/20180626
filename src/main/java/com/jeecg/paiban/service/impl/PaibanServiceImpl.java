package com.jeecg.paiban.service.impl;
import com.jeecg.paiban.service.PaibanServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.paiban.entity.PaibanEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("paibanService")
@Transactional
public class PaibanServiceImpl extends CommonServiceImpl implements PaibanServiceI {

	
 	public void delete(PaibanEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(PaibanEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(PaibanEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(PaibanEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(PaibanEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param t
	 * @return
	 */
	private void doDelBus(PaibanEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(PaibanEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("update_date", t.getUpdateDate());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("bpm_status", t.getBpmStatus());
		map.put("fcarcode", t.getFcarcode());
		map.put("fcarno", t.getFcarno());
		map.put("foutercar", t.getFoutercar());
		map.put("fdriver", t.getFdriver());
		map.put("fbillno1", t.getFbillno1());
		map.put("faddress1", t.getFaddress1());
		map.put("fback_time1", t.getFbackTime1());
		map.put("fbillno2", t.getFbillno2());
		map.put("faddress2", t.getFaddress2());
		map.put("fback_time2", t.getFbackTime2());
		map.put("fbillno3", t.getFbillno3());
		map.put("faddress3", t.getFaddress3());
		map.put("fback_time3", t.getFbackTime3());
		map.put("fbillno4", t.getFbillno4());
		map.put("faddress4", t.getFaddress4());
		map.put("fback_time4", t.getFbackTime4());
		map.put("fbillno5", t.getFbillno5());
		map.put("faddress5", t.getFaddress5());
		map.put("fback_time5", t.getFbackTime5());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,PaibanEntity t){
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
 		sql  = sql.replace("#{fcarcode}",String.valueOf(t.getFcarcode()));
 		sql  = sql.replace("#{fcarno}",String.valueOf(t.getFcarno()));
 		sql  = sql.replace("#{foutercar}",String.valueOf(t.getFoutercar()));
 		sql  = sql.replace("#{fdriver}",String.valueOf(t.getFdriver()));
 		sql  = sql.replace("#{fbillno1}",String.valueOf(t.getFbillno1()));
 		sql  = sql.replace("#{faddress1}",String.valueOf(t.getFaddress1()));
 		sql  = sql.replace("#{fback_time1}",String.valueOf(t.getFbackTime1()));
 		sql  = sql.replace("#{fbillno2}",String.valueOf(t.getFbillno2()));
 		sql  = sql.replace("#{faddress2}",String.valueOf(t.getFaddress2()));
 		sql  = sql.replace("#{fback_time2}",String.valueOf(t.getFbackTime2()));
 		sql  = sql.replace("#{fbillno3}",String.valueOf(t.getFbillno3()));
 		sql  = sql.replace("#{faddress3}",String.valueOf(t.getFaddress3()));
 		sql  = sql.replace("#{fback_time3}",String.valueOf(t.getFbackTime3()));
 		sql  = sql.replace("#{fbillno4}",String.valueOf(t.getFbillno4()));
 		sql  = sql.replace("#{faddress4}",String.valueOf(t.getFaddress4()));
 		sql  = sql.replace("#{fback_time4}",String.valueOf(t.getFbackTime4()));
 		sql  = sql.replace("#{fbillno5}",String.valueOf(t.getFbillno5()));
 		sql  = sql.replace("#{faddress5}",String.valueOf(t.getFaddress5()));
 		sql  = sql.replace("#{fback_time5}",String.valueOf(t.getFbackTime5()));
 		sql  = sql.replace("#{fdate}",String.valueOf(t.getFdate()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("z_paiban",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}