package com.jeecg.hexiao.entity;

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
 * @Description: 应收应付核销
 * @author onlineGenerator
 * @date 2018-08-13 10:56:03
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_hexiao", schema = "")
@SuppressWarnings("serial")
public class HexiaoEntity implements java.io.Serializable {
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
	/**核销状态*/
	@Excel(name="核销状态",width=15)
	private  java.lang.String fstatus;
	/**核销金额*/
	@Excel(name="核销金额",width=15)
	private java.lang.Double fhxamount;
	/**本次余额*/
	@Excel(name="本次余额",width=15)
	private java.lang.Double fbcamount;
	/**实际收付金额*/
	@Excel(name="实际收付金额",width=15)
	private java.lang.Double factualamount;
	private java.lang.String fsettle;
	private java.lang.String fpayer;
	private java.lang.String fcost;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.lang.Double famount;
	/**实际金额*/
	@Excel(name="实际金额",width=15)
	private java.lang.Double ftrueamount;
	/**代垫*/
	@Excel(name="代垫",width=15)
	private java.lang.String fdaidian;
	/**约号*/
	@Excel(name="约号",width=15)
	private java.lang.String fyuehao;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String fnote;
	/**发票号*/
	@Excel(name="发票号",width=15)
	private java.lang.String ffapiao;
	/**审核*/
	@Excel(name="审核",width=15)
	private java.lang.String fcheck;
	/**额定金额*/
	@Excel(name="额定金额",width=15)
	private java.lang.Double feding;
	/**委托号*/
	@Excel(name="委托号",width=15)
	private java.lang.String fweituo;
	/**委托单位*/
	@Excel(name="委托单位",width=15)
	private java.lang.String fwtunit;
	/**派车单号*/
	@Excel(name="派车单号",width=15)
	private java.lang.String fpaiche;
	/**提单号*/
	@Excel(name="提单号",width=15)
	private java.lang.String ftidan;
	/**箱号*/
	@Excel(name="箱号",width=15)
	private java.lang.String fboxno;
	private java.lang.String ftype;
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

	@Column(name ="FSTATUS",nullable=true,length=32)
	public String getFstatus() {
		return fstatus;
	}

	public void setFstatus(String fstatus) {
		this.fstatus = fstatus;
	}

	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  核销金额
	 */
	@Column(name ="FHXAMOUNT",nullable=true,length=32)
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
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  本次余额
	 */

	@Column(name ="FBCAMOUNT",nullable=true,length=32)
	public java.lang.Double getFbcamount(){
		return this.fbcamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  本次余额
	 */
	public void setFbcamount(java.lang.Double fbcamount){
		this.fbcamount = fbcamount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实际收付金额
	 */

	@Column(name ="FACTUALAMOUNT",nullable=true,length=32)
	public java.lang.Double getFactualamount(){
		return this.factualamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实际收付金额
	 */
	public void setFactualamount(java.lang.Double factualamount){
		this.factualamount = factualamount;
	}

	@Column(name ="FSETTLE",nullable=true,length=32)
	public String getFsettle() {
		return fsettle;
	}

	public void setFsettle(String fsettle) {
		this.fsettle = fsettle;
	}

	@Column(name ="FPAYER",nullable=true,length=32)
	public String getFpayer() {
		return fpayer;
	}

	public void setFpayer(String fpayer) {
		this.fpayer = fpayer;
	}

	@Column(name ="FCOST",nullable=true,length=32)
	public String getFcost() {
		return fcost;
	}

	public void setFcost(String fcost) {
		this.fcost = fcost;
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
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实际金额
	 */

	@Column(name ="FTRUEAMOUNT",nullable=true,length=32)
	public java.lang.Double getFtrueamount(){
		return this.ftrueamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实际金额
	 */
	public void setFtrueamount(java.lang.Double ftrueamount){
		this.ftrueamount = ftrueamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代垫
	 */

	@Column(name ="FDAIDIAN",nullable=true,length=32)
	public java.lang.String getFdaidian(){
		return this.fdaidian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代垫
	 */
	public void setFdaidian(java.lang.String fdaidian){
		this.fdaidian = fdaidian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  约号
	 */

	@Column(name ="FYUEHAO",nullable=true,length=32)
	public java.lang.String getFyuehao(){
		return this.fyuehao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  约号
	 */
	public void setFyuehao(java.lang.String fyuehao){
		this.fyuehao = fyuehao;
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
	 *@return: java.lang.String  发票号
	 */

	@Column(name ="FFAPIAO",nullable=true,length=32)
	public java.lang.String getFfapiao(){
		return this.ffapiao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票号
	 */
	public void setFfapiao(java.lang.String ffapiao){
		this.ffapiao = ffapiao;
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
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  额定金额
	 */

	@Column(name ="FEDING",nullable=true,length=32)
	public java.lang.Double getFeding(){
		return this.feding;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  额定金额
	 */
	public void setFeding(java.lang.Double feding){
		this.feding = feding;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  委托号
	 */

	@Column(name ="FWEITUO",nullable=true,length=32)
	public java.lang.String getFweituo(){
		return this.fweituo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托号
	 */
	public void setFweituo(java.lang.String fweituo){
		this.fweituo = fweituo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  委托单位
	 */

	@Column(name ="FWTUNIT",nullable=true,length=32)
	public java.lang.String getFwtunit(){
		return this.fwtunit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托单位
	 */
	public void setFwtunit(java.lang.String fwtunit){
		this.fwtunit = fwtunit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单号
	 */

	@Column(name ="FPAICHE",nullable=true,length=32)
	public java.lang.String getFpaiche(){
		return this.fpaiche;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单号
	 */
	public void setFpaiche(java.lang.String fpaiche){
		this.fpaiche = fpaiche;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提单号
	 */

	@Column(name ="FTIDAN",nullable=true,length=32)
	public java.lang.String getFtidan(){
		return this.ftidan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提单号
	 */
	public void setFtidan(java.lang.String ftidan){
		this.ftidan = ftidan;
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

	@Column(name ="FTYPE",nullable=true,length=32)
	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
}
