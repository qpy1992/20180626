package com.jeecg.port.entity;

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
 * @Description: 港口
 * @author onlineGenerator
 * @date 2018-06-28 16:31:19
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_port", schema = "")
@SuppressWarnings("serial")
public class PortEntity implements java.io.Serializable {
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
	/**港口代码*/
	@Excel(name="港口代码",width=15)
	private java.lang.String fportCode;
	/**国家代码*/
	@Excel(name="国家代码",width=15)
	private java.lang.String fcountryCode;
	/**港口名称*/
	@Excel(name="港口名称",width=15)
	private java.lang.String fportName;
	/**中文名*/
	@Excel(name="中文名",width=15)
	private java.lang.String fcnName;
	/**所属港口*/
	@Excel(name="所属港口",width=15)
	private java.lang.String fbelong;
	/**数字码*/
	@Excel(name="数字码",width=15)
	private java.lang.String fnumberCode;
	/**海关码*/
	@Excel(name="海关码",width=15)
	private java.lang.String fcustomsCode;
	/**AMS码*/
	@Excel(name="AMS码",width=15)
	private java.lang.String fams;
	/**EDI代码*/
	@Excel(name="EDI代码",width=15)
	private java.lang.String fedi;
	/**EDI代码2*/
	@Excel(name="EDI代码2",width=15)
	private java.lang.String fedi2;
	/**EDI代码3*/
	@Excel(name="EDI代码3",width=15)
	private java.lang.String fedi3;
	/**附加说明*/
	@Excel(name="附加说明",width=15)
	private java.lang.String finstruction;
	/**港口类型*/
	@Excel(name="港口类型",width=15,dicCode="port")
	private java.lang.String fportType;
	
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
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
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

	@Column(name ="CREATE_BY",nullable=true,length=50)
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

	@Column(name ="CREATE_DATE",nullable=true,length=20)
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

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
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

	@Column(name ="UPDATE_BY",nullable=true,length=50)
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

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
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

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
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

	@Column(name ="BPM_STATUS",nullable=true,length=32)
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
	 *@return: java.lang.String  港口代码
	 */

	@Column(name ="FPORT_CODE",nullable=true,length=32)
	public java.lang.String getFportCode(){
		return this.fportCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  港口代码
	 */
	public void setFportCode(java.lang.String fportCode){
		this.fportCode = fportCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国家代码
	 */

	@Column(name ="FCOUNTRY_CODE",nullable=true,length=32)
	public java.lang.String getFcountryCode(){
		return this.fcountryCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国家代码
	 */
	public void setFcountryCode(java.lang.String fcountryCode){
		this.fcountryCode = fcountryCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  港口名称
	 */

	@Column(name ="FPORT_NAME",nullable=true,length=32)
	public java.lang.String getFportName(){
		return this.fportName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  港口名称
	 */
	public void setFportName(java.lang.String fportName){
		this.fportName = fportName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中文名
	 */

	@Column(name ="FCN_NAME",nullable=true,length=255)
	public java.lang.String getFcnName(){
		return this.fcnName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中文名
	 */
	public void setFcnName(java.lang.String fcnName){
		this.fcnName = fcnName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属港口
	 */

	@Column(name ="FBELONG",nullable=true,length=32)
	public java.lang.String getFbelong(){
		return this.fbelong;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属港口
	 */
	public void setFbelong(java.lang.String fbelong){
		this.fbelong = fbelong;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数字码
	 */

	@Column(name ="FNUMBER_CODE",nullable=true,length=32)
	public java.lang.String getFnumberCode(){
		return this.fnumberCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数字码
	 */
	public void setFnumberCode(java.lang.String fnumberCode){
		this.fnumberCode = fnumberCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  海关码
	 */

	@Column(name ="FCUSTOMS_CODE",nullable=true,length=32)
	public java.lang.String getFcustomsCode(){
		return this.fcustomsCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  海关码
	 */
	public void setFcustomsCode(java.lang.String fcustomsCode){
		this.fcustomsCode = fcustomsCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  AMS码
	 */

	@Column(name ="FAMS",nullable=true,length=32)
	public java.lang.String getFams(){
		return this.fams;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  AMS码
	 */
	public void setFams(java.lang.String fams){
		this.fams = fams;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  EDI代码
	 */

	@Column(name ="FEDI",nullable=true,length=32)
	public java.lang.String getFedi(){
		return this.fedi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  EDI代码
	 */
	public void setFedi(java.lang.String fedi){
		this.fedi = fedi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  EDI代码2
	 */

	@Column(name ="FEDI2",nullable=true,length=32)
	public java.lang.String getFedi2(){
		return this.fedi2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  EDI代码2
	 */
	public void setFedi2(java.lang.String fedi2){
		this.fedi2 = fedi2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  EDI代码3
	 */

	@Column(name ="FEDI3",nullable=true,length=32)
	public java.lang.String getFedi3(){
		return this.fedi3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  EDI代码3
	 */
	public void setFedi3(java.lang.String fedi3){
		this.fedi3 = fedi3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附加说明
	 */

	@Column(name ="FINSTRUCTION",nullable=true,length=255)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  港口类型
	 */

	@Column(name ="FPORT_TYPE",nullable=true,length=32)
	public java.lang.String getFportType(){
		return this.fportType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  港口类型
	 */
	public void setFportType(java.lang.String fportType){
		this.fportType = fportType;
	}
}
