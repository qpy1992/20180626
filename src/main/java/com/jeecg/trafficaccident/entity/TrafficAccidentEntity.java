package com.jeecg.trafficaccident.entity;

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
 * @Description: 交通事故处理
 * @author onlineGenerator
 * @date 2018-07-11 13:58:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_traffic_accident", schema = "")
@SuppressWarnings("serial")
public class TrafficAccidentEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**制单人*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**制单日期*/
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
	/**流水编码*/
	@Excel(name="流水编码",width=15)
	private java.lang.String fbillno;
	/**审核人*/
	private java.lang.String fchecker;
	/**审核时间*/
	private java.util.Date fcheckTime;
	/**路段等级*/
	@Excel(name="路段等级",width=15)
	private java.lang.String fgrade;
	/**车号*/
	@Excel(name="车号",width=15)
	private java.lang.String fcarno;
	/**出险类别*/
	@Excel(name="出险类别",width=15)
	private java.lang.String fcxtype;
	/**驾驶员*/
	@Excel(name="驾驶员",width=15)
	private java.lang.String fname;
	/**责任划分*/
	@Excel(name="责任划分",width=15)
	private java.lang.String frespon;
	/**出险时间*/
	@Excel(name="出险时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fchuxianTime;
	/**事故级别*/
	@Excel(name="事故级别",width=15)
	private java.lang.String fsggrade;
	/**出险地点*/
	@Excel(name="出险地点",width=15)
	private java.lang.String faddress;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String fnote;
	
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
	 *@return: java.lang.String  制单人
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
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
	 *@return: java.util.Date  制单日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  制单日期
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
	 *@return: java.lang.String  流水编码
	 */

	@Column(name ="FBILLNO",nullable=true,length=32)
	public java.lang.String getFbillno(){
		return this.fbillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流水编码
	 */
	public void setFbillno(java.lang.String fbillno){
		this.fbillno = fbillno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */

	@Column(name ="FCHECKER",nullable=true,length=32)
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
	 *@return: java.util.Date  审核时间
	 */

	@Column(name ="FCHECK_TIME",nullable=true,length=32)
	public java.util.Date getFcheckTime(){
		return this.fcheckTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核时间
	 */
	public void setFcheckTime(java.util.Date fcheckTime){
		this.fcheckTime = fcheckTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  路段等级
	 */

	@Column(name ="FGRADE",nullable=true,length=32)
	public java.lang.String getFgrade(){
		return this.fgrade;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  路段等级
	 */
	public void setFgrade(java.lang.String fgrade){
		this.fgrade = fgrade;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车号
	 */

	@Column(name ="FCARNO",nullable=true,length=32)
	public java.lang.String getFcarno(){
		return this.fcarno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车号
	 */
	public void setFcarno(java.lang.String fcarno){
		this.fcarno = fcarno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出险类别
	 */

	@Column(name ="FCXTYPE",nullable=true,length=32)
	public java.lang.String getFcxtype(){
		return this.fcxtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出险类别
	 */
	public void setFcxtype(java.lang.String fcxtype){
		this.fcxtype = fcxtype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶员
	 */

	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶员
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  责任划分
	 */

	@Column(name ="FRESPON",nullable=true,length=32)
	public java.lang.String getFrespon(){
		return this.frespon;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任划分
	 */
	public void setFrespon(java.lang.String frespon){
		this.frespon = frespon;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出险时间
	 */

	@Column(name ="FCHUXIAN_TIME",nullable=true,length=32)
	public java.util.Date getFchuxianTime(){
		return this.fchuxianTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出险时间
	 */
	public void setFchuxianTime(java.util.Date fchuxianTime){
		this.fchuxianTime = fchuxianTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  事故级别
	 */

	@Column(name ="FSGGRADE",nullable=true,length=32)
	public java.lang.String getFsggrade(){
		return this.fsggrade;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  事故级别
	 */
	public void setFsggrade(java.lang.String fsggrade){
		this.fsggrade = fsggrade;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出险地点
	 */

	@Column(name ="FADDRESS",nullable=true,length=32)
	public java.lang.String getFaddress(){
		return this.faddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出险地点
	 */
	public void setFaddress(java.lang.String faddress){
		this.faddress = faddress;
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
}
