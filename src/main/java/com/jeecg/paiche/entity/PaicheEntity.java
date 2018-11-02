package com.jeecg.paiche.entity;

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
 * @Description: 统一派车单管理
 * @author onlineGenerator
 * @date 2018-07-31 15:13:01
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_paiche", schema = "")
@SuppressWarnings("serial")
public class PaicheEntity implements java.io.Serializable {
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
	/**派车单号*/
	@Excel(name="派车单号",width=15)
	private java.lang.String fbillno;
	/**车辆编号*/
	@Excel(name="车辆编号",width=15)
	private java.lang.String fcarcode;
	/**车牌号*/
	@Excel(name="车牌号",width=15)
	private java.lang.String fcarno;
	/**运输时间*/
	@Excel(name="运输时间",width=15)
	private java.util.Date ftranstime;
	/**类型*/
	@Excel(name="类型",width=15)
	private java.lang.String ftype;
	/**已报销*/
	@Excel(name="已报销",width=15)
	private java.lang.String fbaoxiao;
	/**主司机*/
	@Excel(name="主司机",width=15)
	private java.lang.String fdriver;
	/**双拖*/
	@Excel(name="双拖",width=15)
	private java.lang.String ftype2;
	/**套箱*/
	private java.lang.String ftaoxiang;
	/**直装*/
	private java.lang.String fzhizhuang;
	/**外委*/
	private java.lang.String fwaiwei;
	/**继续业务*/
	private java.lang.String ftype3;
	/**抢修*/
	private java.lang.String ftype4;
	/**回程配载*/
	private java.lang.String ftype5;
	/**副司机*/
	@Excel(name="副司机",width=15)
	private java.lang.String fdriver2;
	/**状态*/
	@Excel(name="状态",width=15)
	private java.lang.String fstatus;
	/**门点*/
	@Excel(name="门点",width=15)
	private java.lang.String fdoorpoint;
	/**运输方式*/
	@Excel(name="运输方式",width=15)
	private java.lang.String ftranstype;
	/**货重*/
	@Excel(name="货重",width=15)
	private java.lang.String fweight;
	/**皮重*/
	@Excel(name="皮重",width=15)
	private java.lang.String fweight2;
	/**出场路码*/
	@Excel(name="出场路码",width=15)
	private java.lang.String fcccode;
	/**进场路码*/
	@Excel(name="进场路码",width=15)
	private java.lang.String fjccode;
	/**起始地*/
	@Excel(name="起始地",width=15)
	private java.lang.String fstart;
	/**终止地*/
	@Excel(name="终止地",width=15)
	private java.lang.String fend;
	/**运输要求*/
	@Excel(name="运输要求",width=15)
	private java.lang.String frequire;
	/**路桥费*/
	@Excel(name="路桥费",width=15)
	private java.lang.Double fluqiao;
	/**打单费*/
	@Excel(name="打单费",width=15)
	private java.lang.Double fdadan;
	/**上下车费*/
	@Excel(name="上下车费",width=15)
	private java.lang.Double fshangxia;
	/**封子费*/
	@Excel(name="封子费",width=15)
	private java.lang.Double ffengzi;
	/**调箱门费*/
	@Excel(name="调箱门费",width=15)
	private java.lang.Double fdiaoxiang;
	/**预录费*/
	@Excel(name="预录费",width=15)
	private java.lang.Double fyulu;
	/**总油耗*/
	@Excel(name="总油耗",width=15)
	private java.lang.Double fyouhao;
	/**油价*/
	@Excel(name="油价",width=15)
	private java.lang.Double fyoujia;
	/**油耗*/
	@Excel(name="油耗",width=15)
	private java.lang.Double fyoufei;
	/**正司机提成*/
	@Excel(name="正司机提成",width=15)
	private java.lang.Double fdriver3;
	/**市内补贴*/
	@Excel(name="市内补贴",width=15)
	private java.lang.Double fshinei;
	/**副司机提成*/
	@Excel(name="副司机提成",width=15)
	private java.lang.Double fdriver4;
	/**回单时间*/
	@Excel(name="回单时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fhdtime;
	/**设备交接单*/
	@Excel(name="设备交接单",width=15)
	private java.lang.String fshebei;
	/**签收单*/
	@Excel(name="签收单",width=15)
	private java.lang.String fqianshou;
	/**预录单*/
	@Excel(name="预录单",width=15)
	private java.lang.String fyuluno;
	/**装箱单*/
	@Excel(name="装箱单",width=15)
	private java.lang.String fzhaungxiang;
	/**白卡*/
	@Excel(name="白卡",width=15)
	private java.lang.String fbaika;
	private java.lang.String fbanci;
	private java.lang.String fgcbillno;
	private java.lang.String fcheck;
	private java.lang.String fchecker;
	private java.util.Date fcheckdate;
	private java.lang.String fboxid;

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
	 *@return: java.lang.String  派车单号
	 */

	@Column(name ="FBILLNO",nullable=true,length=32)
	public java.lang.String getFbillno(){
		return this.fbillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单号
	 */
	public void setFbillno(java.lang.String fbillno){
		this.fbillno = fbillno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车辆编号
	 */

	@Column(name ="FCARCODE",nullable=true,length=32)
	public java.lang.String getFcarcode(){
		return this.fcarcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车辆编号
	 */
	public void setFcarcode(java.lang.String fcarcode){
		this.fcarcode = fcarcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车牌号
	 */

	@Column(name ="FCARNO",nullable=true,length=32)
	public java.lang.String getFcarno(){
		return this.fcarno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车牌号
	 */
	public void setFcarno(java.lang.String fcarno){
		this.fcarno = fcarno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输时间
	 */

	@Column(name ="FTRANSTIME",nullable=true,length=32)
	public java.util.Date getFtranstime(){
		return this.ftranstime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输时间
	 */
	public void setFtranstime(java.util.Date ftranstime){
		this.ftranstime = ftranstime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型
	 */

	@Column(name ="FTYPE",nullable=true,length=32)
	public java.lang.String getFtype(){
		return this.ftype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型
	 */
	public void setFtype(java.lang.String ftype){
		this.ftype = ftype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  已报销
	 */

	@Column(name ="FBAOXIAO",nullable=true,length=32)
	public java.lang.String getFbaoxiao(){
		return this.fbaoxiao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  已报销
	 */
	public void setFbaoxiao(java.lang.String fbaoxiao){
		this.fbaoxiao = fbaoxiao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主司机
	 */

	@Column(name ="FDRIVER",nullable=true,length=32)
	public java.lang.String getFdriver(){
		return this.fdriver;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主司机
	 */
	public void setFdriver(java.lang.String fdriver){
		this.fdriver = fdriver;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详情
	 */

	@Column(name ="FTYPE2",nullable=true,length=32)
	public java.lang.String getFtype2(){
		return this.ftype2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详情
	 */
	public void setFtype2(java.lang.String ftype2){
		this.ftype2 = ftype2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  副司机
	 */

	@Column(name ="FDRIVER2",nullable=true,length=32)
	public java.lang.String getFdriver2(){
		return this.fdriver2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  副司机
	 */
	public void setFdriver2(java.lang.String fdriver2){
		this.fdriver2 = fdriver2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */

	@Column(name ="FSTATUS",nullable=true,length=32)
	public java.lang.String getFstatus(){
		return this.fstatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setFstatus(java.lang.String fstatus){
		this.fstatus = fstatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  门点
	 */

	@Column(name ="FDOORPOINT",nullable=true,length=32)
	public java.lang.String getFdoorpoint(){
		return this.fdoorpoint;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  门点
	 */
	public void setFdoorpoint(java.lang.String fdoorpoint){
		this.fdoorpoint = fdoorpoint;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输方式
	 */

	@Column(name ="FTRANSTYPE",nullable=true,length=32)
	public java.lang.String getFtranstype(){
		return this.ftranstype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输方式
	 */
	public void setFtranstype(java.lang.String ftranstype){
		this.ftranstype = ftranstype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货重
	 */

	@Column(name ="FWEIGHT",nullable=true,length=32)
	public java.lang.String getFweight(){
		return this.fweight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货重
	 */
	public void setFweight(java.lang.String fweight){
		this.fweight = fweight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  皮重
	 */

	@Column(name ="FWEIGHT2",nullable=true,length=32)
	public java.lang.String getFweight2(){
		return this.fweight2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  皮重
	 */
	public void setFweight2(java.lang.String fweight2){
		this.fweight2 = fweight2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出场路码
	 */

	@Column(name ="FCCCODE",nullable=true,length=32)
	public java.lang.String getFcccode(){
		return this.fcccode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出场路码
	 */
	public void setFcccode(java.lang.String fcccode){
		this.fcccode = fcccode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  进场路码
	 */

	@Column(name ="FJCCODE",nullable=true,length=32)
	public java.lang.String getFjccode(){
		return this.fjccode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进场路码
	 */
	public void setFjccode(java.lang.String fjccode){
		this.fjccode = fjccode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  起始地
	 */

	@Column(name ="FSTART",nullable=true,length=32)
	public java.lang.String getFstart(){
		return this.fstart;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  起始地
	 */
	public void setFstart(java.lang.String fstart){
		this.fstart = fstart;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  终止地
	 */

	@Column(name ="FEND",nullable=true,length=32)
	public java.lang.String getFend(){
		return this.fend;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  终止地
	 */
	public void setFend(java.lang.String fend){
		this.fend = fend;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输要求
	 */

	@Column(name ="FREQUIRE",nullable=true,length=32)
	public java.lang.String getFrequire(){
		return this.frequire;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输要求
	 */
	public void setFrequire(java.lang.String frequire){
		this.frequire = frequire;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  路桥费
	 */

	@Column(name ="FLUQIAO",nullable=true,length=32)
	public java.lang.Double getFluqiao(){
		return this.fluqiao;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  路桥费
	 */
	public void setFluqiao(java.lang.Double fluqiao){
		this.fluqiao = fluqiao;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  打单费
	 */

	@Column(name ="FDADAN",nullable=true,length=32)
	public java.lang.Double getFdadan(){
		return this.fdadan;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  打单费
	 */
	public void setFdadan(java.lang.Double fdadan){
		this.fdadan = fdadan;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  上下车费
	 */

	@Column(name ="FSHANGXIA",nullable=true,length=32)
	public java.lang.Double getFshangxia(){
		return this.fshangxia;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  上下车费
	 */
	public void setFshangxia(java.lang.Double fshangxia){
		this.fshangxia = fshangxia;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  封子费
	 */

	@Column(name ="FFENGZI",nullable=true,length=32)
	public java.lang.Double getFfengzi(){
		return this.ffengzi;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  封子费
	 */
	public void setFfengzi(java.lang.Double ffengzi){
		this.ffengzi = ffengzi;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  调箱门费
	 */

	@Column(name ="FDIAOXIANG",nullable=true,length=32)
	public java.lang.Double getFdiaoxiang(){
		return this.fdiaoxiang;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  调箱门费
	 */
	public void setFdiaoxiang(java.lang.Double fdiaoxiang){
		this.fdiaoxiang = fdiaoxiang;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  预录费
	 */

	@Column(name ="FYULU",nullable=true,length=32)
	public java.lang.Double getFyulu(){
		return this.fyulu;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  预录费
	 */
	public void setFyulu(java.lang.Double fyulu){
		this.fyulu = fyulu;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  总油耗
	 */

	@Column(name ="FYOUHAO",nullable=true,length=32)
	public java.lang.Double getFyouhao(){
		return this.fyouhao;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  总油耗
	 */
	public void setFyouhao(java.lang.Double fyouhao){
		this.fyouhao = fyouhao;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  油价
	 */

	@Column(name ="FYOUJIA",nullable=true,length=32)
	public java.lang.Double getFyoujia(){
		return this.fyoujia;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  油价
	 */
	public void setFyoujia(java.lang.Double fyoujia){
		this.fyoujia = fyoujia;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  油耗
	 */

	@Column(name ="FYOUFEI",nullable=true,length=32)
	public java.lang.Double getFyoufei(){
		return this.fyoufei;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  油耗
	 */
	public void setFyoufei(java.lang.Double fyoufei){
		this.fyoufei = fyoufei;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  正司机提成
	 */

	@Column(name ="FDRIVER3",nullable=true,length=32)
	public java.lang.Double getFdriver3(){
		return this.fdriver3;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  正司机提成
	 */
	public void setFdriver3(java.lang.Double fdriver3){
		this.fdriver3 = fdriver3;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  市内补贴
	 */

	@Column(name ="FSHINEI",nullable=true,length=32)
	public java.lang.Double getFshinei(){
		return this.fshinei;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  市内补贴
	 */
	public void setFshinei(java.lang.Double fshinei){
		this.fshinei = fshinei;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  副司机提成
	 */

	@Column(name ="FDRIVER4",nullable=true,length=32)
	public java.lang.Double getFdriver4(){
		return this.fdriver4;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  副司机提成
	 */
	public void setFdriver4(java.lang.Double fdriver4){
		this.fdriver4 = fdriver4;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  回单时间
	 */

	@Column(name ="FHDTIME",nullable=true,length=32)
	public java.util.Date getFhdtime(){
		return this.fhdtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  回单时间
	 */
	public void setFhdtime(java.util.Date fhdtime){
		this.fhdtime = fhdtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  设备交接单
	 */

	@Column(name ="FSHEBEI",nullable=true,length=32)
	public java.lang.String getFshebei(){
		return this.fshebei;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  设备交接单
	 */
	public void setFshebei(java.lang.String fshebei){
		this.fshebei = fshebei;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签收单
	 */

	@Column(name ="FQIANSHOU",nullable=true,length=32)
	public java.lang.String getFqianshou(){
		return this.fqianshou;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签收单
	 */
	public void setFqianshou(java.lang.String fqianshou){
		this.fqianshou = fqianshou;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预录单
	 */

	@Column(name ="FYULUNO",nullable=true,length=32)
	public java.lang.String getFyuluno(){
		return this.fyuluno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预录单
	 */
	public void setFyuluno(java.lang.String fyuluno){
		this.fyuluno = fyuluno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装箱单
	 */

	@Column(name ="FZHAUNGXIANG",nullable=true,length=32)
	public java.lang.String getFzhaungxiang(){
		return this.fzhaungxiang;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装箱单
	 */
	public void setFzhaungxiang(java.lang.String fzhaungxiang){
		this.fzhaungxiang = fzhaungxiang;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  白卡
	 */

	@Column(name ="FBAIKA",nullable=true,length=32)
	public java.lang.String getFbaika(){
		return this.fbaika;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  白卡
	 */
	public void setFbaika(java.lang.String fbaika){
		this.fbaika = fbaika;
	}

	@Column(name ="FBANCI",nullable=true,length=32)
	public String getFbanci() {
		return fbanci;
	}

	public void setFbanci(String fbanci) {
		this.fbanci = fbanci;
	}

	@Column(name ="FTYPE3",nullable=true,length=32)
	public String getFtype3() {
		return ftype3;
	}

	public void setFtype3(String ftype3) {
		this.ftype3 = ftype3;
	}

	@Column(name ="FTYPE4",nullable=true,length=32)
	public String getFtype4() {
		return ftype4;
	}

	public void setFtype4(String ftype4) {
		this.ftype4 = ftype4;
	}

	@Column(name ="FTYPE5",nullable=true,length=32)
	public String getFtype5() {
		return ftype5;
	}

	public void setFtype5(String ftype5) {
		this.ftype5 = ftype5;
	}

	@Column(name ="FGCBILLNO",nullable=true,length=32)
	public String getFgcbillno() {
		return fgcbillno;
	}

	public void setFgcbillno(String fgcbillno) {
		this.fgcbillno = fgcbillno;
	}

	@Column(name ="FTAOXIANG",nullable=true,length=32)
	public String getFtaoxiang() {
		return ftaoxiang;
	}

	public void setFtaoxiang(String ftaoxiang) {
		this.ftaoxiang = ftaoxiang;
	}

	@Column(name ="FZHIZHUANG",nullable=true,length=32)
	public String getFzhizhuang() {
		return fzhizhuang;
	}

	public void setFzhizhuang(String fzhizhuang) {
		this.fzhizhuang = fzhizhuang;
	}

	@Column(name ="FWAIWEI",nullable=true,length=32)
	public String getFwaiwei() {
		return fwaiwei;
	}

	public void setFwaiwei(String fwaiwei) {
		this.fwaiwei = fwaiwei;
	}

	@Column(name="FCHECK",nullable=true)
	public String getFcheck() {
		return fcheck;
	}

	public void setFcheck(String fcheck) {
		this.fcheck = fcheck;
	}

	@Column(name="FCHECKER",nullable=true)
	public String getFchecker() {
		return fchecker;
	}

	public void setFchecker(String fchecker) {
		this.fchecker = fchecker;
	}

	@Column(name="FCHECKDATE",nullable = true)
	public Date getFcheckdate() {
		return fcheckdate;
	}

	public void setFcheckdate(Date fcheckdate) {
		this.fcheckdate = fcheckdate;
	}

	@Column(name="FBOXID",nullable=true)
    public String getFboxid() {
        return fboxid;
    }

    public void setFboxid(String fboxid) {
        this.fboxid = fboxid;
    }
}
