package com.jeecg.item.service.impl;
import com.jeecg.item.service.ItemServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.item.entity.ItemEntity;
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

@Service("itemService")
@Transactional
public class ItemServiceImpl extends CommonServiceImpl implements ItemServiceI {

	
 	public void delete(ItemEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(ItemEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(ItemEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(ItemEntity t) throws Exception{
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
	private void doUpdateBus(ItemEntity t) throws Exception{
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
	private void doDelBus(ItemEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(ItemEntity t){
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
		map.put("fsplit", t.getFsplit());
		map.put("fabbr", t.getFabbr());
		map.put("fnumber", t.getFnumber());
		map.put("fcus_class", t.getFcusClass());
		map.put("fmanu_number", t.getFmanuNumber());
		map.put("ftrans_condition", t.getFtransCondition());
		map.put("fprese_condition", t.getFpreseCondition());
		map.put("ftrans_note", t.getFtransNote());
		map.put("fgross", t.getFgross());
		map.put("fnet", t.getFnet());
		map.put("fprice", t.getFprice());
		map.put("fpack_type", t.getFpackType());
		map.put("funload_time", t.getFunloadTime());
		map.put("flength", t.getFlength());
		map.put("fwidth", t.getFwidth());
		map.put("fheight", t.getFheight());
		map.put("fvolume", t.getFvolume());
		map.put("flower_number", t.getFlowerNumber());
		map.put("flower_unit", t.getFlowerUnit());
		map.put("fnote", t.getFnote());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,ItemEntity t){
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
 		sql  = sql.replace("#{fsplit}",String.valueOf(t.getFsplit()));
 		sql  = sql.replace("#{fabbr}",String.valueOf(t.getFabbr()));
 		sql  = sql.replace("#{fnumber}",String.valueOf(t.getFnumber()));
 		sql  = sql.replace("#{fcus_class}",String.valueOf(t.getFcusClass()));
 		sql  = sql.replace("#{fmanu_number}",String.valueOf(t.getFmanuNumber()));
 		sql  = sql.replace("#{ftrans_condition}",String.valueOf(t.getFtransCondition()));
 		sql  = sql.replace("#{fprese_condition}",String.valueOf(t.getFpreseCondition()));
 		sql  = sql.replace("#{ftrans_note}",String.valueOf(t.getFtransNote()));
 		sql  = sql.replace("#{fgross}",String.valueOf(t.getFgross()));
 		sql  = sql.replace("#{fnet}",String.valueOf(t.getFnet()));
 		sql  = sql.replace("#{fprice}",String.valueOf(t.getFprice()));
 		sql  = sql.replace("#{fpack_type}",String.valueOf(t.getFpackType()));
 		sql  = sql.replace("#{funload_time}",String.valueOf(t.getFunloadTime()));
 		sql  = sql.replace("#{flength}",String.valueOf(t.getFlength()));
 		sql  = sql.replace("#{fwidth}",String.valueOf(t.getFwidth()));
 		sql  = sql.replace("#{fheight}",String.valueOf(t.getFheight()));
 		sql  = sql.replace("#{fvolume}",String.valueOf(t.getFvolume()));
 		sql  = sql.replace("#{flower_number}",String.valueOf(t.getFlowerNumber()));
 		sql  = sql.replace("#{flower_unit}",String.valueOf(t.getFlowerUnit()));
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
					javaInter.execute("z_item",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}