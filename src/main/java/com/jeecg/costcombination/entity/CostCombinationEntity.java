package com.jeecg.costcombination.entity;
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
 * @Description: 费用组合
 * @author onlineGenerator
 * @date 2018-10-09 14:33:19
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_cost_combination", schema = "")
@SuppressWarnings("serial")
public class CostCombinationEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**提箱点*/
    @Excel(name="提箱点",width=15)
	private java.lang.String ftxyard;
	/**装货门点*/
    @Excel(name="装货门点",width=15)
	private java.lang.String fload;
	/**卸货门点*/
    @Excel(name="卸货门点",width=15)
	private java.lang.String fdischarge;
	/**还箱点*/
    @Excel(name="还箱点",width=15)
	private java.lang.String fhxyard;
	/**费用*/
    @Excel(name="费用",width=15)
	private java.lang.Double fcost;
	/**开始时间*/
    @Excel(name="开始时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fstart;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String fnote;
	/**主表id*/
	private java.lang.String fid;
	/**提箱点id*/
	private java.lang.String ftxid;
	/**装货点id*/
	private java.lang.String fzhid;
	/**卸货点id*/
	private java.lang.String fxhid;
	/**还箱点id*/
	private java.lang.String fhxid;
	/**预派车天数*/
	private java.lang.Integer fday;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装货门点
	 */
	
	@Column(name ="FLOAD",nullable=true,length=32)
	public java.lang.String getFload(){
		return this.fload;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装货门点
	 */
	public void setFload(java.lang.String fload){
		this.fload = fload;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卸货门点
	 */
	
	@Column(name ="FDISCHARGE",nullable=true,length=32)
	public java.lang.String getFdischarge(){
		return this.fdischarge;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卸货门点
	 */
	public void setFdischarge(java.lang.String fdischarge){
		this.fdischarge = fdischarge;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  还箱点
	 */
	
	@Column(name ="FHXYARD",nullable=true,length=32)
	public java.lang.String getFhxyard(){
		return this.fhxyard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  还箱点
	 */
	public void setFhxyard(java.lang.String fhxyard){
		this.fhxyard = fhxyard;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  费用
	 */
	
	@Column(name ="FCOST",nullable=true,length=32)
	public java.lang.Double getFcost(){
		return this.fcost;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  费用
	 */
	public void setFcost(java.lang.Double fcost){
		this.fcost = fcost;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */
	
	@Column(name ="FSTART",nullable=true,length=32)
	public java.util.Date getFstart(){
		return this.fstart;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始时间
	 */
	public void setFstart(java.util.Date fstart){
		this.fstart = fstart;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提箱点id
	 */
	
	@Column(name ="FTXID",nullable=true,length=32)
	public java.lang.String getFtxid(){
		return this.ftxid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提箱点id
	 */
	public void setFtxid(java.lang.String ftxid){
		this.ftxid = ftxid;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装货点id
	 */
	
	@Column(name ="FZHID",nullable=true,length=32)
	public java.lang.String getFzhid(){
		return this.fzhid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装货点id
	 */
	public void setFzhid(java.lang.String fzhid){
		this.fzhid = fzhid;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卸货点id
	 */
	
	@Column(name ="FXHID",nullable=true,length=32)
	public java.lang.String getFxhid(){
		return this.fxhid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卸货点id
	 */
	public void setFxhid(java.lang.String fxhid){
		this.fxhid = fxhid;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  还箱点id
	 */
	
	@Column(name ="FHXID",nullable=true,length=32)
	public java.lang.String getFhxid(){
		return this.fhxid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  还箱点id
	 */
	public void setFhxid(java.lang.String fhxid){
		this.fhxid = fhxid;
	}

	@Column(name="fday",length=32)
	public Integer getFday() {
		return fday;
	}

	public void setFday(Integer fday) {
		this.fday = fday;
	}
}
