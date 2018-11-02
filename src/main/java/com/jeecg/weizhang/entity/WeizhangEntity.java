package com.jeecg.weizhang.entity;

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
 * @Description: 车辆违章管理
 * @author onlineGenerator
 * @date 2018-07-11 14:47:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_weizhang", schema = "")
@SuppressWarnings("serial")
public class WeizhangEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**制单人*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**制单日期*/
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
	@Excel(name="流水编码",width=15)
	private java.lang.String fbillno;
	/**审核人*/
	private java.lang.String fchecker;
	/**审核时间*/
	private java.util.Date fcheckTime;
	/**违章时间*/
	@Excel(name="违章时间",width=15)
	private java.lang.String fwzTime;
	/**车号*/
	@Excel(name="车号",width=15)
	private java.lang.String fcarno;
	/**驾驶员*/
	@Excel(name="驾驶员",width=15)
	private java.lang.String fname;
	/**违章地点*/
	@Excel(name="违章地点",width=15)
	private java.lang.String fwzaddress;
	/**具体交通违法行为*/
	@Excel(name="具体交通违法行为",width=15)
	private java.lang.String fbehavior;
	/**处罚金额*/
	@Excel(name="处罚金额",width=15)
	private java.lang.Double famount;
	/**驾驶证扣分*/
	@Excel(name="驾驶证扣分",width=15)
	private java.lang.Integer fkoufen;
	/**通报单位*/
	@Excel(name="通报单位",width=15)
	private java.lang.String ftongbao;
	/**违章次数*/
	@Excel(name="违章次数",width=15)
	private java.lang.Integer fwzqty;
	/**处理违章时间*/
	@Excel(name="处理违章时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fclwztime;
	/**年度累计违章次数*/
	@Excel(name="年度累计违章次数",width=15)
	private java.lang.Integer fyearqty;
	/**年度违章扣6分次数*/
	@Excel(name="年度违章扣6分次数",width=15)
	private java.lang.Integer fsix;
	/**超速次数*/
	@Excel(name="超速次数",width=15)
	private java.lang.Integer fchaosu;
	/**年度累计扣分*/
	@Excel(name="年度累计扣分",width=15)
	private java.lang.Integer fyearkf;
	/**年度超速次数*/
	@Excel(name="年度超速次数",width=15)
	private java.lang.Integer fyearcs;
	/**年度超速50次数*/
	@Excel(name="年度超速50次数",width=15)
	private java.lang.Integer fyearfifty;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String fnote;
	
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
	 *@return: java.lang.String  制单人
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  制单人
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
	 *@return: java.util.Date  制单日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  制单日期
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
	 *@return: java.lang.String  流水编码
	 */

	@Column(name ="FBILLNO",nullable=true,length=32)
	public java.lang.String getFbillno(){
		return this.fbillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流水编码
	 */
	public void setFbillno(java.lang.String fbillno){
		this.fbillno = fbillno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */

	@Column(name ="FCHECKER",nullable=true,length=32)
	public java.lang.String getFchecker(){
		return this.fchecker;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setFchecker(java.lang.String fchecker){
		this.fchecker = fchecker;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核时间
	 */

	@Column(name ="FCHECK_TIME",nullable=true,length=32)
	public java.util.Date getFcheckTime(){
		return this.fcheckTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核时间
	 */
	public void setFcheckTime(java.util.Date fcheckTime){
		this.fcheckTime = fcheckTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  违章时间
	 */

	@Column(name ="FWZ_TIME",nullable=true,length=32)
	public java.lang.String getFwzTime(){
		return this.fwzTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  违章时间
	 */
	public void setFwzTime(java.lang.String fwzTime){
		this.fwzTime = fwzTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车号
	 */

	@Column(name ="FCARNO",nullable=true,length=32)
	public java.lang.String getFcarno(){
		return this.fcarno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车号
	 */
	public void setFcarno(java.lang.String fcarno){
		this.fcarno = fcarno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾驶员
	 */

	@Column(name ="FNAME",nullable=true,length=32)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾驶员
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  违章地点
	 */

	@Column(name ="FWZADDRESS",nullable=true,length=255)
	public java.lang.String getFwzaddress(){
		return this.fwzaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  违章地点
	 */
	public void setFwzaddress(java.lang.String fwzaddress){
		this.fwzaddress = fwzaddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  具体交通违法行为
	 */

	@Column(name ="FBEHAVIOR",nullable=true,length=255)
	public java.lang.String getFbehavior(){
		return this.fbehavior;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  具体交通违法行为
	 */
	public void setFbehavior(java.lang.String fbehavior){
		this.fbehavior = fbehavior;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  处罚金额
	 */

	@Column(name ="FAMOUNT",nullable=true,length=32)
	public java.lang.Double getFamount(){
		return this.famount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  处罚金额
	 */
	public void setFamount(java.lang.Double famount){
		this.famount = famount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  驾驶证扣分
	 */

	@Column(name ="FKOUFEN",nullable=true,length=32)
	public java.lang.Integer getFkoufen(){
		return this.fkoufen;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  驾驶证扣分
	 */
	public void setFkoufen(java.lang.Integer fkoufen){
		this.fkoufen = fkoufen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通报单位
	 */

	@Column(name ="FTONGBAO",nullable=true,length=32)
	public java.lang.String getFtongbao(){
		return this.ftongbao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通报单位
	 */
	public void setFtongbao(java.lang.String ftongbao){
		this.ftongbao = ftongbao;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  违章次数
	 */

	@Column(name ="FWZQTY",nullable=true,length=32)
	public java.lang.Integer getFwzqty(){
		return this.fwzqty;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  违章次数
	 */
	public void setFwzqty(java.lang.Integer fwzqty){
		this.fwzqty = fwzqty;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  处理违章时间
	 */

	@Column(name ="FCLWZTIME",nullable=true,length=32)
	public java.util.Date getFclwztime(){
		return this.fclwztime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  处理违章时间
	 */
	public void setFclwztime(java.util.Date fclwztime){
		this.fclwztime = fclwztime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年度累计违章次数
	 */

	@Column(name ="FYEARQTY",nullable=true,length=32)
	public java.lang.Integer getFyearqty(){
		return this.fyearqty;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年度累计违章次数
	 */
	public void setFyearqty(java.lang.Integer fyearqty){
		this.fyearqty = fyearqty;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年度违章扣6分次数
	 */

	@Column(name ="FSIX",nullable=true,length=32)
	public java.lang.Integer getFsix(){
		return this.fsix;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年度违章扣6分次数
	 */
	public void setFsix(java.lang.Integer fsix){
		this.fsix = fsix;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  超速次数
	 */

	@Column(name ="FCHAOSU",nullable=true,length=32)
	public java.lang.Integer getFchaosu(){
		return this.fchaosu;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  超速次数
	 */
	public void setFchaosu(java.lang.Integer fchaosu){
		this.fchaosu = fchaosu;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年度累计扣分
	 */

	@Column(name ="FYEARKF",nullable=true,length=32)
	public java.lang.Integer getFyearkf(){
		return this.fyearkf;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年度累计扣分
	 */
	public void setFyearkf(java.lang.Integer fyearkf){
		this.fyearkf = fyearkf;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年度超速次数
	 */

	@Column(name ="FYEARCS",nullable=true,length=32)
	public java.lang.Integer getFyearcs(){
		return this.fyearcs;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年度超速次数
	 */
	public void setFyearcs(java.lang.Integer fyearcs){
		this.fyearcs = fyearcs;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年度超速50次数
	 */

	@Column(name ="FYEARFIFTY",nullable=true,length=32)
	public java.lang.Integer getFyearfifty(){
		return this.fyearfifty;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年度超速50次数
	 */
	public void setFyearfifty(java.lang.Integer fyearfifty){
		this.fyearfifty = fyearfifty;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="FNOTE",nullable=true,length=255)
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
}
