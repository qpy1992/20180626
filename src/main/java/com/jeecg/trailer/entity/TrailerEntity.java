package com.jeecg.trailer.entity;

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
 * @Description: 挂车管理
 * @author onlineGenerator
 * @date 2018-10-23 11:02:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_trailer", schema = "")
@SuppressWarnings("serial")
public class TrailerEntity implements java.io.Serializable {
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
	/**挂车代码*/
	@Excel(name="挂车代码",width=15)
	private java.lang.String fcode;
	/**机动车所有人*/
	@Excel(name="机动车所有人",width=15)
	private java.lang.String fowner;
	/**登记日期*/
	@Excel(name="登记日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date fregdate;
	/**机动车登记编号*/
	@Excel(name="机动车登记编号",width=15)
	private java.lang.String fname;
	/**车辆类型*/
	@Excel(name="车辆类型",width=15,dicCode="cartype")
	private java.lang.String fcartype;
	/**车辆品牌*/
	@Excel(name="车辆品牌",width=15,dicCode="brand")
	private java.lang.String fbrand;
	/**车辆型号*/
	@Excel(name="车辆型号",width=15)
	private java.lang.String fmodel;
	/**车身颜色*/
	@Excel(name="车身颜色",width=15,dicCode="color")
	private java.lang.String fcolor;
	/**车辆识别代号*/
	@Excel(name="车辆识别代号",width=15)
	private java.lang.String fidcode;
	/**国产进口*/
	@Excel(name="国产进口",width=15,dicCode="imex")
	private java.lang.String fimex;
	/**制造厂名称*/
	@Excel(name="制造厂名称",width=15)
	private java.lang.String fmade;
	/**前轮距*/
	@Excel(name="前轮距",width=15)
	private java.lang.Integer flunju1;
	/**后轮距*/
	@Excel(name="后轮距",width=15)
	private java.lang.Integer flunju2;
	/**轮胎数*/
	@Excel(name="轮胎数",width=15)
	private java.lang.Integer ftyrenum;
	/**轮胎规格*/
	@Excel(name="轮胎规格",width=15)
	private java.lang.String ftyremodel;
	/**钢板弹簧片数*/
	@Excel(name="钢板弹簧片数",width=15)
	private java.lang.Integer ffbthnum;
	/**轴距*/
	@Excel(name="轴距",width=15)
	private java.lang.Integer faxis;
	/**轴数*/
	@Excel(name="轴数",width=15)
	private java.lang.Integer faxisnum;
	/**车长*/
	@Excel(name="车长",width=15)
	private java.lang.Integer flength;
	/**车宽*/
	@Excel(name="车宽",width=15)
	private java.lang.Integer fwidth;
	/**车高*/
	@Excel(name="车高",width=15)
	private java.lang.Integer fheight;
	/**总质量*/
	@Excel(name="总质量",width=15)
	private java.lang.Double fweight;
	/**实际质量*/
	@Excel(name="实际质量",width=15)
	private java.lang.Double ftrueweight;
	/**核定载质量*/
	@Excel(name="核定载质量",width=15)
	private java.lang.Double fperweight;
	/**使用性质*/
	@Excel(name="使用性质",width=15,dicCode="nature")
	private java.lang.String fnature;
	/**字号*/
	@Excel(name="字号",width=15)
	private java.lang.String flogzi;
	/**证号*/
	@Excel(name="证号",width=15)
	private java.lang.String flognum;
	/**运输证号*/
	private java.lang.String flog;
	/**经营范围*/
	@Excel(name="经营范围",width=15)
	private java.lang.String fjinying;
	/**运输证发证日期*/
	@Excel(name="运输证发证日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date fazhengdate;
	/**运输证有效日期*/
	@Excel(name="运输证有效日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date fyouxiaodate;
	/**整备质量*/
	@Excel(name="整备质量",width=15)
	private java.lang.Double fzbweight;
	/**强制报废日期*/
	@Excel(name="强制报废日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date forcebf;
	/**检验有效日期*/
	@Excel(name="检验有效日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date fjydate;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String fnote;
	/**登记证书*/
	@Excel(name="登记证书",width=15)
	private java.lang.String fdjzs;
	/**行驶证*/
	@Excel(name="行驶证",width=15)
	private java.lang.String fxsz;
	/**营运证*/
	@Excel(name="营运证",width=15)
	private java.lang.String fyyz;
	/**交强险*/
	@Excel(name="交强险",width=15)
	private java.lang.String fjqx;
	/**商业险*/
	@Excel(name="商业险",width=15)
	private java.lang.String fsyx;
	/**货物险*/
	@Excel(name="货物险",width=15)
	private java.lang.String fhwx;
	/**状态*/
	private java.lang.String fstatus;
	
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
	 *@return: java.lang.String  挂车代码
	 */

	@Column(name ="FCODE",nullable=true,length=32)
	public java.lang.String getFcode(){
		return this.fcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  挂车代码
	 */
	public void setFcode(java.lang.String fcode){
		this.fcode = fcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  机动车所有人
	 */

	@Column(name ="FOWNER",nullable=true,length=255)
	public java.lang.String getFowner(){
		return this.fowner;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  机动车所有人
	 */
	public void setFowner(java.lang.String fowner){
		this.fowner = fowner;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  登记日期
	 */

	@Column(name ="FREGDATE",nullable=true,length=32)
	public java.util.Date getFregdate(){
		return this.fregdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  登记日期
	 */
	public void setFregdate(java.util.Date fregdate){
		this.fregdate = fregdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  机动车登记编号
	 */

	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  机动车登记编号
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车辆类型
	 */

	@Column(name ="FCARTYPE",nullable=true,length=32)
	public java.lang.String getFcartype(){
		return this.fcartype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车辆类型
	 */
	public void setFcartype(java.lang.String fcartype){
		this.fcartype = fcartype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车辆品牌
	 */

	@Column(name ="FBRAND",nullable=true,length=32)
	public java.lang.String getFbrand(){
		return this.fbrand;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车辆品牌
	 */
	public void setFbrand(java.lang.String fbrand){
		this.fbrand = fbrand;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车辆型号
	 */

	@Column(name ="FMODEL",nullable=true,length=32)
	public java.lang.String getFmodel(){
		return this.fmodel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车辆型号
	 */
	public void setFmodel(java.lang.String fmodel){
		this.fmodel = fmodel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车身颜色
	 */

	@Column(name ="FCOLOR",nullable=true,length=32)
	public java.lang.String getFcolor(){
		return this.fcolor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车身颜色
	 */
	public void setFcolor(java.lang.String fcolor){
		this.fcolor = fcolor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车辆识别代号
	 */

	@Column(name ="FIDCODE",nullable=true,length=32)
	public java.lang.String getFidcode(){
		return this.fidcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车辆识别代号
	 */
	public void setFidcode(java.lang.String fidcode){
		this.fidcode = fidcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国产进口
	 */

	@Column(name ="FIMEX",nullable=true,length=32)
	public java.lang.String getFimex(){
		return this.fimex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国产进口
	 */
	public void setFimex(java.lang.String fimex){
		this.fimex = fimex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  制造厂名称
	 */

	@Column(name ="FMADE",nullable=true,length=32)
	public java.lang.String getFmade(){
		return this.fmade;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  制造厂名称
	 */
	public void setFmade(java.lang.String fmade){
		this.fmade = fmade;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  前轮距
	 */

	@Column(name ="FLUNJU1",nullable=true,length=32)
	public java.lang.Integer getFlunju1(){
		return this.flunju1;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  前轮距
	 */
	public void setFlunju1(java.lang.Integer flunju1){
		this.flunju1 = flunju1;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  后轮距
	 */

	@Column(name ="FLUNJU2",nullable=true,length=32)
	public java.lang.Integer getFlunju2(){
		return this.flunju2;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  后轮距
	 */
	public void setFlunju2(java.lang.Integer flunju2){
		this.flunju2 = flunju2;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  轮胎数
	 */

	@Column(name ="FTYRENUM",nullable=true,length=32)
	public java.lang.Integer getFtyrenum(){
		return this.ftyrenum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  轮胎数
	 */
	public void setFtyrenum(java.lang.Integer ftyrenum){
		this.ftyrenum = ftyrenum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  轮胎规格
	 */

	@Column(name ="FTYREMODEL",nullable=true,length=32)
	public java.lang.String getFtyremodel(){
		return this.ftyremodel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  轮胎规格
	 */
	public void setFtyremodel(java.lang.String ftyremodel){
		this.ftyremodel = ftyremodel;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  钢板弹簧片数
	 */

	@Column(name ="FFBTHNUM",nullable=true,length=32)
	public java.lang.Integer getFfbthnum(){
		return this.ffbthnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  钢板弹簧片数
	 */
	public void setFfbthnum(java.lang.Integer ffbthnum){
		this.ffbthnum = ffbthnum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  轴距
	 */

	@Column(name ="FAXIS",nullable=true,length=32)
	public java.lang.Integer getFaxis(){
		return this.faxis;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  轴距
	 */
	public void setFaxis(java.lang.Integer faxis){
		this.faxis = faxis;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  轴数
	 */

	@Column(name ="FAXISNUM",nullable=true,length=32)
	public java.lang.Integer getFaxisnum(){
		return this.faxisnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  轴数
	 */
	public void setFaxisnum(java.lang.Integer faxisnum){
		this.faxisnum = faxisnum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  车长
	 */

	@Column(name ="FLENGTH",nullable=true,length=32)
	public java.lang.Integer getFlength(){
		return this.flength;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  车长
	 */
	public void setFlength(java.lang.Integer flength){
		this.flength = flength;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  车宽
	 */

	@Column(name ="FWIDTH",nullable=true,length=32)
	public java.lang.Integer getFwidth(){
		return this.fwidth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  车宽
	 */
	public void setFwidth(java.lang.Integer fwidth){
		this.fwidth = fwidth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  车高
	 */

	@Column(name ="FHEIGHT",nullable=true,length=32)
	public java.lang.Integer getFheight(){
		return this.fheight;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  车高
	 */
	public void setFheight(java.lang.Integer fheight){
		this.fheight = fheight;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  总质量
	 */

	@Column(name ="FWEIGHT",nullable=true,length=32)
	public java.lang.Double getFweight(){
		return this.fweight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  总质量
	 */
	public void setFweight(java.lang.Double fweight){
		this.fweight = fweight;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  实际质量
	 */

	@Column(name ="FTRUEWEIGHT",nullable=true,length=32)
	public java.lang.Double getFtrueweight(){
		return this.ftrueweight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  实际质量
	 */
	public void setFtrueweight(java.lang.Double ftrueweight){
		this.ftrueweight = ftrueweight;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  核定载质量
	 */

	@Column(name ="FPERWEIGHT",nullable=true,length=32)
	public java.lang.Double getFperweight(){
		return this.fperweight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  核定载质量
	 */
	public void setFperweight(java.lang.Double fperweight){
		this.fperweight = fperweight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  使用性质
	 */

	@Column(name ="FNATURE",nullable=true,length=32)
	public java.lang.String getFnature(){
		return this.fnature;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  使用性质
	 */
	public void setFnature(java.lang.String fnature){
		this.fnature = fnature;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  字号
	 */

	@Column(name ="FLOGZI",nullable=true,length=32)
	public java.lang.String getFlogzi(){
		return this.flogzi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  字号
	 */
	public void setFlogzi(java.lang.String flogzi){
		this.flogzi = flogzi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证号
	 */

	@Column(name ="FLOGNUM",nullable=true,length=32)
	public java.lang.String getFlognum(){
		return this.flognum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证号
	 */
	public void setFlognum(java.lang.String flognum){
		this.flognum = flognum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输证号
	 */

	@Column(name ="FLOG",nullable=true,length=32)
	public java.lang.String getFlog(){
		return this.flog;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输证号
	 */
	public void setFlog(java.lang.String flog){
		this.flog = flog;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经营范围
	 */

	@Column(name ="FJINYING",nullable=true,length=32)
	public java.lang.String getFjinying(){
		return this.fjinying;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经营范围
	 */
	public void setFjinying(java.lang.String fjinying){
		this.fjinying = fjinying;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  运输证发证日期
	 */

	@Column(name ="FAZHENGDATE",nullable=true,length=32)
	public java.util.Date getFazhengdate(){
		return this.fazhengdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  运输证发证日期
	 */
	public void setFazhengdate(java.util.Date fazhengdate){
		this.fazhengdate = fazhengdate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  运输证有效日期
	 */

	@Column(name ="FYOUXIAODATE",nullable=true,length=32)
	public java.util.Date getFyouxiaodate(){
		return this.fyouxiaodate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  运输证有效日期
	 */
	public void setFyouxiaodate(java.util.Date fyouxiaodate){
		this.fyouxiaodate = fyouxiaodate;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  整备质量
	 */

	@Column(name ="FZBWEIGHT",nullable=true,length=32)
	public java.lang.Double getFzbweight(){
		return this.fzbweight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  整备质量
	 */
	public void setFzbweight(java.lang.Double fzbweight){
		this.fzbweight = fzbweight;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  强制报废日期
	 */

	@Column(name ="FORCEBF",nullable=true,length=32)
	public java.util.Date getForcebf(){
		return this.forcebf;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  强制报废日期
	 */
	public void setForcebf(java.util.Date forcebf){
		this.forcebf = forcebf;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  检验有效日期
	 */

	@Column(name ="FJYDATE",nullable=true,length=32)
	public java.util.Date getFjydate(){
		return this.fjydate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  检验有效日期
	 */
	public void setFjydate(java.util.Date fjydate){
		this.fjydate = fjydate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="FNOTE",nullable=true,length=1000)
	public java.lang.String getFnote(){
		return this.fnote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setFnote(java.lang.String fnote){
		this.fnote = fnote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  登记证书
	 */

	@Column(name ="FDJZS",nullable=true,length=1000)
	public java.lang.String getFdjzs(){
		return this.fdjzs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  登记证书
	 */
	public void setFdjzs(java.lang.String fdjzs){
		this.fdjzs = fdjzs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行驶证
	 */

	@Column(name ="FXSZ",nullable=true,length=1000)
	public java.lang.String getFxsz(){
		return this.fxsz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行驶证
	 */
	public void setFxsz(java.lang.String fxsz){
		this.fxsz = fxsz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  营运证
	 */

	@Column(name ="FYYZ",nullable=true,length=1000)
	public java.lang.String getFyyz(){
		return this.fyyz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  营运证
	 */
	public void setFyyz(java.lang.String fyyz){
		this.fyyz = fyyz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交强险
	 */

	@Column(name ="FJQX",nullable=true,length=1000)
	public java.lang.String getFjqx(){
		return this.fjqx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交强险
	 */
	public void setFjqx(java.lang.String fjqx){
		this.fjqx = fjqx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商业险
	 */

	@Column(name ="FSYX",nullable=true,length=1000)
	public java.lang.String getFsyx(){
		return this.fsyx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商业险
	 */
	public void setFsyx(java.lang.String fsyx){
		this.fsyx = fsyx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  货物险
	 */

	@Column(name ="FHWX",nullable=true,length=1000)
	public java.lang.String getFhwx(){
		return this.fhwx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货物险
	 */
	public void setFhwx(java.lang.String fhwx){
		this.fhwx = fhwx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */

	@Column(name ="FSTATUS",nullable=true,length=32)
	public java.lang.String getFstatus(){
		return this.fstatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setFstatus(java.lang.String fstatus){
		this.fstatus = fstatus;
	}
}
