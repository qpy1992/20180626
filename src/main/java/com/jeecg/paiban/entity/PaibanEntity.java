package com.jeecg.paiban.entity;

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
 * @Description: 计划排班
 * @author onlineGenerator
 * @date 2018-07-16 14:54:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_paiban", schema = "")
@SuppressWarnings("serial")
public class PaibanEntity implements java.io.Serializable {
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
	/**车辆代码*/
	@Excel(name="车辆代码",width=15)
	private java.lang.String fcarcode;
	/**车号*/
	@Excel(name="车号",width=15)
	private java.lang.String fcarno;
	/**外部车*/
	@Excel(name="外部车",width=15)
	private java.lang.String foutercar;
	/**车主*/
	@Excel(name="车主",width=15)
	private java.lang.String fdriver;
	/**派车单号*/
	@Excel(name="派车单号",width=15)
	private java.lang.String fbillno1;
	/**详细地址*/
	@Excel(name="详细地址",width=15)
	private java.lang.String faddress1;
	/**预计返回时间*/
	@Excel(name="预计返回时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fbackTime1;
	/**派车单号*/
	@Excel(name="派车单号",width=15)
	private java.lang.String fbillno2;
	/**详细地址*/
	@Excel(name="详细地址",width=15)
	private java.lang.String faddress2;
	/**预计返回时间*/
	@Excel(name="预计返回时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fbackTime2;
	/**派车单号*/
	@Excel(name="派车单号",width=15)
	private java.lang.String fbillno3;
	/**详细地址*/
	@Excel(name="详细地址",width=15)
	private java.lang.String faddress3;
	/**预计返回时间*/
	@Excel(name="预计返回时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fbackTime3;
	/**派车单号*/
	@Excel(name="派车单号",width=15)
	private java.lang.String fbillno4;
	/**详细地址*/
	@Excel(name="详细地址",width=15)
	private java.lang.String faddress4;
	/**预计返回时间*/
	@Excel(name="预计返回时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fbackTime4;
	/**派车单号*/
	@Excel(name="派车单号",width=15)
	private java.lang.String fbillno5;
	/**详细地址*/
	@Excel(name="详细地址",width=15)
	private java.lang.String faddress5;
	/**预计返回时间*/
	@Excel(name="预计返回时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fbackTime5;
	/**预计返回时间*/
	@Excel(name="作业日期",width=15,format = "yyyy-MM-dd")
	private java.lang.String fdate;
	
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
	 *@return: java.lang.String  车辆代码
	 */

	@Column(name ="FCARCODE",nullable=true,length=32)
	public java.lang.String getFcarcode(){
		return this.fcarcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车辆代码
	 */
	public void setFcarcode(java.lang.String fcarcode){
		this.fcarcode = fcarcode;
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
	 *@return: java.lang.String  外部车
	 */

	@Column(name ="FOUTERCAR",nullable=true,length=32)
	public java.lang.String getFoutercar(){
		return this.foutercar;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外部车
	 */
	public void setFoutercar(java.lang.String foutercar){
		this.foutercar = foutercar;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车主
	 */

	@Column(name ="FDRIVER",nullable=true,length=32)
	public java.lang.String getFdriver(){
		return this.fdriver;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车主
	 */
	public void setFdriver(java.lang.String fdriver){
		this.fdriver = fdriver;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单号
	 */

	@Column(name ="FBILLNO1",nullable=true,length=32)
	public java.lang.String getFbillno1(){
		return this.fbillno1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单号
	 */
	public void setFbillno1(java.lang.String fbillno1){
		this.fbillno1 = fbillno1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详细地址
	 */

	@Column(name ="FADDRESS1",nullable=true,length=32)
	public java.lang.String getFaddress1(){
		return this.faddress1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详细地址
	 */
	public void setFaddress1(java.lang.String faddress1){
		this.faddress1 = faddress1;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计返回时间
	 */

	@Column(name ="FBACK_TIME1",nullable=true,length=32)
	public java.util.Date getFbackTime1(){
		return this.fbackTime1;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计返回时间
	 */
	public void setFbackTime1(java.util.Date fbackTime1){
		this.fbackTime1 = fbackTime1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单号
	 */

	@Column(name ="FBILLNO2",nullable=true,length=32)
	public java.lang.String getFbillno2(){
		return this.fbillno2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单号
	 */
	public void setFbillno2(java.lang.String fbillno2){
		this.fbillno2 = fbillno2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详细地址
	 */

	@Column(name ="FADDRESS2",nullable=true,length=32)
	public java.lang.String getFaddress2(){
		return this.faddress2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详细地址
	 */
	public void setFaddress2(java.lang.String faddress2){
		this.faddress2 = faddress2;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计返回时间
	 */

	@Column(name ="FBACK_TIME2",nullable=true,length=32)
	public java.util.Date getFbackTime2(){
		return this.fbackTime2;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计返回时间
	 */
	public void setFbackTime2(java.util.Date fbackTime2){
		this.fbackTime2 = fbackTime2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单号
	 */

	@Column(name ="FBILLNO3",nullable=true,length=32)
	public java.lang.String getFbillno3(){
		return this.fbillno3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单号
	 */
	public void setFbillno3(java.lang.String fbillno3){
		this.fbillno3 = fbillno3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详细地址
	 */

	@Column(name ="FADDRESS3",nullable=true,length=32)
	public java.lang.String getFaddress3(){
		return this.faddress3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详细地址
	 */
	public void setFaddress3(java.lang.String faddress3){
		this.faddress3 = faddress3;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计返回时间
	 */

	@Column(name ="FBACK_TIME3",nullable=true,length=32)
	public java.util.Date getFbackTime3(){
		return this.fbackTime3;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计返回时间
	 */
	public void setFbackTime3(java.util.Date fbackTime3){
		this.fbackTime3 = fbackTime3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单号
	 */

	@Column(name ="FBILLNO4",nullable=true,length=32)
	public java.lang.String getFbillno4(){
		return this.fbillno4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单号
	 */
	public void setFbillno4(java.lang.String fbillno4){
		this.fbillno4 = fbillno4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详细地址
	 */

	@Column(name ="FADDRESS4",nullable=true,length=32)
	public java.lang.String getFaddress4(){
		return this.faddress4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详细地址
	 */
	public void setFaddress4(java.lang.String faddress4){
		this.faddress4 = faddress4;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计返回时间
	 */

	@Column(name ="FBACK_TIME4",nullable=true,length=32)
	public java.util.Date getFbackTime4(){
		return this.fbackTime4;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计返回时间
	 */
	public void setFbackTime4(java.util.Date fbackTime4){
		this.fbackTime4 = fbackTime4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单号
	 */

	@Column(name ="FBILLNO5",nullable=true,length=32)
	public java.lang.String getFbillno5(){
		return this.fbillno5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单号
	 */
	public void setFbillno5(java.lang.String fbillno5){
		this.fbillno5 = fbillno5;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详细地址
	 */

	@Column(name ="FADDRESS5",nullable=true,length=32)
	public java.lang.String getFaddress5(){
		return this.faddress5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详细地址
	 */
	public void setFaddress5(java.lang.String faddress5){
		this.faddress5 = faddress5;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预计返回时间
	 */

	@Column(name ="FBACK_TIME5",nullable=true,length=32)
	public java.util.Date getFbackTime5(){
		return this.fbackTime5;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预计返回时间
	 */
	public void setFbackTime5(java.util.Date fbackTime5){
		this.fbackTime5 = fbackTime5;
	}

	@Column(name ="FDATE",nullable=false,length=32)
	public String getFdate() {
		return this.fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
}
