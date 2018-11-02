
package com.jeecg.pay.page;
import com.jeecg.pay.entity.PayEntity;
import com.jeecg.zhangdan.entity.ZhangdanEntity;

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
 * @Description: 应付账单
 * @author onlineGenerator
 * @date 2018-08-17 13:19:05
 * @version V1.0   
 *
 */
public class PayPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**制单人*/
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
	/**对账单号*/
    @Excel(name="对账单号")
	private java.lang.String fbillno;
	/**对账单位代码*/
    @Excel(name="对账单位代码")
	private java.lang.String funitcode;
	/**币别*/
    @Excel(name="币别")
	private java.lang.String fbibie;
	/**金额*/
    @Excel(name="金额")
	private java.lang.Double famount;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String fnote;
	/**对账日期起*/
    @Excel(name="对账日期起",format = "yyyy-MM-dd")
	private java.util.Date fstartdate;
	/**对账日期止*/
    @Excel(name="对账日期止",format = "yyyy-MM-dd")
	private java.util.Date fenddate;
	/**对账范围*/
    @Excel(name="对账范围")
	private java.lang.String frange;
	/**对账单位名称*/
    @Excel(name="对账单位名称")
	private java.lang.String funit;
	
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
	 *@return: java.lang.String  制单人
	 */
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  制单人
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
	 *@return: java.lang.String  对账单号
	 */
	public java.lang.String getFbillno(){
		return this.fbillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对账单号
	 */
	public void setFbillno(java.lang.String fbillno){
		this.fbillno = fbillno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对账单位代码
	 */
	public java.lang.String getFunitcode(){
		return this.funitcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对账单位代码
	 */
	public void setFunitcode(java.lang.String funitcode){
		this.funitcode = funitcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  币别
	 */
	public java.lang.String getFbibie(){
		return this.fbibie;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  币别
	 */
	public void setFbibie(java.lang.String fbibie){
		this.fbibie = fbibie;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  对账日期起
	 */
	public java.util.Date getFstartdate(){
		return this.fstartdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  对账日期起
	 */
	public void setFstartdate(java.util.Date fstartdate){
		this.fstartdate = fstartdate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  对账日期止
	 */
	public java.util.Date getFenddate(){
		return this.fenddate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  对账日期止
	 */
	public void setFenddate(java.util.Date fenddate){
		this.fenddate = fenddate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对账范围
	 */
	public java.lang.String getFrange(){
		return this.frange;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对账范围
	 */
	public void setFrange(java.lang.String frange){
		this.frange = frange;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对账单位名称
	 */
	public java.lang.String getFunit(){
		return this.funit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对账单位名称
	 */
	public void setFunit(java.lang.String funit){
		this.funit = funit;
	}

	/**保存-应付账单明细*/
    @ExcelCollection(name="应付账单明细")
	private List<ZhangdanEntity> zhangdanList = new ArrayList<ZhangdanEntity>();
		public List<ZhangdanEntity> getZhangdanList() {
		return zhangdanList;
		}
		public void setZhangdanList(List<ZhangdanEntity> zhangdanList) {
		this.zhangdanList = zhangdanList;
		}
}
