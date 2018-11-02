package com.jeecg.custom.entity;
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
 * @Description: 客户资料维护
 * @author onlineGenerator
 * @date 2018-08-31 16:32:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_custom", schema = "")
@SuppressWarnings("serial")
public class CustomEntity implements java.io.Serializable {
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
	/**公司类型*/
    @Excel(name="公司类型",width=15,dicCode="comtype")
	private java.lang.Integer fcompanyType;
	/**客户代码*/
    @Excel(name="客户代码",width=15)
	private java.lang.String fcustomCode;
	/**简称*/
    @Excel(name="简称",width=15)
	private java.lang.String fabbr;
	/**税号*/
    @Excel(name="税号",width=15)
	private java.lang.String fdutyPara;
	/**中文名称*/
    @Excel(name="中文名称",width=15)
	private java.lang.String fcnName;
	/**英文名称*/
    @Excel(name="英文名称",width=15)
	private java.lang.String fenName;
	/**财务编码*/
    @Excel(name="财务编码",width=15)
	private java.lang.String financeCode;
	/**信用等级*/
    @Excel(name="信用等级",width=15,dicCode="grade")
	private java.lang.String fcreditRate;
	/**合同期起*/
    @Excel(name="合同期起",width=15,format = "yyyy-MM-dd")
	private java.util.Date fcontractStart;
	/**合同期止*/
    @Excel(name="合同期止",width=15,format = "yyyy-MM-dd")
	private java.util.Date fcontractEnd;
	/**项目组*/
    @Excel(name="项目组",width=15,dicCode="team")
	private java.lang.String fprojectTeam;
	/**国家城市*/
    @Excel(name="国家城市",width=15)
	private java.lang.String fcountry;
	/**地址*/
    @Excel(name="地址",width=15)
	private java.lang.String faddress;
	/**邮编*/
    @Excel(name="邮编",width=15)
	private java.lang.String fzipcode;
	/**联系电话*/
    @Excel(name="联系电话",width=15)
	private java.lang.String fmobile;
	/**联系传真*/
    @Excel(name="联系传真",width=15)
	private java.lang.String fax;
	/**关键字*/
    @Excel(name="关键字",width=15)
	private java.lang.String fkeyword;
	/**公司网址*/
    @Excel(name="公司网址",width=15)
	private java.lang.String fcompanyWebsite;
	/**电子邮件*/
    @Excel(name="电子邮件",width=15)
	private java.lang.String femail;
	/**开票税率*/
    @Excel(name="开票税率",width=15)
	private java.lang.Double fticketRate;
	/**附加说明*/
    @Excel(name="附加说明",width=15)
	private java.lang.String finstruction;
	private java.lang.String province;
	private java.lang.String city;
	private java.lang.String area;

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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  公司类型
	 */
	
	@Column(name ="FCOMPANY_TYPE",nullable=true,length=32)
	public java.lang.Integer getFcompanyType(){
		return this.fcompanyType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  公司类型
	 */
	public void setFcompanyType(java.lang.Integer fcompanyType){
		this.fcompanyType = fcompanyType;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户代码
	 */
	
	@Column(name ="FCUSTOM_CODE",nullable=true,length=32)
	public java.lang.String getFcustomCode(){
		return this.fcustomCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户代码
	 */
	public void setFcustomCode(java.lang.String fcustomCode){
		this.fcustomCode = fcustomCode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简称
	 */
	
	@Column(name ="FABBR",nullable=true,length=255)
	public java.lang.String getFabbr(){
		return this.fabbr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简称
	 */
	public void setFabbr(java.lang.String fabbr){
		this.fabbr = fabbr;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  税号
	 */
	
	@Column(name ="FDUTY_PARA",nullable=true,length=32)
	public java.lang.String getFdutyPara(){
		return this.fdutyPara;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  税号
	 */
	public void setFdutyPara(java.lang.String fdutyPara){
		this.fdutyPara = fdutyPara;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中文名称
	 */
	
	@Column(name ="FCN_NAME",nullable=true,length=255)
	public java.lang.String getFcnName(){
		return this.fcnName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中文名称
	 */
	public void setFcnName(java.lang.String fcnName){
		this.fcnName = fcnName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  英文名称
	 */
	
	@Column(name ="FEN_NAME",nullable=true,length=255)
	public java.lang.String getFenName(){
		return this.fenName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  英文名称
	 */
	public void setFenName(java.lang.String fenName){
		this.fenName = fenName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  财务编码
	 */
	
	@Column(name ="FINANCE_CODE",nullable=true,length=32)
	public java.lang.String getFinanceCode(){
		return this.financeCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  财务编码
	 */
	public void setFinanceCode(java.lang.String financeCode){
		this.financeCode = financeCode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  信用等级
	 */
	
	@Column(name ="FCREDIT_RATE",nullable=true,length=32)
	public java.lang.String getFcreditRate(){
		return this.fcreditRate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  信用等级
	 */
	public void setFcreditRate(java.lang.String fcreditRate){
		this.fcreditRate = fcreditRate;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  合同期起
	 */
	
	@Column(name ="FCONTRACT_START",nullable=true,length=32)
	public java.util.Date getFcontractStart(){
		return this.fcontractStart;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  合同期起
	 */
	public void setFcontractStart(java.util.Date fcontractStart){
		this.fcontractStart = fcontractStart;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  合同期止
	 */
	
	@Column(name ="FCONTRACT_END",nullable=true,length=32)
	public java.util.Date getFcontractEnd(){
		return this.fcontractEnd;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  合同期止
	 */
	public void setFcontractEnd(java.util.Date fcontractEnd){
		this.fcontractEnd = fcontractEnd;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目组
	 */
	
	@Column(name ="FPROJECT_TEAM",nullable=true,length=32)
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
	 *@return: java.lang.String  国家城市
	 */
	
	@Column(name ="FCOUNTRY",nullable=true,length=32)
	public java.lang.String getFcountry(){
		return this.fcountry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国家城市
	 */
	public void setFcountry(java.lang.String fcountry){
		this.fcountry = fcountry;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */
	
	@Column(name ="FADDRESS",nullable=true,length=255)
	public java.lang.String getFaddress(){
		return this.faddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setFaddress(java.lang.String faddress){
		this.faddress = faddress;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮编
	 */
	
	@Column(name ="FZIPCODE",nullable=true,length=32)
	public java.lang.String getFzipcode(){
		return this.fzipcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮编
	 */
	public void setFzipcode(java.lang.String fzipcode){
		this.fzipcode = fzipcode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	
	@Column(name ="FMOBILE",nullable=true,length=32)
	public java.lang.String getFmobile(){
		return this.fmobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setFmobile(java.lang.String fmobile){
		this.fmobile = fmobile;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系传真
	 */
	
	@Column(name ="FAX",nullable=true,length=32)
	public java.lang.String getFax(){
		return this.fax;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系传真
	 */
	public void setFax(java.lang.String fax){
		this.fax = fax;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关键字
	 */
	
	@Column(name ="FKEYWORD",nullable=true,length=32)
	public java.lang.String getFkeyword(){
		return this.fkeyword;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关键字
	 */
	public void setFkeyword(java.lang.String fkeyword){
		this.fkeyword = fkeyword;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司网址
	 */
	
	@Column(name ="FCOMPANY_WEBSITE",nullable=true,length=255)
	public java.lang.String getFcompanyWebsite(){
		return this.fcompanyWebsite;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司网址
	 */
	public void setFcompanyWebsite(java.lang.String fcompanyWebsite){
		this.fcompanyWebsite = fcompanyWebsite;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电子邮件
	 */
	
	@Column(name ="FEMAIL",nullable=true,length=32)
	public java.lang.String getFemail(){
		return this.femail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电子邮件
	 */
	public void setFemail(java.lang.String femail){
		this.femail = femail;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开票税率
	 */
	
	@Column(name ="FTICKET_RATE",nullable=true,length=32)
	public java.lang.Double getFticketRate(){
		return this.fticketRate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开票税率
	 */
	public void setFticketRate(java.lang.Double fticketRate){
		this.fticketRate = fticketRate;
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

    @Column(name ="PROVINCE",nullable=true,length=32)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Column(name ="CITY",nullable=true,length=32)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name ="AREA",nullable=true,length=32)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
