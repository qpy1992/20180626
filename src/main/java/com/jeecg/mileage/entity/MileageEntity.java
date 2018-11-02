package com.jeecg.mileage.entity;

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
 * @Description: 里程数
 * @author onlineGenerator
 * @date 2018-08-01 15:32:57
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_mileage", schema = "")
@SuppressWarnings("serial")
public class MileageEntity implements java.io.Serializable {
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
	/**区域*/
	@Excel(name="区域",width=15)
	private java.lang.String fdparea;
	/**里程数*/
	@Excel(name="里程数",width=15)
	private java.lang.Double fmileage;
	/**里程类型*/
	@Excel(name="里程类型",width=15)
	private java.lang.String fmitype;
	/**顺序*/
	@Excel(name="顺序",width=15)
	private java.lang.String forder;
	/**空驶里程*/
	@Excel(name="空驶里程",width=15)
	private java.lang.Double fkong;
	/**空箱里程*/
	@Excel(name="空箱里程",width=15)
	private java.lang.Double fkongxiang;
	/**重箱里程*/
	@Excel(name="重箱里程",width=15)
	private java.lang.Double fzhong;
	/**补贴里程*/
	@Excel(name="补贴里程",width=15)
	private java.lang.Double fbutie;
	/**总里程*/
	@Excel(name="总里程",width=15)
	private java.lang.Double ftotal;
	/**额定油耗*/
	@Excel(name="额定油耗",width=15)
	private java.lang.Double feding;
	
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
	 *@return: java.lang.String  区域
	 */

	@Column(name ="FDPAREA",nullable=true,length=32)
	public java.lang.String getFdparea(){
		return this.fdparea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区域
	 */
	public void setFdparea(java.lang.String fdparea){
		this.fdparea = fdparea;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  里程数
	 */

	@Column(name ="FMILEAGE",nullable=true,length=32)
	public java.lang.Double getFmileage(){
		return this.fmileage;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  里程数
	 */
	public void setFmileage(java.lang.Double fmileage){
		this.fmileage = fmileage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  里程类型
	 */

	@Column(name ="FMITYPE",nullable=true,length=32)
	public java.lang.String getFmitype(){
		return this.fmitype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  里程类型
	 */
	public void setFmitype(java.lang.String fmitype){
		this.fmitype = fmitype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  顺序
	 */

	@Column(name ="FORDER",nullable=true,length=32)
	public java.lang.String getForder(){
		return this.forder;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  顺序
	 */
	public void setForder(java.lang.String forder){
		this.forder = forder;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  空驶里程
	 */

	@Column(name ="FKONG",nullable=true,length=32)
	public java.lang.Double getFkong(){
		return this.fkong;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  空驶里程
	 */
	public void setFkong(java.lang.Double fkong){
		this.fkong = fkong;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  空箱里程
	 */

	@Column(name ="FKONGXIANG",nullable=true,length=32)
	public java.lang.Double getFkongxiang(){
		return this.fkongxiang;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  空箱里程
	 */
	public void setFkongxiang(java.lang.Double fkongxiang){
		this.fkongxiang = fkongxiang;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  重箱里程
	 */

	@Column(name ="FZHONG",nullable=true,length=32)
	public java.lang.Double getFzhong(){
		return this.fzhong;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  重箱里程
	 */
	public void setFzhong(java.lang.Double fzhong){
		this.fzhong = fzhong;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  补贴里程
	 */

	@Column(name ="FBUTIE",nullable=true,length=32)
	public java.lang.Double getFbutie(){
		return this.fbutie;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  补贴里程
	 */
	public void setFbutie(java.lang.Double fbutie){
		this.fbutie = fbutie;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  总里程
	 */

	@Column(name ="FTOTAL",nullable=true,length=32)
	public java.lang.Double getFtotal(){
		return this.ftotal;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  总里程
	 */
	public void setFtotal(java.lang.Double ftotal){
		this.ftotal = ftotal;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  额定油耗
	 */

	@Column(name ="FEDING",nullable=true,length=32)
	public java.lang.Double getFeding(){
		return this.feding;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  额定油耗
	 */
	public void setFeding(java.lang.Double feding){
		this.feding = feding;
	}
}
