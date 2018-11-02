package com.jeecg.zputstoragedetail.entity;
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
 * @Description: 入库明细
 * @author onlineGenerator
 * @date 2018-08-24 16:01:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_putstorage_detail", schema = "")
@SuppressWarnings("serial")
public class ZPutstorageDetailEntity implements java.io.Serializable {
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
	/**入库数量*/
    @Excel(name="入库数量",width=15)
	private java.lang.Integer rkNumber;
	/**进价*/
    @Excel(name="进价",width=15)
	private java.lang.Double purchasePrice;
	/**进价合计*/
    @Excel(name="进价合计",width=15)
	private java.lang.Double purchaseTotal;
	/**售价*/
    @Excel(name="售价",width=15)
	private java.lang.Double salePrice;
	/**售价合计*/
    @Excel(name="售价合计",width=15)
	private java.lang.Double saleTotal;
	/**采购日期*/
    @Excel(name="采购日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date purchaseDate;
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
	
	@Column(name ="WULIO_Code",nullable=true,length=32)
	public java.lang.String getWulioCode() {
		return wulioCode;
	}

	public void setWulioCode(java.lang.String wulioCode) {
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  入库数量
	 */
	
	@Column(name ="RK_NUMBER",nullable=true,length=32)
	public java.lang.Integer getRkNumber(){
		return this.rkNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  入库数量
	 */
	public void setRkNumber(java.lang.Integer rkNumber){
		this.rkNumber = rkNumber;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  进价
	 */
	
	@Column(name ="PURCHASE_PRICE",nullable=true,length=32)
	public java.lang.Double getPurchasePrice(){
		return this.purchasePrice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  进价
	 */
	public void setPurchasePrice(java.lang.Double purchasePrice){
		this.purchasePrice = purchasePrice;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  进价合计
	 */
	
	@Column(name ="PURCHASE_TOTAL",nullable=true,length=32)
	public java.lang.Double getPurchaseTotal(){
		return this.purchaseTotal;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  进价合计
	 */
	public void setPurchaseTotal(java.lang.Double purchaseTotal){
		this.purchaseTotal = purchaseTotal;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  售价
	 */
	
	@Column(name ="SALE_PRICE",nullable=true,length=32)
	public java.lang.Double getSalePrice(){
		return this.salePrice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  售价
	 */
	public void setSalePrice(java.lang.Double salePrice){
		this.salePrice = salePrice;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  售价合计
	 */
	
	@Column(name ="SALE_TOTAL",nullable=true,length=32)
	public java.lang.Double getSaleTotal(){
		return this.saleTotal;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  售价合计
	 */
	public void setSaleTotal(java.lang.Double saleTotal){
		this.saleTotal = saleTotal;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  采购日期
	 */
	
	@Column(name ="PURCHASE_DATE",nullable=true,length=32)
	public java.util.Date getPurchaseDate(){
		return this.purchaseDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  采购日期
	 */
	public void setPurchaseDate(java.util.Date purchaseDate){
		this.purchaseDate = purchaseDate;
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

	public Object get(String string) {
		// TODO Auto-generated method stub
		return wulioCode;
	}

	@Override
	public String toString() {
		return "ZPutstorageDetailEntity [id=" + id + ", wulioCode=" + wulioCode + ", wulioName=" + wulioName
				+ ", specifications=" + specifications + ", unit=" + unit + ", rkNumber=" + rkNumber
				+ ", purchasePrice=" + purchasePrice + ", purchaseTotal=" + purchaseTotal + ", salePrice=" + salePrice
				+ ", saleTotal=" + saleTotal + ", purchaseDate=" + purchaseDate + ", note=" + note + ", fid=" + fid
				+ "]";
	}

	
}
