package com.jeecg.zdriver.entity;

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
 * @Description: 驾驶人
 * @author onlineGenerator
 * @date 2018-09-18 11:32:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_driver", schema = "")
@SuppressWarnings("serial")
public class ZDriverEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**驾驶人*/
	@Excel(name="驾驶人",width=15)
	private java.lang.String fname;
	/**驾驶证号*/
	@Excel(name="驾驶证号",width=15)
	private java.lang.String licenseNumber;
	/**准驾车型*/
	@Excel(name="准驾车型",width=15)
	private java.lang.String carType;
	/**是否沪籍*/
	@Excel(name="是否沪籍",width=15)
	private java.lang.String ishu;
	/**初领日期*/
	@Excel(name="初领日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date initialDate;
	/**有效日期*/
	@Excel(name="有效日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date effectiveDate;
	/**手机号*/
	@Excel(name="手机号",width=15)
	private java.lang.String phone;
	/**地址*/
	@Excel(name="地址",width=15)
	private java.lang.String address;
	/**离职日期*/
	@Excel(name="离职日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date departureDate;
	/**信息维护员*/
	@Excel(name="信息维护员",width=15)
	private java.lang.String fpeople;
	
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
	 *@return: java.lang.String  驾驶人
	 */

	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶人
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶证号
	 */

	@Column(name ="LICENSE_NUMBER",nullable=true,length=32)
	public java.lang.String getLicenseNumber(){
		return this.licenseNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶证号
	 */
	public void setLicenseNumber(java.lang.String licenseNumber){
		this.licenseNumber = licenseNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  准驾车型
	 */

	@Column(name ="CAR_TYPE",nullable=true,length=32)
	public java.lang.String getCarType(){
		return this.carType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  准驾车型
	 */
	public void setCarType(java.lang.String carType){
		this.carType = carType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否沪籍
	 */

	@Column(name ="ISHU",nullable=true,length=32)
	public java.lang.String getIshu(){
		return this.ishu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否沪籍
	 */
	public void setIshu(java.lang.String ishu){
		this.ishu = ishu;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  初领日期
	 */

	@Column(name ="INITIAL_DATE",nullable=true,length=32)
	public java.util.Date getInitialDate(){
		return this.initialDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  初领日期
	 */
	public void setInitialDate(java.util.Date initialDate){
		this.initialDate = initialDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  有效日期
	 */

	@Column(name ="EFFECTIVE_DATE",nullable=true,length=32)
	public java.util.Date getEffectiveDate(){
		return this.effectiveDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  有效日期
	 */
	public void setEffectiveDate(java.util.Date effectiveDate){
		this.effectiveDate = effectiveDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号
	 */

	@Column(name ="PHONE",nullable=true,length=32)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */

	@Column(name ="ADDRESS",nullable=true,length=32)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  离职日期
	 */

	@Column(name ="DEPARTURE_DATE",nullable=true,length=32)
	public java.util.Date getDepartureDate(){
		return this.departureDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  离职日期
	 */
	public void setDepartureDate(java.util.Date departureDate){
		this.departureDate = departureDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  信息维护员
	 */

	@Column(name ="FPEOPLE",nullable=true,length=32)
	public java.lang.String getFpeople(){
		return this.fpeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  信息维护员
	 */
	public void setFpeople(java.lang.String fpeople){
		this.fpeople = fpeople;
	}
}
