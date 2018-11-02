package com.jeecg.lipei.service.impl;
import com.jeecg.lipei.service.LipeiServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.lipei.entity.LipeiEntity;
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

@Service("lipeiService")
@Transactional
public class LipeiServiceImpl extends CommonServiceImpl implements LipeiServiceI {

	
 	public void delete(LipeiEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(LipeiEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(LipeiEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(LipeiEntity t) throws Exception{
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
	private void doUpdateBus(LipeiEntity t) throws Exception{
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
	private void doDelBus(LipeiEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(LipeiEntity t){
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
		map.put("fjiaotong", t.getFjiaotong());
		map.put("fcarno", t.getFcarno());
		map.put("fname", t.getFname());
		map.put("fchuxian_time", t.getFchuxianTime());
		map.put("fzeren", t.getFzeren());
		map.put("fxingcheng", t.getFxingcheng());
		map.put("fsschuli", t.getFsschuli());
		map.put("fdingji", t.getFdingji());
		map.put("ftyday", t.getFtyday());
		map.put("fkoukuan", t.getFkoukuan());
		map.put("famount", t.getFamount());
		map.put("fbaoxian", t.getFbaoxian());
		map.put("fzssunshi", t.getFzssunshi());
		map.put("fbxjiesuan", t.getFbxjiesuan());
		map.put("fother", t.getFother());
		map.put("fjatime", t.getFjatime());
		map.put("fdisan", t.getFdisan());
		map.put("fjcltime", t.getFjcltime());
		map.put("fyufu", t.getFyufu());
		map.put("fpeifutime", t.getFpeifutime());
		map.put("fpolice", t.getFpolice());
		map.put("fgsjatime", t.getFgsjatime());
		map.put("fnote", t.getFnote());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,LipeiEntity t){
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
 		sql  = sql.replace("#{fjiaotong}",String.valueOf(t.getFjiaotong()));
 		sql  = sql.replace("#{fcarno}",String.valueOf(t.getFcarno()));
 		sql  = sql.replace("#{fname}",String.valueOf(t.getFname()));
 		sql  = sql.replace("#{fchuxian_time}",String.valueOf(t.getFchuxianTime()));
 		sql  = sql.replace("#{fzeren}",String.valueOf(t.getFzeren()));
 		sql  = sql.replace("#{fxingcheng}",String.valueOf(t.getFxingcheng()));
 		sql  = sql.replace("#{fsschuli}",String.valueOf(t.getFsschuli()));
 		sql  = sql.replace("#{fdingji}",String.valueOf(t.getFdingji()));
 		sql  = sql.replace("#{ftyday}",String.valueOf(t.getFtyday()));
 		sql  = sql.replace("#{fkoukuan}",String.valueOf(t.getFkoukuan()));
 		sql  = sql.replace("#{famount}",String.valueOf(t.getFamount()));
 		sql  = sql.replace("#{fbaoxian}",String.valueOf(t.getFbaoxian()));
 		sql  = sql.replace("#{fzssunshi}",String.valueOf(t.getFzssunshi()));
 		sql  = sql.replace("#{fbxjiesuan}",String.valueOf(t.getFbxjiesuan()));
 		sql  = sql.replace("#{fother}",String.valueOf(t.getFother()));
 		sql  = sql.replace("#{fjatime}",String.valueOf(t.getFjatime()));
 		sql  = sql.replace("#{fdisan}",String.valueOf(t.getFdisan()));
 		sql  = sql.replace("#{fjcltime}",String.valueOf(t.getFjcltime()));
 		sql  = sql.replace("#{fyufu}",String.valueOf(t.getFyufu()));
 		sql  = sql.replace("#{fpeifutime}",String.valueOf(t.getFpeifutime()));
 		sql  = sql.replace("#{fpolice}",String.valueOf(t.getFpolice()));
 		sql  = sql.replace("#{fgsjatime}",String.valueOf(t.getFgsjatime()));
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
					javaInter.execute("z_lipei",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}