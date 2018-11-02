package com.jeecg.weizhang.service.impl;
import com.jeecg.weizhang.service.WeizhangServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.weizhang.entity.WeizhangEntity;
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

@Service("weizhangService")
@Transactional
public class WeizhangServiceImpl extends CommonServiceImpl implements WeizhangServiceI {

	
 	public void delete(WeizhangEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WeizhangEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WeizhangEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WeizhangEntity t) throws Exception{
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
	private void doUpdateBus(WeizhangEntity t) throws Exception{
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
	private void doDelBus(WeizhangEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WeizhangEntity t){
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
		map.put("fchecker", t.getFchecker());
		map.put("fcheck_time", t.getFcheckTime());
		map.put("fwz_time", t.getFwzTime());
		map.put("fcarno", t.getFcarno());
		map.put("fname", t.getFname());
		map.put("fwzaddress", t.getFwzaddress());
		map.put("fbehavior", t.getFbehavior());
		map.put("famount", t.getFamount());
		map.put("fkoufen", t.getFkoufen());
		map.put("ftongbao", t.getFtongbao());
		map.put("fwzqty", t.getFwzqty());
		map.put("fclwztime", t.getFclwztime());
		map.put("fyearqty", t.getFyearqty());
		map.put("fsix", t.getFsix());
		map.put("fchaosu", t.getFchaosu());
		map.put("fyearkf", t.getFyearkf());
		map.put("fyearcs", t.getFyearcs());
		map.put("fyearfifty", t.getFyearfifty());
		map.put("fnote", t.getFnote());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WeizhangEntity t){
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
 		sql  = sql.replace("#{fchecker}",String.valueOf(t.getFchecker()));
 		sql  = sql.replace("#{fcheck_time}",String.valueOf(t.getFcheckTime()));
 		sql  = sql.replace("#{fwz_time}",String.valueOf(t.getFwzTime()));
 		sql  = sql.replace("#{fcarno}",String.valueOf(t.getFcarno()));
 		sql  = sql.replace("#{fname}",String.valueOf(t.getFname()));
 		sql  = sql.replace("#{fwzaddress}",String.valueOf(t.getFwzaddress()));
 		sql  = sql.replace("#{fbehavior}",String.valueOf(t.getFbehavior()));
 		sql  = sql.replace("#{famount}",String.valueOf(t.getFamount()));
 		sql  = sql.replace("#{fkoufen}",String.valueOf(t.getFkoufen()));
 		sql  = sql.replace("#{ftongbao}",String.valueOf(t.getFtongbao()));
 		sql  = sql.replace("#{fwzqty}",String.valueOf(t.getFwzqty()));
 		sql  = sql.replace("#{fclwztime}",String.valueOf(t.getFclwztime()));
 		sql  = sql.replace("#{fyearqty}",String.valueOf(t.getFyearqty()));
 		sql  = sql.replace("#{fsix}",String.valueOf(t.getFsix()));
 		sql  = sql.replace("#{fchaosu}",String.valueOf(t.getFchaosu()));
 		sql  = sql.replace("#{fyearkf}",String.valueOf(t.getFyearkf()));
 		sql  = sql.replace("#{fyearcs}",String.valueOf(t.getFyearcs()));
 		sql  = sql.replace("#{fyearfifty}",String.valueOf(t.getFyearfifty()));
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
					javaInter.execute("z_weizhang",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}