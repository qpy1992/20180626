package com.jeecg.pay.service.impl;
import com.jeecg.pay.service.ZPcPayServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.pay.entity.ZPcPayEntity;
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

@Service("zPcPayService")
@Transactional
public class ZPcPayServiceImpl extends CommonServiceImpl implements ZPcPayServiceI {

	
 	public void delete(ZPcPayEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(ZPcPayEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(ZPcPayEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(ZPcPayEntity t) throws Exception{
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
	private void doUpdateBus(ZPcPayEntity t) throws Exception{
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
	private void doDelBus(ZPcPayEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(ZPcPayEntity t){
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
		map.put("fcheck", t.getFcheck());
		map.put("feetype", t.getFeetype());
		map.put("feename", t.getFeename());
		map.put("fsettle", t.getFsettle());
		map.put("fsettlename", t.getFsettlename());
		map.put("fdriver", t.getFdriver());
		map.put("funit", t.getFunit());
		map.put("funitprice", t.getFunitprice());
		map.put("fqty", t.getFqty());
		map.put("famount", t.getFamount());
		map.put("fentan", t.getFentan());
		map.put("fcarcode", t.getFcarcode());
		map.put("fguache", t.getFguache());
		map.put("fdaidian", t.getFdaidian());
		map.put("fbaoxiao", t.getFbaoxiao());
		map.put("fxianghao", t.getFxianghao());
		map.put("fweitup", t.getFweitup());
		map.put("fcustomno", t.getFcustomno());
		map.put("feding", t.getFeding());
		map.put("fchecker", t.getFchecker());
		map.put("finstruction", t.getFinstruction());
		map.put("fid", t.getFid());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,ZPcPayEntity t){
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
 		sql  = sql.replace("#{fcheck}",String.valueOf(t.getFcheck()));
 		sql  = sql.replace("#{feetype}",String.valueOf(t.getFeetype()));
 		sql  = sql.replace("#{feename}",String.valueOf(t.getFeename()));
 		sql  = sql.replace("#{fsettle}",String.valueOf(t.getFsettle()));
 		sql  = sql.replace("#{fsettlename}",String.valueOf(t.getFsettlename()));
 		sql  = sql.replace("#{fdriver}",String.valueOf(t.getFdriver()));
 		sql  = sql.replace("#{funit}",String.valueOf(t.getFunit()));
 		sql  = sql.replace("#{funitprice}",String.valueOf(t.getFunitprice()));
 		sql  = sql.replace("#{fqty}",String.valueOf(t.getFqty()));
 		sql  = sql.replace("#{famount}",String.valueOf(t.getFamount()));
 		sql  = sql.replace("#{fentan}",String.valueOf(t.getFentan()));
 		sql  = sql.replace("#{fcarcode}",String.valueOf(t.getFcarcode()));
 		sql  = sql.replace("#{fguache}",String.valueOf(t.getFguache()));
 		sql  = sql.replace("#{fdaidian}",String.valueOf(t.getFdaidian()));
 		sql  = sql.replace("#{fbaoxiao}",String.valueOf(t.getFbaoxiao()));
 		sql  = sql.replace("#{fxianghao}",String.valueOf(t.getFxianghao()));
 		sql  = sql.replace("#{fweitup}",String.valueOf(t.getFweitup()));
 		sql  = sql.replace("#{fcustomno}",String.valueOf(t.getFcustomno()));
 		sql  = sql.replace("#{feding}",String.valueOf(t.getFeding()));
 		sql  = sql.replace("#{fchecker}",String.valueOf(t.getFchecker()));
 		sql  = sql.replace("#{finstruction}",String.valueOf(t.getFinstruction()));
 		sql  = sql.replace("#{fid}",String.valueOf(t.getFid()));
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
					javaInter.execute("z_pc_pay",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}