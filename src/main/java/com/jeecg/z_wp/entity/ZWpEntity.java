package com.jeecg.z_wp.entity;

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
 * @Description: 物品
 * @author onlineGenerator
 * @date 2018-08-10 09:11:03
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_wp", schema = "")
@SuppressWarnings("serial")
public class ZWpEntity implements java.io.Serializable {
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
	/**序号*/
	@Excel(name="序号",width=15)
	private java.lang.String zXh;
	/**物品代码*/
	@Excel(name="物品代码",width=15)
	private java.lang.String zWpdm;
	/**物品名称*/
	@Excel(name="物品名称",width=15)
	private java.lang.String zWpmc;
	/**规格型号*/
	@Excel(name="规格型号",width=15)
	private java.lang.String zGgxh;
	/**单位*/
	@Excel(name="单位",width=15)
	private java.lang.String zDw;
	/**进价*/
	@Excel(name="进价",width=15)
	private java.lang.Double zJprice;
	/**销价*/
	@Excel(name="销价",width=15)
	private java.lang.Double zSprice;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String zBz;
	
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
	 *@return: java.lang.String  序号
	 */

	@Column(name ="Z_XH",nullable=true,length=32)
	public java.lang.String getZXh(){
		return this.zXh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  序号
	 */
	public void setZXh(java.lang.String zXh){
		this.zXh = zXh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  物品代码
	 */

	@Column(name ="Z_WPDM",nullable=true,length=32)
	public java.lang.String getZWpdm(){
		return this.zWpdm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  物品代码
	 */
	public void setZWpdm(java.lang.String zWpdm){
		this.zWpdm = zWpdm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  物品名称
	 */

	@Column(name ="Z_WPMC",nullable=true,length=32)
	public java.lang.String getZWpmc(){
		return this.zWpmc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  物品名称
	 */
	public void setZWpmc(java.lang.String zWpmc){
		this.zWpmc = zWpmc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格型号
	 */

	@Column(name ="Z_GGXH",nullable=true,length=32)
	public java.lang.String getZGgxh(){
		return this.zGgxh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格型号
	 */
	public void setZGgxh(java.lang.String zGgxh){
		this.zGgxh = zGgxh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */

	@Column(name ="Z_DW",nullable=true,length=32)
	public java.lang.String getZDw(){
		return this.zDw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setZDw(java.lang.String zDw){
		this.zDw = zDw;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  进价
	 */

	@Column(name ="Z_JPRICE",nullable=true,length=32)
	public java.lang.Double getZJprice(){
		return this.zJprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  进价
	 */
	public void setZJprice(java.lang.Double zJprice){
		this.zJprice = zJprice;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  销价
	 */

	@Column(name ="Z_SPRICE",nullable=true,length=32)
	public java.lang.Double getZSprice(){
		return this.zSprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  销价
	 */
	public void setZSprice(java.lang.Double zSprice){
		this.zSprice = zSprice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="Z_BZ",nullable=true,length=32)
	public java.lang.String getZBz(){
		return this.zBz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setZBz(java.lang.String zBz){
		this.zBz = zBz;
	}
}
