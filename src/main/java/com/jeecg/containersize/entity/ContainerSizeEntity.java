package com.jeecg.containersize.entity;

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
 * @Description: 集装箱尺寸对照表
 * @author onlineGenerator
 * @date 2018-11-02 16:10:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_container_size", schema = "")
@SuppressWarnings("serial")
public class ContainerSizeEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**箱型*/
	@Excel(name="箱型",width=15)
	private java.lang.String ftype;
	/**长度*/
	@Excel(name="长度",width=15)
	private java.lang.Integer flength;
	/**宽度*/
	@Excel(name="宽度",width=15)
	private java.lang.Integer fwidth;
	/**高度*/
	@Excel(name="高度",width=15)
	private java.lang.Integer fheight;
	/**体积*/
	@Excel(name="体积",width=15)
	private java.lang.Double fvolum;
	
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
	 *@return: java.lang.String  箱型
	 */

	@Column(name ="FTYPE",nullable=true,length=32)
	public java.lang.String getFtype(){
		return this.ftype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱型
	 */
	public void setFtype(java.lang.String ftype){
		this.ftype = ftype;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  长度
	 */

	@Column(name ="FLENGTH",nullable=true,length=32)
	public java.lang.Integer getFlength(){
		return this.flength;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  长度
	 */
	public void setFlength(java.lang.Integer flength){
		this.flength = flength;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  宽度
	 */

	@Column(name ="FWIDTH",nullable=true,length=32)
	public java.lang.Integer getFwidth(){
		return this.fwidth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  宽度
	 */
	public void setFwidth(java.lang.Integer fwidth){
		this.fwidth = fwidth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  高度
	 */

	@Column(name ="FHEIGHT",nullable=true,length=32)
	public java.lang.Integer getFheight(){
		return this.fheight;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  高度
	 */
	public void setFheight(java.lang.Integer fheight){
		this.fheight = fheight;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  体积
	 */

	@Column(name ="FVOLUM",nullable=true,length=32)
	public java.lang.Double getFvolum(){
		return this.fvolum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  体积
	 */
	public void setFvolum(java.lang.Double fvolum){
		this.fvolum = fvolum;
	}
}
