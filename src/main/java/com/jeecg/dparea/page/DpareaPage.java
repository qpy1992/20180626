
package com.jeecg.dparea.page;
import com.jeecg.dparea.entity.DpareaEntity;
import com.jeecg.dp.entity.DpEntity;

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
 * @Description: 门点区域
 * @author onlineGenerator
 * @date 2018-08-06 09:57:31
 * @version V1.0   
 *
 */
public class DpareaPage implements java.io.Serializable {
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
	/**区域代码*/
    @Excel(name="区域代码")
	private java.lang.String fareaCode;
	/**作废*/
	private java.lang.String fvoid;
	/**区域名称*/
    @Excel(name="区域名称")
	private java.lang.String fareaName;
	/**项目组*/
    @Excel(name="项目组")
	private java.lang.String fprojectTeam;
	/**附加说明*/
    @Excel(name="附加说明")
	private java.lang.String finstruction;
	
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
	 *@return: java.lang.String  区域代码
	 */
	public java.lang.String getFareaCode(){
		return this.fareaCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区域代码
	 */
	public void setFareaCode(java.lang.String fareaCode){
		this.fareaCode = fareaCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作废
	 */
	public java.lang.String getFvoid(){
		return this.fvoid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作废
	 */
	public void setFvoid(java.lang.String fvoid){
		this.fvoid = fvoid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区域名称
	 */
	public java.lang.String getFareaName(){
		return this.fareaName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区域名称
	 */
	public void setFareaName(java.lang.String fareaName){
		this.fareaName = fareaName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目组
	 */
	public java.lang.String getFprojectTeam(){
		return this.fprojectTeam;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目组
	 */
	public void setFprojectTeam(java.lang.String fprojectTeam){
		this.fprojectTeam = fprojectTeam;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附加说明
	 */
	public java.lang.String getFinstruction(){
		return this.finstruction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附加说明
	 */
	public void setFinstruction(java.lang.String finstruction){
		this.finstruction = finstruction;
	}

	/**保存-门点堆场*/
    @ExcelCollection(name="门点堆场")
	private List<DpEntity> dpList = new ArrayList<DpEntity>();
		public List<DpEntity> getDpList() {
		return dpList;
		}
		public void setDpList(List<DpEntity> dpList) {
		this.dpList = dpList;
		}
}
