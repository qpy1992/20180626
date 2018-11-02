package com.jeecg.customentrust.service.impl;
import com.jeecg.charge.entity.ChargeEntity;
import com.jeecg.contianer.entity.ContianerEntity;
import com.jeecg.customentrust.service.CustomEntrustServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.customentrust.entity.CustomEntrustEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("customEntrustService")
@Transactional
public class CustomEntrustServiceImpl extends CommonServiceImpl implements CustomEntrustServiceI {

	
 	public void delete(CustomEntrustEntity entity) throws Exception{
        List<ContianerEntity> contianerList = this.findByProperty(ContianerEntity.class,"fid",entity.getId());
        List<ChargeEntity> chargeList = this.findByProperty(ChargeEntity.class,"fid",entity.getId());
        super.delete(entity);
        this.deleteAllEntitie(contianerList);
        this.deleteAllEntitie(chargeList);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(CustomEntrustEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(CustomEntrustEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(CustomEntrustEntity t) throws Exception{
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
	private void doUpdateBus(CustomEntrustEntity t) throws Exception{
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
	private void doDelBus(CustomEntrustEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(CustomEntrustEntity t){
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
		map.put("fentrust_unit", t.getFentrustUnit());
		map.put("foperate_time", t.getFoperateTime());
		map.put("fcontact", t.getFcontact());
		map.put("fphone", t.getFphone());
		map.put("fmobile", t.getFmobile());
		map.put("fax", t.getFax());
		map.put("fsalesman", t.getFsalesman());
		map.put("fbox_type", t.getFboxType());
		map.put("fbuss_type", t.getFbussType());
		map.put("fload_port", t.getFloadPort());
		map.put("fcontractno", t.getFcontractno());
		map.put("ftrans_type", t.getFtransType());
		map.put("fcus_code", t.getFcusCode());
		map.put("ftransport", t.getFtransport());
		map.put("fshipname", t.getFshipname());
		map.put("fvoyageno", t.getFvoyageno());
		map.put("fblno", t.getFblno());
		map.put("ftargetport", t.getFtargetport());
		map.put("fnote", t.getFnote());
		map.put("fkinds", t.getFkinds());
		map.put("fshipcompany", t.getFshipcompany());
		map.put("fantibox", t.getFantibox());
		map.put("fzytime", t.getFzytime());
		map.put("farrivetime", t.getFarrivetime());
		map.put("fcuttime", t.getFcuttime());
		map.put("fseprano", t.getFseprano());
		map.put("fname", t.getFname());
		map.put("fqty", t.getFqty());
		map.put("fweight", t.getFweight());
		map.put("fvolume", t.getFvolume());
		map.put("ftxyard", t.getFtxyard());
		map.put("fhxyard", t.getFhxyard());
		map.put("fgoodsprop", t.getFgoodsprop());
		map.put("fzgaddress", t.getFzgaddress());
		map.put("fzgcontact", t.getFzgcontact());
		map.put("fzgphone", t.getFzgphone());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,CustomEntrustEntity t){
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
 		sql  = sql.replace("#{fentrust_unit}",String.valueOf(t.getFentrustUnit()));
 		sql  = sql.replace("#{foperate_time}",String.valueOf(t.getFoperateTime()));
 		sql  = sql.replace("#{fcontact}",String.valueOf(t.getFcontact()));
 		sql  = sql.replace("#{fphone}",String.valueOf(t.getFphone()));
 		sql  = sql.replace("#{fmobile}",String.valueOf(t.getFmobile()));
 		sql  = sql.replace("#{fax}",String.valueOf(t.getFax()));
 		sql  = sql.replace("#{fsalesman}",String.valueOf(t.getFsalesman()));
 		sql  = sql.replace("#{fbox_type}",String.valueOf(t.getFboxType()));
 		sql  = sql.replace("#{fbuss_type}",String.valueOf(t.getFbussType()));
 		sql  = sql.replace("#{fload_port}",String.valueOf(t.getFloadPort()));
 		sql  = sql.replace("#{fcontractno}",String.valueOf(t.getFcontractno()));
 		sql  = sql.replace("#{ftrans_type}",String.valueOf(t.getFtransType()));
 		sql  = sql.replace("#{fcus_code}",String.valueOf(t.getFcusCode()));
 		sql  = sql.replace("#{ftransport}",String.valueOf(t.getFtransport()));
 		sql  = sql.replace("#{fshipname}",String.valueOf(t.getFshipname()));
 		sql  = sql.replace("#{fvoyageno}",String.valueOf(t.getFvoyageno()));
 		sql  = sql.replace("#{fblno}",String.valueOf(t.getFblno()));
 		sql  = sql.replace("#{ftargetport}",String.valueOf(t.getFtargetport()));
 		sql  = sql.replace("#{fnote}",String.valueOf(t.getFnote()));
 		sql  = sql.replace("#{fkinds}",String.valueOf(t.getFkinds()));
 		sql  = sql.replace("#{fshipcompany}",String.valueOf(t.getFshipcompany()));
 		sql  = sql.replace("#{fantibox}",String.valueOf(t.getFantibox()));
 		sql  = sql.replace("#{fzytime}",String.valueOf(t.getFzytime()));
 		sql  = sql.replace("#{farrivetime}",String.valueOf(t.getFarrivetime()));
 		sql  = sql.replace("#{fcuttime}",String.valueOf(t.getFcuttime()));
 		sql  = sql.replace("#{fseprano}",String.valueOf(t.getFseprano()));
 		sql  = sql.replace("#{fname}",String.valueOf(t.getFname()));
 		sql  = sql.replace("#{fqty}",String.valueOf(t.getFqty()));
 		sql  = sql.replace("#{fweight}",String.valueOf(t.getFweight()));
 		sql  = sql.replace("#{fvolume}",String.valueOf(t.getFvolume()));
 		sql  = sql.replace("#{ftxyard}",String.valueOf(t.getFtxyard()));
 		sql  = sql.replace("#{fhxyard}",String.valueOf(t.getFhxyard()));
 		sql  = sql.replace("#{fgoodsprop}",String.valueOf(t.getFgoodsprop()));
 		sql  = sql.replace("#{fzgaddress}",String.valueOf(t.getFzgaddress()));
 		sql  = sql.replace("#{fzgcontact}",String.valueOf(t.getFzgcontact()));
 		sql  = sql.replace("#{fzgphone}",String.valueOf(t.getFzgphone()));
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
					javaInter.execute("z_custom_entrust",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}