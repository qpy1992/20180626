
package com.jeecg.zputstorage.page;
import com.jeecg.zputstorage.entity.ZPutstorageEntity;
import com.jeecg.zputstoragedetail.entity.ZPutstorageDetailEntity;

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
 * @Description: 入库
 * @author onlineGenerator
 * @date 2018-08-24 16:01:08
 * @version V1.0   
 *
 */
public class ZPutstoragePage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**流水编码*/
    @Excel(name="流水编码")
	private java.lang.String code;
	/**制单日期*/
    @Excel(name="制单日期",format = "yyyy-MM-dd")
	private java.util.Date makeDate;
	/**制单人*/
    @Excel(name="制单人")
	private java.lang.String makePeople;
	/**审核人*/
    @Excel(name="审核人")
	private java.lang.String checkPeople;
	/**审核日期*/
    @Excel(name="审核日期",format = "yyyy-MM-dd")
	private java.util.Date checkDate;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  制单日期
	 */
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核日期
	 */
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

	/**保存-入库明细*/
    @ExcelCollection(name="入库明细")
	private List<ZPutstorageDetailEntity> zPutstorageDetailList = new ArrayList<ZPutstorageDetailEntity>();
		public List<ZPutstorageDetailEntity> getZPutstorageDetailList() {
		return zPutstorageDetailList;
		}
		public void setZPutstorageDetailList(List<ZPutstorageDetailEntity> zPutstorageDetailList) {
		this.zPutstorageDetailList = zPutstorageDetailList;
		}
}
