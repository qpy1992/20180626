package com.jeecg.zdriverillegal.entity;

import java.math.BigDecimal;
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
 * @Description: 驾驶人违法
 * @author onlineGenerator
 * @date 2018-09-18 15:42:01
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_driverillegal", schema = "")
@SuppressWarnings("serial")
public class ZDriverillegalEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**驾驶人id*/
	@Excel(name="驾驶人id",width=15)
	private java.lang.String driverId;
	/**驾驶人*/
	@Excel(name="驾驶人",width=15)
	private java.lang.String driverName;
	/**驾驶证号*/
	@Excel(name="驾驶证号",width=15)
	private java.lang.String cardNo;
	/**违法时间*/
	@Excel(name="违法时间",width=15)
	private java.lang.String time;
	/**违法地点*/
	@Excel(name="违法地点",width=15)
	private java.lang.String address;
	/**具体违法内容*/
	@Excel(name="具体违法内容",width=15)
	private java.lang.String fcontent;
	/**处理情况*/
	@Excel(name="处理情况",width=15)
	private java.lang.String dealsituation;
	
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
	 *@return: java.lang.String  驾驶人id
	 */

	@Column(name ="DRIVER_ID",nullable=true,length=32)
	public java.lang.String getDriverId(){
		return this.driverId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶人id
	 */
	public void setDriverId(java.lang.String driverId){
		this.driverId = driverId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶人
	 */

	@Column(name ="DRIVER_NAME",nullable=true,length=32)
	public java.lang.String getDriverName(){
		return this.driverName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶人
	 */
	public void setDriverName(java.lang.String driverName){
		this.driverName = driverName;
	}
	
	

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  违法时间
	 */

	@Column(name ="TIME",nullable=true,length=32)
	public java.lang.String getTime(){
		return this.time;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  违法时间
	 */
	public void setTime(java.lang.String time){
		this.time = time;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  违法地点
	 */

	@Column(name ="ADDRESS",nullable=true,length=32)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  违法地点
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  具体违法内容
	 */

	@Column(name ="FCONTENT",nullable=true,length=32)
	public java.lang.String getFcontent(){
		return this.fcontent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  具体违法内容
	 */
	public void setFcontent(java.lang.String fcontent){
		this.fcontent = fcontent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理情况
	 */

	@Column(name ="DEALSITUATION",nullable=true,length=32)
	public java.lang.String getDealsituation(){
		return this.dealsituation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理情况
	 */
	public void setDealsituation(java.lang.String dealsituation){
		this.dealsituation = dealsituation;
	}
	@Column(name ="CARD_NO",nullable=true,length=32)
	public java.lang.String getCardNo()
	{
		return cardNo;
	}

	public void setCardNo(java.lang.String cardNo)
	{
		this.cardNo = cardNo;
	}
	
	
}
