package com.jeecg.paichepic.entity;

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
 * @Description: 派车单图片
 * @author onlineGenerator
 * @date 2018-08-27 15:55:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_paiche_pic", schema = "")
@SuppressWarnings("serial")
public class PaichePicEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**图片*/
	@Excel(name="图片",width=15)
	private java.lang.String fpic;
	/**微信名称*/
	@Excel(name="微信名称",width=15)
	private java.lang.String fwxname;
	/**微信头像*/
	@Excel(name="微信头像",width=15)
	private java.lang.String fwxpic;
	/**派车单id*/
	@Excel(name="派车单id",width=15)
	private java.lang.String fid;
	/**司机*/
	@Excel(name="司机",width=15)
	private java.lang.String fdriver;
	/**上传时间*/
	@Excel(name="上传时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date ftime;
	/**上传地点*/
	@Excel(name="上传地点",width=15)
	private java.lang.String flocation;
	
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
	 *@return: java.lang.String  图片
	 */

	@Column(name ="FPIC",nullable=true,length=255)
	public java.lang.String getFpic(){
		return this.fpic;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片
	 */
	public void setFpic(java.lang.String fpic){
		this.fpic = fpic;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信名称
	 */

	@Column(name ="FWXNAME",nullable=true,length=32)
	public java.lang.String getFwxname(){
		return this.fwxname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信名称
	 */
	public void setFwxname(java.lang.String fwxname){
		this.fwxname = fwxname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信头像
	 */

	@Column(name ="FWXPIC",nullable=true,length=255)
	public java.lang.String getFwxpic(){
		return this.fwxpic;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信头像
	 */
	public void setFwxpic(java.lang.String fwxpic){
		this.fwxpic = fwxpic;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单id
	 */

	@Column(name ="FID",nullable=true,length=32)
	public java.lang.String getFid(){
		return this.fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单id
	 */
	public void setFid(java.lang.String fid){
		this.fid = fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  司机
	 */

	@Column(name ="FDRIVER",nullable=true,length=32)
	public java.lang.String getFdriver(){
		return this.fdriver;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  司机
	 */
	public void setFdriver(java.lang.String fdriver){
		this.fdriver = fdriver;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  上传时间
	 */

	@Column(name ="FTIME",nullable=true,length=32)
	public java.util.Date getFtime(){
		return this.ftime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  上传时间
	 */
	public void setFtime(java.util.Date ftime){
		this.ftime = ftime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上传地点
	 */

	@Column(name ="FLOCATION",nullable=true,length=255)
	public java.lang.String getFlocation(){
		return this.flocation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上传地点
	 */
	public void setFlocation(java.lang.String flocation){
		this.flocation = flocation;
	}
}
