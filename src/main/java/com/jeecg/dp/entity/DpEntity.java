package com.jeecg.dp.entity;
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
 * @Description: 门点堆场
 * @author onlineGenerator
 * @date 2018-08-06 09:57:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_dp", schema = "")
@SuppressWarnings("serial")
public class DpEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**门点代码*/
    @Excel(name="门点代码",width=15)
	private java.lang.String fitemid;
	/**门点名称*/
    @Excel(name="门点名称",width=15)
	private java.lang.String fname;
	/**联系人*/
    @Excel(name="联系人",width=15)
	private java.lang.String fcontact;
	/**电话*/
    @Excel(name="电话",width=15)
	private java.lang.String fphone;
	/**主表id*/
	private java.lang.String fid;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	
	@Column(name ="ID",nullable=false,length=64)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  门点代码
	 */
	
	@Column(name ="FITEMID",nullable=true,length=255)
	public java.lang.String getFitemid(){
		return this.fitemid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  门点代码
	 */
	public void setFitemid(java.lang.String fitemid){
		this.fitemid = fitemid;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  门点名称
	 */
	
	@Column(name ="FNAME",nullable=true,length=255)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  门点名称
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人
	 */
	
	@Column(name ="FCONTACT",nullable=true,length=255)
	public java.lang.String getFcontact(){
		return this.fcontact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人
	 */
	public void setFcontact(java.lang.String fcontact){
		this.fcontact = fcontact;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */
	
	@Column(name ="FPHONE",nullable=true,length=255)
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
