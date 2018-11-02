package com.jeecg.container.service.impl;
import com.jeecg.container.service.ContainerServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.container.entity.ContainerEntity;
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

@Service("containerService")
@Transactional
public class ContainerServiceImpl extends CommonServiceImpl implements ContainerServiceI {

	
 	public void delete(ContainerEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(ContainerEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(ContainerEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(ContainerEntity t) throws Exception{
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
	private void doUpdateBus(ContainerEntity t) throws Exception{
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
	private void doDelBus(ContainerEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(ContainerEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("fboxno", t.getFboxno());
		map.put("ftitle", t.getFtitle());
		map.put("fboxtype", t.getFboxtype());
		map.put("floadport", t.getFloadport());
		map.put("ftransfer", t.getFtransfer());
		map.put("ftarget", t.getFtarget());
		map.put("fvoyage", t.getFvoyage());
		map.put("fvoyagenum", t.getFvoyagenum());
		map.put("fmodel", t.getFmodel());
		map.put("fmakeboxtime", t.getFmakeboxtime());
		map.put("fgrade", t.getFgrade());
		map.put("fdrpagenum", t.getFdrpagenum());
		map.put("funnumber", t.getFunnumber());
		map.put("flash_point", t.getFlashPoint());
		map.put("fcolddegree", t.getFcolddegree());
		map.put("ftotals", t.getFtotals());
		map.put("fgrosses", t.getFgrosses());
		map.put("fvolumes", t.getFvolumes());
		map.put("fextract", t.getFextract());
		map.put("freturn", t.getFreturn());
		map.put("foperator", t.getFoperator());
		map.put("fid", t.getFid());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,ContainerEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{fboxno}",String.valueOf(t.getFboxno()));
 		sql  = sql.replace("#{ftitle}",String.valueOf(t.getFtitle()));
 		sql  = sql.replace("#{fboxtype}",String.valueOf(t.getFboxtype()));
 		sql  = sql.replace("#{floadport}",String.valueOf(t.getFloadport()));
 		sql  = sql.replace("#{ftransfer}",String.valueOf(t.getFtransfer()));
 		sql  = sql.replace("#{ftarget}",String.valueOf(t.getFtarget()));
 		sql  = sql.replace("#{fvoyage}",String.valueOf(t.getFvoyage()));
 		sql  = sql.replace("#{fvoyagenum}",String.valueOf(t.getFvoyagenum()));
 		sql  = sql.replace("#{fmodel}",String.valueOf(t.getFmodel()));
 		sql  = sql.replace("#{fmakeboxtime}",String.valueOf(t.getFmakeboxtime()));
 		sql  = sql.replace("#{fgrade}",String.valueOf(t.getFgrade()));
 		sql  = sql.replace("#{fdrpagenum}",String.valueOf(t.getFdrpagenum()));
 		sql  = sql.replace("#{funnumber}",String.valueOf(t.getFunnumber()));
 		sql  = sql.replace("#{flash_point}",String.valueOf(t.getFlashPoint()));
 		sql  = sql.replace("#{fcolddegree}",String.valueOf(t.getFcolddegree()));
 		sql  = sql.replace("#{ftotals}",String.valueOf(t.getFtotals()));
 		sql  = sql.replace("#{fgrosses}",String.valueOf(t.getFgrosses()));
 		sql  = sql.replace("#{fvolumes}",String.valueOf(t.getFvolumes()));
 		sql  = sql.replace("#{fextract}",String.valueOf(t.getFextract()));
 		sql  = sql.replace("#{freturn}",String.valueOf(t.getFreturn()));
 		sql  = sql.replace("#{foperator}",String.valueOf(t.getFoperator()));
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
					javaInter.execute("z_contianer",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}