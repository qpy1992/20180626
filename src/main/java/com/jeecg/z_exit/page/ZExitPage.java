
package com.jeecg.z_exit.page;
import com.jeecg.z_exit.entity.ZExitEntity;
import com.jeecg.z_exitdetail.entity.ZExitdetailEntity;

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
 * @Description: 出库
 * @author onlineGenerator
 * @date 2018-08-10 12:21:40
 * @version V1.0   
 *
 */
public class ZExitPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**流水编码*/
    @Excel(name="流水编码")
	private java.lang.String zLsbm;
	/**制单日期*/
    @Excel(name="制单日期",format = "yyyy-MM-dd")
	private java.util.Date zZddate;
	/**制单人*/
    @Excel(name="制单人")
	private java.lang.String zZdpeople;
	/**审核人*/
    @Excel(name="审核人")
	private java.lang.String zCheckpeople;
	/**审核时间*/
    @Excel(name="审核时间",format = "yyyy-MM-dd")
	private java.util.Date zChecktime;
	/**车号*/
    @Excel(name="车号")
	private java.lang.String zCh;
	/**驾驶员*/
    @Excel(name="驾驶员")
	private java.lang.String zJsy;
	/**出库人*/
    @Excel(name="出库人")
	private java.lang.String zExitpeople;
	/**出库合计*/
    @Excel(name="出库合计")
	private java.lang.String zExittotal;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String zBz;
	
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
	 *@return: java.lang.String  创建人名称
	 */
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流水编码
	 */
	public java.lang.String getZLsbm(){
		return this.zLsbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流水编码
	 */
	public void setZLsbm(java.lang.String zLsbm){
		this.zLsbm = zLsbm;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  制单日期
	 */
	public java.util.Date getZZddate(){
		return this.zZddate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  制单日期
	 */
	public void setZZddate(java.util.Date zZddate){
		this.zZddate = zZddate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  制单人
	 */
	public java.lang.String getZZdpeople(){
		return this.zZdpeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  制单人
	 */
	public void setZZdpeople(java.lang.String zZdpeople){
		this.zZdpeople = zZdpeople;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */
	public java.lang.String getZCheckpeople(){
		return this.zCheckpeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setZCheckpeople(java.lang.String zCheckpeople){
		this.zCheckpeople = zCheckpeople;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核时间
	 */
	public java.util.Date getZChecktime(){
		return this.zChecktime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核时间
	 */
	public void setZChecktime(java.util.Date zChecktime){
		this.zChecktime = zChecktime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车号
	 */
	public java.lang.String getZCh(){
		return this.zCh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车号
	 */
	public void setZCh(java.lang.String zCh){
		this.zCh = zCh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶员
	 */
	public java.lang.String getZJsy(){
		return this.zJsy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶员
	 */
	public void setZJsy(java.lang.String zJsy){
		this.zJsy = zJsy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出库人
	 */
	public java.lang.String getZExitpeople(){
		return this.zExitpeople;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出库人
	 */
	public void setZExitpeople(java.lang.String zExitpeople){
		this.zExitpeople = zExitpeople;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出库合计
	 */
	public java.lang.String getZExittotal(){
		return this.zExittotal;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出库合计
	 */
	public void setZExittotal(java.lang.String zExittotal){
		this.zExittotal = zExittotal;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	public java.lang.String getZBz(){
		return this.zBz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setZBz(java.lang.String zBz){
		this.zBz = zBz;
	}

	/**保存-出库明细表*/
    @ExcelCollection(name="出库明细表")
	private List<ZExitdetailEntity> zExitdetailList = new ArrayList<ZExitdetailEntity>();
		public List<ZExitdetailEntity> getZExitdetailList() {
		return zExitdetailList;
		}
		public void setZExitdetailList(List<ZExitdetailEntity> zExitdetailList) {
		this.zExitdetailList = zExitdetailList;
		}
}
