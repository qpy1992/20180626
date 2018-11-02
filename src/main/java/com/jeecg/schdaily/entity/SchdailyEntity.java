package com.jeecg.schdaily.entity;

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
 * @Description: 调度日记
 * @author onlineGenerator
 * @date 2018-09-18 10:15:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_schdaily", schema = "")
@SuppressWarnings("serial")
public class SchdailyEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**托运单位*/
	@Excel(name="托运单位",width=15)
	private java.lang.String ftuoyun;
	/**派车单号*/
	@Excel(name="派车单号",width=15)
	private java.lang.String fpaicheno;
	/**提箱点*/
	@Excel(name="提箱点",width=15)
	private java.lang.String ftxyard;
	/**装货时间*/
	@Excel(name="装货时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fzhtime;
	/**装货门点*/
	@Excel(name="装货门点",width=15)
	private java.lang.String fzhaddress;
	/**卸货时间*/
	@Excel(name="卸货时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fxhtime;
	/**卸货门点*/
	@Excel(name="卸货门点",width=15)
	private java.lang.String fxhaddress;
	/**换箱点*/
	@Excel(name="换箱点",width=15)
	private java.lang.String fhxyard;
	/**箱量*/
	@Excel(name="箱量",width=15)
	private java.lang.String fboxamount;
	/**箱号*/
	@Excel(name="箱号",width=15)
	private java.lang.String fboxno;
	/**车号*/
	@Excel(name="车号",width=15)
	private java.lang.String fcarno;
	/**挂车号*/
	@Excel(name="挂车号",width=15)
	private java.lang.String fguano;
	/**司机*/
	@Excel(name="司机",width=15)
	private java.lang.String fdriver;
	/**额外费用*/
	@Excel(name="额外费用",width=15)
	private java.lang.Double fbudget;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String fnote;
	@Excel(name="日期",width=15)
	private java.lang.String fdate;
	
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
	 *@return: java.lang.String  托运单位
	 */

	@Column(name ="FTUOYUN",nullable=true,length=32)
	public java.lang.String getFtuoyun(){
		return this.ftuoyun;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  托运单位
	 */
	public void setFtuoyun(java.lang.String ftuoyun){
		this.ftuoyun = ftuoyun;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单号
	 */

	@Column(name ="FPAICHENO",nullable=true,length=32)
	public java.lang.String getFpaicheno(){
		return this.fpaicheno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单号
	 */
	public void setFpaicheno(java.lang.String fpaicheno){
		this.fpaicheno = fpaicheno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提箱点
	 */

	@Column(name ="FTXYARD",nullable=true,length=32)
	public java.lang.String getFtxyard(){
		return this.ftxyard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提箱点
	 */
	public void setFtxyard(java.lang.String ftxyard){
		this.ftxyard = ftxyard;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  装货时间
	 */

	@Column(name ="FZHTIME",nullable=true,length=32)
	public java.util.Date getFzhtime(){
		return this.fzhtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  装货时间
	 */
	public void setFzhtime(java.util.Date fzhtime){
		this.fzhtime = fzhtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装货门点
	 */

	@Column(name ="FZHADDRESS",nullable=true,length=32)
	public java.lang.String getFzhaddress(){
		return this.fzhaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装货门点
	 */
	public void setFzhaddress(java.lang.String fzhaddress){
		this.fzhaddress = fzhaddress;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  卸货时间
	 */

	@Column(name ="FXHTIME",nullable=true,length=32)
	public java.util.Date getFxhtime(){
		return this.fxhtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  卸货时间
	 */
	public void setFxhtime(java.util.Date fxhtime){
		this.fxhtime = fxhtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卸货门点
	 */

	@Column(name ="FXHADDRESS",nullable=true,length=32)
	public java.lang.String getFxhaddress(){
		return this.fxhaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卸货门点
	 */
	public void setFxhaddress(java.lang.String fxhaddress){
		this.fxhaddress = fxhaddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  换箱点
	 */

	@Column(name ="FHXYARD",nullable=true,length=32)
	public java.lang.String getFhxyard(){
		return this.fhxyard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  换箱点
	 */
	public void setFhxyard(java.lang.String fhxyard){
		this.fhxyard = fhxyard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  箱量
	 */

	@Column(name ="FBOXAMOUNT",nullable=true,length=32)
	public java.lang.String getFboxamount(){
		return this.fboxamount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱量
	 */
	public void setFboxamount(java.lang.String fboxamount){
		this.fboxamount = fboxamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  箱号
	 */

	@Column(name ="FBOXNO",nullable=true,length=32)
	public java.lang.String getFboxno(){
		return this.fboxno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱号
	 */
	public void setFboxno(java.lang.String fboxno){
		this.fboxno = fboxno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车号
	 */

	@Column(name ="FCARNO",nullable=true,length=32)
	public java.lang.String getFcarno(){
		return this.fcarno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车号
	 */
	public void setFcarno(java.lang.String fcarno){
		this.fcarno = fcarno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  挂车号
	 */

	@Column(name ="FGUANO",nullable=true,length=32)
	public java.lang.String getFguano(){
		return this.fguano;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  挂车号
	 */
	public void setFguano(java.lang.String fguano){
		this.fguano = fguano;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  司机
	 */

	@Column(name ="FDRIVER",nullable=true,length=32)
	public java.lang.String getFdriver(){
		return this.fdriver;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  司机
	 */
	public void setFdriver(java.lang.String fdriver){
		this.fdriver = fdriver;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  额外费用
	 */

	@Column(name ="FBUDGET",nullable=true,length=32)
	public java.lang.Double getFbudget(){
		return this.fbudget;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  额外费用
	 */
	public void setFbudget(java.lang.Double fbudget){
		this.fbudget = fbudget;
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

	@Column(name="FDATE",nullable=true,length=32)
	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
}
