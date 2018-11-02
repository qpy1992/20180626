package com.jeecg.fapiao.entity;

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
 * @Description: 运输发票
 * @author onlineGenerator
 * @date 2018-08-13 09:38:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_fapiao", schema = "")
@SuppressWarnings("serial")
public class FapiaoEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**录入人*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**录入时间*/
	private java.util.Date createDate;
	/**更新人*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新时间*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**发票号码*/
	@Excel(name="发票号码",width=15)
	private java.lang.String fbillno;
	/**结算单位代码*/
	@Excel(name="结算单位代码",width=15)
	private java.lang.String fsettle;
	/**发票抬头*/
	@Excel(name="发票抬头",width=15)
	private java.lang.String ftaitou;
	/**签发日期*/
	@Excel(name="签发日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date fqfdate;
	/**税号*/
	@Excel(name="税号",width=15)
	private java.lang.String fshuihao;
	/**作废*/
	@Excel(name="作废",width=15)
	private java.lang.String fvoid;
	/**作废人*/
	@Excel(name="作废人",width=15)
	private java.lang.String fvoidman;
	/**作废时间*/
	@Excel(name="作废时间",width=15)
	private java.lang.String fvoidtime;
	/**锁定*/
	@Excel(name="锁定",width=15)
	private java.lang.String flock;
	/**信用日期*/
	@Excel(name="信用日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date fxydate;
	/**币种*/
	@Excel(name="币种",width=15)
	private java.lang.String fbibie;
	/**委托编号*/
	@Excel(name="委托编号",width=15)
	private java.lang.String fweituo;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.lang.Double famount;
	/**实际金额*/
	@Excel(name="实际金额",width=15)
	private java.lang.Double factualamount;
	/**输出*/
	@Excel(name="输出",width=15)
	private java.lang.String fputout;
	/**锁定人*/
	@Excel(name="锁定人",width=15)
	private java.lang.String flockman;
	/**锁定时间*/
	@Excel(name="锁定时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date flocktime;
	/**领用日期*/
	@Excel(name="领用日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date flydate;
	/**参考号*/
	@Excel(name="参考号",width=15)
	private java.lang.String fcankao;
	/**委托单位*/
	@Excel(name="委托单位",width=15)
	private java.lang.String fwtunit;
	/**审核*/
	@Excel(name="审核",width=15)
	private java.lang.String fcheck;
	/**提单号*/
	@Excel(name="提单号",width=15)
	private java.lang.String ftidan;
	/**红冲*/
	@Excel(name="红冲",width=15)
	private java.lang.String fred;
	/**红冲说明*/
	@Excel(name="红冲说明",width=15)
	private java.lang.String frednote;
	/**附加说明*/
	@Excel(name="附加说明",width=15)
	private java.lang.String ffujia;
	
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
	 *@return: java.util.Date  录入时间
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  录入时间
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
	 *@return: java.util.Date  更新时间
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
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
	 *@return: java.lang.String  发票号码
	 */

	@Column(name ="FBILLNO",nullable=true,length=32)
	public java.lang.String getFbillno(){
		return this.fbillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票号码
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
	 *@return: java.lang.String  发票抬头
	 */

	@Column(name ="FTAITOU",nullable=true,length=32)
	public java.lang.String getFtaitou(){
		return this.ftaitou;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票抬头
	 */
	public void setFtaitou(java.lang.String ftaitou){
		this.ftaitou = ftaitou;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签发日期
	 */

	@Column(name ="FQFDATE",nullable=true,length=32)
	public java.util.Date getFqfdate(){
		return this.fqfdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  签发日期
	 */
	public void setFqfdate(java.util.Date fqfdate){
		this.fqfdate = fqfdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  税号
	 */

	@Column(name ="FSHUIHAO",nullable=true,length=32)
	public java.lang.String getFshuihao(){
		return this.fshuihao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  税号
	 */
	public void setFshuihao(java.lang.String fshuihao){
		this.fshuihao = fshuihao;
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
	 *@return: java.lang.String  作废人
	 */

	@Column(name ="FVOIDMAN",nullable=true,length=32)
	public java.lang.String getFvoidman(){
		return this.fvoidman;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作废人
	 */
	public void setFvoidman(java.lang.String fvoidman){
		this.fvoidman = fvoidman;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作废时间
	 */

	@Column(name ="FVOIDTIME",nullable=true,length=32)
	public java.lang.String getFvoidtime(){
		return this.fvoidtime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作废时间
	 */
	public void setFvoidtime(java.lang.String fvoidtime){
		this.fvoidtime = fvoidtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  锁定
	 */

	@Column(name ="FLOCK",nullable=true,length=32)
	public java.lang.String getFlock(){
		return this.flock;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  锁定
	 */
	public void setFlock(java.lang.String flock){
		this.flock = flock;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  信用日期
	 */

	@Column(name ="FXYDATE",nullable=true,length=32)
	public java.util.Date getFxydate(){
		return this.fxydate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  信用日期
	 */
	public void setFxydate(java.util.Date fxydate){
		this.fxydate = fxydate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  币种
	 */

	@Column(name ="FBIBIE",nullable=true,length=32)
	public java.lang.String getFbibie(){
		return this.fbibie;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  币种
	 */
	public void setFbibie(java.lang.String fbibie){
		this.fbibie = fbibie;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  委托编号
	 */

	@Column(name ="FWEITUO",nullable=true,length=32)
	public java.lang.String getFweituo(){
		return this.fweituo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托编号
	 */
	public void setFweituo(java.lang.String fweituo){
		this.fweituo = fweituo;
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

	@Column(name ="FACTUALAMOUNT",nullable=true,length=32)
	public java.lang.Double getFactualamount(){
		return this.factualamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实际金额
	 */
	public void setFactualamount(java.lang.Double factualamount){
		this.factualamount = factualamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  输出
	 */

	@Column(name ="FPUTOUT",nullable=true,length=32)
	public java.lang.String getFputout(){
		return this.fputout;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  输出
	 */
	public void setFputout(java.lang.String fputout){
		this.fputout = fputout;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  锁定人
	 */

	@Column(name ="FLOCKMAN",nullable=true,length=32)
	public java.lang.String getFlockman(){
		return this.flockman;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  锁定人
	 */
	public void setFlockman(java.lang.String flockman){
		this.flockman = flockman;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  锁定时间
	 */

	@Column(name ="FLOCKTIME",nullable=true,length=32)
	public java.util.Date getFlocktime(){
		return this.flocktime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  锁定时间
	 */
	public void setFlocktime(java.util.Date flocktime){
		this.flocktime = flocktime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  领用日期
	 */

	@Column(name ="FLYDATE",nullable=true,length=32)
	public java.util.Date getFlydate(){
		return this.flydate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  领用日期
	 */
	public void setFlydate(java.util.Date flydate){
		this.flydate = flydate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参考号
	 */

	@Column(name ="FCANKAO",nullable=true,length=32)
	public java.lang.String getFcankao(){
		return this.fcankao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参考号
	 */
	public void setFcankao(java.lang.String fcankao){
		this.fcankao = fcankao;
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
	 *@return: java.lang.String  红冲
	 */

	@Column(name ="FRED",nullable=true,length=32)
	public java.lang.String getFred(){
		return this.fred;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  红冲
	 */
	public void setFred(java.lang.String fred){
		this.fred = fred;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  红冲说明
	 */

	@Column(name ="FREDNOTE",nullable=true,length=255)
	public java.lang.String getFrednote(){
		return this.frednote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  红冲说明
	 */
	public void setFrednote(java.lang.String frednote){
		this.frednote = frednote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附加说明
	 */

	@Column(name ="FFUJIA",nullable=true,length=255)
	public java.lang.String getFfujia(){
		return this.ffujia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附加说明
	 */
	public void setFfujia(java.lang.String ffujia){
		this.ffujia = ffujia;
	}
}
