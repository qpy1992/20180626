package com.jeecg.diaodufee.entity;

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
 * @Description: 调度费用录入
 * @author onlineGenerator
 * @date 2018-07-06 15:35:37
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_diaodu_fee", schema = "")
@SuppressWarnings("serial")
public class DiaoduFeeEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**录入人*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**录入日期*/
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
	/**类型*/
	@Excel(name="类型",width=15)
	private java.lang.String fkind;
	/**费用种类*/
	@Excel(name="费用种类",width=15)
	private java.lang.String ftype;
	/**费用种类名称*/
	@Excel(name="费用种类名称",width=15)
	private java.lang.String fname;
	/**结算单位*/
	@Excel(name="结算单位",width=15)
	private java.lang.String fsettle;
	/**结算单位名称*/
	@Excel(name="结算单位名称",width=15)
	private java.lang.String fsettleName;
	/**单位*/
	@Excel(name="单位",width=15)
	private java.lang.String funit;
	/**单价*/
	@Excel(name="单价",width=15)
	private java.lang.Double funitprice;
	/**数量*/
	@Excel(name="数量",width=15)
	private java.lang.Integer fnumber;
	/**收付金额*/
	@Excel(name="收付金额",width=15)
	private java.lang.Double famount;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.lang.Double famount1;
	/**额定金额*/
	@Excel(name="额定金额",width=15)
	private java.lang.Double fratedamount;
	/**实际金额*/
	@Excel(name="实际金额",width=15)
	private java.lang.Double frealamount;
	/**代垫*/
	@Excel(name="代垫",width=15)
	private java.lang.Double fcushion;
	/**审核*/
	@Excel(name="审核",width=15)
	private java.lang.String fcheck;
	/**费用属性*/
	@Excel(name="费用属性",width=15)
	private java.lang.String fattribute;
	/**客户号*/
	@Excel(name="客户号",width=15)
	private java.lang.String fcustomno;
	/**附加说明*/
	@Excel(name="附加说明",width=15)
	private java.lang.String fnote;
	/**箱号*/
	@Excel(name="箱号",width=15)
	private java.lang.String fboxno;
	/**箱编号*/
	@Excel(name="箱编号",width=15)
	private java.lang.String fboxnum;
	
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
	 *@return: java.lang.String  类型
	 */

	@Column(name ="FKIND",nullable=true,length=32)
	public java.lang.String getFkind(){
		return this.fkind;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setFkind(java.lang.String fkind){
		this.fkind = fkind;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用种类
	 */

	@Column(name ="FTYPE",nullable=true,length=32)
	public java.lang.String getFtype(){
		return this.ftype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类
	 */
	public void setFtype(java.lang.String ftype){
		this.ftype = ftype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用种类名称
	 */

	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类名称
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位
	 */

	@Column(name ="FSETTLE",nullable=true,length=32)
	public java.lang.String getFsettle(){
		return this.fsettle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位
	 */
	public void setFsettle(java.lang.String fsettle){
		this.fsettle = fsettle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位名称
	 */

	@Column(name ="FSETTLE_NAME",nullable=true,length=32)
	public java.lang.String getFsettleName(){
		return this.fsettleName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位名称
	 */
	public void setFsettleName(java.lang.String fsettleName){
		this.fsettleName = fsettleName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */

	@Column(name ="FUNIT",nullable=true,length=32)
	public java.lang.String getFunit(){
		return this.funit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setFunit(java.lang.String funit){
		this.funit = funit;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  单价
	 */

	@Column(name ="FUNITPRICE",nullable=true,length=32)
	public java.lang.Double getFunitprice(){
		return this.funitprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  单价
	 */
	public void setFunitprice(java.lang.Double funitprice){
		this.funitprice = funitprice;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数量
	 */

	@Column(name ="FNUMBER",nullable=true,length=32)
	public java.lang.Integer getFnumber(){
		return this.fnumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数量
	 */
	public void setFnumber(java.lang.Integer fnumber){
		this.fnumber = fnumber;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  收付金额
	 */

	@Column(name ="FAMOUNT",nullable=true,length=32)
	public java.lang.Double getFamount(){
		return this.famount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  收付金额
	 */
	public void setFamount(java.lang.Double famount){
		this.famount = famount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  金额
	 */

	@Column(name ="FAMOUNT1",nullable=true,length=32)
	public java.lang.Double getFamount1(){
		return this.famount1;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  金额
	 */
	public void setFamount1(java.lang.Double famount1){
		this.famount1 = famount1;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  额定金额
	 */

	@Column(name ="FRATEDAMOUNT",nullable=true,length=32)
	public java.lang.Double getFratedamount(){
		return this.fratedamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  额定金额
	 */
	public void setFratedamount(java.lang.Double fratedamount){
		this.fratedamount = fratedamount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实际金额
	 */

	@Column(name ="FREALAMOUNT",nullable=true,length=32)
	public java.lang.Double getFrealamount(){
		return this.frealamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实际金额
	 */
	public void setFrealamount(java.lang.Double frealamount){
		this.frealamount = frealamount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  代垫
	 */

	@Column(name ="FCUSHION",nullable=true,length=32)
	public java.lang.Double getFcushion(){
		return this.fcushion;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  代垫
	 */
	public void setFcushion(java.lang.Double fcushion){
		this.fcushion = fcushion;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核
	 */

	@Column(name ="FCHECK",nullable=true,length=32)
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
	 *@return: java.lang.String  费用属性
	 */

	@Column(name ="FATTRIBUTE",nullable=true,length=32)
	public java.lang.String getFattribute(){
		return this.fattribute;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用属性
	 */
	public void setFattribute(java.lang.String fattribute){
		this.fattribute = fattribute;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户号
	 */

	@Column(name ="FCUSTOMNO",nullable=true,length=32)
	public java.lang.String getFcustomno(){
		return this.fcustomno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户号
	 */
	public void setFcustomno(java.lang.String fcustomno){
		this.fcustomno = fcustomno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附加说明
	 */

	@Column(name ="FNOTE",nullable=true,length=255)
	public java.lang.String getFnote(){
		return this.fnote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附加说明
	 */
	public void setFnote(java.lang.String fnote){
		this.fnote = fnote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  箱号
	 */

	@Column(name ="FBOXNO",nullable=true,length=32)
	public java.lang.String getFboxno(){
		return this.fboxno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱号
	 */
	public void setFboxno(java.lang.String fboxno){
		this.fboxno = fboxno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  箱编号
	 */

	@Column(name ="FBOXNUM",nullable=true,length=32)
	public java.lang.String getFboxnum(){
		return this.fboxnum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱编号
	 */
	public void setFboxnum(java.lang.String fboxnum){
		this.fboxnum = fboxnum;
	}
}
