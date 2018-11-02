package com.jeecg.siji.entity;

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
 * @Description: 司机资料
 * @author onlineGenerator
 * @date 2018-10-22 15:43:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_siji", schema = "")
@SuppressWarnings("serial")
public class SijiEntity implements java.io.Serializable {
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
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String fname;
	/**性别*/
	@Excel(name="性别",width=15,dicCode="sex")
	private java.lang.String fsex;
	/**民族*/
	@Excel(name="民族",width=15)
	private java.lang.String fregion;
	/**出生日期*/
	@Excel(name="出生日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date fbirthday;
	/**户籍住址*/
	@Excel(name="户籍住址",width=15)
	private java.lang.String faddress;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private java.lang.String fidnum;
	/**签发机关*/
	@Excel(name="签发机关",width=15)
	private java.lang.String fjiguan;
	/**有效期限起*/
	@Excel(name="有效期限起",width=15,format = "yyyy-MM-dd")
	private java.util.Date fqixian1;
	/**有效期限止*/
	@Excel(name="有效期限止",width=15,format = "yyyy-MM-dd")
	private java.util.Date fqixian2;
	/**从业资格号*/
	@Excel(name="从业资格号",width=15)
	private java.lang.String fcongye;
	/**从业资格类别*/
	@Excel(name="从业资格类别",width=15,dicCode="congye")
	private java.lang.String fcytype;
	/**初次发证时间*/
	@Excel(name="初次发证时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fazhengtime;
	/**发证时间*/
	@Excel(name="发证时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fazheng;
	/**有效期至*/
	@Excel(name="有效期至",width=15,format = "yyyy-MM-dd")
	private java.util.Date fyouxiao;
	/**驾驶证号*/
	@Excel(name="驾驶证号",width=15)
	private java.lang.String fjiashi;
	/**初次领证日期*/
	@Excel(name="初次领证日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date fchuci;
	/**准驾车型*/
	@Excel(name="准驾车型",width=15,dicCode="zhunjia")
	private java.lang.String fzhunjia;
	/**有效起始日期*/
	@Excel(name="有效起始日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date fyouxiao1;
	/**有效期限*/
	@Excel(name="有效期限",width=15)
	private java.lang.String fyxqixian;
	/**档案编号*/
	@Excel(name="档案编号",width=15)
	private java.lang.String fdangan;
	/**记录*/
	@Excel(name="记录",width=15)
	private java.lang.String frecord;
	/**代码*/
	@Excel(name="代码",width=15)
	private java.lang.String fcode;
	/**入职时间*/
	@Excel(name="入职时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fruzhi;
	/**离职时间*/
	@Excel(name="离职时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date flizhi;
	/**手机号*/
	@Excel(name="手机号",width=15)
	private java.lang.String fmobile;
	/**紧急联系人*/
	@Excel(name="紧急联系人",width=15)
	private java.lang.String femergen;
	/**手机号*/
	@Excel(name="手机号",width=15)
	private java.lang.String femobile;
	/**驾驶证*/
	@Excel(name="驾驶证",width=15)
	private java.lang.String fjsz;
	/**身份证*/
	@Excel(name="身份证",width=15)
	private java.lang.String fsfz;
	/**上岗证*/
	@Excel(name="上岗证",width=15)
	private java.lang.String fsgz;
	/**体检报告*/
	@Excel(name="体检报告",width=15)
	private java.lang.String ftjbg;
	/**培训证书*/
	@Excel(name="培训证书",width=15)
	private java.lang.String fpxzs;
	/**意外险*/
	@Excel(name="意外险",width=15)
	private java.lang.String fywx;
	
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
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */

	@Column(name ="FSEX",nullable=true,length=32)
	public java.lang.String getFsex(){
		return this.fsex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setFsex(java.lang.String fsex){
		this.fsex = fsex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */

	@Column(name ="FREGION",nullable=true,length=32)
	public java.lang.String getFregion(){
		return this.fregion;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setFregion(java.lang.String fregion){
		this.fregion = fregion;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生日期
	 */

	@Column(name ="FBIRTHDAY",nullable=true,length=20)
	public java.util.Date getFbirthday(){
		return this.fbirthday;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生日期
	 */
	public void setFbirthday(java.util.Date fbirthday){
		this.fbirthday = fbirthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍住址
	 */

	@Column(name ="FADDRESS",nullable=true,length=1000)
	public java.lang.String getFaddress(){
		return this.faddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍住址
	 */
	public void setFaddress(java.lang.String faddress){
		this.faddress = faddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */

	@Column(name ="FIDNUM",nullable=true,length=32)
	public java.lang.String getFidnum(){
		return this.fidnum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setFidnum(java.lang.String fidnum){
		this.fidnum = fidnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签发机关
	 */

	@Column(name ="FJIGUAN",nullable=true,length=32)
	public java.lang.String getFjiguan(){
		return this.fjiguan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签发机关
	 */
	public void setFjiguan(java.lang.String fjiguan){
		this.fjiguan = fjiguan;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  有效期限起
	 */

	@Column(name ="FQIXIAN1",nullable=true,length=20)
	public java.util.Date getFqixian1(){
		return this.fqixian1;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  有效期限起
	 */
	public void setFqixian1(java.util.Date fqixian1){
		this.fqixian1 = fqixian1;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  有效期限止
	 */

	@Column(name ="FQIXIAN2",nullable=true,length=20)
	public java.util.Date getFqixian2(){
		return this.fqixian2;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  有效期限止
	 */
	public void setFqixian2(java.util.Date fqixian2){
		this.fqixian2 = fqixian2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  从业资格号
	 */

	@Column(name ="FCONGYE",nullable=true,length=32)
	public java.lang.String getFcongye(){
		return this.fcongye;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  从业资格号
	 */
	public void setFcongye(java.lang.String fcongye){
		this.fcongye = fcongye;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  从业资格类别
	 */

	@Column(name ="FCYTYPE",nullable=true,length=32)
	public java.lang.String getFcytype(){
		return this.fcytype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  从业资格类别
	 */
	public void setFcytype(java.lang.String fcytype){
		this.fcytype = fcytype;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  初次发证时间
	 */

	@Column(name ="FAZHENGTIME",nullable=true,length=20)
	public java.util.Date getFazhengtime(){
		return this.fazhengtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  初次发证时间
	 */
	public void setFazhengtime(java.util.Date fazhengtime){
		this.fazhengtime = fazhengtime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发证时间
	 */

	@Column(name ="FAZHENG",nullable=true,length=20)
	public java.util.Date getFazheng(){
		return this.fazheng;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发证时间
	 */
	public void setFazheng(java.util.Date fazheng){
		this.fazheng = fazheng;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  有效期至
	 */

	@Column(name ="FYOUXIAO",nullable=true,length=20)
	public java.util.Date getFyouxiao(){
		return this.fyouxiao;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  有效期至
	 */
	public void setFyouxiao(java.util.Date fyouxiao){
		this.fyouxiao = fyouxiao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶证号
	 */

	@Column(name ="FJIASHI",nullable=true,length=32)
	public java.lang.String getFjiashi(){
		return this.fjiashi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶证号
	 */
	public void setFjiashi(java.lang.String fjiashi){
		this.fjiashi = fjiashi;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  初次领证日期
	 */

	@Column(name ="FCHUCI",nullable=true,length=20)
	public java.util.Date getFchuci(){
		return this.fchuci;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  初次领证日期
	 */
	public void setFchuci(java.util.Date fchuci){
		this.fchuci = fchuci;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  准驾车型
	 */

	@Column(name ="FZHUNJIA",nullable=true,length=255)
	public java.lang.String getFzhunjia(){
		return this.fzhunjia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  准驾车型
	 */
	public void setFzhunjia(java.lang.String fzhunjia){
		this.fzhunjia = fzhunjia;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  有效起始日期
	 */

	@Column(name ="FYOUXIAO1",nullable=true,length=20)
	public java.util.Date getFyouxiao1(){
		return this.fyouxiao1;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  有效起始日期
	 */
	public void setFyouxiao1(java.util.Date fyouxiao1){
		this.fyouxiao1 = fyouxiao1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  有效期限
	 */

	@Column(name ="FYXQIXIAN",nullable=true,length=20)
	public java.lang.String getFyxqixian(){
		return this.fyxqixian;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  有效期限
	 */
	public void setFyxqixian(java.lang.String fyxqixian){
		this.fyxqixian = fyxqixian;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  档案编号
	 */

	@Column(name ="FDANGAN",nullable=true,length=32)
	public java.lang.String getFdangan(){
		return this.fdangan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  档案编号
	 */
	public void setFdangan(java.lang.String fdangan){
		this.fdangan = fdangan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  记录
	 */

	@Column(name ="FRECORD",nullable=true,length=1000)
	public java.lang.String getFrecord(){
		return this.frecord;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  记录
	 */
	public void setFrecord(java.lang.String frecord){
		this.frecord = frecord;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代码
	 */

	@Column(name ="FCODE",nullable=true,length=32)
	public java.lang.String getFcode(){
		return this.fcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代码
	 */
	public void setFcode(java.lang.String fcode){
		this.fcode = fcode;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  入职时间
	 */

	@Column(name ="FRUZHI",nullable=true,length=20)
	public java.util.Date getFruzhi(){
		return this.fruzhi;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  入职时间
	 */
	public void setFruzhi(java.util.Date fruzhi){
		this.fruzhi = fruzhi;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  离职时间
	 */

	@Column(name ="FLIZHI",nullable=true,length=20)
	public java.util.Date getFlizhi(){
		return this.flizhi;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  离职时间
	 */
	public void setFlizhi(java.util.Date flizhi){
		this.flizhi = flizhi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号
	 */

	@Column(name ="FMOBILE",nullable=true,length=32)
	public java.lang.String getFmobile(){
		return this.fmobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号
	 */
	public void setFmobile(java.lang.String fmobile){
		this.fmobile = fmobile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  紧急联系人
	 */

	@Column(name ="FEMERGEN",nullable=true,length=32)
	public java.lang.String getFemergen(){
		return this.femergen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  紧急联系人
	 */
	public void setFemergen(java.lang.String femergen){
		this.femergen = femergen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号
	 */

	@Column(name ="FEMOBILE",nullable=true,length=32)
	public java.lang.String getFemobile(){
		return this.femobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号
	 */
	public void setFemobile(java.lang.String femobile){
		this.femobile = femobile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶证
	 */

	@Column(name ="FJSZ",nullable=true,length=255)
	public java.lang.String getFjsz(){
		return this.fjsz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶证
	 */
	public void setFjsz(java.lang.String fjsz){
		this.fjsz = fjsz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证
	 */

	@Column(name ="FSFZ",nullable=true,length=255)
	public java.lang.String getFsfz(){
		return this.fsfz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证
	 */
	public void setFsfz(java.lang.String fsfz){
		this.fsfz = fsfz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上岗证
	 */

	@Column(name ="FSGZ",nullable=true,length=255)
	public java.lang.String getFsgz(){
		return this.fsgz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上岗证
	 */
	public void setFsgz(java.lang.String fsgz){
		this.fsgz = fsgz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体检报告
	 */

	@Column(name ="FTJBG",nullable=true,length=255)
	public java.lang.String getFtjbg(){
		return this.ftjbg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体检报告
	 */
	public void setFtjbg(java.lang.String ftjbg){
		this.ftjbg = ftjbg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训证书
	 */

	@Column(name ="FPXZS",nullable=true,length=255)
	public java.lang.String getFpxzs(){
		return this.fpxzs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训证书
	 */
	public void setFpxzs(java.lang.String fpxzs){
		this.fpxzs = fpxzs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  意外险
	 */

	@Column(name ="FYWX",nullable=true,length=255)
	public java.lang.String getFywx(){
		return this.fywx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  意外险
	 */
	public void setFywx(java.lang.String fywx){
		this.fywx = fywx;
	}
}
