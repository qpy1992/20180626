package com.jeecg.zhangdan.entity;
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
 * @Description: 应付账单明细
 * @author onlineGenerator
 * @date 2018-08-17 13:19:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_zhangdan", schema = "")
@SuppressWarnings("serial")
public class ZhangdanEntity implements java.io.Serializable {
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
	/**审核*/
    @Excel(name="审核",width=15)
	private java.lang.String fcheck;
	/**委托单号*/
    @Excel(name="委托单号",width=15)
	private java.lang.String fweituo;
	/**费用种类名称*/
    @Excel(name="费用种类名称",width=15)
	private java.lang.String fcost;
	/**应收*/
    @Excel(name="应收",width=15)
	private java.lang.String frece;
	/**结算单位*/
    @Excel(name="结算单位",width=15)
	private java.lang.String fsettle;
	/**币种*/
    @Excel(name="币种",width=15)
	private java.lang.String fcurrency;
	/**单价*/
    @Excel(name="单价",width=15)
	private java.lang.Double fprice;
	/**数量*/
    @Excel(name="数量",width=15)
	private java.lang.Double fqty;
	/**金额*/
    @Excel(name="金额",width=15)
	private java.lang.Double fjine;
	/**单位*/
    @Excel(name="单位",width=15)
	private java.lang.String funit;
	/**提单号*/
    @Excel(name="提单号",width=15)
	private java.lang.String ftidan;
	/**航名*/
    @Excel(name="航名",width=15)
	private java.lang.String fshipname;
	/**航次*/
    @Excel(name="航次",width=15)
	private java.lang.String fvoyageno;
	/**作业时间*/
    @Excel(name="作业时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date foperatetime;
	/**箱型*/
    @Excel(name="箱型",width=15)
	private java.lang.String fboxtype;
	/**主表id*/
	private java.lang.String fid;
	/**费用id*/
	private java.lang.String costid;
	
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
	 *@return: java.lang.String  委托单号
	 */
	
	@Column(name ="FWEITUO",nullable=true,length=32)
	public java.lang.String getFweituo(){
		return this.fweituo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托单号
	 */
	public void setFweituo(java.lang.String fweituo){
		this.fweituo = fweituo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用种类名称
	 */
	
	@Column(name ="FCOST",nullable=true,length=32)
	public java.lang.String getFcost(){
		return this.fcost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类名称
	 */
	public void setFcost(java.lang.String fcost){
		this.fcost = fcost;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应收
	 */
	
	@Column(name ="FRECE",nullable=true,length=32)
	public java.lang.String getFrece(){
		return this.frece;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应收
	 */
	public void setFrece(java.lang.String frece){
		this.frece = frece;
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
	 *@return: java.lang.String  币种
	 */
	
	@Column(name ="FCURRENCY",nullable=true,length=32)
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
	
	@Column(name ="FJINE",nullable=true,length=32)
	public java.lang.Double getFjine(){
		return this.fjine;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  金额
	 */
	public void setFjine(java.lang.Double fjine){
		this.fjine = fjine;
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
	 *@return: java.lang.String  航名
	 */
	
	@Column(name ="FSHIPNAME",nullable=true,length=32)
	public java.lang.String getFshipname(){
		return this.fshipname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  航名
	 */
	public void setFshipname(java.lang.String fshipname){
		this.fshipname = fshipname;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  航次
	 */
	
	@Column(name ="FVOYAGENO",nullable=true,length=32)
	public java.lang.String getFvoyageno(){
		return this.fvoyageno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  航次
	 */
	public void setFvoyageno(java.lang.String fvoyageno){
		this.fvoyageno = fvoyageno;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  作业时间
	 */
	
	@Column(name ="FOPERATETIME",nullable=true,length=32)
	public java.util.Date getFoperatetime(){
		return this.foperatetime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  作业时间
	 */
	public void setFoperatetime(java.util.Date foperatetime){
		this.foperatetime = foperatetime;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  箱型
	 */
	
	@Column(name ="FBOXTYPE",nullable=true,length=32)
	public java.lang.String getFboxtype(){
		return this.fboxtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱型
	 */
	public void setFboxtype(java.lang.String fboxtype){
		this.fboxtype = fboxtype;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主表id
	 */
	
	@Column(name ="FID",nullable=false,length=32)
	public java.lang.String getFid(){
		return this.fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表id
	 */
	public void setFid(java.lang.String fid){
		this.fid = fid;
	}

	@Column(name = "COSTID",nullable = false,length = 32)
	public String getCostid() {
		return costid;
	}

	public void setCostid(String costid) {
		this.costid = costid;
	}
}
