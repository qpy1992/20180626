package com.jeecg.zcardetail.entity;

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
 * @Description: 机动车基本信息
 * @author onlineGenerator
 * @date 2018-09-18 15:18:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_cardetail", schema = "")
@SuppressWarnings("serial")
public class ZCardetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**车辆号牌*/
	@Excel(name="车辆号牌",width=15)
	private java.lang.String carno;
	/**车辆类型*/
	@Excel(name="车辆类型",width=15)
	private java.lang.String cartype;
	/**管辖区县*/
	@Excel(name="管辖区县",width=15)
	private java.lang.String area;
	/**车次登记时间*/
	@Excel(name="车次登记时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date time;
	/**安检有效日期*/
	@Excel(name="安检有效日期",width=15)
	private java.lang.String effectiveDate;
	/**退出日期*/
	@Excel(name="退出日期",width=15)
	private java.lang.String exitDate;
	/**信息维护人员*/
	@Excel(name="信息维护人员",width=15)
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
	 *@return: java.lang.String  车辆号牌
	 */

	@Column(name ="CARNO",nullable=true,length=32)
	public java.lang.String getCarno(){
		return this.carno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车辆号牌
	 */
	public void setCarno(java.lang.String carno){
		this.carno = carno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车辆类型
	 */

	@Column(name ="CARTYPE",nullable=true,length=32)
	public java.lang.String getCartype(){
		return this.cartype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车辆类型
	 */
	public void setCartype(java.lang.String cartype){
		this.cartype = cartype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管辖区县
	 */

	@Column(name ="AREA",nullable=true,length=32)
	public java.lang.String getArea(){
		return this.area;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管辖区县
	 */
	public void setArea(java.lang.String area){
		this.area = area;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  车次登记时间
	 */

	@Column(name ="TIME",nullable=true,length=32)
	public java.util.Date getTime(){
		return this.time;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  车次登记时间
	 */
	public void setTime(java.util.Date time){
		this.time = time;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  安检有效日期
	 */

	@Column(name ="EFFECTIVE_DATE",nullable=true,length=32)
	public java.lang.String getEffectiveDate(){
		return this.effectiveDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  安检有效日期
	 */
	public void setEffectiveDate(java.lang.String effectiveDate){
		this.effectiveDate = effectiveDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  退出日期
	 */

	@Column(name ="EXIT_DATE",nullable=true,length=32)
	public java.lang.String getExitDate(){
		return this.exitDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  退出日期
	 */
	public void setExitDate(java.lang.String exitDate){
		this.exitDate = exitDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  信息维护人员
	 */

	@Column(name ="FPEOPLE",nullable=true,length=32)
	public java.lang.String getFpeople(){
		return this.fpeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  信息维护人员
	 */
	public void setFpeople(java.lang.String fpeople){
		this.fpeople = fpeople;
	}
}
