package com.jeecg.schdaily.service.impl;
import com.jeecg.schdaily.service.SchdailyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.schdaily.entity.SchdailyEntity;
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

@Service("schdailyService")
@Transactional
public class SchdailyServiceImpl extends CommonServiceImpl implements SchdailyServiceI {

	
 	public void delete(SchdailyEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(SchdailyEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(SchdailyEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(SchdailyEntity t) throws Exception{
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
	private void doUpdateBus(SchdailyEntity t) throws Exception{
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
	private void doDelBus(SchdailyEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(SchdailyEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("ftuoyun", t.getFtuoyun());
		map.put("fpaicheno", t.getFpaicheno());
		map.put("ftxyard", t.getFtxyard());
		map.put("fzhtime", t.getFzhtime());
		map.put("fzhaddress", t.getFzhaddress());
		map.put("fxhtime", t.getFxhtime());
		map.put("fxhaddress", t.getFxhaddress());
		map.put("fhxyard", t.getFhxyard());
		map.put("fboxamount", t.getFboxamount());
		map.put("fboxno", t.getFboxno());
		map.put("fcarno", t.getFcarno());
		map.put("fguano", t.getFguano());
		map.put("fdriver", t.getFdriver());
		map.put("fbudget", t.getFbudget());
		map.put("fnote", t.getFnote());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,SchdailyEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{ftuoyun}",String.valueOf(t.getFtuoyun()));
 		sql  = sql.replace("#{fpaicheno}",String.valueOf(t.getFpaicheno()));
 		sql  = sql.replace("#{ftxyard}",String.valueOf(t.getFtxyard()));
 		sql  = sql.replace("#{fzhtime}",String.valueOf(t.getFzhtime()));
 		sql  = sql.replace("#{fzhaddress}",String.valueOf(t.getFzhaddress()));
 		sql  = sql.replace("#{fxhtime}",String.valueOf(t.getFxhtime()));
 		sql  = sql.replace("#{fxhaddress}",String.valueOf(t.getFxhaddress()));
 		sql  = sql.replace("#{fhxyard}",String.valueOf(t.getFhxyard()));
 		sql  = sql.replace("#{fboxamount}",String.valueOf(t.getFboxamount()));
 		sql  = sql.replace("#{fboxno}",String.valueOf(t.getFboxno()));
 		sql  = sql.replace("#{fcarno}",String.valueOf(t.getFcarno()));
 		sql  = sql.replace("#{fguano}",String.valueOf(t.getFguano()));
 		sql  = sql.replace("#{fdriver}",String.valueOf(t.getFdriver()));
 		sql  = sql.replace("#{fbudget}",String.valueOf(t.getFbudget()));
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
					javaInter.execute("z_schdaily",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}