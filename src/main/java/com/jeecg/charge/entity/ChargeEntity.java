package com.jeecg.charge.entity;

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
 * @Description: 费用
 * @author onlineGenerator
 * @date 2018-08-15 13:38:45
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_charge", schema = "")
@SuppressWarnings("serial")
public class ChargeEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**审核*/
	private java.lang.String fcheck;
	/**审核人*/
	private java.lang.String fchecker;
	/**收付*/
	@Excel(name="收付",width=15,dicCode="shoufu")
	private java.lang.String fshoufu;
	/**费用种类*/
	@Excel(name="费用种类",width=15)
	private java.lang.String fcost;
	/**费用种类名称*/
	@Excel(name="费用种类名称",width=15)
	private java.lang.String fcostname;
	/**结算单位*/
	@Excel(name="结算单位",width=15)
	private java.lang.String fsettle;
	/**结算单位名称*/
	@Excel(name="结算单位名称",width=15)
	private java.lang.String fsettlename;
	/**单位*/
	@Excel(name="单位",width=15)
	private java.lang.String funit;
	/**单价*/
	@Excel(name="单价",width=15)
	private java.lang.Double fprice;
	/**币别*/
	@Excel(name="币别",width=15)
	private java.lang.String fbibie;
	/**汇率*/
	@Excel(name="汇率",width=15)
	private java.lang.Double fhuilv;
	/**数量*/
	@Excel(name="数量",width=15)
	private java.lang.Double fqty;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.lang.Double famount;
	/**收付金额*/
	@Excel(name="收付金额",width=15)
	private java.lang.Double fsfamount;
	/**本位币金额*/
	@Excel(name="本位币金额",width=15)
	private java.lang.Double fbwamount;
	/**代垫*/
	@Excel(name="代垫",width=15)
	private java.lang.String fdd;
	/**录入人*/
	private java.lang.String createName;
	/**录入日期*/
	private java.util.Date createDate;
	/**更新人*/
	private java.lang.String updateName;
	/**更新日期*/
	private java.util.Date updateDate;
	/**主表主键*/
	private java.lang.String fid;
	/**来源*/
	private java.lang.String forigin;
	/**开票*/
	private java.lang.String fkp;
	/**已开金额*/
	private java.lang.String fykamount;
	/**报销*/
	private java.lang.String fbx;
	/**对账*/
	private java.lang.String fdz;
	/**核销*/
	private java.lang.String fhx;
	/**核销金额*/
	private java.lang.Double fhxamount;
	/**本次余额*/
	private java.lang.Double fremain;
	/**实际收付*/
	private java.lang.Double fshiji;
	/**集装箱id*/
	private java.lang.String conid;
	/**审核日期*/
	private java.util.Date fcheckdate;

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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用种类
	 */

	@Column(name ="FCOST",nullable=true,length=32)
	public java.lang.String getFcost(){
		return this.fcost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类
	 */
	public void setFcost(java.lang.String fcost){
		this.fcost = fcost;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用种类名称
	 */

	@Column(name ="FCOSTNAME",nullable=true,length=32)
	public java.lang.String getFcostname(){
		return this.fcostname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类名称
	 */
	public void setFcostname(java.lang.String fcostname){
		this.fcostname = fcostname;
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

	@Column(name ="FSETTLENAME",nullable=true,length=32)
	public java.lang.String getFsettlename(){
		return this.fsettlename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位名称
	 */
	public void setFsettlename(java.lang.String fsettlename){
		this.fsettlename = fsettlename;
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

	@Column(name ="FPRICE",nullable=true,length=32)
	public java.lang.Double getFprice(){
		return this.fprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  单价
	 */
	public void setFprice(java.lang.Double fprice){
		this.fprice = fprice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  币别
	 */

	@Column(name ="FBIBIE",nullable=true,length=32)
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
	 *@return: java.lang.Double  汇率
	 */

	@Column(name ="FHUILV",nullable=true,length=32)
	public java.lang.Double getFhuilv(){
		return this.fhuilv;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  汇率
	 */
	public void setFhuilv(java.lang.Double fhuilv){
		this.fhuilv = fhuilv;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  数量
	 */

	@Column(name ="FQTY",nullable=true,length=32)
	public java.lang.Double getFqty(){
		return this.fqty;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  数量
	 */
	public void setFqty(java.lang.Double fqty){
		this.fqty = fqty;
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
	 *@return: java.lang.Double  收付金额
	 */

	@Column(name ="FSFAMOUNT",nullable=true,length=32)
	public java.lang.Double getFsfamount(){
		return this.fsfamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  收付金额
	 */
	public void setFsfamount(java.lang.Double fsfamount){
		this.fsfamount = fsfamount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  本位币金额
	 */

	@Column(name ="FBWAMOUNT",nullable=true,length=32)
	public java.lang.Double getFbwamount(){
		return this.fbwamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  本位币金额
	 */
	public void setFbwamount(java.lang.Double fbwamount){
		this.fbwamount = fbwamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代垫
	 */

	@Column(name ="FDD",nullable=true,length=32)
	public java.lang.String getFdd(){
		return this.fdd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代垫
	 */
	public void setFdd(java.lang.String fdd){
		this.fdd = fdd;
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
	 *@return: java.lang.String  主表主键
	 */

	@Column(name ="FID",nullable=true,length=32)
	public java.lang.String getFid(){
		return this.fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表主键
	 */
	public void setFid(java.lang.String fid){
		this.fid = fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  来源
	 */

	@Column(name ="FORIGIN",nullable=true,length=32)
	public java.lang.String getForigin(){
		return this.forigin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来源
	 */
	public void setForigin(java.lang.String forigin){
		this.forigin = forigin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开票
	 */

	@Column(name ="FKP",nullable=true,length=32)
	public java.lang.String getFkp(){
		return this.fkp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开票
	 */
	public void setFkp(java.lang.String fkp){
		this.fkp = fkp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  已开金额
	 */

	@Column(name ="FYKAMOUNT",nullable=true,length=32)
	public java.lang.String getFykamount(){
		return this.fykamount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  已开金额
	 */
	public void setFykamount(java.lang.String fykamount){
		this.fykamount = fykamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报销
	 */

	@Column(name ="FBX",nullable=true,length=32)
	public java.lang.String getFbx(){
		return this.fbx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报销
	 */
	public void setFbx(java.lang.String fbx){
		this.fbx = fbx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对账
	 */

	@Column(name ="FDZ",nullable=true,length=32)
	public java.lang.String getFdz(){
		return this.fdz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对账
	 */
	public void setFdz(java.lang.String fdz){
		this.fdz = fdz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  核销
	 */

	@Column(name ="FHX",nullable=true,length=32)
	public java.lang.String getFhx(){
		return this.fhx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  核销
	 */
	public void setFhx(java.lang.String fhx){
		this.fhx = fhx;
	}

	@Column(name="FHXAMOUNT",nullable=true)
	public Double getFhxamount() {
		return fhxamount;
	}

	public void setFhxamount(Double fhxamount) {
		this.fhxamount = fhxamount;
	}

	@Column(name="FREMAIN",nullable = true)
	public Double getFremain() {
		return fremain;
	}

	public void setFremain(Double fremain) {
		this.fremain = fremain;
	}

	@Column(name="FSHIJI",nullable = true)
	public Double getFshiji() {
		return fshiji;
	}

	public void setFshiji(Double fshiji) {
		this.fshiji = fshiji;
	}

	@Column(name="conid",nullable = true,length = 32)
	public String getConid() {
		return conid;
	}

	public void setConid(String conid) {
		this.conid = conid;
	}

	@Column(name="fcheckdate",length=32)
	public Date getFcheckdate() {
		return fcheckdate;
	}

	public void setFcheckdate(Date fcheckdate) {
		this.fcheckdate = fcheckdate;
	}
}
