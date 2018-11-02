package com.jeecg.cussales.entity;
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
 * @Description: 业务员
 * @author onlineGenerator
 * @date 2018-08-31 16:32:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_custom_salesman", schema = "")
@SuppressWarnings("serial")
public class CustomSalesmanEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**业务员名称*/
    @Excel(name="业务员名称",width=15)
	private java.lang.String fname;
	/**职务*/
    @Excel(name="职务",width=15)
	private java.lang.String fpost;
	/**电话*/
    @Excel(name="电话",width=15)
	private java.lang.String fphone;
	/**电子邮件*/
    @Excel(name="电子邮件",width=15)
	private java.lang.String femail;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String fnote;
	/**主表id*/
	private java.lang.String fid;
	/**提成*/
    @Excel(name="提成",width=15)
	private java.lang.Double ftc;
	
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
	 *@return: java.lang.String  业务员名称
	 */
	
	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务员名称
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职务
	 */
	
	@Column(name ="FPOST",nullable=true,length=32)
	public java.lang.String getFpost(){
		return this.fpost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职务
	 */
	public void setFpost(java.lang.String fpost){
		this.fpost = fpost;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */
	
	@Column(name ="FPHONE",nullable=true,length=32)
	public java.lang.String getFphone(){
		return this.fphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setFphone(java.lang.String fphone){
		this.fphone = fphone;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电子邮件
	 */
	
	@Column(name ="FEMAIL",nullable=true,length=32)
	public java.lang.String getFemail(){
		return this.femail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电子邮件
	 */
	public void setFemail(java.lang.String femail){
		this.femail = femail;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="FNOTE",nullable=true,length=255)
	public java.lang.String getFnote(){
		return this.fnote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setFnote(java.lang.String fnote){
		this.fnote = fnote;
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
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  提成
	 */
	
	@Column(name ="FTC",nullable=true,length=32)
	public java.lang.Double getFtc(){
		return this.ftc;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  提成
	 */
	public void setFtc(java.lang.Double ftc){
		this.ftc = ftc;
	}
	
}
