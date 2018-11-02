package com.jeecg.lipei.entity;

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
 * @Description: 车辆保险理赔
 * @author onlineGenerator
 * @date 2018-07-11 16:17:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_lipei", schema = "")
@SuppressWarnings("serial")
public class LipeiEntity implements java.io.Serializable {
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
	/**交通事故处理单号*/
	@Excel(name="交通事故处理单号",width=15)
	private java.lang.String fjiaotong;
	/**车号*/
	@Excel(name="车号",width=15)
	private java.lang.String fcarno;
	/**驾驶员*/
	@Excel(name="驾驶员",width=15)
	private java.lang.String fname;
	/**出险时间*/
	@Excel(name="出险时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fchuxianTime;
	/**责任划分*/
	@Excel(name="责任划分",width=15)
	private java.lang.String fzeren;
	/**行程*/
	@Excel(name="行程",width=15)
	private java.lang.String fxingcheng;
	/**损失处理方式*/
	@Excel(name="损失处理方式",width=15,dicCode="sunshi")
	private java.lang.String fsschuli;
	/**内部定级*/
	@Excel(name="内部定级",width=15,dicCode="dingji")
	private java.lang.String fdingji;
	/**停运天数*/
	@Excel(name="停运天数",width=15)
	private java.lang.Integer ftyday;
	/**司机扣款*/
	@Excel(name="司机扣款",width=15)
	private java.lang.Double fkoukuan;
	/**事故总金额*/
	@Excel(name="事故总金额",width=15)
	private java.lang.Double famount;
	/**保险赔付*/
	@Excel(name="保险赔付",width=15)
	private java.lang.Double fbaoxian;
	/**自身损失*/
	@Excel(name="自身损失",width=15)
	private java.lang.Double fzssunshi;
	/**保险结算单号*/
	@Excel(name="保险结算单号",width=15)
	private java.lang.String fbxjiesuan;
	/**其他损失*/
	@Excel(name="其他损失",width=15)
	private java.lang.Double fother;
	/**保险结案时间*/
	@Excel(name="保险结案时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fjatime;
	/**第三者损失*/
	@Excel(name="第三者损失",width=15)
	private java.lang.Double fdisan;
	/**交理赔材料时间*/
	@Excel(name="交理赔材料时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fjcltime;
	/**公司预付*/
	@Excel(name="公司预付",width=15)
	private java.lang.Double fyufu;
	/**赔付时间*/
	@Excel(name="赔付时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fpeifutime;
	/**交警结案时间*/
	@Excel(name="交警结案时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fpolice;
	/**公司结案时间*/
	@Excel(name="公司结案时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fgsjatime;
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
	 *@return: java.lang.String  交通事故处理单号
	 */

	@Column(name ="FJIAOTONG",nullable=true,length=32)
	public java.lang.String getFjiaotong(){
		return this.fjiaotong;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交通事故处理单号
	 */
	public void setFjiaotong(java.lang.String fjiaotong){
		this.fjiaotong = fjiaotong;
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
	 *@return: java.lang.String  责任划分
	 */

	@Column(name ="FZEREN",nullable=true,length=32)
	public java.lang.String getFzeren(){
		return this.fzeren;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  责任划分
	 */
	public void setFzeren(java.lang.String fzeren){
		this.fzeren = fzeren;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行程
	 */

	@Column(name ="FXINGCHENG",nullable=true,length=255)
	public java.lang.String getFxingcheng(){
		return this.fxingcheng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行程
	 */
	public void setFxingcheng(java.lang.String fxingcheng){
		this.fxingcheng = fxingcheng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  损失处理方式
	 */

	@Column(name ="FSSCHULI",nullable=true,length=32)
	public java.lang.String getFsschuli(){
		return this.fsschuli;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  损失处理方式
	 */
	public void setFsschuli(java.lang.String fsschuli){
		this.fsschuli = fsschuli;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内部定级
	 */

	@Column(name ="FDINGJI",nullable=true,length=32)
	public java.lang.String getFdingji(){
		return this.fdingji;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内部定级
	 */
	public void setFdingji(java.lang.String fdingji){
		this.fdingji = fdingji;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  停运天数
	 */

	@Column(name ="FTYDAY",nullable=true,length=32)
	public java.lang.Integer getFtyday(){
		return this.ftyday;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  停运天数
	 */
	public void setFtyday(java.lang.Integer ftyday){
		this.ftyday = ftyday;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  司机扣款
	 */

	@Column(name ="FKOUKUAN",nullable=true,length=32)
	public java.lang.Double getFkoukuan(){
		return this.fkoukuan;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  司机扣款
	 */
	public void setFkoukuan(java.lang.Double fkoukuan){
		this.fkoukuan = fkoukuan;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  事故总金额
	 */

	@Column(name ="FAMOUNT",nullable=true,length=32)
	public java.lang.Double getFamount(){
		return this.famount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  事故总金额
	 */
	public void setFamount(java.lang.Double famount){
		this.famount = famount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  保险赔付
	 */

	@Column(name ="FBAOXIAN",nullable=true,length=32)
	public java.lang.Double getFbaoxian(){
		return this.fbaoxian;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  保险赔付
	 */
	public void setFbaoxian(java.lang.Double fbaoxian){
		this.fbaoxian = fbaoxian;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  自身损失
	 */

	@Column(name ="FZSSUNSHI",nullable=true,length=32)
	public java.lang.Double getFzssunshi(){
		return this.fzssunshi;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  自身损失
	 */
	public void setFzssunshi(java.lang.Double fzssunshi){
		this.fzssunshi = fzssunshi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保险结算单号
	 */

	@Column(name ="FBXJIESUAN",nullable=true,length=32)
	public java.lang.String getFbxjiesuan(){
		return this.fbxjiesuan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保险结算单号
	 */
	public void setFbxjiesuan(java.lang.String fbxjiesuan){
		this.fbxjiesuan = fbxjiesuan;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  其他损失
	 */

	@Column(name ="FOTHER",nullable=true,length=32)
	public java.lang.Double getFother(){
		return this.fother;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  其他损失
	 */
	public void setFother(java.lang.Double fother){
		this.fother = fother;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  保险结案时间
	 */

	@Column(name ="FJATIME",nullable=true,length=32)
	public java.util.Date getFjatime(){
		return this.fjatime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  保险结案时间
	 */
	public void setFjatime(java.util.Date fjatime){
		this.fjatime = fjatime;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  第三者损失
	 */

	@Column(name ="FDISAN",nullable=true,length=32)
	public java.lang.Double getFdisan(){
		return this.fdisan;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  第三者损失
	 */
	public void setFdisan(java.lang.Double fdisan){
		this.fdisan = fdisan;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  交理赔材料时间
	 */

	@Column(name ="FJCLTIME",nullable=true,length=32)
	public java.util.Date getFjcltime(){
		return this.fjcltime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  交理赔材料时间
	 */
	public void setFjcltime(java.util.Date fjcltime){
		this.fjcltime = fjcltime;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  公司预付
	 */

	@Column(name ="FYUFU",nullable=true,length=32)
	public java.lang.Double getFyufu(){
		return this.fyufu;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  公司预付
	 */
	public void setFyufu(java.lang.Double fyufu){
		this.fyufu = fyufu;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  赔付时间
	 */

	@Column(name ="FPEIFUTIME",nullable=true,length=32)
	public java.util.Date getFpeifutime(){
		return this.fpeifutime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  赔付时间
	 */
	public void setFpeifutime(java.util.Date fpeifutime){
		this.fpeifutime = fpeifutime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  交警结案时间
	 */

	@Column(name ="FPOLICE",nullable=true,length=32)
	public java.util.Date getFpolice(){
		return this.fpolice;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  交警结案时间
	 */
	public void setFpolice(java.util.Date fpolice){
		this.fpolice = fpolice;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  公司结案时间
	 */

	@Column(name ="FGSJATIME",nullable=true,length=32)
	public java.util.Date getFgsjatime(){
		return this.fgsjatime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  公司结案时间
	 */
	public void setFgsjatime(java.util.Date fgsjatime){
		this.fgsjatime = fgsjatime;
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
