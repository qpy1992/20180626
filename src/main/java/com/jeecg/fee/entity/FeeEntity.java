package com.jeecg.fee.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 费用种类
 * @author onlineGenerator
 * @date 2018-07-04 15:35:41
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_fee", schema = "")
@SuppressWarnings("serial")
public class FeeEntity implements java.io.Serializable {
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
	/**费用代码*/
	@Excel(name="费用代码",width=15)
	private java.lang.String feeCode;
	/**作废*/
	@Excel(name="作废",width=15,dicCode="sf_yn")
	private java.lang.String fvoid;
	/**费用组*/
	@Excel(name="费用组",width=15)
	private java.lang.String feeTeam;
	/**中文名称*/
	@Excel(name="中文名称",width=15)
	private java.lang.String fcnName;
	/**对应单位*/
	@Excel(name="对应单位",width=15,dicCode="unit")
	private java.lang.String funit;
	/**费用名称*/
	@Excel(name="费用名称",width=15)
	private java.lang.String fname;
	/**默认币种*/
	@Excel(name="默认币种",width=15)
	private java.lang.String fdefaultCurrency;
	/**选项1*/
	@Excel(name="选项1",width=15,dicCode="fdc")
	private java.lang.String fdc1;
	/**默认价格*/
	@Excel(name="默认价格",width=15)
	private java.lang.Double fdefaultPrice;
	/**选项2*/
	@Excel(name="选项2",width=15,dicCode="fdp")
	private java.lang.String fdp1;
	/**约价*/
	@Excel(name="约价",width=15)
	private java.lang.Double fcontractPrice;
	/**选项3*/
	@Excel(name="选项3",width=15,dicCode="fcp")
	private java.lang.String fcp1;
	/**附加说明*/
	@Excel(name="附加说明",width=15)
	private java.lang.String finstruction;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
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

	@Column(name ="CREATE_NAME",nullable=true,length=50)
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

	@Column(name ="CREATE_BY",nullable=true,length=50)
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

	@Column(name ="CREATE_DATE",nullable=true,length=20)
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

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
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

	@Column(name ="UPDATE_BY",nullable=true,length=50)
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

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
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

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
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

	@Column(name ="BPM_STATUS",nullable=true,length=32)
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
	 *@return: java.lang.String  费用代码
	 */

	@Column(name ="FEE_CODE",nullable=true,length=32)
	public java.lang.String getFeeCode(){
		return this.feeCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用代码
	 */
	public void setFeeCode(java.lang.String feeCode){
		this.feeCode = feeCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作废
	 */

	@Column(name ="FVOID",nullable=true,length=32)
	public java.lang.String getFvoid(){
		return this.fvoid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作废
	 */
	public void setFvoid(java.lang.String fvoid){
		this.fvoid = fvoid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用组
	 */

	@Column(name ="FEE_TEAM",nullable=true,length=32)
	public java.lang.String getFeeTeam(){
		return this.feeTeam;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用组
	 */
	public void setFeeTeam(java.lang.String feeTeam){
		this.feeTeam = feeTeam;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中文名称
	 */

	@Column(name ="FCN_NAME",nullable=true,length=32)
	public java.lang.String getFcnName(){
		return this.fcnName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中文名称
	 */
	public void setFcnName(java.lang.String fcnName){
		this.fcnName = fcnName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对应单位
	 */

	@Column(name ="FUNIT",nullable=true,length=32)
	public java.lang.String getFunit(){
		return this.funit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对应单位
	 */
	public void setFunit(java.lang.String funit){
		this.funit = funit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用名称
	 */

	@Column(name ="FNAME",nullable=true,length=255)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用名称
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  默认币种
	 */

	@Column(name ="FDEFAULT_CURRENCY",nullable=true,length=32)
	public java.lang.String getFdefaultCurrency(){
		return this.fdefaultCurrency;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  默认币种
	 */
	public void setFdefaultCurrency(java.lang.String fdefaultCurrency){
		this.fdefaultCurrency = fdefaultCurrency;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选项1
	 */

	@Column(name ="FDC1",nullable=true,length=32)
	public java.lang.String getFdc1(){
		return this.fdc1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选项1
	 */
	public void setFdc1(java.lang.String fdc1){
		this.fdc1 = fdc1;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  默认价格
	 */

	@Column(name ="FDEFAULT_PRICE",nullable=true,length=32)
	public java.lang.Double getFdefaultPrice(){
		return this.fdefaultPrice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  默认价格
	 */
	public void setFdefaultPrice(java.lang.Double fdefaultPrice){
		this.fdefaultPrice = fdefaultPrice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选项2
	 */

	@Column(name ="FDP1",nullable=true,length=32)
	public java.lang.String getFdp1(){
		return this.fdp1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选项2
	 */
	public void setFdp1(java.lang.String fdp1){
		this.fdp1 = fdp1;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  约价
	 */

	@Column(name ="FCONTRACT_PRICE",nullable=true,length=32)
	public java.lang.Double getFcontractPrice(){
		return this.fcontractPrice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  约价
	 */
	public void setFcontractPrice(java.lang.Double fcontractPrice){
		this.fcontractPrice = fcontractPrice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选项3
	 */

	@Column(name ="FCP1",nullable=true,length=32)
	public java.lang.String getFcp1(){
		return this.fcp1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选项3
	 */
	public void setFcp1(java.lang.String fcp1){
		this.fcp1 = fcp1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附加说明
	 */

	@Column(name ="FINSTRUCTION",nullable=true,length=255)
	public java.lang.String getFinstruction(){
		return this.finstruction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附加说明
	 */
	public void setFinstruction(java.lang.String finstruction){
		this.finstruction = finstruction;
	}
}
