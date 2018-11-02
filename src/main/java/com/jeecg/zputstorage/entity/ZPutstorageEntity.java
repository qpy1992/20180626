package com.jeecg.zputstorage.entity;
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
 * @Description: 入库
 * @author onlineGenerator
 * @date 2018-08-24 16:01:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_putstorage", schema = "")
@SuppressWarnings("serial")
public class ZPutstorageEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**流水编码*/
    @Excel(name="流水编码",width=15)
	private java.lang.String code;
	/**制单日期*/
    @Excel(name="制单日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date makeDate;
	/**制单人*/
    @Excel(name="制单人",width=15)
	private java.lang.String makePeople;
	/**审核人*/
    @Excel(name="审核人",width=15)
	private java.lang.String checkPeople;
	/**审核日期*/
    @Excel(name="审核日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date checkDate;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String note;
	
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
	 *@return: java.lang.String  流水编码
	 */
	
	@Column(name ="CODE",nullable=true,length=32)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流水编码
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  制单日期
	 */
	
	@Column(name ="MAKE_DATE",nullable=true,length=32)
	public java.util.Date getMakeDate(){
		return this.makeDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  制单日期
	 */
	public void setMakeDate(java.util.Date makeDate){
		this.makeDate = makeDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  制单人
	 */
	
	@Column(name ="MAKE_PEOPLE",nullable=true,length=32)
	public java.lang.String getMakePeople(){
		return this.makePeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  制单人
	 */
	public void setMakePeople(java.lang.String makePeople){
		this.makePeople = makePeople;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */
	
	@Column(name ="CHECK_PEOPLE",nullable=true,length=32)
	public java.lang.String getCheckPeople(){
		return this.checkPeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setCheckPeople(java.lang.String checkPeople){
		this.checkPeople = checkPeople;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核日期
	 */
	
	@Column(name ="CHECK_DATE",nullable=true,length=32)
	public java.util.Date getCheckDate(){
		return this.checkDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核日期
	 */
	public void setCheckDate(java.util.Date checkDate){
		this.checkDate = checkDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	
	@Column(name ="NOTE",nullable=true,length=32)
	public java.lang.String getNote(){
		return this.note;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setNote(java.lang.String note){
		this.note = note;
	}
	
}
