package com.jeecg.bxcost.entity;
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
 * @Description: 报销费用明细
 * @author onlineGenerator
 * @date 2018-08-16 10:35:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_bxcost", schema = "")
@SuppressWarnings("serial")
public class BxcostEntity implements java.io.Serializable {
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
	/**委托单号*/
    @Excel(name="委托单号",width=15)
	private java.lang.String fweituo;
	/**提单号*/
    @Excel(name="提单号",width=15)
	private java.lang.String fbrno;
	/**费用种类*/
    @Excel(name="费用种类",width=15)
	private java.lang.String fcost;
	/**结算单位代码*/
    @Excel(name="结算单位代码",width=15)
	private java.lang.String fsettle;
	/**结算单位名称*/
    @Excel(name="结算单位名称",width=15)
	private java.lang.String fsettlename;
	/**派车单号*/
    @Excel(name="派车单号",width=15)
	private java.lang.String fpaiche;
	/**箱号*/
    @Excel(name="箱号",width=15)
	private java.lang.String fboxno;
	/**金额*/
    @Excel(name="金额",width=15)
	private java.lang.Double famount;
	/**收付金额*/
    @Excel(name="收付金额",width=15)
	private java.lang.Double fsfamount;
	/**代垫*/
    @Excel(name="代垫",width=15)
	private java.lang.String fdaidian;
	/**附加说明*/
    @Excel(name="附加说明",width=15)
	private java.lang.String finstruction;
	/**主表主键*/
	private java.lang.String fid;
	/**费用id*/
	private java.lang.String costid;
	
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
	 *@return: java.lang.String  委托单号
	 */
	
	@Column(name ="FWEITUO",nullable=true,length=32)
	public java.lang.String getFweituo(){
		return this.fweituo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托单号
	 */
	public void setFweituo(java.lang.String fweituo){
		this.fweituo = fweituo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提单号
	 */
	
	@Column(name ="FBRNO",nullable=true,length=32)
	public java.lang.String getFbrno(){
		return this.fbrno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提单号
	 */
	public void setFbrno(java.lang.String fbrno){
		this.fbrno = fbrno;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用种类
	 */
	
	@Column(name ="FCOST",nullable=true,length=32)
	public java.lang.String getFcost(){
		return this.fcost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类
	 */
	public void setFcost(java.lang.String fcost){
		this.fcost = fcost;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位代码
	 */
	
	@Column(name ="FSETTLE",nullable=true,length=32)
	public java.lang.String getFsettle(){
		return this.fsettle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位代码
	 */
	public void setFsettle(java.lang.String fsettle){
		this.fsettle = fsettle;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位名称
	 */
	
	@Column(name ="FSETTLENAME",nullable=true,length=32)
	public java.lang.String getFsettlename(){
		return this.fsettlename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结算单位名称
	 */
	public void setFsettlename(java.lang.String fsettlename){
		this.fsettlename = fsettlename;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  派车单号
	 */
	
	@Column(name ="FPAICHE",nullable=true,length=32)
	public java.lang.String getFpaiche(){
		return this.fpaiche;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  派车单号
	 */
	public void setFpaiche(java.lang.String fpaiche){
		this.fpaiche = fpaiche;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  箱号
	 */
	
	@Column(name ="FBOXNO",nullable=true,length=32)
	public java.lang.String getFboxno(){
		return this.fboxno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱号
	 */
	public void setFboxno(java.lang.String fboxno){
		this.fboxno = fboxno;
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
	 *@return: java.lang.Double  收付金额
	 */
	
	@Column(name ="FSFAMOUNT",nullable=true,length=32)
	public java.lang.Double getFsfamount(){
		return this.fsfamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  收付金额
	 */
	public void setFsfamount(java.lang.Double fsfamount){
		this.fsfamount = fsfamount;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代垫
	 */
	
	@Column(name ="FDAIDIAN",nullable=true,length=32)
	public java.lang.String getFdaidian(){
		return this.fdaidian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代垫
	 */
	public void setFdaidian(java.lang.String fdaidian){
		this.fdaidian = fdaidian;
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
	 *@return: java.lang.String  主表主键
	 */
	
	@Column(name ="FID",nullable=true,length=32)
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

	@Column(name = "COSTID",nullable = true,length = 32)
    public String getCostid() {
        return costid;
    }

    public void setCostid(String costid) {
        this.costid = costid;
    }
}
