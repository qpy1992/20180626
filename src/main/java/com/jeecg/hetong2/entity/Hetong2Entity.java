package com.jeecg.hetong2.entity;
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
 * @Description: 价格要素及费率
 * @author onlineGenerator
 * @date 2018-07-09 09:03:41
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_hetong_2", schema = "")
@SuppressWarnings("serial")
public class Hetong2Entity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**业务类型*/
    @Excel(name="业务类型",width=15)
	private java.lang.String ftype;
	/**费用代码*/
    @Excel(name="费用代码",width=15)
	private java.lang.String fnumber;
	/**费用种类名称*/
    @Excel(name="费用种类名称",width=15)
	private java.lang.String feeType;
	/**单位*/
    @Excel(name="单位",width=15)
	private java.lang.String funit;
	/**单价*/
    @Excel(name="单价",width=15)
	private java.lang.Double fprice;
	/**最小金额*/
    @Excel(name="最小金额",width=15)
	private java.lang.Double fminAmount;
	/**主表主键*/
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
	 *@return: java.lang.String  业务类型
	 */
	
	@Column(name ="FTYPE",nullable=true,length=32)
	public java.lang.String getFtype(){
		return this.ftype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务类型
	 */
	public void setFtype(java.lang.String ftype){
		this.ftype = ftype;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用代码
	 */
	
	@Column(name ="FNUMBER",nullable=true,length=32)
	public java.lang.String getFnumber(){
		return this.fnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用代码
	 */
	public void setFnumber(java.lang.String fnumber){
		this.fnumber = fnumber;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用种类名称
	 */
	
	@Column(name ="FEE_TYPE",nullable=true,length=32)
	public java.lang.String getFeeType(){
		return this.feeType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类名称
	 */
	public void setFeeType(java.lang.String feeType){
		this.feeType = feeType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */
	
	@Column(name ="FUNIT",nullable=true,length=32)
	public java.lang.String getFunit(){
		return this.funit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setFunit(java.lang.String funit){
		this.funit = funit;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  单价
	 */
	
	@Column(name ="FPRICE",nullable=true,length=32)
	public java.lang.Double getFprice(){
		return this.fprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  单价
	 */
	public void setFprice(java.lang.Double fprice){
		this.fprice = fprice;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  最小金额
	 */
	
	@Column(name ="FMIN_AMOUNT",nullable=true,length=32)
	public java.lang.Double getFminAmount(){
		return this.fminAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  最小金额
	 */
	public void setFminAmount(java.lang.Double fminAmount){
		this.fminAmount = fminAmount;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主表主键
	 */
	
	@Column(name ="FID",nullable=false,length=32)
	public java.lang.String getFid(){
		return this.fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主表主键
	 */
	public void setFid(java.lang.String fid){
		this.fid = fid;
	}
	
}
