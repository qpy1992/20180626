package com.jeecg.zpractitioners.entity;

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
 * @Description: 从业人员变动
 * @author onlineGenerator
 * @date 2018-09-18 11:21:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_practitioners", schema = "")
@SuppressWarnings("serial")
public class ZPractitionersEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建日期*/
	private java.util.Date createDate;
	/**月份*/
	@Excel(name="月份",width=15)
	private java.lang.String month;
	/**工种岗位*/
	@Excel(name="工种岗位",width=15)
	private java.lang.String job;
	/**月初数*/
	@Excel(name="月初数",width=15)
	private java.lang.Integer beginNumber;
	/**本月增加*/
	@Excel(name="本月增加",width=15)
	private java.lang.Integer increase;
	/**本月减少*/
	@Excel(name="本月减少",width=15)
	private java.lang.Integer decrease;
	/**月末数*/
	@Excel(name="月末数",width=15)
	private java.lang.Integer endNumber;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String note;
	
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
	 *@return: java.lang.String  月份
	 */

	@Column(name ="MONTH",nullable=true,length=32)
	public java.lang.String getMonth(){
		return this.month;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  月份
	 */
	public void setMonth(java.lang.String month){
		this.month = month;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工种岗位
	 */

	@Column(name ="JOB",nullable=true,length=32)
	public java.lang.String getJob(){
		return this.job;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工种岗位
	 */
	public void setJob(java.lang.String job){
		this.job = job;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  月初数
	 */

	@Column(name ="BEGIN_NUMBER",nullable=true,length=32)
	public java.lang.Integer getBeginNumber(){
		return this.beginNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  月初数
	 */
	public void setBeginNumber(java.lang.Integer beginNumber){
		this.beginNumber = beginNumber;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  本月增加
	 */

	@Column(name ="INCREASE",nullable=true,length=32)
	public java.lang.Integer getIncrease(){
		return this.increase;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  本月增加
	 */
	public void setIncrease(java.lang.Integer increase){
		this.increase = increase;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  本月减少
	 */

	@Column(name ="DECREASE",nullable=true,length=32)
	public java.lang.Integer getDecrease(){
		return this.decrease;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  本月减少
	 */
	public void setDecrease(java.lang.Integer decrease){
		this.decrease = decrease;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  月末数
	 */

	@Column(name ="END_NUMBER",nullable=true,length=32)
	public java.lang.Integer getEndNumber(){
		return this.endNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  月末数
	 */
	public void setEndNumber(java.lang.Integer endNumber){
		this.endNumber = endNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="NOTE",nullable=true,length=32)
	public java.lang.String getNote(){
		return this.note;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setNote(java.lang.String note){
		this.note = note;
	}
}
