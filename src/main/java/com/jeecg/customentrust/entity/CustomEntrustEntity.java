package com.jeecg.customentrust.entity;

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
 * @Description: 客户委托
 * @author onlineGenerator
 * @date 2018-08-01 16:13:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_custom_entrust", schema = "")
@SuppressWarnings("serial")
public class CustomEntrustEntity implements java.io.Serializable {
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
	/**委托号*/
	@Excel(name="委托号",width=15)
	private java.lang.String fbillno;
	/**委托单位*/
	@Excel(name="委托单位",width=15)
	private java.lang.String fentrustUnit;
	/**操作时间*/
	@Excel(name="操作时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date foperateTime;
	/**联系人*/
	@Excel(name="联系人",width=15)
	private java.lang.String fcontact;
	/**联系电话*/
	@Excel(name="联系电话",width=15)
	private java.lang.String fphone;
	/**联系手机*/
	@Excel(name="联系手机",width=15)
	private java.lang.String fmobile;
	/**联系传真*/
	@Excel(name="联系传真",width=15)
	private java.lang.String fax;
	/**业务员*/
	@Excel(name="业务员",width=15)
	private java.lang.String fsalesman;
	/**做箱类型*/
	@Excel(name="做箱类型",width=15,dicCode="box")
	private java.lang.String fboxType;
	/**业务类型*/
	@Excel(name="业务类型",width=15,dicCode="buss")
	private java.lang.String fbussType;
	/**装船港*/
	@Excel(name="装船港",width=15)
	private java.lang.String floadPort;
	/**合同号*/
	@Excel(name="合同号",width=15)
	private java.lang.String fcontractno;
	/**运输方式*/
	@Excel(name="运输方式",width=15,dicCode="trans")
	private java.lang.String ftransType;
	/**客户编码*/
	@Excel(name="客户编码",width=15)
	private java.lang.String fcusCode;
	/**中转港*/
	@Excel(name="中转港",width=15)
	private java.lang.String ftransport;
	/**船名*/
	@Excel(name="船名",width=15)
	private java.lang.String fshipname;
	/**航次*/
	@Excel(name="航次",width=15)
	private java.lang.String fvoyageno;
	/**提单号*/
	@Excel(name="提单号",width=15)
	private java.lang.String fblno;
	/**目的港*/
	@Excel(name="目的港",width=15)
	private java.lang.String ftargetport;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String fnote;
	/**委托类型*/
	@Excel(name="委托类型",width=15,dicCode="entrust")
	private java.lang.String fkinds;
	/**船公司*/
	@Excel(name="船公司",width=15)
	private java.lang.String fshipcompany;
	/**防箱公司*/
	@Excel(name="防箱公司",width=15)
	private java.lang.String fantibox;
	/**作业时间*/
	@Excel(name="作业时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fzytime;
	/**到港时间*/
	@Excel(name="到港时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date farrivetime;
	/**截港时间*/
	@Excel(name="截港时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fcuttime;
	/**分提单号*/
	@Excel(name="分提单号",width=15)
	private java.lang.String fseprano;
	/**品名*/
	@Excel(name="品名",width=15)
	private java.lang.String fname;
	/**件数*/
	@Excel(name="件数",width=15)
	private java.lang.String fqty;
	/**重量*/
	@Excel(name="重量",width=15)
	private java.lang.String fweight;
	/**体积*/
	@Excel(name="体积",width=15)
	private java.lang.String fvolume;
	/**提箱堆场*/
	@Excel(name="提箱堆场",width=15)
	private java.lang.String ftxyard;
	/**还箱堆场*/
	@Excel(name="还箱堆场",width=15)
	private java.lang.String fhxyard;
	/**货物属性*/
	@Excel(name="货物属性",width=15)
	private java.lang.String fgoodsprop;
	/**转关地址*/
	@Excel(name="转关地址",width=15)
	private java.lang.String fzgaddress;
	/**转关联系人*/
	@Excel(name="转关联系人",width=15)
	private java.lang.String fzgcontact;
	/**转关联系电话*/
	@Excel(name="转关联系电话",width=15)
	private java.lang.String fzgphone;
	private java.lang.String fcheck;
	private java.lang.String fchecker;
	private java.util.Date fcheckdate;
    /**联合国编号*/
    @Excel(name="联合国编号",width=15)
    private java.lang.String fun;
    /**闪点*/
    @Excel(name="闪点",width=15)
    private java.lang.String flash;
    /**冷藏温度*/
    @Excel(name="冷藏温度",width=15)
    private java.lang.String fcold;
    /**加热温度*/
    @Excel(name="加热温度",width=15)
    private java.lang.String fhot;
    /**危规页码*/
    @Excel(name="危规页码",width=15)
    private java.lang.String fwei;
    /**等级*/
    @Excel(name="等级",width=15)
    private java.lang.String fgrade;
    /**集装箱经营人*/
    @Excel(name="集装箱经营人",width=15)
    private java.lang.String foperator;
    /**客户id*/
    private java.lang.String cid;

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
	 *@return: java.lang.String  委托号
	 */

	@Column(name ="FBILLNO",nullable=true,length=32)
	public java.lang.String getFbillno(){
		return this.fbillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托号
	 */
	public void setFbillno(java.lang.String fbillno){
		this.fbillno = fbillno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  委托单位
	 */

	@Column(name ="FENTRUST_UNIT",nullable=true,length=32)
	public java.lang.String getFentrustUnit(){
		return this.fentrustUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托单位
	 */
	public void setFentrustUnit(java.lang.String fentrustUnit){
		this.fentrustUnit = fentrustUnit;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  操作时间
	 */

	@Column(name ="FOPERATE_TIME",nullable=true,length=32)
	public java.util.Date getFoperateTime(){
		return this.foperateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  操作时间
	 */
	public void setFoperateTime(java.util.Date foperateTime){
		this.foperateTime = foperateTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人
	 */

	@Column(name ="FCONTACT",nullable=true,length=32)
	public java.lang.String getFcontact(){
		return this.fcontact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人
	 */
	public void setFcontact(java.lang.String fcontact){
		this.fcontact = fcontact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */

	@Column(name ="FPHONE",nullable=true,length=32)
	public java.lang.String getFphone(){
		return this.fphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setFphone(java.lang.String fphone){
		this.fphone = fphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系手机
	 */

	@Column(name ="FMOBILE",nullable=true,length=32)
	public java.lang.String getFmobile(){
		return this.fmobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系手机
	 */
	public void setFmobile(java.lang.String fmobile){
		this.fmobile = fmobile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系传真
	 */

	@Column(name ="FAX",nullable=true,length=32)
	public java.lang.String getFax(){
		return this.fax;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系传真
	 */
	public void setFax(java.lang.String fax){
		this.fax = fax;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务员
	 */

	@Column(name ="FSALESMAN",nullable=true,length=32)
	public java.lang.String getFsalesman(){
		return this.fsalesman;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务员
	 */
	public void setFsalesman(java.lang.String fsalesman){
		this.fsalesman = fsalesman;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  做箱类型
	 */

	@Column(name ="FBOX_TYPE",nullable=true,length=32)
	public java.lang.String getFboxType(){
		return this.fboxType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  做箱类型
	 */
	public void setFboxType(java.lang.String fboxType){
		this.fboxType = fboxType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务类型
	 */

	@Column(name ="FBUSS_TYPE",nullable=true,length=32)
	public java.lang.String getFbussType(){
		return this.fbussType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务类型
	 */
	public void setFbussType(java.lang.String fbussType){
		this.fbussType = fbussType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装船港
	 */

	@Column(name ="FLOAD_PORT",nullable=true,length=32)
	public java.lang.String getFloadPort(){
		return this.floadPort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装船港
	 */
	public void setFloadPort(java.lang.String floadPort){
		this.floadPort = floadPort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同号
	 */

	@Column(name ="FCONTRACTNO",nullable=true,length=32)
	public java.lang.String getFcontractno(){
		return this.fcontractno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同号
	 */
	public void setFcontractno(java.lang.String fcontractno){
		this.fcontractno = fcontractno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输方式
	 */

	@Column(name ="FTRANS_TYPE",nullable=true,length=32)
	public java.lang.String getFtransType(){
		return this.ftransType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输方式
	 */
	public void setFtransType(java.lang.String ftransType){
		this.ftransType = ftransType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户编码
	 */

	@Column(name ="FCUS_CODE",nullable=true,length=32)
	public java.lang.String getFcusCode(){
		return this.fcusCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编码
	 */
	public void setFcusCode(java.lang.String fcusCode){
		this.fcusCode = fcusCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中转港
	 */

	@Column(name ="FTRANSPORT",nullable=true,length=32)
	public java.lang.String getFtransport(){
		return this.ftransport;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中转港
	 */
	public void setFtransport(java.lang.String ftransport){
		this.ftransport = ftransport;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  船名
	 */

	@Column(name ="FSHIPNAME",nullable=true,length=32)
	public java.lang.String getFshipname(){
		return this.fshipname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  船名
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提单号
	 */

	@Column(name ="FBLNO",nullable=true,length=32)
	public java.lang.String getFblno(){
		return this.fblno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提单号
	 */
	public void setFblno(java.lang.String fblno){
		this.fblno = fblno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  目的港
	 */

	@Column(name ="FTARGETPORT",nullable=true,length=32)
	public java.lang.String getFtargetport(){
		return this.ftargetport;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目的港
	 */
	public void setFtargetport(java.lang.String ftargetport){
		this.ftargetport = ftargetport;
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
	 *@return: java.lang.String  委托类型
	 */

	@Column(name ="FKINDS",nullable=true,length=32)
	public java.lang.String getFkinds(){
		return this.fkinds;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托类型
	 */
	public void setFkinds(java.lang.String fkinds){
		this.fkinds = fkinds;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  船公司
	 */

	@Column(name ="FSHIPCOMPANY",nullable=true,length=32)
	public java.lang.String getFshipcompany(){
		return this.fshipcompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  船公司
	 */
	public void setFshipcompany(java.lang.String fshipcompany){
		this.fshipcompany = fshipcompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  防箱公司
	 */

	@Column(name ="FANTIBOX",nullable=true,length=32)
	public java.lang.String getFantibox(){
		return this.fantibox;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  防箱公司
	 */
	public void setFantibox(java.lang.String fantibox){
		this.fantibox = fantibox;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  作业时间
	 */

	@Column(name ="FZYTIME",nullable=true,length=32)
	public java.util.Date getFzytime(){
		return this.fzytime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  作业时间
	 */
	public void setFzytime(java.util.Date fzytime){
		this.fzytime = fzytime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  到港时间
	 */

	@Column(name ="FARRIVETIME",nullable=true,length=32)
	public java.util.Date getFarrivetime(){
		return this.farrivetime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  到港时间
	 */
	public void setFarrivetime(java.util.Date farrivetime){
		this.farrivetime = farrivetime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  截港时间
	 */

	@Column(name ="FCUTTIME",nullable=true,length=32)
	public java.util.Date getFcuttime(){
		return this.fcuttime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  截港时间
	 */
	public void setFcuttime(java.util.Date fcuttime){
		this.fcuttime = fcuttime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分提单号
	 */

	@Column(name ="FSEPRANO",nullable=true,length=32)
	public java.lang.String getFseprano(){
		return this.fseprano;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分提单号
	 */
	public void setFseprano(java.lang.String fseprano){
		this.fseprano = fseprano;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品名
	 */

	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品名
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  件数
	 */

	@Column(name ="FQTY",nullable=true,length=32)
	public java.lang.String getFqty(){
		return this.fqty;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  件数
	 */
	public void setFqty(java.lang.String fqty){
		this.fqty = fqty;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  重量
	 */

	@Column(name ="FWEIGHT",nullable=true,length=32)
	public java.lang.String getFweight(){
		return this.fweight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  重量
	 */
	public void setFweight(java.lang.String fweight){
		this.fweight = fweight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体积
	 */

	@Column(name ="FVOLUME",nullable=true,length=32)
	public java.lang.String getFvolume(){
		return this.fvolume;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体积
	 */
	public void setFvolume(java.lang.String fvolume){
		this.fvolume = fvolume;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提箱堆场
	 */

	@Column(name ="FTXYARD",nullable=true,length=32)
	public java.lang.String getFtxyard(){
		return this.ftxyard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提箱堆场
	 */
	public void setFtxyard(java.lang.String ftxyard){
		this.ftxyard = ftxyard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  还箱堆场
	 */

	@Column(name ="FHXYARD",nullable=true,length=32)
	public java.lang.String getFhxyard(){
		return this.fhxyard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  还箱堆场
	 */
	public void setFhxyard(java.lang.String fhxyard){
		this.fhxyard = fhxyard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货物属性
	 */

	@Column(name ="FGOODSPROP",nullable=true,length=32)
	public java.lang.String getFgoodsprop(){
		return this.fgoodsprop;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货物属性
	 */
	public void setFgoodsprop(java.lang.String fgoodsprop){
		this.fgoodsprop = fgoodsprop;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  转关地址
	 */

	@Column(name ="FZGADDRESS",nullable=true,length=32)
	public java.lang.String getFzgaddress(){
		return this.fzgaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  转关地址
	 */
	public void setFzgaddress(java.lang.String fzgaddress){
		this.fzgaddress = fzgaddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  转关联系人
	 */

	@Column(name ="FZGCONTACT",nullable=true,length=32)
	public java.lang.String getFzgcontact(){
		return this.fzgcontact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  转关联系人
	 */
	public void setFzgcontact(java.lang.String fzgcontact){
		this.fzgcontact = fzgcontact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  转关联系电话
	 */

	@Column(name ="FZGPHONE",nullable=true,length=32)
	public java.lang.String getFzgphone(){
		return this.fzgphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  转关联系电话
	 */
	public void setFzgphone(java.lang.String fzgphone){
		this.fzgphone = fzgphone;
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
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  联合国编号
     */
    @Column(name ="FUN",nullable=true,length=32)
    public java.lang.String getFun(){
        return this.fun;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  联合国编号
     */
    public void setFun(java.lang.String fun){
        this.fun = fun;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  闪点
     */
    @Column(name ="FLASH",nullable=true,length=32)
    public java.lang.String getFlash(){
        return this.flash;
    }
    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  闪点
     */
    public void setFlash(java.lang.String flash){
        this.flash = flash;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  冷藏温度
     */
    @Column(name ="FCOLD",nullable=true,length=32)
    public java.lang.String getFcold(){
        return this.fcold;
    }
    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  冷藏温度
     */
    public void setFcold(java.lang.String fcold){
        this.fcold = fcold;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  加热温度
     */
    @Column(name ="FHOT",nullable=true,length=32)
    public java.lang.String getFhot(){
        return this.fhot;
    }
    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  加热温度
     */
    public void setFhot(java.lang.String fhot){
        this.fhot = fhot;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  危规页码
     */
    @Column(name ="FWEI",nullable=true,length=32)
    public java.lang.String getFwei(){
        return this.fwei;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  危规页码
     */
    public void setFwei(java.lang.String fwei){
        this.fwei = fwei;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  等级
     */
    @Column(name ="FGRADE",nullable=true,length=32)
    public java.lang.String getFgrade(){
        return this.fgrade;
    }
    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  等级
     */
    public void setFgrade(java.lang.String fgrade){
        this.fgrade = fgrade;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  集装箱经营人
     */
    @Column(name ="FOPERATOR",nullable=true,length=32)
    public java.lang.String getFoperator(){
        return this.foperator;
    }
    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  集装箱经营人
     */
    public void setFoperator(java.lang.String foperator){
        this.foperator = foperator;
    }

    @Column(name="cid",nullable=false,length=32)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
