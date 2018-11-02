package com.jeecg.zdriverdetail.entity;

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
 * @Description: 驾驶人基本信息
 * @author onlineGenerator
 * @date 2018-09-18 13:44:19
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_driverdetail", schema = "")
@SuppressWarnings("serial")
public class ZDriverdetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**工号*/
	@Excel(name="工号",width=15)
	private java.lang.String jobnumber;
	/**工种*/
	@Excel(name="工种",width=15)
	private java.lang.String job;
	/**入职日期*/
	@Excel(name="入职日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date entryDate;
	/**离职日期*/
	@Excel(name="离职日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date departureDate;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String fname;
	/**性别*/
	@Excel(name="性别",width=15)
	private java.lang.String sex;
	/**出生年月*/
	@Excel(name="出生年月",width=15,format = "yyyy-MM-dd")
	private java.util.Date birthDate;
	/**学历*/
	@Excel(name="学历",width=15)
	private java.lang.String education;
	/**民族*/
	@Excel(name="民族",width=15)
	private java.lang.String nation;
	/**籍贯*/
	@Excel(name="籍贯",width=15)
	private java.lang.String birthplace;
	/**身份证号码*/
	@Excel(name="身份证号码",width=15)
	private java.lang.String idcard;
	/**政治面貌*/
	@Excel(name="政治面貌",width=15)
	private java.lang.String political;
	/**家庭住址*/
	@Excel(name="家庭住址",width=15)
	private java.lang.String address;
	/**驾驶证初领日期*/
	@Excel(name="驾驶证初领日期",width=15)
	private java.lang.String initialDate;
	/**实际联系地址*/
	@Excel(name="实际联系地址",width=15)
	private java.lang.String residentialAddress;
	/**准驾车型*/
	@Excel(name="准驾车型",width=15)
	private java.lang.String carType;
	/**驾驶证登记地址*/
	@Excel(name="驾驶证登记地址",width=15)
	private java.lang.String registrationAddress;
	/**驾驶证档案号*/
	@Excel(name="驾驶证档案号",width=15)
	private java.lang.String licenseNo;
	/**发证机关*/
	@Excel(name="发证机关",width=15)
	private java.lang.String issuingAuthority;
	/**联系电话*/
	@Excel(name="联系电话",width=15)
	private java.lang.String phone;
	/**照片*/
	@Excel(name="照片",width=15)
	private java.lang.String image;
	
	@Excel(name="是否沪籍",width=15)
	private java.lang.String ishu;
	
	@Excel(name="有效日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date effectiveDate;
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
	 *@return: java.lang.String  工号
	 */

	@Column(name ="JOBNUMBER",nullable=true,length=32)
	public java.lang.String getJobnumber(){
		return this.jobnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工号
	 */
	public void setJobnumber(java.lang.String jobnumber){
		this.jobnumber = jobnumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工种
	 */

	@Column(name ="JOB",nullable=true,length=32)
	public java.lang.String getJob(){
		return this.job;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工种
	 */
	public void setJob(java.lang.String job){
		this.job = job;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入职日期
	 */

	@Column(name ="ENTRY_DATE",nullable=true,length=32)
	public java.util.Date getEntryDate(){
		return this.entryDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入职日期
	 */
	public void setEntryDate(java.util.Date entryDate){
		this.entryDate = entryDate;
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
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */

	@Column(name ="SEX",nullable=true,length=32)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生年月
	 */

	@Column(name ="BIRTH_DATE",nullable=true,length=32)
	public java.util.Date getBirthDate(){
		return this.birthDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生年月
	 */
	public void setBirthDate(java.util.Date birthDate){
		this.birthDate = birthDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */

	@Column(name ="EDUCATION",nullable=true,length=32)
	public java.lang.String getEducation(){
		return this.education;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setEducation(java.lang.String education){
		this.education = education;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */

	@Column(name ="NATION",nullable=true,length=32)
	public java.lang.String getNation(){
		return this.nation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setNation(java.lang.String nation){
		this.nation = nation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  籍贯
	 */

	@Column(name ="BIRTHPLACE",nullable=true,length=32)
	public java.lang.String getBirthplace(){
		return this.birthplace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  籍贯
	 */
	public void setBirthplace(java.lang.String birthplace){
		this.birthplace = birthplace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号码
	 */

	@Column(name ="IDCARD",nullable=true,length=32)
	public java.lang.String getIdcard(){
		return this.idcard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号码
	 */
	public void setIdcard(java.lang.String idcard){
		this.idcard = idcard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  政治面貌
	 */

	@Column(name ="POLITICAL",nullable=true,length=32)
	public java.lang.String getPolitical(){
		return this.political;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌
	 */
	public void setPolitical(java.lang.String political){
		this.political = political;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  家庭住址
	 */

	@Column(name ="ADDRESS",nullable=true,length=32)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  家庭住址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶证初领日期
	 */

	@Column(name ="INITIAL_DATE",nullable=true,length=32)
	public java.lang.String getInitialDate(){
		return this.initialDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶证初领日期
	 */
	public void setInitialDate(java.lang.String initialDate){
		this.initialDate = initialDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实际联系地址
	 */

	@Column(name ="RESIDENTIAL_ADDRESS",nullable=true,length=32)
	public java.lang.String getResidentialAddress(){
		return this.residentialAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实际联系地址
	 */
	public void setResidentialAddress(java.lang.String residentialAddress){
		this.residentialAddress = residentialAddress;
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
	 *@return: java.lang.String  驾驶证登记地址
	 */

	@Column(name ="REGISTRATION_ADDRESS",nullable=true,length=32)
	public java.lang.String getRegistrationAddress(){
		return this.registrationAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶证登记地址
	 */
	public void setRegistrationAddress(java.lang.String registrationAddress){
		this.registrationAddress = registrationAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶证档案号
	 */

	@Column(name ="LICENSE_NO",nullable=true,length=32)
	public java.lang.String getLicenseNo(){
		return this.licenseNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶证档案号
	 */
	public void setLicenseNo(java.lang.String licenseNo){
		this.licenseNo = licenseNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发证机关
	 */

	@Column(name ="ISSUING_AUTHORITY",nullable=true,length=32)
	public java.lang.String getIssuingAuthority(){
		return this.issuingAuthority;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发证机关
	 */
	public void setIssuingAuthority(java.lang.String issuingAuthority){
		this.issuingAuthority = issuingAuthority;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */

	@Column(name ="PHONE",nullable=true,length=32)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  照片
	 */

	@Column(name ="IMAGE",nullable=true,length=32)
	public java.lang.String getImage(){
		return this.image;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  照片
	 */
	public void setImage(java.lang.String image){
		this.image = image;
	}
	
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
}
