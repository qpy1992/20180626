package com.jeecg.zzhengjian.entity;

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
 * @Description: 从业证件
 * @author onlineGenerator
 * @date 2018-09-18 16:47:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_zhengjian", schema = "")
@SuppressWarnings("serial")
public class ZZhengjianEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**从业证件名称*/
	@Excel(name="从业证件名称",width=15)
	private java.lang.String fname;
	/**证件号码*/
	@Excel(name="证件号码",width=15)
	private java.lang.String zhengjianNo;
	/**发证机关*/
	@Excel(name="发证机关",width=15)
	private java.lang.String issuingAuthority;
	/**颁发日期*/
	@Excel(name="颁发日期",width=15)
	private java.lang.String time;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  从业证件名称
	 */

	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  从业证件名称
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件号码
	 */

	@Column(name ="ZHENGJIAN_NO",nullable=true,length=32)
	public java.lang.String getZhengjianNo(){
		return this.zhengjianNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号码
	 */
	public void setZhengjianNo(java.lang.String zhengjianNo){
		this.zhengjianNo = zhengjianNo;
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
	 *@return: java.lang.String  颁发日期
	 */

	@Column(name ="TIME",nullable=true,length=32)
	public java.lang.String getTime(){
		return this.time;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  颁发日期
	 */
	public void setTime(java.lang.String time){
		this.time = time;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人员id
	 */

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
