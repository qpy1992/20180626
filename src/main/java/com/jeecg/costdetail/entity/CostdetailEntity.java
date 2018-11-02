package com.jeecg.costdetail.entity;
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
 * @Description: 费用详情
 * @author onlineGenerator
 * @date 2018-10-09 14:33:19
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_costdetail", schema = "")
@SuppressWarnings("serial")
public class CostdetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**费用代码*/
    @Excel(name="费用代码",width=15)
	private java.lang.String fcostcode;
	/**费用名称*/
    @Excel(name="费用名称",width=15)
	private java.lang.String fcost;
	/**应收应付*/
    @Excel(name="应收应付",width=15,dicCode="shoufu")
	private java.lang.String fyf;
	/**费用*/
    @Excel(name="费用",width=15)
	private java.lang.Double fee;
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
	 *@return: java.lang.String  费用代码
	 */
	
	@Column(name ="FCOSTCODE",nullable=true,length=32)
	public java.lang.String getFcostcode(){
		return this.fcostcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用代码
	 */
	public void setFcostcode(java.lang.String fcostcode){
		this.fcostcode = fcostcode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用名称
	 */
	
	@Column(name ="FCOST",nullable=true,length=32)
	public java.lang.String getFcost(){
		return this.fcost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用名称
	 */
	public void setFcost(java.lang.String fcost){
		this.fcost = fcost;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应收应付
	 */
	
	@Column(name ="FYF",nullable=true,length=32)
	public java.lang.String getFyf(){
		return this.fyf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应收应付
	 */
	public void setFyf(java.lang.String fyf){
		this.fyf = fyf;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用
	 */
	
	@Column(name ="FEE",nullable=true,length=32)
	public java.lang.Double getFee(){
		return this.fee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用
	 */
	public void setFee(java.lang.Double fee){
		this.fee = fee;
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
