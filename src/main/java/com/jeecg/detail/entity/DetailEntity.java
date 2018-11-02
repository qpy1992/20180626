package com.jeecg.detail.entity;
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
 * @Description: 箱货明细
 * @author onlineGenerator
 * @date 2018-08-01 16:47:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_detail", schema = "")
@SuppressWarnings("serial")
public class DetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**提单号*/
    @Excel(name="提单号",width=15)
	private java.lang.String fbillno;
	/**货名*/
    @Excel(name="货名",width=15)
	private java.lang.String fname;
	/**唛头*/
    @Excel(name="唛头",width=15)
	private java.lang.String fmaitou;
	/**包装*/
    @Excel(name="包装",width=15)
	private java.lang.String fpackage;
	/**件数*/
    @Excel(name="件数",width=15)
	private java.math.BigDecimal fqty;
	/**毛重*/
    @Excel(name="毛重",width=15)
	private java.math.BigDecimal fgross;
    /**体积*/
    @Excel(name="体积",width=15)
	private java.math.BigDecimal fvolume;
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
	 *@return: java.lang.String  提单号
	 */
	
	@Column(name ="FBILLNO",nullable=true,length=32)
	public java.lang.String getFbillno(){
		return this.fbillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提单号
	 */
	public void setFbillno(java.lang.String fbillno){
		this.fbillno = fbillno;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货名
	 */
	
	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货名
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  唛头
	 */
	
	@Column(name ="FMAITOU",nullable=true,length=32)
	public java.lang.String getFmaitou(){
		return this.fmaitou;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  唛头
	 */
	public void setFmaitou(java.lang.String fmaitou){
		this.fmaitou = fmaitou;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包装
	 */
	
	@Column(name ="FPACKAGE",nullable=true,length=32)
	public java.lang.String getFpackage(){
		return this.fpackage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装
	 */
	public void setFpackage(java.lang.String fpackage){
		this.fpackage = fpackage;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  件数
	 */
	
	@Column(name ="FQTY",nullable=true,length=32)
	public java.math.BigDecimal getFqty(){
		return this.fqty;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  件数
	 */
	public void setFqty(java.math.BigDecimal fqty){
		this.fqty = fqty;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  毛重
	 */
	
	@Column(name ="FGROSS",nullable=true,length=32)
	public java.math.BigDecimal getFgross(){
		return this.fgross;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  毛重
	 */
	public void setFgross(java.math.BigDecimal fgross){
		this.fgross = fgross;
	}

	@Column(name="FVOLUME",nullable = true)
	public BigDecimal getFvolume() {
		return fvolume;
	}

	public void setFvolume(BigDecimal fvolume) {
		this.fvolume = fvolume;
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
