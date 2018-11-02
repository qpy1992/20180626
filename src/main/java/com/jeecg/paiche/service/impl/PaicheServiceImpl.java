package com.jeecg.paiche.service.impl;
import com.jeecg.charge.entity.ChargeEntity;
import com.jeecg.paiche.service.PaicheServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.paiche.entity.PaicheEntity;
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

@Service("paicheService")
@Transactional
public class PaicheServiceImpl extends CommonServiceImpl implements PaicheServiceI {

	
 	public void delete(PaicheEntity entity) throws Exception{
        List<ChargeEntity> chargeList = this.findByProperty(ChargeEntity.class,"fid",entity.getId());
 		super.delete(entity);
 		this.deleteAllEntitie(chargeList);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(PaicheEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(PaicheEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(PaicheEntity t) throws Exception{
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
	private void doUpdateBus(PaicheEntity t) throws Exception{
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
	private void doDelBus(PaicheEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(PaicheEntity t){
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
		map.put("fcarcode", t.getFcarcode());
		map.put("fcarno", t.getFcarno());
		map.put("ftranstime", t.getFtranstime());
		map.put("ftype", t.getFtype());
		map.put("fbaoxiao", t.getFbaoxiao());
		map.put("fdriver", t.getFdriver());
		map.put("ftype2", t.getFtype2());
		map.put("fdriver2", t.getFdriver2());
		map.put("fstatus", t.getFstatus());
		map.put("fdoorpoint", t.getFdoorpoint());
		map.put("ftranstype", t.getFtranstype());
		map.put("fweight", t.getFweight());
		map.put("fweight2", t.getFweight2());
		map.put("fcccode", t.getFcccode());
		map.put("fjccode", t.getFjccode());
		map.put("fstart", t.getFstart());
		map.put("fend", t.getFend());
		map.put("frequire", t.getFrequire());
		map.put("fluqiao", t.getFluqiao());
		map.put("fdadan", t.getFdadan());
		map.put("fshangxia", t.getFshangxia());
		map.put("ffengzi", t.getFfengzi());
		map.put("fdiaoxiang", t.getFdiaoxiang());
		map.put("fyulu", t.getFyulu());
		map.put("fyouhao", t.getFyouhao());
		map.put("fyoujia", t.getFyoujia());
		map.put("fyoufei", t.getFyoufei());
		map.put("fdriver3", t.getFdriver3());
		map.put("fshinei", t.getFshinei());
		map.put("fdriver4", t.getFdriver4());
		map.put("fhdtime", t.getFhdtime());
		map.put("fshebei", t.getFshebei());
		map.put("fqianshou", t.getFqianshou());
		map.put("fyuluno", t.getFyuluno());
		map.put("fzhaungxiang", t.getFzhaungxiang());
		map.put("fbaika", t.getFbaika());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,PaicheEntity t){
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
 		sql  = sql.replace("#{fcarcode}",String.valueOf(t.getFcarcode()));
 		sql  = sql.replace("#{fcarno}",String.valueOf(t.getFcarno()));
 		sql  = sql.replace("#{ftranstime}",String.valueOf(t.getFtranstime()));
 		sql  = sql.replace("#{ftype}",String.valueOf(t.getFtype()));
 		sql  = sql.replace("#{fbaoxiao}",String.valueOf(t.getFbaoxiao()));
 		sql  = sql.replace("#{fdriver}",String.valueOf(t.getFdriver()));
 		sql  = sql.replace("#{ftype2}",String.valueOf(t.getFtype2()));
 		sql  = sql.replace("#{fdriver2}",String.valueOf(t.getFdriver2()));
 		sql  = sql.replace("#{fstatus}",String.valueOf(t.getFstatus()));
 		sql  = sql.replace("#{fdoorpoint}",String.valueOf(t.getFdoorpoint()));
 		sql  = sql.replace("#{ftranstype}",String.valueOf(t.getFtranstype()));
 		sql  = sql.replace("#{fweight}",String.valueOf(t.getFweight()));
 		sql  = sql.replace("#{fweight2}",String.valueOf(t.getFweight2()));
 		sql  = sql.replace("#{fcccode}",String.valueOf(t.getFcccode()));
 		sql  = sql.replace("#{fjccode}",String.valueOf(t.getFjccode()));
 		sql  = sql.replace("#{fstart}",String.valueOf(t.getFstart()));
 		sql  = sql.replace("#{fend}",String.valueOf(t.getFend()));
 		sql  = sql.replace("#{frequire}",String.valueOf(t.getFrequire()));
 		sql  = sql.replace("#{fluqiao}",String.valueOf(t.getFluqiao()));
 		sql  = sql.replace("#{fdadan}",String.valueOf(t.getFdadan()));
 		sql  = sql.replace("#{fshangxia}",String.valueOf(t.getFshangxia()));
 		sql  = sql.replace("#{ffengzi}",String.valueOf(t.getFfengzi()));
 		sql  = sql.replace("#{fdiaoxiang}",String.valueOf(t.getFdiaoxiang()));
 		sql  = sql.replace("#{fyulu}",String.valueOf(t.getFyulu()));
 		sql  = sql.replace("#{fyouhao}",String.valueOf(t.getFyouhao()));
 		sql  = sql.replace("#{fyoujia}",String.valueOf(t.getFyoujia()));
 		sql  = sql.replace("#{fyoufei}",String.valueOf(t.getFyoufei()));
 		sql  = sql.replace("#{fdriver3}",String.valueOf(t.getFdriver3()));
 		sql  = sql.replace("#{fshinei}",String.valueOf(t.getFshinei()));
 		sql  = sql.replace("#{fdriver4}",String.valueOf(t.getFdriver4()));
 		sql  = sql.replace("#{fhdtime}",String.valueOf(t.getFhdtime()));
 		sql  = sql.replace("#{fshebei}",String.valueOf(t.getFshebei()));
 		sql  = sql.replace("#{fqianshou}",String.valueOf(t.getFqianshou()));
 		sql  = sql.replace("#{fyuluno}",String.valueOf(t.getFyuluno()));
 		sql  = sql.replace("#{fzhaungxiang}",String.valueOf(t.getFzhaungxiang()));
 		sql  = sql.replace("#{fbaika}",String.valueOf(t.getFbaika()));
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
					javaInter.execute("z_paiche",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}