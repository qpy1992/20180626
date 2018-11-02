package com.jeecg.cost.entity;

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
 * @Description: 费用
 * @author onlineGenerator
 * @date 2018-08-02 11:15:57
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_cost", schema = "")
@SuppressWarnings("serial")
public class CostEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**审核*/
	private java.lang.String fcheck;
	/**收付*/
	@Excel(name="收付",width=15,dicCode="shoufu")
	private java.lang.String frecePay;
	/**费用种类*/
	@Excel(name="费用种类",width=15)
	private java.lang.String fcostType;
	/**费用种类名称*/
	@Excel(name="费用种类名称",width=15)
	private java.lang.String fcostname;
	/**结算单位*/
	@Excel(name="结算单位",width=15)
	private java.lang.String fsettleUnit;
	/**结算单位名称*/
	@Excel(name="结算单位名称",width=15)
	private java.lang.String fsettlename;
	/**单位*/
	@Excel(name="单位",width=15)
	private java.lang.String funit;
	/**单价*/
	@Excel(name="单价",width=15)
	private java.lang.Double fprice;
	/**数量*/
	@Excel(name="数量",width=15)
	private java.lang.Double fqty;
	/**收付金额*/
	@Excel(name="收付金额",width=15)
	private java.lang.Double frpamount;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.lang.Double famount;
	/**币别*/
	@Excel(name="币别",width = 15)
	private java.lang.String fbibie;
	/**汇率*/
	@Excel(name="汇率",width = 15)
	private  java.lang.Double fhuilv;
	/**本位币金额*/
	@Excel(name="本位币金额",width=15)
	private java.lang.Double fratedAmount;
	/**实际金额*/
	@Excel(name="实际金额",width=15)
	private java.lang.Double factualAmount;
	/**代垫*/
	@Excel(name="代垫",width=15)
	private java.lang.String fcushion;
	/**费用属性*/
	@Excel(name="费用属性",width=15)
	private java.lang.String fcostProp;
	/**客户号*/
	@Excel(name="客户号",width=15)
	private java.lang.String fcusNum;
	/**录入人*/
	@Excel(name="录入人",width=15)
	private java.lang.String finputPerson;
	/**录入时间*/
	@Excel(name="录入时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date finputTime;
	/**主表主键*/
	@Excel(name="主表主键",width=15)
	private java.lang.String fid;
	/**状态*/
	private java.lang.String fstatus;
	
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
	 *@return: java.lang.String  审核
	 */

	@Column(name ="FCHECK",nullable=true,length=32)
	public java.lang.String getFcheck(){
		return this.fcheck;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核
	 */
	public void setFcheck(java.lang.String fcheck){
		this.fcheck = fcheck;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收付
	 */

	@Column(name ="FRECE_PAY",nullable=true,length=32)
	public java.lang.String getFrecePay(){
		return this.frecePay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收付
	 */
	public void setFrecePay(java.lang.String frecePay){
		this.frecePay = frecePay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用种类
	 */

	@Column(name ="FCOST_TYPE",nullable=true,length=32)
	public java.lang.String getFcostType(){
		return this.fcostType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类
	 */
	public void setFcostType(java.lang.String fcostType){
		this.fcostType = fcostType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位
	 */

	@Column(name ="FSETTLE_UNIT",nullable=true,length=32)
	public java.lang.String getFsettleUnit(){
		return this.fsettleUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位
	 */
	public void setFsettleUnit(java.lang.String fsettleUnit){
		this.fsettleUnit = fsettleUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */

	@Column(name ="FUNIT",nullable=true,length=32)
	public java.lang.String getFunit(){
		return this.funit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setFunit(java.lang.String funit){
		this.funit = funit;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  单价
	 */

	@Column(name ="FPRICE",nullable=true,length=32)
	public java.lang.Double getFprice(){
		return this.fprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  单价
	 */
	public void setFprice(java.lang.Double fprice){
		this.fprice = fprice;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  数量
	 */

	@Column(name ="FQTY",nullable=true,length=32)
	public java.lang.Double getFqty(){
		return this.fqty;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  数量
	 */
	public void setFqty(java.lang.Double fqty){
		this.fqty = fqty;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  收付金额
	 */

	@Column(name ="FRPAMOUNT",nullable=true,length=32)
	public java.lang.Double getFrpamount(){
		return this.frpamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  收付金额
	 */
	public void setFrpamount(java.lang.Double frpamount){
		this.frpamount = frpamount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  金额
	 */

	@Column(name ="FAMOUNT",nullable=true,length=32)
	public java.lang.Double getFamount(){
		return this.famount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  金额
	 */
	public void setFamount(java.lang.Double famount){
		this.famount = famount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  额定金额
	 */

	@Column(name ="FRATED_AMOUNT",nullable=true,length=32)
	public java.lang.Double getFratedAmount(){
		return this.fratedAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  额定金额
	 */
	public void setFratedAmount(java.lang.Double fratedAmount){
		this.fratedAmount = fratedAmount;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实际金额
	 */

	@Column(name ="FACTUAL_AMOUNT",nullable=true,length=32)
	public java.lang.Double getFactualAmount(){
		return this.factualAmount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实际金额
	 */
	public void setFactualAmount(java.lang.Double factualAmount){
		this.factualAmount = factualAmount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代垫
	 */

	@Column(name ="FCUSHION",nullable=true,length=32)
	public java.lang.String getFcushion(){
		return this.fcushion;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代垫
	 */
	public void setFcushion(java.lang.String fcushion){
		this.fcushion = fcushion;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用属性
	 */

	@Column(name ="FCOST_PROP",nullable=true,length=32)
	public java.lang.String getFcostProp(){
		return this.fcostProp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用属性
	 */
	public void setFcostProp(java.lang.String fcostProp){
		this.fcostProp = fcostProp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户号
	 */

	@Column(name ="FCUS_NUM",nullable=true,length=32)
	public java.lang.String getFcusNum(){
		return this.fcusNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户号
	 */
	public void setFcusNum(java.lang.String fcusNum){
		this.fcusNum = fcusNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  录入人
	 */

	@Column(name ="FINPUT_PERSON",nullable=true,length=32)
	public java.lang.String getFinputPerson(){
		return this.finputPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  录入人
	 */
	public void setFinputPerson(java.lang.String finputPerson){
		this.finputPerson = finputPerson;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  录入时间
	 */

	@Column(name ="FINPUT_TIME",nullable=true,length=32)
	public java.util.Date getFinputTime(){
		return this.finputTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  录入时间
	 */
	public void setFinputTime(java.util.Date finputTime){
		this.finputTime = finputTime;
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

	@Column(name ="FCOSTNAME",nullable=false,length=32)
	public String getFcostname(){
		return fcostname;
	}

	public void setFcostname(String fcostname){
		this.fcostname = fcostname;
	}

	@Column(name ="FSETTLENAME",nullable=false,length=32)
	public String getFsettlename(){
		return fsettlename;
	}

	public void setFsettlename(String fsettlename){
		this.fsettlename = fsettlename;
	}

    @Column(name ="FBIBIE",nullable=false,length=32)
    public String getFbibie() {
        return fbibie;
    }

    public void setFbibie(String fbibie) {
        this.fbibie = fbibie;
    }

    @Column(name ="FHUILV",nullable=false,length=32)
    public Double getFhuilv() {
        return fhuilv;
    }

    public void setFhuilv(Double fhuilv) {
        this.fhuilv = fhuilv;
    }

    @Column(name ="FSTATUS",nullable=false,length=32)
    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus;
    }
}
