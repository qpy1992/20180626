package com.jeecg.dprate.entity;
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
 * @Description: 门点费率
 * @author onlineGenerator
 * @date 2018-08-30 16:16:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_dp_rate", schema = "")
@SuppressWarnings("serial")
public class DpRateEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**费用种类*/
    @Excel(name="费用种类",width=15)
	private java.lang.String feeType;
	/**费用种类名称*/
    @Excel(name="费用种类名称",width=15)
	private java.lang.String feeTypeName;
	/**箱型*/
    @Excel(name="箱型",width=15)
	private java.lang.String fboxType;
	/**费率*/
    @Excel(name="费率",width=15)
	private java.lang.String frate;
	/**主表id*/
	private java.lang.String fid;
	
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
	 *@return: java.lang.String  费用种类
	 */
	
	@Column(name ="FEE_TYPE",nullable=true,length=32)
	public java.lang.String getFeeType(){
		return this.feeType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类
	 */
	public void setFeeType(java.lang.String feeType){
		this.feeType = feeType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用种类名称
	 */
	
	@Column(name ="FEE_TYPE_NAME",nullable=true,length=32)
	public java.lang.String getFeeTypeName(){
		return this.feeTypeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类名称
	 */
	public void setFeeTypeName(java.lang.String feeTypeName){
		this.feeTypeName = feeTypeName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  箱型
	 */
	
	@Column(name ="FBOX_TYPE",nullable=true,length=32)
	public java.lang.String getFboxType(){
		return this.fboxType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱型
	 */
	public void setFboxType(java.lang.String fboxType){
		this.fboxType = fboxType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费率
	 */
	
	@Column(name ="FRATE",nullable=true,length=32)
	public java.lang.String getFrate(){
		return this.frate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费率
	 */
	public void setFrate(java.lang.String frate){
		this.frate = frate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主表id
	 */
	
	@Column(name ="FID",nullable=false,length=32)
	public java.lang.String getFid(){
		return this.fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表id
	 */
	public void setFid(java.lang.String fid){
		this.fid = fid;
	}
	
}
