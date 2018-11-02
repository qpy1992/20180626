package com.jeecg.zoutstoragedetail.entity;
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
 * @Description: 领用明细
 * @author onlineGenerator
 * @date 2018-08-26 15:43:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_outstoragedetail", schema = "")
@SuppressWarnings("serial")
public class ZOutstoragedetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**物料代码*/
    @Excel(name="物料代码",width=15)
	private java.lang.String wulioCode;
	/**物料名称*/
    @Excel(name="物料名称",width=15)
	private java.lang.String wulioName;
	/**规格型号*/
    @Excel(name="规格型号",width=15)
	private java.lang.String specifications;
	/**单位*/
    @Excel(name="单位",width=15)
	private java.lang.String unit;
	/**库存数量*/
    @Excel(name="库存数量",width=15)
    private java.lang.Integer number;
	/**领用数量*/
    @Excel(name="领用数量",width=15)
    private java.lang.Integer lyNumber;
	/**进价*/
    @Excel(name="进价",width=15)
    private java.lang.Double purchasePrice;
	/**进价合计*/
    @Excel(name="进价合计",width=15)
    private java.lang.Double purchaseTotal;
	/**销价*/
    @Excel(name="销价",width=15)
    private java.lang.Double salePrice;
	/**销价合计*/
    @Excel(name="销价合计",width=15)
    private java.lang.Double saleTotal;
	/**利润*/
    @Excel(name="利润",width=15)
    private java.lang.Double profits;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String note;
	/**父id*/
    @Excel(name="父id",width=15)
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
	 *@return: java.lang.String  物料代码
	 */
	
	@Column(name ="WULIO_CODE",nullable=true,length=32)
	public java.lang.String getWulioCode(){
		return this.wulioCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  物料代码
	 */
	public void setWulioCode(java.lang.String wulioCode){
		this.wulioCode = wulioCode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  物料名称
	 */
	
	@Column(name ="WULIO_NAME",nullable=true,length=32)
	public java.lang.String getWulioName(){
		return this.wulioName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  物料名称
	 */
	public void setWulioName(java.lang.String wulioName){
		this.wulioName = wulioName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格型号
	 */
	
	@Column(name ="SPECIFICATIONS",nullable=true,length=32)
	public java.lang.String getSpecifications(){
		return this.specifications;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格型号
	 */
	public void setSpecifications(java.lang.String specifications){
		this.specifications = specifications;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */
	
	@Column(name ="UNIT",nullable=true,length=32)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
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
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  父id
	 */
	
	@Column(name ="FID",nullable=true,length=32)
	public java.lang.String getFid(){
		return this.fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  父id
	 */
	public void setFid(java.lang.String fid){
		this.fid = fid;
	}

	@Column(name ="number",nullable=true,length=32)
	public java.lang.Integer getNumber() {
		return number;
	}

	public void setNumber(java.lang.Integer number) {
		this.number = number;
	}

	@Column(name ="ly_number",nullable=true,length=32)
	public java.lang.Integer getLyNumber() {
		return lyNumber;
	}

	public void setLyNumber(java.lang.Integer lyNumber) {
		this.lyNumber = lyNumber;
	}

	@Column(name ="purchase_price",nullable=true,length=32)
	public java.lang.Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(java.lang.Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	@Column(name ="purchase_total",nullable=true,length=32)
	public java.lang.Double getPurchaseTotal() {
		return purchaseTotal;
	}

	public void setPurchaseTotal(java.lang.Double purchaseTotal) {
		this.purchaseTotal = purchaseTotal;
	}

	@Column(name ="sale_price",nullable=true,length=32)
	public java.lang.Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(java.lang.Double salePrice) {
		this.salePrice = salePrice;
	}

	@Column(name ="sale_total",nullable=true,length=32)
	public java.lang.Double getSaleTotal() {
		return saleTotal;
	}

	public void setSaleTotal(java.lang.Double saleTotal) {
		this.saleTotal = saleTotal;
	}

	@Column(name ="profits",nullable=true,length=32)
	public java.lang.Double getProfits() {
		return profits;
	}

	public void setProfits(java.lang.Double profits) {
		this.profits = profits;
	}
	
	
	
}
