package com.jeecg.contact.entity;
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
 * @Description: 门点联系人
 * @author onlineGenerator
 * @date 2018-06-29 09:32:27
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_dp_contact", schema = "")
@SuppressWarnings("serial")
public class ContactEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**联系人名*/
    @Excel(name="联系人名",width=15)
	private java.lang.String fcontactName;
	/**默认*/
    @Excel(name="默认",width=15)
	private java.lang.String fdefault;
	/**性别*/
    @Excel(name="性别",width=15)
	private java.lang.String fgender;
	/**电话*/
    @Excel(name="电话",width=15)
	private java.lang.String fphone;
	/**手机*/
    @Excel(name="手机",width=15)
	private java.lang.String fmobile;
	/**传真*/
    @Excel(name="传真",width=15)
	private java.lang.String fax;
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
	 *@return: java.lang.String  联系人名
	 */
	
	@Column(name ="FCONTACT_NAME",nullable=true,length=32)
	public java.lang.String getFcontactName(){
		return this.fcontactName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人名
	 */
	public void setFcontactName(java.lang.String fcontactName){
		this.fcontactName = fcontactName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  默认
	 */
	
	@Column(name ="FDEFAULT",nullable=true,length=32)
	public java.lang.String getFdefault(){
		return this.fdefault;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  默认
	 */
	public void setFdefault(java.lang.String fdefault){
		this.fdefault = fdefault;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	
	@Column(name ="FGENDER",nullable=true,length=32)
	public java.lang.String getFgender(){
		return this.fgender;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setFgender(java.lang.String fgender){
		this.fgender = fgender;
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
	 *@return: java.lang.String  手机
	 */
	
	@Column(name ="FMOBILE",nullable=true,length=32)
	public java.lang.String getFmobile(){
		return this.fmobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机
	 */
	public void setFmobile(java.lang.String fmobile){
		this.fmobile = fmobile;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  传真
	 */
	
	@Column(name ="FAX",nullable=true,length=32)
	public java.lang.String getFax(){
		return this.fax;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  传真
	 */
	public void setFax(java.lang.String fax){
		this.fax = fax;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主表id
	 */
	
	@Column(name ="FID",nullable=false,length=36)
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
