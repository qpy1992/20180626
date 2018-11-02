package com.jeecg.siji.service.impl;
import com.jeecg.siji.service.SijiServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.siji.entity.SijiEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
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

@Service("sijiService")
@Transactional
public class SijiServiceImpl extends CommonServiceImpl implements SijiServiceI {
	@Autowired
	private SystemService systemService;
	
 	public void delete(SijiEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(SijiEntity entity) throws Exception{
 		entity.setFcode(systemService.getFcode(23));
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(SijiEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(SijiEntity t) throws Exception{
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
	private void doUpdateBus(SijiEntity t) throws Exception{
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
	private void doDelBus(SijiEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(SijiEntity t){
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
		map.put("fname", t.getFname());
		map.put("fsex", t.getFsex());
		map.put("fregion", t.getFregion());
		map.put("fbirthday", t.getFbirthday());
		map.put("faddress", t.getFaddress());
		map.put("fidnum", t.getFidnum());
		map.put("fjiguan", t.getFjiguan());
		map.put("fqixian1", t.getFqixian1());
		map.put("fqixian2", t.getFqixian2());
		map.put("fcongye", t.getFcongye());
		map.put("fcytype", t.getFcytype());
		map.put("fazhengtime", t.getFazhengtime());
		map.put("fazheng", t.getFazheng());
		map.put("fyouxiao", t.getFyouxiao());
		map.put("fjiashi", t.getFjiashi());
		map.put("fchuci", t.getFchuci());
		map.put("fzhunjia", t.getFzhunjia());
		map.put("fyouxiao1", t.getFyouxiao1());
		map.put("fyxqixian", t.getFyxqixian());
		map.put("fdangan", t.getFdangan());
		map.put("frecord", t.getFrecord());
		map.put("fcode", t.getFcode());
		map.put("fruzhi", t.getFruzhi());
		map.put("flizhi", t.getFlizhi());
		map.put("fmobile", t.getFmobile());
		map.put("femergen", t.getFemergen());
		map.put("femobile", t.getFemobile());
		map.put("fjsz", t.getFjsz());
		map.put("fsfz", t.getFsfz());
		map.put("fsgz", t.getFsgz());
		map.put("ftjbg", t.getFtjbg());
		map.put("fpxzs", t.getFpxzs());
		map.put("fywx", t.getFywx());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,SijiEntity t){
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
 		sql  = sql.replace("#{fname}",String.valueOf(t.getFname()));
 		sql  = sql.replace("#{fsex}",String.valueOf(t.getFsex()));
 		sql  = sql.replace("#{fregion}",String.valueOf(t.getFregion()));
 		sql  = sql.replace("#{fbirthday}",String.valueOf(t.getFbirthday()));
 		sql  = sql.replace("#{faddress}",String.valueOf(t.getFaddress()));
 		sql  = sql.replace("#{fidnum}",String.valueOf(t.getFidnum()));
 		sql  = sql.replace("#{fjiguan}",String.valueOf(t.getFjiguan()));
 		sql  = sql.replace("#{fqixian1}",String.valueOf(t.getFqixian1()));
 		sql  = sql.replace("#{fqixian2}",String.valueOf(t.getFqixian2()));
 		sql  = sql.replace("#{fcongye}",String.valueOf(t.getFcongye()));
 		sql  = sql.replace("#{fcytype}",String.valueOf(t.getFcytype()));
 		sql  = sql.replace("#{fazhengtime}",String.valueOf(t.getFazhengtime()));
 		sql  = sql.replace("#{fazheng}",String.valueOf(t.getFazheng()));
 		sql  = sql.replace("#{fyouxiao}",String.valueOf(t.getFyouxiao()));
 		sql  = sql.replace("#{fjiashi}",String.valueOf(t.getFjiashi()));
 		sql  = sql.replace("#{fchuci}",String.valueOf(t.getFchuci()));
 		sql  = sql.replace("#{fzhunjia}",String.valueOf(t.getFzhunjia()));
 		sql  = sql.replace("#{fyouxiao1}",String.valueOf(t.getFyouxiao1()));
 		sql  = sql.replace("#{fyxqixian}",String.valueOf(t.getFyxqixian()));
 		sql  = sql.replace("#{fdangan}",String.valueOf(t.getFdangan()));
 		sql  = sql.replace("#{frecord}",String.valueOf(t.getFrecord()));
 		sql  = sql.replace("#{fcode}",String.valueOf(t.getFcode()));
 		sql  = sql.replace("#{fruzhi}",String.valueOf(t.getFruzhi()));
 		sql  = sql.replace("#{flizhi}",String.valueOf(t.getFlizhi()));
 		sql  = sql.replace("#{fmobile}",String.valueOf(t.getFmobile()));
 		sql  = sql.replace("#{femergen}",String.valueOf(t.getFemergen()));
 		sql  = sql.replace("#{femobile}",String.valueOf(t.getFemobile()));
 		sql  = sql.replace("#{fjsz}",String.valueOf(t.getFjsz()));
 		sql  = sql.replace("#{fsfz}",String.valueOf(t.getFsfz()));
 		sql  = sql.replace("#{fsgz}",String.valueOf(t.getFsgz()));
 		sql  = sql.replace("#{ftjbg}",String.valueOf(t.getFtjbg()));
 		sql  = sql.replace("#{fpxzs}",String.valueOf(t.getFpxzs()));
 		sql  = sql.replace("#{fywx}",String.valueOf(t.getFywx()));
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
					javaInter.execute("z_siji",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}