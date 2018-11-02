package com.jeecg.zstore.entity;

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
 * @Description: 库存表
 * @author onlineGenerator
 * @date 2018-08-26 15:12:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_store", schema = "")
@SuppressWarnings("serial")
public class ZStoreEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用品名称*/
	@Excel(name="用品名称",width=15)
	private java.lang.String fname;
	/**规格型号*/
	@Excel(name="规格型号",width=15)
	private java.lang.String specifications;
	/**单位*/
	@Excel(name="单位",width=15)
	private java.lang.String unit;
	/**进价*/
	@Excel(name="进价",width=15)
	private java.lang.Double purchasePrice;
	/**数量*/
	@Excel(name="数量",width=15)
	private java.lang.Integer rkNumber;
	/**进价合计*/
	@Excel(name="进价合计",width=15)
	private java.lang.Double purchaseTotal;
	
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
	 *@return: java.lang.String  用品名称
	 */

	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用品名称
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格型号
	 */

	@Column(name ="SPECIFICATIONS",nullable=true,length=32)
	public java.lang.String getSpecifications(){
		return this.specifications;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格型号
	 */
	public void setSpecifications(java.lang.String specifications){
		this.specifications = specifications;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */

	@Column(name ="UNIT",nullable=true,length=32)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  进价
	 */

	@Column(name ="PURCHASE_PRICE",nullable=true,length=32)
	public java.lang.Double getPurchasePrice(){
		return this.purchasePrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进价
	 */
	public void setPurchasePrice(java.lang.Double purchasePrice){
		this.purchasePrice = purchasePrice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数量
	 */

	@Column(name ="RK_NUMBER",nullable=true,length=32)
	public java.lang.Integer getRkNumber(){
		return this.rkNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数量
	 */
	public void setRkNumber(java.lang.Integer rkNumber){
		this.rkNumber = rkNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  进价合计
	 */

	@Column(name ="PURCHASE_TOTAL",nullable=true,length=32)
	public java.lang.Double getPurchaseTotal(){
		return this.purchaseTotal;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进价合计
	 */
	public void setPurchaseTotal(java.lang.Double purchaseTotal){
		this.purchaseTotal = purchaseTotal;
	}
}
