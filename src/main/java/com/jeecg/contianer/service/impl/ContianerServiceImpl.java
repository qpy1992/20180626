package com.jeecg.contianer.service.impl;

import com.jeecg.charge.entity.ChargeEntity;
import com.jeecg.contianer.service.ContianerServiceI;
import com.jeecg.costdetail.entity.CostdetailEntity;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.contianer.entity.ContianerEntity;
import com.jeecg.detail.entity.DetailEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("contianerService")
@Transactional
public class ContianerServiceImpl extends CommonServiceImpl implements ContianerServiceI {
	@Autowired
	private JdbcTemplate jdbcTemplate;

 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((ContianerEntity)entity);
 	}
	
	public void addMain(ContianerEntity contianer,
	        List<DetailEntity> detailList, String fsettleid){
			//保存主信息
			this.save(contianer);
			//生成固定的费用
			List<String> ids = jdbcTemplate.queryForList("select id from z_costdetail where fid=?",String.class,contianer.getCid1());
			if(ids.size()!=0){
				for(String id:ids){
					CostdetailEntity costdetail = getEntity(CostdetailEntity.class,id);
					ChargeEntity charge = new ChargeEntity();
					charge.setFshoufu(costdetail.getFyf());
					charge.setFcheck("0");
					charge.setFcost(costdetail.getFcostcode());
					charge.setFcostname(costdetail.getFcost());
					String fsettle = jdbcTemplate.queryForObject("select fcustom_code from z_custom where id=?",String.class,fsettleid);
					String fsettlename = jdbcTemplate.queryForObject("select fcn_name from z_custom where id=?",String.class, fsettleid);
					charge.setFsettle(fsettle);
					charge.setFsettlename(fsettlename);
					charge.setFprice(costdetail.getFee());
					charge.setFqty(1.0);
					charge.setFamount(costdetail.getFee());
					charge.setFid(contianer.getFid());
					charge.setForigin("0");
					charge.setFkp("N");
					charge.setFykamount("0");
					charge.setFbx("N");
					charge.setFdz("N");
					charge.setFhx("N");
					charge.setFhxamount(0.0);
					charge.setFremain(costdetail.getFee());
					charge.setConid(contianer.getId());
					save(charge);
				}
			}
		    BigDecimal ftotal = contianer.getFtotals();
		    if(ftotal==null){
		    	ftotal = new BigDecimal(0);
			}
		    BigDecimal fgross = contianer.getFgrosses();
			if(fgross==null){
				fgross = new BigDecimal(0);
			}
		    BigDecimal fvolume = contianer.getFvolumes();
			if(fvolume==null){
				fvolume = new BigDecimal(0);
			}
			/**保存-箱货明细*/
			for(DetailEntity detail:detailList){
				//外键设置
				detail.setFid(contianer.getId());
				ftotal = ftotal.add(detail.getFqty());
				fgross = fgross.add(detail.getFgross());
				fvolume = fvolume.add(detail.getFvolume());
				this.save(detail);
			}
			contianer.setFtotals(ftotal);
			contianer.setFgrosses(fgross);
			contianer.setFvolumes(fvolume);
			//执行新增操作配置的sql增强
 			this.doAddSql(contianer);
	}

	
	public void updateMain(ContianerEntity contianer,
	        List<DetailEntity> detailList) {
		//保存主表信息
		BigDecimal ftotal = null,fgross = null,fvolume = null;
		if(StringUtil.isNotEmpty(contianer.getId())){
			try {
				ContianerEntity temp = findUniqueByProperty(ContianerEntity.class, "id", contianer.getId());
				MyBeanUtils.copyBeanNotNull2Bean(contianer, temp);
				this.saveOrUpdate(temp);
				jdbcTemplate.execute("update z_charge set fprice="+temp.getFprice()+" where conid='"+temp.getId()+"'");
				ftotal = temp.getFtotals();
				fgross = temp.getFgrosses();
				fvolume = temp.getFvolumes();
				if(ftotal==null){
					ftotal = new BigDecimal(0);
				}
				if(fgross==null){
					fgross = new BigDecimal(0);
				}
				if(fvolume==null){
					fvolume = new BigDecimal(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.saveOrUpdate(contianer);
			jdbcTemplate.execute("update z_charge set fprice="+contianer.getFprice()+" where conid='"+contianer.getId()+"'");
			ftotal = contianer.getFtotals();
			fgross = contianer.getFgrosses();
			fvolume = contianer.getFvolumes();
			if(ftotal==null){
				ftotal = new BigDecimal(0);
			}
			if(fgross==null){
				fgross = new BigDecimal(0);
			}
			if(fvolume==null){
				fvolume = new BigDecimal(0);
			}
		}
		//===================================================================================
		//获取参数
		Object id0 = contianer.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-箱货明细
	    String hql0 = "from DetailEntity where 1 = 1 AND fID = ? ";
	    List<DetailEntity> detailOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-箱货明细
		if(detailList!=null&&detailList.size()>0){
		for(DetailEntity oldE:detailOldList){
			boolean isUpdate = false;
				for(DetailEntity sendE:detailList){
					//需要更新的明细数据-箱货明细
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
							ftotal = ftotal.add(oldE.getFqty());
							fgross = fgross.add(oldE.getFgross());
							fvolume = fvolume.add(oldE.getFvolume());
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-箱货明细
		    		super.delete(oldE);
		    		ftotal = ftotal.subtract(oldE.getFqty());
		    		fgross = fgross.subtract(oldE.getFgross());
		    		fvolume = fvolume.subtract(oldE.getFvolume());
	    		}
			}
			//3.持久化新增的数据-箱货明细
			for(DetailEntity detail:detailList){
				if(oConvertUtils.isEmpty(detail.getId())){
					//外键设置
					detail.setFid(contianer.getId());
					ftotal = ftotal.add(detail.getFqty());
					fgross = fgross.add(detail.getFgross());
					fvolume = fvolume.add(detail.getFvolume());
					this.save(detail);
				}
			}
		}
		if(StringUtil.isNotEmpty(contianer.getId())){
			try {
				ContianerEntity temp = findUniqueByProperty(ContianerEntity.class, "id", contianer.getId());
				MyBeanUtils.copyBeanNotNull2Bean(contianer, temp);
				temp.setFtotals(ftotal);
				temp.setFgrosses(fgross);
				temp.setFvolumes(fvolume);
			}catch (Exception e){
				e.printStackTrace();
			}
		}else {
			contianer.setFtotals(ftotal);
			contianer.setFgrosses(fgross);
			contianer.setFvolumes(fvolume);
		}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(contianer);
	}

	
	public void delMain(ContianerEntity contianer) {
		//删除主表信息
		this.delete(contianer);
		jdbcTemplate.execute("delete from z_charge where conid='"+contianer.getId()+"'");
		//===================================================================================
		//获取参数
		Object id0 = contianer.getId();
		//===================================================================================
		//删除-箱货明细
	    String hql0 = "from DetailEntity where 1 = 1 AND fID = ? ";
	    List<DetailEntity> detailOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(detailOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param t
	 * @return
	 */
 	public boolean doAddSql(ContianerEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param t
	 * @return
	 */
 	public boolean doUpdateSql(ContianerEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param t
	 * @return
	 */
 	public boolean doDelSql(ContianerEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,ContianerEntity t){
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
 		sql  = sql.replace("#{fzhdp}",String.valueOf(t.getFzhdp()));
 		sql  = sql.replace("#{fzhdpdz}",String.valueOf(t.getFzhdpdz()));
 		sql  = sql.replace("#{fzhunit}",String.valueOf(t.getFzhunit()));
 		sql  = sql.replace("#{fzhcontact}",String.valueOf(t.getFzhcontact()));
 		sql  = sql.replace("#{fzhmobile}",String.valueOf(t.getFzhmobile()));
 		sql  = sql.replace("#{fnote}",String.valueOf(t.getFnote()));
 		sql  = sql.replace("#{ftsyw}",String.valueOf(t.getFtsyw()));
 		sql  = sql.replace("#{fxhdp}",String.valueOf(t.getFxhdp()));
 		sql  = sql.replace("#{fxhdpdz}",String.valueOf(t.getFxhdpdz()));
 		sql  = sql.replace("#{fxhtime}",String.valueOf(t.getFxhtime()));
 		sql  = sql.replace("#{fxhunit}",String.valueOf(t.getFxhunit()));
 		sql  = sql.replace("#{fxhcontact}",String.valueOf(t.getFxhcontact()));
 		sql  = sql.replace("#{fxhmobile}",String.valueOf(t.getFxhmobile()));
 		sql  = sql.replace("#{fbillno}",String.valueOf(t.getFbillno()));
 		sql  = sql.replace("#{fzanluo}",String.valueOf(t.getFzanluo()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}