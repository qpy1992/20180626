package com.jeecg.require.entity;
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
 * @Description: 运输资质要求
 * @author onlineGenerator
 * @date 2018-06-28 09:35:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_custom_require", schema = "")
@SuppressWarnings("serial")
public class CustomRequireEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**资质要求*/
    @Excel(name="资质要求",width=15)
	private java.lang.String frequire;
	/**适用货物*/
    @Excel(name="适用货物",width=15)
	private java.lang.String fgoods;
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
	 *@return: java.lang.String  资质要求
	 */
	
	@Column(name ="FREQUIRE",nullable=true,length=255)
	public java.lang.String getFrequire(){
		return this.frequire;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  资质要求
	 */
	public void setFrequire(java.lang.String frequire){
		this.frequire = frequire;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  适用货物
	 */
	
	@Column(name ="FGOODS",nullable=true,length=32)
	public java.lang.String getFgoods(){
		return this.fgoods;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  适用货物
	 */
	public void setFgoods(java.lang.String fgoods){
		this.fgoods = fgoods;
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
