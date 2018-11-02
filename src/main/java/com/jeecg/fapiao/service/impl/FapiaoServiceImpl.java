package com.jeecg.fapiao.service.impl;
import com.jeecg.fapiao.service.FapiaoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.fapiao.entity.FapiaoEntity;
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

@Service("fapiaoService")
@Transactional
public class FapiaoServiceImpl extends CommonServiceImpl implements FapiaoServiceI {

	
 	public void delete(FapiaoEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(FapiaoEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(FapiaoEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(FapiaoEntity t) throws Exception{
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
	private void doUpdateBus(FapiaoEntity t) throws Exception{
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
	private void doDelBus(FapiaoEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(FapiaoEntity t){
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
		map.put("fsettle", t.getFsettle());
		map.put("ftaitou", t.getFtaitou());
		map.put("fqfdate", t.getFqfdate());
		map.put("fshuihao", t.getFshuihao());
		map.put("fvoid", t.getFvoid());
		map.put("fvoidman", t.getFvoidman());
		map.put("fvoidtime", t.getFvoidtime());
		map.put("flock", t.getFlock());
		map.put("fxydate", t.getFxydate());
		map.put("fbibie", t.getFbibie());
		map.put("fweituo", t.getFweituo());
		map.put("famount", t.getFamount());
		map.put("factualamount", t.getFactualamount());
		map.put("fputout", t.getFputout());
		map.put("flockman", t.getFlockman());
		map.put("flocktime", t.getFlocktime());
		map.put("flydate", t.getFlydate());
		map.put("fcankao", t.getFcankao());
		map.put("fwtunit", t.getFwtunit());
		map.put("fcheck", t.getFcheck());
		map.put("ftidan", t.getFtidan());
		map.put("fred", t.getFred());
		map.put("frednote", t.getFrednote());
		map.put("ffujia", t.getFfujia());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,FapiaoEntity t){
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
 		sql  = sql.replace("#{fsettle}",String.valueOf(t.getFsettle()));
 		sql  = sql.replace("#{ftaitou}",String.valueOf(t.getFtaitou()));
 		sql  = sql.replace("#{fqfdate}",String.valueOf(t.getFqfdate()));
 		sql  = sql.replace("#{fshuihao}",String.valueOf(t.getFshuihao()));
 		sql  = sql.replace("#{fvoid}",String.valueOf(t.getFvoid()));
 		sql  = sql.replace("#{fvoidman}",String.valueOf(t.getFvoidman()));
 		sql  = sql.replace("#{fvoidtime}",String.valueOf(t.getFvoidtime()));
 		sql  = sql.replace("#{flock}",String.valueOf(t.getFlock()));
 		sql  = sql.replace("#{fxydate}",String.valueOf(t.getFxydate()));
 		sql  = sql.replace("#{fbibie}",String.valueOf(t.getFbibie()));
 		sql  = sql.replace("#{fweituo}",String.valueOf(t.getFweituo()));
 		sql  = sql.replace("#{famount}",String.valueOf(t.getFamount()));
 		sql  = sql.replace("#{factualamount}",String.valueOf(t.getFactualamount()));
 		sql  = sql.replace("#{fputout}",String.valueOf(t.getFputout()));
 		sql  = sql.replace("#{flockman}",String.valueOf(t.getFlockman()));
 		sql  = sql.replace("#{flocktime}",String.valueOf(t.getFlocktime()));
 		sql  = sql.replace("#{flydate}",String.valueOf(t.getFlydate()));
 		sql  = sql.replace("#{fcankao}",String.valueOf(t.getFcankao()));
 		sql  = sql.replace("#{fwtunit}",String.valueOf(t.getFwtunit()));
 		sql  = sql.replace("#{fcheck}",String.valueOf(t.getFcheck()));
 		sql  = sql.replace("#{ftidan}",String.valueOf(t.getFtidan()));
 		sql  = sql.replace("#{fred}",String.valueOf(t.getFred()));
 		sql  = sql.replace("#{frednote}",String.valueOf(t.getFrednote()));
 		sql  = sql.replace("#{ffujia}",String.valueOf(t.getFfujia()));
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
					javaInter.execute("z_fapiao",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}