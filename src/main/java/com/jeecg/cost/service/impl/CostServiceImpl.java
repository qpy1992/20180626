package com.jeecg.cost.service.impl;
import com.jeecg.cost.service.CostServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.cost.entity.CostEntity;
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

@Service("costService")
@Transactional
public class CostServiceImpl extends CommonServiceImpl implements CostServiceI {

	
 	public void delete(CostEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(CostEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(CostEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(CostEntity t) throws Exception{
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
	private void doUpdateBus(CostEntity t) throws Exception{
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
	private void doDelBus(CostEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(CostEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("fcheck", t.getFcheck());
		map.put("frece_pay", t.getFrecePay());
		map.put("fcost_type", t.getFcostType());
		map.put("fsettle_unit", t.getFsettleUnit());
		map.put("funit", t.getFunit());
		map.put("fprice", t.getFprice());
		map.put("fqty", t.getFqty());
		map.put("frpamount", t.getFrpamount());
		map.put("famount", t.getFamount());
		map.put("frated_amount", t.getFratedAmount());
		map.put("factual_amount", t.getFactualAmount());
		map.put("fcushion", t.getFcushion());
		map.put("fcost_prop", t.getFcostProp());
		map.put("fcus_num", t.getFcusNum());
		map.put("finput_person", t.getFinputPerson());
		map.put("finput_time", t.getFinputTime());
		map.put("fid", t.getFid());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,CostEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{fcheck}",String.valueOf(t.getFcheck()));
 		sql  = sql.replace("#{frece_pay}",String.valueOf(t.getFrecePay()));
 		sql  = sql.replace("#{fcost_type}",String.valueOf(t.getFcostType()));
 		sql  = sql.replace("#{fsettle_unit}",String.valueOf(t.getFsettleUnit()));
 		sql  = sql.replace("#{funit}",String.valueOf(t.getFunit()));
 		sql  = sql.replace("#{fprice}",String.valueOf(t.getFprice()));
 		sql  = sql.replace("#{fqty}",String.valueOf(t.getFqty()));
 		sql  = sql.replace("#{frpamount}",String.valueOf(t.getFrpamount()));
 		sql  = sql.replace("#{famount}",String.valueOf(t.getFamount()));
 		sql  = sql.replace("#{frated_amount}",String.valueOf(t.getFratedAmount()));
 		sql  = sql.replace("#{factual_amount}",String.valueOf(t.getFactualAmount()));
 		sql  = sql.replace("#{fcushion}",String.valueOf(t.getFcushion()));
 		sql  = sql.replace("#{fcost_prop}",String.valueOf(t.getFcostProp()));
 		sql  = sql.replace("#{fcus_num}",String.valueOf(t.getFcusNum()));
 		sql  = sql.replace("#{finput_person}",String.valueOf(t.getFinputPerson()));
 		sql  = sql.replace("#{finput_time}",String.valueOf(t.getFinputTime()));
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
					javaInter.execute("z_cost",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}