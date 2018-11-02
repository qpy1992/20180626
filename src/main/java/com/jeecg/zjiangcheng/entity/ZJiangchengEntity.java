package com.jeecg.zjiangcheng.entity;

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
 * @Description: 奖惩
 * @author onlineGenerator
 * @date 2018-09-19 10:40:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_jiangcheng", schema = "")
@SuppressWarnings("serial")
public class ZJiangchengEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建日期*/
	private java.util.Date createDate;
	/**日期*/
	@Excel(name="日期",width=15)
	private java.lang.String time;
	/**奖惩原因*/
	@Excel(name="奖惩原因",width=15)
	private java.lang.String reason;
	/**奖惩记录*/
	@Excel(name="奖惩记录",width=15)
	private java.lang.String record;
	/**奖惩部门*/
	@Excel(name="奖惩部门",width=15)
	private java.lang.String department;
	/**人员id*/
	@Excel(name="人员id",width=15)
	private java.lang.String pid;
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
	 *@return: java.lang.String  奖惩原因
	 */

	@Column(name ="REASON",nullable=true,length=32)
	public java.lang.String getReason(){
		return this.reason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  奖惩原因
	 */
	public void setReason(java.lang.String reason){
		this.reason = reason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  奖惩记录
	 */

	@Column(name ="RECORD",nullable=true,length=32)
	public java.lang.String getRecord(){
		return this.record;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  奖惩记录
	 */
	public void setRecord(java.lang.String record){
		this.record = record;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  奖惩部门
	 */

	@Column(name ="DEPARTMENT",nullable=true,length=32)
	public java.lang.String getDepartment(){
		return this.department;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  奖惩部门
	 */
	public void setDepartment(java.lang.String department){
		this.department = department;
	}
	
	@Column(name ="PID",nullable=true,length=32)
	public java.lang.String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员id
	 */
	public void setPid(java.lang.String pid){
		this.pid = pid;
	}
}
