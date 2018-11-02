package com.jeecg.zbreaklaw.entity;

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
 * @Description: 交通违法排查督办
 * @author onlineGenerator
 * @date 2018-09-18 15:42:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_breaklaw", schema = "")
@SuppressWarnings("serial")
public class ZBreaklawEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**日期*/
	@Excel(name="日期",width=15)
	private java.lang.String time;
	/**驾驶人总数*/
	@Excel(name="驾驶人总数",width=15)
	private java.lang.String driverNumber;
	/**违反次数*/
	@Excel(name="违反次数",width=15)
	private java.lang.String number;
	/**违法率*/
	@Excel(name="违法率",width=15)
	private java.lang.String rate;
	/**违法分类*/
	@Excel(name="违法分类",width=15,dicCode="ratetype")
	private java.lang.String ftype;
	/**累计违法次数*/
	@Excel(name="累计违法次数",width=15)
	private java.lang.Integer allratenumber;
	/**当月已处理次数*/
	@Excel(name="当月已处理次数",width=15)
	private java.lang.Integer dealnumber;
	/**累计已处理次数*/
	@Excel(name="累计已处理次数",width=15)
	private java.lang.Integer alldealnumber;
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
	 *@return: java.lang.String  日期
	 */

	@Column(name ="TIME",nullable=true,length=32)
	public java.lang.String getTime(){
		return this.time;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  日期
	 */
	public void setTime(java.lang.String time){
		this.time = time;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶人总数
	 */

	@Column(name ="DRIVER_NUMBER",nullable=true,length=32)
	public java.lang.String getDriverNumber(){
		return this.driverNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶人总数
	 */
	public void setDriverNumber(java.lang.String driverNumber){
		this.driverNumber = driverNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  违反次数
	 */

	@Column(name ="NUMBER",nullable=true,length=32)
	public java.lang.String getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  违反次数
	 */
	public void setNumber(java.lang.String number){
		this.number = number;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  违法率
	 */

	@Column(name ="RATE",nullable=true,length=32)
	public java.lang.String getRate(){
		return this.rate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  违法率
	 */
	public void setRate(java.lang.String rate){
		this.rate = rate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  违法分类
	 */

	@Column(name ="FTYPE",nullable=true,length=32)
	public java.lang.String getFtype(){
		return this.ftype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  违法分类
	 */
	public void setFtype(java.lang.String ftype){
		this.ftype = ftype;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  累计违法次数
	 */

	@Column(name ="ALLRATENUMBER",nullable=true,length=32)
	public java.lang.Integer getAllratenumber(){
		return this.allratenumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  累计违法次数
	 */
	public void setAllratenumber(java.lang.Integer allratenumber){
		this.allratenumber = allratenumber;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  当月已处理次数
	 */

	@Column(name ="DEALNUMBER",nullable=true,length=32)
	public java.lang.Integer getDealnumber(){
		return this.dealnumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  当月已处理次数
	 */
	public void setDealnumber(java.lang.Integer dealnumber){
		this.dealnumber = dealnumber;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  累计已处理次数
	 */

	@Column(name ="ALLDEALNUMBER",nullable=true,length=32)
	public java.lang.Integer getAlldealnumber(){
		return this.alldealnumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  累计已处理次数
	 */
	public void setAlldealnumber(java.lang.Integer alldealnumber){
		this.alldealnumber = alldealnumber;
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
