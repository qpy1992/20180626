package com.jeecg.truesf.entity;

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
 * @Description: 实际收付
 * @author onlineGenerator
 * @date 2018-08-13 13:26:02
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_truesf", schema = "")
@SuppressWarnings("serial")
public class TruesfEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**录入人*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**录入日期*/
	private java.util.Date createDate;
	/**更新人*/
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
	/**流水号*/
	@Excel(name="流水号",width=15)
	private java.lang.String fbillno;
	/**结算单位代码*/
	@Excel(name="结算单位代码",width=15)
	private java.lang.String fsettle;
	/**结算单位*/
	@Excel(name="结算单位",width=15)
	private java.lang.String fsettlename;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.lang.Double famount;
	/**收付*/
	@Excel(name="收付",width=15)
	private java.lang.String fshoufu;
	/**剩余金额*/
	@Excel(name="剩余金额",width=15)
	private java.lang.Double fremain;
	/**结算方式*/
	@Excel(name="结算方式",width=15)
	private java.lang.String fsettletype;
	/**银行账号*/
	@Excel(name="银行账号",width=15)
	private java.lang.String fbank;
	/**凭证号*/
	@Excel(name="凭证号",width=15)
	private java.lang.String fvoucher;
	/**凭证号数字*/
	@Excel(name="凭证号数字",width=15)
	private java.lang.String fvoucherno;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String fnote;
	/**凭证月*/
	@Excel(name="凭证月",width=15)
	private java.lang.String fvoumonth;
	/**凭证月编号*/
	@Excel(name="凭证月编号",width=15)
	private java.lang.String fmonthno;
	
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
	 *@return: java.lang.String  录入人
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  录入人
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
	 *@return: java.util.Date  录入日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  录入日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人
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
	 *@return: java.lang.String  流水号
	 */

	@Column(name ="FBILLNO",nullable=true,length=32)
	public java.lang.String getFbillno(){
		return this.fbillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流水号
	 */
	public void setFbillno(java.lang.String fbillno){
		this.fbillno = fbillno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位代码
	 */

	@Column(name ="FSETTLE",nullable=true,length=32)
	public java.lang.String getFsettle(){
		return this.fsettle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位代码
	 */
	public void setFsettle(java.lang.String fsettle){
		this.fsettle = fsettle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位
	 */

	@Column(name ="FSETTLENAME",nullable=true,length=32)
	public java.lang.String getFsettlename(){
		return this.fsettlename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位
	 */
	public void setFsettlename(java.lang.String fsettlename){
		this.fsettlename = fsettlename;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  金额
	 */

	@Column(name ="FAMOUNT",nullable=true,length=32)
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
	 *@return: java.lang.String  收付
	 */

	@Column(name ="FSHOUFU",nullable=true,length=32)
	public java.lang.String getFshoufu(){
		return this.fshoufu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收付
	 */
	public void setFshoufu(java.lang.String fshoufu){
		this.fshoufu = fshoufu;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  剩余金额
	 */

	@Column(name ="FREMAIN",nullable=true,length=32)
	public java.lang.Double getFremain(){
		return this.fremain;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  剩余金额
	 */
	public void setFremain(java.lang.Double fremain){
		this.fremain = fremain;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算方式
	 */

	@Column(name ="FSETTLETYPE",nullable=true,length=32)
	public java.lang.String getFsettletype(){
		return this.fsettletype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算方式
	 */
	public void setFsettletype(java.lang.String fsettletype){
		this.fsettletype = fsettletype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  银行账号
	 */

	@Column(name ="FBANK",nullable=true,length=32)
	public java.lang.String getFbank(){
		return this.fbank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  银行账号
	 */
	public void setFbank(java.lang.String fbank){
		this.fbank = fbank;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  凭证号
	 */

	@Column(name ="FVOUCHER",nullable=true,length=32)
	public java.lang.String getFvoucher(){
		return this.fvoucher;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  凭证号
	 */
	public void setFvoucher(java.lang.String fvoucher){
		this.fvoucher = fvoucher;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  凭证号数字
	 */

	@Column(name ="FVOUCHERNO",nullable=true,length=32)
	public java.lang.String getFvoucherno(){
		return this.fvoucherno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  凭证号数字
	 */
	public void setFvoucherno(java.lang.String fvoucherno){
		this.fvoucherno = fvoucherno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="FNOTE",nullable=true,length=255)
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
	 *@return: java.lang.String  凭证月
	 */

	@Column(name ="FVOUMONTH",nullable=true,length=32)
	public java.lang.String getFvoumonth(){
		return this.fvoumonth;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  凭证月
	 */
	public void setFvoumonth(java.lang.String fvoumonth){
		this.fvoumonth = fvoumonth;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  凭证月编号
	 */

	@Column(name ="FMONTHNO",nullable=true,length=32)
	public java.lang.String getFmonthno(){
		return this.fmonthno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  凭证月编号
	 */
	public void setFmonthno(java.lang.String fmonthno){
		this.fmonthno = fmonthno;
	}
}
