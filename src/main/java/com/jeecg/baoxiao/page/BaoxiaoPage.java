
package com.jeecg.baoxiao.page;
import com.jeecg.baoxiao.entity.BaoxiaoEntity;
import com.jeecg.bxcost.entity.BxcostEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

/**   
 * @Title: Entity
 * @Description: 报销单管理
 * @author onlineGenerator
 * @date 2018-08-16 10:35:38
 * @version V1.0   
 *
 */
public class BaoxiaoPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**报销单号*/
    @Excel(name="报销单号")
	private java.lang.String fbxno;
	/**申请人*/
    @Excel(name="申请人")
	private java.lang.String fapplyer;
	/**申请日期*/
    @Excel(name="申请日期",format = "yyyy-MM-dd")
	private java.util.Date fapplydate;
	/**审核*/
    @Excel(name="审核")
	private java.lang.String fcheck;
	/**审核人*/
    @Excel(name="审核人")
	private java.lang.String fchecker;
	/**审核日期*/
    @Excel(name="审核日期",format = "yyyy-MM-dd")
	private java.util.Date fcheckdate;
	/**金额*/
    @Excel(name="金额")
	private java.lang.Double famount;
	/**核销金额*/
    @Excel(name="核销金额")
	private java.lang.Double fhxamount;
	/**核销状态*/
    @Excel(name="核销状态")
	private java.lang.String fhxstatus;
	/**报销人*/
    @Excel(name="报销人")
	private java.lang.String fbxman;
	/**币种*/
    @Excel(name="币种")
	private java.lang.String fcurrency;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String fnote;
	/**派车单号*/
	private java.lang.String fpcno;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报销单号
	 */
	public java.lang.String getFbxno(){
		return this.fbxno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报销单号
	 */
	public void setFbxno(java.lang.String fbxno){
		this.fbxno = fbxno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请人
	 */
	public java.lang.String getFapplyer(){
		return this.fapplyer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人
	 */
	public void setFapplyer(java.lang.String fapplyer){
		this.fapplyer = fapplyer;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请日期
	 */
	public java.util.Date getFapplydate(){
		return this.fapplydate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请日期
	 */
	public void setFapplydate(java.util.Date fapplydate){
		this.fapplydate = fapplydate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核
	 */
	public java.lang.String getFcheck(){
		return this.fcheck;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核
	 */
	public void setFcheck(java.lang.String fcheck){
		this.fcheck = fcheck;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */
	public java.lang.String getFchecker(){
		return this.fchecker;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setFchecker(java.lang.String fchecker){
		this.fchecker = fchecker;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核日期
	 */
	public java.util.Date getFcheckdate(){
		return this.fcheckdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核日期
	 */
	public void setFcheckdate(java.util.Date fcheckdate){
		this.fcheckdate = fcheckdate;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  金额
	 */
	public java.lang.Double getFamount(){
		return this.famount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  金额
	 */
	public void setFamount(java.lang.Double famount){
		this.famount = famount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  核销金额
	 */
	public java.lang.Double getFhxamount(){
		return this.fhxamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  核销金额
	 */
	public void setFhxamount(java.lang.Double fhxamount){
		this.fhxamount = fhxamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  核销状态
	 */
	public java.lang.String getFhxstatus(){
		return this.fhxstatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  核销状态
	 */
	public void setFhxstatus(java.lang.String fhxstatus){
		this.fhxstatus = fhxstatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报销人
	 */
	public java.lang.String getFbxman(){
		return this.fbxman;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报销人
	 */
	public void setFbxman(java.lang.String fbxman){
		this.fbxman = fbxman;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  币种
	 */
	public java.lang.String getFcurrency(){
		return this.fcurrency;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  币种
	 */
	public void setFcurrency(java.lang.String fcurrency){
		this.fcurrency = fcurrency;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	public java.lang.String getFnote(){
		return this.fnote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setFnote(java.lang.String fnote){
		this.fnote = fnote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单号
	 */
	public java.lang.String getFpcno(){
		return this.fpcno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单号
	 */
	public void setFpcno(java.lang.String fpcno){
		this.fpcno = fpcno;
	}

	/**保存-报销费用明细*/
    @ExcelCollection(name="报销费用明细")
	private List<BxcostEntity> bxcostList = new ArrayList<BxcostEntity>();
		public List<BxcostEntity> getBxcostList() {
		return bxcostList;
		}
		public void setBxcostList(List<BxcostEntity> bxcostList) {
		this.bxcostList = bxcostList;
		}
}
