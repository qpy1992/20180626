package com.jeecg.vehicle.service.impl;
import com.jeecg.vehicle.service.VehicleServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.vehicle.entity.VehicleEntity;
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

@Service("vehicleService")
@Transactional
public class VehicleServiceImpl extends CommonServiceImpl implements VehicleServiceI {
    @Autowired
    private SystemService systemService;
	
 	public void delete(VehicleEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(VehicleEntity entity) throws Exception{
 	    entity.setFitemid(systemService.getFcode(1));
 	    entity.setFlog("沪交运管"+entity.getFlogzi()+"字"+entity.getFlognum()+"号");
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(VehicleEntity entity) throws Exception{
        entity.setFlog("沪交运管"+entity.getFlogzi()+"字"+entity.getFlognum()+"号");
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(VehicleEntity t) throws Exception{
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
	private void doUpdateBus(VehicleEntity t) throws Exception{
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
	private void doDelBus(VehicleEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(VehicleEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("create_date", t.getCreateDate());
		map.put("update_date", t.getUpdateDate());
		map.put("bpm_status", t.getBpmStatus());
		map.put("fitemid", t.getFitemid());
		map.put("fcarno", t.getFcarno());
		map.put("fowner", t.getFowner());
		map.put("fregdate", t.getFregdate());
		map.put("fcartype", t.getFcartype());
		map.put("fbrand", t.getFbrand());
		map.put("fmodel", t.getFmodel());
		map.put("fcolor", t.getFcolor());
		map.put("fidcode", t.getFidcode());
		map.put("fimex", t.getFimex());
		map.put("fengin", t.getFengin());
		map.put("fengintype", t.getFengintype());
		map.put("fuel", t.getFuel());
		map.put("fdisplace", t.getFdisplace());
		map.put("fwatt", t.getFwatt());
		map.put("fmade", t.getFmade());
		map.put("fzhuan", t.getFzhuan());
		map.put("flunju1", t.getFlunju1());
		map.put("flunju2", t.getFlunju2());
		map.put("ftyrenum", t.getFtyrenum());
		map.put("ftyremodel", t.getFtyremodel());
		map.put("ffbthnum", t.getFfbthnum());
		map.put("faxis", t.getFaxis());
		map.put("faxisnum", t.getFaxisnum());
		map.put("flength", t.getFlength());
		map.put("fwidth", t.getFwidth());
		map.put("fheight", t.getFheight());
		map.put("fweight", t.getFweight());
		map.put("ftrueweight", t.getFtrueweight());
		map.put("fperweight", t.getFperweight());
		map.put("fnature", t.getFnature());
		map.put("flogzi", t.getFlogzi());
		map.put("flognum", t.getFlognum());
		map.put("flog", t.getFlog());
		map.put("fjinying", t.getFjinying());
		map.put("fazhengdate", t.getFazhengdate());
		map.put("fyouxiaodate", t.getFyouxiaodate());
		map.put("fzbweight", t.getFzbweight());
		map.put("forcebf", t.getForcebf());
		map.put("fjydate", t.getFjydate());
		map.put("fdjzs", t.getFdjzs());
		map.put("fxsz", t.getFxsz());
		map.put("fyyz", t.getFyyz());
		map.put("fjqx", t.getFjqx());
		map.put("fsyx", t.getFsyx());
		map.put("fhwx", t.getFhwx());
		map.put("fnote", t.getFnote());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,VehicleEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{bpm_status}",String.valueOf(t.getBpmStatus()));
 		sql  = sql.replace("#{fitemid}",String.valueOf(t.getFitemid()));
 		sql  = sql.replace("#{fcarno}",String.valueOf(t.getFcarno()));
 		sql  = sql.replace("#{fowner}",String.valueOf(t.getFowner()));
 		sql  = sql.replace("#{fregdate}",String.valueOf(t.getFregdate()));
 		sql  = sql.replace("#{fcartype}",String.valueOf(t.getFcartype()));
 		sql  = sql.replace("#{fbrand}",String.valueOf(t.getFbrand()));
 		sql  = sql.replace("#{fmodel}",String.valueOf(t.getFmodel()));
 		sql  = sql.replace("#{fcolor}",String.valueOf(t.getFcolor()));
 		sql  = sql.replace("#{fidcode}",String.valueOf(t.getFidcode()));
 		sql  = sql.replace("#{fimex}",String.valueOf(t.getFimex()));
 		sql  = sql.replace("#{fengin}",String.valueOf(t.getFengin()));
 		sql  = sql.replace("#{fengintype}",String.valueOf(t.getFengintype()));
 		sql  = sql.replace("#{fuel}",String.valueOf(t.getFuel()));
 		sql  = sql.replace("#{fdisplace}",String.valueOf(t.getFdisplace()));
 		sql  = sql.replace("#{fwatt}",String.valueOf(t.getFwatt()));
 		sql  = sql.replace("#{fmade}",String.valueOf(t.getFmade()));
 		sql  = sql.replace("#{fzhuan}",String.valueOf(t.getFzhuan()));
 		sql  = sql.replace("#{flunju1}",String.valueOf(t.getFlunju1()));
 		sql  = sql.replace("#{flunju2}",String.valueOf(t.getFlunju2()));
 		sql  = sql.replace("#{ftyrenum}",String.valueOf(t.getFtyrenum()));
 		sql  = sql.replace("#{ftyremodel}",String.valueOf(t.getFtyremodel()));
 		sql  = sql.replace("#{ffbthnum}",String.valueOf(t.getFfbthnum()));
 		sql  = sql.replace("#{faxis}",String.valueOf(t.getFaxis()));
 		sql  = sql.replace("#{faxisnum}",String.valueOf(t.getFaxisnum()));
 		sql  = sql.replace("#{flength}",String.valueOf(t.getFlength()));
 		sql  = sql.replace("#{fwidth}",String.valueOf(t.getFwidth()));
 		sql  = sql.replace("#{fheight}",String.valueOf(t.getFheight()));
 		sql  = sql.replace("#{fweight}",String.valueOf(t.getFweight()));
 		sql  = sql.replace("#{ftrueweight}",String.valueOf(t.getFtrueweight()));
 		sql  = sql.replace("#{fperweight}",String.valueOf(t.getFperweight()));
 		sql  = sql.replace("#{fnature}",String.valueOf(t.getFnature()));
 		sql  = sql.replace("#{flogzi}",String.valueOf(t.getFlogzi()));
 		sql  = sql.replace("#{flognum}",String.valueOf(t.getFlognum()));
 		sql  = sql.replace("#{flog}",String.valueOf(t.getFlog()));
 		sql  = sql.replace("#{fjinying}",String.valueOf(t.getFjinying()));
 		sql  = sql.replace("#{fazhengdate}",String.valueOf(t.getFazhengdate()));
 		sql  = sql.replace("#{fyouxiaodate}",String.valueOf(t.getFyouxiaodate()));
 		sql  = sql.replace("#{fzbweight}",String.valueOf(t.getFzbweight()));
 		sql  = sql.replace("#{forcebf}",String.valueOf(t.getForcebf()));
 		sql  = sql.replace("#{fjydate}",String.valueOf(t.getFjydate()));
 		sql  = sql.replace("#{fdjzs}",String.valueOf(t.getFdjzs()));
 		sql  = sql.replace("#{fxsz}",String.valueOf(t.getFxsz()));
 		sql  = sql.replace("#{fyyz}",String.valueOf(t.getFyyz()));
 		sql  = sql.replace("#{fjqx}",String.valueOf(t.getFjqx()));
 		sql  = sql.replace("#{fsyx}",String.valueOf(t.getFsyx()));
 		sql  = sql.replace("#{fhwx}",String.valueOf(t.getFhwx()));
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
					javaInter.execute("z_vehicle",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}