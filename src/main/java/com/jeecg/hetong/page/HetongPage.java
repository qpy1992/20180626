
package com.jeecg.hetong.page;
import com.jeecg.hetong.entity.HetongEntity;
import com.jeecg.hetong1.entity.Hetong1Entity;
import com.jeecg.hetong2.entity.Hetong2Entity;

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
 * @Description: 合同维护
 * @author onlineGenerator
 * @date 2018-07-09 09:03:41
 * @version V1.0   
 *
 */
public class HetongPage implements java.io.Serializable {
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
	/**合同号*/
    @Excel(name="合同号")
	private java.lang.String fbillno;
	/**合同类型*/
    @Excel(name="合同类型")
	private java.lang.String ftype;
	/**收付类型*/
    @Excel(name="收付类型")
	private java.lang.String fkind;
	/**结算单位*/
    @Excel(name="结算单位")
	private java.lang.String fsettle;
	/**结算单位名称*/
    @Excel(name="结算单位名称")
	private java.lang.String fsettleName;
	/**计费方式*/
    @Excel(name="计费方式")
	private java.lang.String fchargetype;
	/**生效日期*/
    @Excel(name="生效日期",format = "yyyy-MM-dd")
	private java.util.Date fstartDate;
	/**失效日期*/
    @Excel(name="失效日期",format = "yyyy-MM-dd")
	private java.util.Date fenddate;
	/**附加说明*/
    @Excel(name="附加说明")
	private java.lang.String fnote;
	/**委托编号*/
    @Excel(name="委托编号")
	private java.lang.String fbrno;
	
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
	 *@return: java.lang.String  合同号
	 */
	public java.lang.String getFbillno(){
		return this.fbillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同号
	 */
	public void setFbillno(java.lang.String fbillno){
		this.fbillno = fbillno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同类型
	 */
	public java.lang.String getFtype(){
		return this.ftype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同类型
	 */
	public void setFtype(java.lang.String ftype){
		this.ftype = ftype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收付类型
	 */
	public java.lang.String getFkind(){
		return this.fkind;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收付类型
	 */
	public void setFkind(java.lang.String fkind){
		this.fkind = fkind;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位
	 */
	public java.lang.String getFsettle(){
		return this.fsettle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位
	 */
	public void setFsettle(java.lang.String fsettle){
		this.fsettle = fsettle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位名称
	 */
	public java.lang.String getFsettleName(){
		return this.fsettleName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位名称
	 */
	public void setFsettleName(java.lang.String fsettleName){
		this.fsettleName = fsettleName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计费方式
	 */
	public java.lang.String getFchargetype(){
		return this.fchargetype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计费方式
	 */
	public void setFchargetype(java.lang.String fchargetype){
		this.fchargetype = fchargetype;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生效日期
	 */
	public java.util.Date getFstartDate(){
		return this.fstartDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生效日期
	 */
	public void setFstartDate(java.util.Date fstartDate){
		this.fstartDate = fstartDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  失效日期
	 */
	public java.util.Date getFenddate(){
		return this.fenddate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  失效日期
	 */
	public void setFenddate(java.util.Date fenddate){
		this.fenddate = fenddate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附加说明
	 */
	public java.lang.String getFnote(){
		return this.fnote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附加说明
	 */
	public void setFnote(java.lang.String fnote){
		this.fnote = fnote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  委托编号
	 */
	public java.lang.String getFbrno(){
		return this.fbrno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托编号
	 */
	public void setFbrno(java.lang.String fbrno){
		this.fbrno = fbrno;
	}

	/**保存-门点信息*/
    @ExcelCollection(name="门点信息")
	private List<Hetong1Entity> hetong1List = new ArrayList<Hetong1Entity>();
		public List<Hetong1Entity> getHetong1List() {
		return hetong1List;
		}
		public void setHetong1List(List<Hetong1Entity> hetong1List) {
		this.hetong1List = hetong1List;
		}
	/**保存-价格要素及费率*/
    @ExcelCollection(name="价格要素及费率")
	private List<Hetong2Entity> hetong2List = new ArrayList<Hetong2Entity>();
		public List<Hetong2Entity> getHetong2List() {
		return hetong2List;
		}
		public void setHetong2List(List<Hetong2Entity> hetong2List) {
		this.hetong2List = hetong2List;
		}
}
