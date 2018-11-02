
package com.jeecg.zoutstorage.page;
import com.jeecg.zoutstorage.entity.ZOutstorageEntity;
import com.jeecg.zoutstoragedetail.entity.ZOutstoragedetailEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

/**   
 * @Title: Entity
 * @Description: 领用单
 * @author onlineGenerator
 * @date 2018-08-26 15:43:21
 * @version V1.0   
 *
 */
public class ZOutstoragePage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**流水编码*/
    @Excel(name="流水编码")
	private java.lang.String code;
	/**制单日期*/
    @Excel(name="制单日期")
	private java.lang.String makeDate;
	/**制单人*/
    @Excel(name="制单人")
	private java.lang.String makePeople;
	/**审核人*/
    @Excel(name="审核人")
	private java.lang.String checkPeople;
	/**审核ri日期*/
    @Excel(name="审核ri日期")
	private java.lang.String checkDate;
	/**车号*/
    @Excel(name="车号")
	private java.lang.String carcode;
	/**驾驶员*/
    @Excel(name="驾驶员")
	private java.lang.String driver;
	/**领用人*/
    @Excel(name="领用人")
	private java.lang.String lyperson;
	/**领用合计*/
    @Excel(name="领用合计")
	private java.lang.String lytotal;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String note;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  制单日期
	 */
	public java.lang.String getMakeDate(){
		return this.makeDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  制单日期
	 */
	public void setMakeDate(java.lang.String makeDate){
		this.makeDate = makeDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  制单人
	 */
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核ri日期
	 */
	public java.lang.String getCheckDate(){
		return this.checkDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核ri日期
	 */
	public void setCheckDate(java.lang.String checkDate){
		this.checkDate = checkDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车号
	 */
	public java.lang.String getCarcode(){
		return this.carcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车号
	 */
	public void setCarcode(java.lang.String carcode){
		this.carcode = carcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶员
	 */
	public java.lang.String getDriver(){
		return this.driver;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶员
	 */
	public void setDriver(java.lang.String driver){
		this.driver = driver;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  领用人
	 */
	public java.lang.String getLyperson(){
		return this.lyperson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  领用人
	 */
	public void setLyperson(java.lang.String lyperson){
		this.lyperson = lyperson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  领用合计
	 */
	public java.lang.String getLytotal(){
		return this.lytotal;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  领用合计
	 */
	public void setLytotal(java.lang.String lytotal){
		this.lytotal = lytotal;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
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

	/**保存-领用明细*/
    @ExcelCollection(name="领用明细")
	private List<ZOutstoragedetailEntity> zOutstoragedetailList = new ArrayList<ZOutstoragedetailEntity>();
		public List<ZOutstoragedetailEntity> getZOutstoragedetailList() {
		return zOutstoragedetailList;
		}
		public void setZOutstoragedetailList(List<ZOutstoragedetailEntity> zOutstoragedetailList) {
		this.zOutstoragedetailList = zOutstoragedetailList;
		}
}
