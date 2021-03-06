package com.jeecg.charge.service.impl;
import com.jeecg.charge.service.ChargeServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.charge.entity.ChargeEntity;
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

@Service("chargeService")
@Transactional
public class ChargeServiceImpl extends CommonServiceImpl implements ChargeServiceI {

	
 	public void delete(ChargeEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(ChargeEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(ChargeEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(ChargeEntity t) throws Exception{
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
	private void doUpdateBus(ChargeEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(ChargeEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(ChargeEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_by", t.getCreateBy());
		map.put("update_by", t.getUpdateBy());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("bpm_status", t.getBpmStatus());
		map.put("fcheck", t.getFcheck());
		map.put("fchecker", t.getFchecker());
		map.put("fshoufu", t.getFshoufu());
		map.put("fcost", t.getFcost());
		map.put("fcostname", t.getFcostname());
		map.put("fsettle", t.getFsettle());
		map.put("fsettlename", t.getFsettlename());
		map.put("funit", t.getFunit());
		map.put("fprice", t.getFprice());
		map.put("fbibie", t.getFbibie());
		map.put("fhuilv", t.getFhuilv());
		map.put("fqty", t.getFqty());
		map.put("famount", t.getFamount());
		map.put("fsfamount", t.getFsfamount());
		map.put("fbwamount", t.getFbwamount());
		map.put("fdd", t.getFdd());
		map.put("create_name", t.getCreateName());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_date", t.getUpdateDate());
		map.put("fid", t.getFid());
		map.put("forigin", t.getForigin());
		map.put("fkp", t.getFkp());
		map.put("fykamount", t.getFykamount());
		map.put("fbx", t.getFbx());
		map.put("fdz", t.getFdz());
		map.put("fhx", t.getFhx());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,ChargeEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{bpm_status}",String.valueOf(t.getBpmStatus()));
 		sql  = sql.replace("#{fcheck}",String.valueOf(t.getFcheck()));
 		sql  = sql.replace("#{fchecker}",String.valueOf(t.getFchecker()));
 		sql  = sql.replace("#{fshoufu}",String.valueOf(t.getFshoufu()));
 		sql  = sql.replace("#{fcost}",String.valueOf(t.getFcost()));
 		sql  = sql.replace("#{fcostname}",String.valueOf(t.getFcostname()));
 		sql  = sql.replace("#{fsettle}",String.valueOf(t.getFsettle()));
 		sql  = sql.replace("#{fsettlename}",String.valueOf(t.getFsettlename()));
 		sql  = sql.replace("#{funit}",String.valueOf(t.getFunit()));
 		sql  = sql.replace("#{fprice}",String.valueOf(t.getFprice()));
 		sql  = sql.replace("#{fbibie}",String.valueOf(t.getFbibie()));
 		sql  = sql.replace("#{fhuilv}",String.valueOf(t.getFhuilv()));
 		sql  = sql.replace("#{fqty}",String.valueOf(t.getFqty()));
 		sql  = sql.replace("#{famount}",String.valueOf(t.getFamount()));
 		sql  = sql.replace("#{fsfamount}",String.valueOf(t.getFsfamount()));
 		sql  = sql.replace("#{fbwamount}",String.valueOf(t.getFbwamount()));
 		sql  = sql.replace("#{fdd}",String.valueOf(t.getFdd()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{fid}",String.valueOf(t.getFid()));
 		sql  = sql.replace("#{forigin}",String.valueOf(t.getForigin()));
 		sql  = sql.replace("#{fkp}",String.valueOf(t.getFkp()));
 		sql  = sql.replace("#{fykamount}",String.valueOf(t.getFykamount()));
 		sql  = sql.replace("#{fbx}",String.valueOf(t.getFbx()));
 		sql  = sql.replace("#{fdz}",String.valueOf(t.getFdz()));
 		sql  = sql.replace("#{fhx}",String.valueOf(t.getFhx()));
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
					javaInter.execute("z_charge",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}