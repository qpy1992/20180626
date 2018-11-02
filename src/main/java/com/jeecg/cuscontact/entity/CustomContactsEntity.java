package com.jeecg.cuscontact.entity;
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
 * @Description: 联系人
 * @author onlineGenerator
 * @date 2018-08-31 16:32:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_custom_contacts", schema = "")
@SuppressWarnings("serial")
public class CustomContactsEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**联系人名*/
    @Excel(name="联系人名",width=15)
	private java.lang.String fcontactsName;
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
	/**邮箱*/
    @Excel(name="邮箱",width=15)
	private java.lang.String femail;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String fnote;
	/**主表主键*/
	private java.lang.String fid;
	/**职位*/
    @Excel(name="职位",width=15,dicCode="position")
	private java.lang.String fposition;
	
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
	
	@Column(name ="FCONTACTS_NAME",nullable=true,length=32)
	public java.lang.String getFcontactsName(){
		return this.fcontactsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人名
	 */
	public void setFcontactsName(java.lang.String fcontactsName){
		this.fcontactsName = fcontactsName;
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
	 *@return: java.lang.String  邮箱
	 */
	
	@Column(name ="FEMAIL",nullable=true,length=32)
	public java.lang.String getFemail(){
		return this.femail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮箱
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
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位
	 */
	
	@Column(name ="FPOSITION",nullable=true,length=32)
	public java.lang.String getFposition(){
		return this.fposition;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位
	 */
	public void setFposition(java.lang.String fposition){
		this.fposition = fposition;
	}
	
}
