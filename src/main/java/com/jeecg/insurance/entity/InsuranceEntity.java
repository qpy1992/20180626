package com.jeecg.insurance.entity;

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
 * @Description: 车辆保险
 * @author onlineGenerator
 * @date 2018-07-11 13:05:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_insurance", schema = "")
@SuppressWarnings("serial")
public class InsuranceEntity implements java.io.Serializable {
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
	/**车号*/
	@Excel(name="车号",width=15)
	private java.lang.String fbillno;
	/**座位*/
	@Excel(name="座位",width=15)
	private java.lang.Double fseat;
	/**车船险*/
	@Excel(name="车船险",width=15)
	private java.lang.Double fcarInsu;
	/**交强险*/
	@Excel(name="交强险",width=15)
	private java.lang.Double fstrongInsu;
	/**交强险优惠*/
	@Excel(name="交强险优惠",width=15)
	private java.lang.Double fdiscount;
	/**交强险保单号*/
	@Excel(name="交强险保单号",width=15)
	private java.lang.String fstrongno;
	/**开始日期*/
	@Excel(name="开始日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date fstartdate;
	/**结束日期*/
	@Excel(name="结束日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date fenddate;
	/**承运险*/
	@Excel(name="承运险",width=15)
	private java.lang.Double ftransrisk;
	/**承运险优惠*/
	@Excel(name="承运险优惠",width=15)
	private java.lang.Double ftransdiscount;
	/**承运险保单号*/
	@Excel(name="承运险保单号",width=15)
	private java.lang.String ftransno;
	/**开始日期2*/
	@Excel(name="开始日期2",width=15,format = "yyyy-MM-dd")
	private java.util.Date fstart2;
	/**结束日期2*/
	@Excel(name="结束日期2",width=15,format = "yyyy-MM-dd")
	private java.util.Date fend2;
	/**三者险*/
	@Excel(name="三者险",width=15)
	private java.lang.Double fsan;
	/**车损险*/
	@Excel(name="车损险",width=15)
	private java.lang.Double fchesun;
	/**玻璃险*/
	@Excel(name="玻璃险",width=15)
	private java.lang.Double fboli;
	/**不计免赔*/
	@Excel(name="不计免赔",width=15)
	private java.lang.Double fmianpei;
	/**商业险优惠*/
	@Excel(name="商业险优惠",width=15)
	private java.lang.Double fbussdiscount;
	/**商业险保单号*/
	@Excel(name="商业险保单号",width=15)
	private java.lang.String fbussno;
	/**开始日期3*/
	@Excel(name="开始日期3",width=15,format = "yyyy-MM-dd")
	private java.util.Date fstart3;
	/**结束日期3*/
	@Excel(name="结束日期3",width=15,format = "yyyy-MM-dd")
	private java.util.Date fend3;
	/**保费合计*/
	@Excel(name="保费合计",width=15)
	private java.lang.Double ftotal;
	/**承保公司*/
	@Excel(name="承保公司",width=15)
	private java.lang.String fchengbao;
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
	 *@return: java.lang.String  车号
	 */

	@Column(name ="FBILLNO",nullable=true,length=32)
	public java.lang.String getFbillno(){
		return this.fbillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车号
	 */
	public void setFbillno(java.lang.String fbillno){
		this.fbillno = fbillno;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  座位
	 */

	@Column(name ="FSEAT",nullable=true,length=32)
	public java.lang.Double getFseat(){
		return this.fseat;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  座位
	 */
	public void setFseat(java.lang.Double fseat){
		this.fseat = fseat;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  车船险
	 */

	@Column(name ="FCAR_INSU",nullable=true,length=32)
	public java.lang.Double getFcarInsu(){
		return this.fcarInsu;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  车船险
	 */
	public void setFcarInsu(java.lang.Double fcarInsu){
		this.fcarInsu = fcarInsu;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  交强险
	 */

	@Column(name ="FSTRONG_INSU",nullable=true,length=32)
	public java.lang.Double getFstrongInsu(){
		return this.fstrongInsu;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  交强险
	 */
	public void setFstrongInsu(java.lang.Double fstrongInsu){
		this.fstrongInsu = fstrongInsu;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  交强险优惠
	 */

	@Column(name ="FDISCOUNT",nullable=true,length=32)
	public java.lang.Double getFdiscount(){
		return this.fdiscount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  交强险优惠
	 */
	public void setFdiscount(java.lang.Double fdiscount){
		this.fdiscount = fdiscount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交强险保单号
	 */

	@Column(name ="FSTRONGNO",nullable=true,length=32)
	public java.lang.String getFstrongno(){
		return this.fstrongno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交强险保单号
	 */
	public void setFstrongno(java.lang.String fstrongno){
		this.fstrongno = fstrongno;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始日期
	 */

	@Column(name ="FSTARTDATE",nullable=true,length=32)
	public java.util.Date getFstartdate(){
		return this.fstartdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始日期
	 */
	public void setFstartdate(java.util.Date fstartdate){
		this.fstartdate = fstartdate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束日期
	 */

	@Column(name ="FENDDATE",nullable=true,length=32)
	public java.util.Date getFenddate(){
		return this.fenddate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束日期
	 */
	public void setFenddate(java.util.Date fenddate){
		this.fenddate = fenddate;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  承运险
	 */

	@Column(name ="FTRANSRISK",nullable=true,length=32)
	public java.lang.Double getFtransrisk(){
		return this.ftransrisk;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  承运险
	 */
	public void setFtransrisk(java.lang.Double ftransrisk){
		this.ftransrisk = ftransrisk;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  承运险优惠
	 */

	@Column(name ="FTRANSDISCOUNT",nullable=true,length=32)
	public java.lang.Double getFtransdiscount(){
		return this.ftransdiscount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  承运险优惠
	 */
	public void setFtransdiscount(java.lang.Double ftransdiscount){
		this.ftransdiscount = ftransdiscount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承运险保单号
	 */

	@Column(name ="FTRANSNO",nullable=true,length=32)
	public java.lang.String getFtransno(){
		return this.ftransno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承运险保单号
	 */
	public void setFtransno(java.lang.String ftransno){
		this.ftransno = ftransno;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始日期2
	 */

	@Column(name ="FSTART2",nullable=true,length=32)
	public java.util.Date getFstart2(){
		return this.fstart2;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始日期2
	 */
	public void setFstart2(java.util.Date fstart2){
		this.fstart2 = fstart2;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束日期2
	 */

	@Column(name ="FEND2",nullable=true,length=32)
	public java.util.Date getFend2(){
		return this.fend2;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束日期2
	 */
	public void setFend2(java.util.Date fend2){
		this.fend2 = fend2;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  三者险
	 */

	@Column(name ="FSAN",nullable=true,length=32)
	public java.lang.Double getFsan(){
		return this.fsan;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  三者险
	 */
	public void setFsan(java.lang.Double fsan){
		this.fsan = fsan;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  车损险
	 */

	@Column(name ="FCHESUN",nullable=true,length=32)
	public java.lang.Double getFchesun(){
		return this.fchesun;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  车损险
	 */
	public void setFchesun(java.lang.Double fchesun){
		this.fchesun = fchesun;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  玻璃险
	 */

	@Column(name ="FBOLI",nullable=true,length=32)
	public java.lang.Double getFboli(){
		return this.fboli;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  玻璃险
	 */
	public void setFboli(java.lang.Double fboli){
		this.fboli = fboli;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  不计免赔
	 */

	@Column(name ="FMIANPEI",nullable=true,length=32)
	public java.lang.Double getFmianpei(){
		return this.fmianpei;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  不计免赔
	 */
	public void setFmianpei(java.lang.Double fmianpei){
		this.fmianpei = fmianpei;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  商业险优惠
	 */

	@Column(name ="FBUSSDISCOUNT",nullable=true,length=32)
	public java.lang.Double getFbussdiscount(){
		return this.fbussdiscount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  商业险优惠
	 */
	public void setFbussdiscount(java.lang.Double fbussdiscount){
		this.fbussdiscount = fbussdiscount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商业险保单号
	 */

	@Column(name ="FBUSSNO",nullable=true,length=32)
	public java.lang.String getFbussno(){
		return this.fbussno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商业险保单号
	 */
	public void setFbussno(java.lang.String fbussno){
		this.fbussno = fbussno;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始日期3
	 */

	@Column(name ="FSTART3",nullable=true,length=32)
	public java.util.Date getFstart3(){
		return this.fstart3;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始日期3
	 */
	public void setFstart3(java.util.Date fstart3){
		this.fstart3 = fstart3;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束日期3
	 */

	@Column(name ="FEND3",nullable=true,length=32)
	public java.util.Date getFend3(){
		return this.fend3;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束日期3
	 */
	public void setFend3(java.util.Date fend3){
		this.fend3 = fend3;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  保费合计
	 */

	@Column(name ="FTOTAL",nullable=true,length=32)
	public java.lang.Double getFtotal(){
		return this.ftotal;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  保费合计
	 */
	public void setFtotal(java.lang.Double ftotal){
		this.ftotal = ftotal;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承保公司
	 */

	@Column(name ="FCHENGBAO",nullable=true,length=32)
	public java.lang.String getFchengbao(){
		return this.fchengbao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承保公司
	 */
	public void setFchengbao(java.lang.String fchengbao){
		this.fchengbao = fchengbao;
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
