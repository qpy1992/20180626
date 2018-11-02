package com.jeecg.insurance.service.impl;
import com.jeecg.insurance.service.InsuranceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.insurance.entity.InsuranceEntity;
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

@Service("insuranceService")
@Transactional
public class InsuranceServiceImpl extends CommonServiceImpl implements InsuranceServiceI {

	
 	public void delete(InsuranceEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(InsuranceEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(InsuranceEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(InsuranceEntity t) throws Exception{
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
	private void doUpdateBus(InsuranceEntity t) throws Exception{
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
	private void doDelBus(InsuranceEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(InsuranceEntity t){
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
		map.put("fbillno", t.getFbillno());
		map.put("fseat", t.getFseat());
		map.put("fcar_insu", t.getFcarInsu());
		map.put("fstrong_insu", t.getFstrongInsu());
		map.put("fdiscount", t.getFdiscount());
		map.put("fstrongno", t.getFstrongno());
		map.put("fstartdate", t.getFstartdate());
		map.put("fenddate", t.getFenddate());
		map.put("ftransrisk", t.getFtransrisk());
		map.put("ftransdiscount", t.getFtransdiscount());
		map.put("ftransno", t.getFtransno());
		map.put("fstart2", t.getFstart2());
		map.put("fend2", t.getFend2());
		map.put("fsan", t.getFsan());
		map.put("fchesun", t.getFchesun());
		map.put("fboli", t.getFboli());
		map.put("fmianpei", t.getFmianpei());
		map.put("fbussdiscount", t.getFbussdiscount());
		map.put("fbussno", t.getFbussno());
		map.put("fstart3", t.getFstart3());
		map.put("fend3", t.getFend3());
		map.put("ftotal", t.getFtotal());
		map.put("fchengbao", t.getFchengbao());
		map.put("fnote", t.getFnote());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,InsuranceEntity t){
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
 		sql  = sql.replace("#{fseat}",String.valueOf(t.getFseat()));
 		sql  = sql.replace("#{fcar_insu}",String.valueOf(t.getFcarInsu()));
 		sql  = sql.replace("#{fstrong_insu}",String.valueOf(t.getFstrongInsu()));
 		sql  = sql.replace("#{fdiscount}",String.valueOf(t.getFdiscount()));
 		sql  = sql.replace("#{fstrongno}",String.valueOf(t.getFstrongno()));
 		sql  = sql.replace("#{fstartdate}",String.valueOf(t.getFstartdate()));
 		sql  = sql.replace("#{fenddate}",String.valueOf(t.getFenddate()));
 		sql  = sql.replace("#{ftransrisk}",String.valueOf(t.getFtransrisk()));
 		sql  = sql.replace("#{ftransdiscount}",String.valueOf(t.getFtransdiscount()));
 		sql  = sql.replace("#{ftransno}",String.valueOf(t.getFtransno()));
 		sql  = sql.replace("#{fstart2}",String.valueOf(t.getFstart2()));
 		sql  = sql.replace("#{fend2}",String.valueOf(t.getFend2()));
 		sql  = sql.replace("#{fsan}",String.valueOf(t.getFsan()));
 		sql  = sql.replace("#{fchesun}",String.valueOf(t.getFchesun()));
 		sql  = sql.replace("#{fboli}",String.valueOf(t.getFboli()));
 		sql  = sql.replace("#{fmianpei}",String.valueOf(t.getFmianpei()));
 		sql  = sql.replace("#{fbussdiscount}",String.valueOf(t.getFbussdiscount()));
 		sql  = sql.replace("#{fbussno}",String.valueOf(t.getFbussno()));
 		sql  = sql.replace("#{fstart3}",String.valueOf(t.getFstart3()));
 		sql  = sql.replace("#{fend3}",String.valueOf(t.getFend3()));
 		sql  = sql.replace("#{ftotal}",String.valueOf(t.getFtotal()));
 		sql  = sql.replace("#{fchengbao}",String.valueOf(t.getFchengbao()));
 		sql  = sql.replace("#{fnote}",String.valueOf(t.getFnote()));
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
					javaInter.execute("z_insurance",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}