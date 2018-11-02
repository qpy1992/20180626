package com.jeecg.hetong1.entity;
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
 * @Description: 门点信息
 * @author onlineGenerator
 * @date 2018-07-09 09:03:41
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_hetong_1", schema = "")
@SuppressWarnings("serial")
public class Hetong1Entity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**门点代码*/
    @Excel(name="门点代码",width=15)
	private java.lang.String fnumber;
	/**门点地址*/
    @Excel(name="门点地址",width=15)
	private java.lang.String faddress;
	/**提还箱堆场区域*/
    @Excel(name="提还箱堆场区域",width=15)
	private java.lang.String fyard;
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
	 *@return: java.lang.String  门点代码
	 */
	
	@Column(name ="FNUMBER",nullable=true,length=32)
	public java.lang.String getFnumber(){
		return this.fnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  门点代码
	 */
	public void setFnumber(java.lang.String fnumber){
		this.fnumber = fnumber;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  门点地址
	 */
	
	@Column(name ="FADDRESS",nullable=true,length=32)
	public java.lang.String getFaddress(){
		return this.faddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  门点地址
	 */
	public void setFaddress(java.lang.String faddress){
		this.faddress = faddress;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提还箱堆场区域
	 */
	
	@Column(name ="FYARD",nullable=true,length=32)
	public java.lang.String getFyard(){
		return this.fyard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提还箱堆场区域
	 */
	public void setFyard(java.lang.String fyard){
		this.fyard = fyard;
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
