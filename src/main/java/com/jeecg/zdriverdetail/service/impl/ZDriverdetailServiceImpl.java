package com.jeecg.zdriverdetail.service.impl;
import com.jeecg.zdriverdetail.service.ZDriverdetailServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.zdriverdetail.entity.ZDriverdetailEntity;
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

@Service("zDriverdetailService")
@Transactional
public class ZDriverdetailServiceImpl extends CommonServiceImpl implements ZDriverdetailServiceI {

	
 	public void delete(ZDriverdetailEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(ZDriverdetailEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(ZDriverdetailEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(ZDriverdetailEntity t) throws Exception{
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
	private void doUpdateBus(ZDriverdetailEntity t) throws Exception{
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
	private void doDelBus(ZDriverdetailEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(ZDriverdetailEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("jobnumber", t.getJobnumber());
		map.put("job", t.getJob());
		map.put("entry_date", t.getEntryDate());
		map.put("departure_date", t.getDepartureDate());
		map.put("fname", t.getFname());
		map.put("sex", t.getSex());
		map.put("birth_date", t.getBirthDate());
		map.put("education", t.getEducation());
		map.put("nation", t.getNation());
		map.put("birthplace", t.getBirthplace());
		map.put("idcard", t.getIdcard());
		map.put("political", t.getPolitical());
		map.put("address", t.getAddress());
		map.put("initial_date", t.getInitialDate());
		map.put("residential_address", t.getResidentialAddress());
		map.put("car_type", t.getCarType());
		map.put("registration_address", t.getRegistrationAddress());
		map.put("license_no", t.getLicenseNo());
		map.put("issuing_authority", t.getIssuingAuthority());
		map.put("phone", t.getPhone());
		map.put("image", t.getImage());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,ZDriverdetailEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{jobnumber}",String.valueOf(t.getJobnumber()));
 		sql  = sql.replace("#{job}",String.valueOf(t.getJob()));
 		sql  = sql.replace("#{entry_date}",String.valueOf(t.getEntryDate()));
 		sql  = sql.replace("#{departure_date}",String.valueOf(t.getDepartureDate()));
 		sql  = sql.replace("#{fname}",String.valueOf(t.getFname()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{birth_date}",String.valueOf(t.getBirthDate()));
 		sql  = sql.replace("#{education}",String.valueOf(t.getEducation()));
 		sql  = sql.replace("#{nation}",String.valueOf(t.getNation()));
 		sql  = sql.replace("#{birthplace}",String.valueOf(t.getBirthplace()));
 		sql  = sql.replace("#{idcard}",String.valueOf(t.getIdcard()));
 		sql  = sql.replace("#{political}",String.valueOf(t.getPolitical()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{initial_date}",String.valueOf(t.getInitialDate()));
 		sql  = sql.replace("#{residential_address}",String.valueOf(t.getResidentialAddress()));
 		sql  = sql.replace("#{car_type}",String.valueOf(t.getCarType()));
 		sql  = sql.replace("#{registration_address}",String.valueOf(t.getRegistrationAddress()));
 		sql  = sql.replace("#{license_no}",String.valueOf(t.getLicenseNo()));
 		sql  = sql.replace("#{issuing_authority}",String.valueOf(t.getIssuingAuthority()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{image}",String.valueOf(t.getImage()));
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
					javaInter.execute("z_driverdetail",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}