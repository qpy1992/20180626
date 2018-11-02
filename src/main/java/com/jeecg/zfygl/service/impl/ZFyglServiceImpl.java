package com.jeecg.zfygl.service.impl;
import com.jeecg.zfygl.service.ZFyglServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.zfygl.entity.ZFyglEntity;
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

@Service("zFyglService")
@Transactional
public class ZFyglServiceImpl extends CommonServiceImpl implements ZFyglServiceI {

	
 	public void delete(ZFyglEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(ZFyglEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(ZFyglEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(ZFyglEntity t) throws Exception{
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
	private void doUpdateBus(ZFyglEntity t) throws Exception{
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
	private void doDelBus(ZFyglEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(ZFyglEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("update_date", t.getUpdateDate());
		map.put("fglgzh", t.getFglgzh());
		map.put("fwtbh", t.getFwtbh());
		map.put("fkhh", t.getFkhh());
		map.put("fkhname", t.getFkhname());
		map.put("fst", t.getFst());
		map.put("ftx", t.getFtx());
		map.put("fzl", t.getFzl());
		map.put("fsg", t.getFsg());
		map.put("fbx", t.getFbx());
		map.put("fww", t.getFww());
		map.put("fyt", t.getFyt());
		map.put("fmddz", t.getFmddz());
		map.put("fxsddh", t.getFxsddh());
		map.put("xxxl", t.getXxxl());
		map.put("khcgddh", t.getKhcgddh());
		map.put("fh", t.getFh());
		map.put("yfsd", t.getYfsd());
		map.put("yssd", t.getYssd());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,ZFyglEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{fglgzh}",String.valueOf(t.getFglgzh()));
 		sql  = sql.replace("#{fwtbh}",String.valueOf(t.getFwtbh()));
 		sql  = sql.replace("#{fkhh}",String.valueOf(t.getFkhh()));
 		sql  = sql.replace("#{fkhname}",String.valueOf(t.getFkhname()));
 		sql  = sql.replace("#{fst}",String.valueOf(t.getFst()));
 		sql  = sql.replace("#{ftx}",String.valueOf(t.getFtx()));
 		sql  = sql.replace("#{fzl}",String.valueOf(t.getFzl()));
 		sql  = sql.replace("#{fsg}",String.valueOf(t.getFsg()));
 		sql  = sql.replace("#{fbx}",String.valueOf(t.getFbx()));
 		sql  = sql.replace("#{fww}",String.valueOf(t.getFww()));
 		sql  = sql.replace("#{fyt}",String.valueOf(t.getFyt()));
 		sql  = sql.replace("#{fmddz}",String.valueOf(t.getFmddz()));
 		sql  = sql.replace("#{fxsddh}",String.valueOf(t.getFxsddh()));
 		sql  = sql.replace("#{xxxl}",String.valueOf(t.getXxxl()));
 		sql  = sql.replace("#{khcgddh}",String.valueOf(t.getKhcgddh()));
 		sql  = sql.replace("#{fh}",String.valueOf(t.getFh()));
 		sql  = sql.replace("#{yfsd}",String.valueOf(t.getYfsd()));
 		sql  = sql.replace("#{yssd}",String.valueOf(t.getYssd()));
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
					javaInter.execute("z_fygl",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}