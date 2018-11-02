package com.jeecg.zcar.entity;

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
 * @Description: 营运车辆变动情况
 * @author onlineGenerator
 * @date 2018-09-18 15:18:27
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_car", schema = "")
@SuppressWarnings("serial")
public class ZCarEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**月份*/
	@Excel(name="月份",width=15)
	private java.lang.String month;
	/**车辆类别*/
	@Excel(name="车辆类别",width=15)
	private java.lang.String cartype;
	/**月初数*/
	@Excel(name="月初数",width=15)
	private java.lang.String beginNumber;
	/**本月增加*/
	@Excel(name="本月增加",width=15)
	private java.lang.String increase;
	/**本月减少*/
	@Excel(name="本月减少",width=15)
	private java.lang.String decrease;
	/**月末数*/
	@Excel(name="月末数",width=15)
	private java.lang.String endNumber;
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
	 *@return: java.lang.String  车辆类别
	 */

	@Column(name ="CARTYPE",nullable=true,length=32)
	public java.lang.String getCartype(){
		return this.cartype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车辆类别
	 */
	public void setCartype(java.lang.String cartype){
		this.cartype = cartype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  月初数
	 */

	@Column(name ="BEGIN_NUMBER",nullable=true,length=32)
	public java.lang.String getBeginNumber(){
		return this.beginNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  月初数
	 */
	public void setBeginNumber(java.lang.String beginNumber){
		this.beginNumber = beginNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本月增加
	 */

	@Column(name ="INCREASE",nullable=true,length=32)
	public java.lang.String getIncrease(){
		return this.increase;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本月增加
	 */
	public void setIncrease(java.lang.String increase){
		this.increase = increase;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本月减少
	 */

	@Column(name ="DECREASE",nullable=true,length=32)
	public java.lang.String getDecrease(){
		return this.decrease;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本月减少
	 */
	public void setDecrease(java.lang.String decrease){
		this.decrease = decrease;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  月末数
	 */

	@Column(name ="END_NUMBER",nullable=true,length=32)
	public java.lang.String getEndNumber(){
		return this.endNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  月末数
	 */
	public void setEndNumber(java.lang.String endNumber){
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
