package com.jeecg.receive.entity;

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
 * @Description: 派车单应收
 * @author onlineGenerator
 * @date 2018-07-31 16:23:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_pc_receive", schema = "")
@SuppressWarnings("serial")
public class ZPcReceiveEntity implements java.io.Serializable {
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
	/**审核*/
	@Excel(name="审核",width=15)
	private java.lang.String fcheck;
	/**费用种类*/
	@Excel(name="费用种类",width=15)
	private java.lang.String feetype;
	/**费用种类名称*/
	@Excel(name="费用种类名称",width=15)
	private java.lang.String feename;
	/**结算单位*/
	@Excel(name="结算单位",width=15)
	private java.lang.String fsettle;
	/**结算单位名称*/
	@Excel(name="结算单位名称",width=15)
	private java.lang.String fsettlename;
	/**单位*/
	@Excel(name="单位",width=15)
	private java.lang.String funit;
	/**单价*/
	@Excel(name="单价",width=15)
	private java.lang.String funitprice;
	/**金额*/
	@Excel(name="金额",width=15)
	private java.lang.String famount;
	/**数量*/
	@Excel(name="数量",width=15)
	private java.lang.String fqty;
	/**分摊*/
	@Excel(name="分摊",width=15)
	private java.lang.String fentan;
	/**车号*/
	@Excel(name="车号",width=15)
	private java.lang.String fcarcode;
	/**挂车标识*/
	@Excel(name="挂车标识",width=15)
	private java.lang.String fguache;
	/**委托编号*/
	@Excel(name="委托编号",width=15)
	private java.lang.String fweituo;
	/**额定金额*/
	@Excel(name="额定金额",width=15)
	private java.lang.String feding;
	/**箱号*/
	@Excel(name="箱号",width=15)
	private java.lang.String fxianghao;
	/**已开票金额*/
	@Excel(name="已开票金额",width=15)
	private java.lang.String fyikai;
	/**客户号*/
	@Excel(name="客户号",width=15)
	private java.lang.String fcustomno;
	/**纯代收代付*/
	@Excel(name="纯代收代付",width=15)
	private java.lang.String fchun;
	/**发票号*/
	@Excel(name="发票号",width=15)
	private java.lang.String fapiao;
	/**审核人*/
	@Excel(name="审核人",width=15)
	private java.lang.String fchecker;
	/**附加说明*/
	@Excel(name="附加说明",width=15)
	private java.lang.String finstruction;
	/**主表主键*/
	private java.lang.String fid;
	
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
	 *@return: java.lang.String  审核
	 */

	@Column(name ="FCHECK",nullable=true,length=32)
	public java.lang.String getFcheck(){
		return this.fcheck;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核
	 */
	public void setFcheck(java.lang.String fcheck){
		this.fcheck = fcheck;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用种类
	 */

	@Column(name ="FEETYPE",nullable=true,length=32)
	public java.lang.String getFeetype(){
		return this.feetype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类
	 */
	public void setFeetype(java.lang.String feetype){
		this.feetype = feetype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用种类名称
	 */

	@Column(name ="FEENAME",nullable=true,length=32)
	public java.lang.String getFeename(){
		return this.feename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用种类名称
	 */
	public void setFeename(java.lang.String feename){
		this.feename = feename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结算单位
	 */

	@Column(name ="FSETTLE",nullable=true,length=32)
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
	 *@return: java.lang.String  单位
	 */

	@Column(name ="FUNIT",nullable=true,length=32)
	public java.lang.String getFunit(){
		return this.funit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setFunit(java.lang.String funit){
		this.funit = funit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单价
	 */

	@Column(name ="FUNITPRICE",nullable=true,length=32)
	public java.lang.String getFunitprice(){
		return this.funitprice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单价
	 */
	public void setFunitprice(java.lang.String funitprice){
		this.funitprice = funitprice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  金额
	 */

	@Column(name ="FAMOUNT",nullable=true,length=32)
	public java.lang.String getFamount(){
		return this.famount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  金额
	 */
	public void setFamount(java.lang.String famount){
		this.famount = famount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数量
	 */

	@Column(name ="FQTY",nullable=true,length=32)
	public java.lang.String getFqty(){
		return this.fqty;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数量
	 */
	public void setFqty(java.lang.String fqty){
		this.fqty = fqty;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分摊
	 */

	@Column(name ="FENTAN",nullable=true,length=32)
	public java.lang.String getFentan(){
		return this.fentan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分摊
	 */
	public void setFentan(java.lang.String fentan){
		this.fentan = fentan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车号
	 */

	@Column(name ="FCARCODE",nullable=true,length=32)
	public java.lang.String getFcarcode(){
		return this.fcarcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车号
	 */
	public void setFcarcode(java.lang.String fcarcode){
		this.fcarcode = fcarcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  挂车标识
	 */

	@Column(name ="FGUACHE",nullable=true,length=32)
	public java.lang.String getFguache(){
		return this.fguache;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  挂车标识
	 */
	public void setFguache(java.lang.String fguache){
		this.fguache = fguache;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  委托编号
	 */

	@Column(name ="FWEITUO",nullable=true,length=32)
	public java.lang.String getFweituo(){
		return this.fweituo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托编号
	 */
	public void setFweituo(java.lang.String fweituo){
		this.fweituo = fweituo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  额定金额
	 */

	@Column(name ="FEDING",nullable=true,length=32)
	public java.lang.String getFeding(){
		return this.feding;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  额定金额
	 */
	public void setFeding(java.lang.String feding){
		this.feding = feding;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  箱号
	 */

	@Column(name ="FXIANGHAO",nullable=true,length=32)
	public java.lang.String getFxianghao(){
		return this.fxianghao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱号
	 */
	public void setFxianghao(java.lang.String fxianghao){
		this.fxianghao = fxianghao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  已开票金额
	 */

	@Column(name ="FYIKAI",nullable=true,length=32)
	public java.lang.String getFyikai(){
		return this.fyikai;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  已开票金额
	 */
	public void setFyikai(java.lang.String fyikai){
		this.fyikai = fyikai;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户号
	 */

	@Column(name ="FCUSTOMNO",nullable=true,length=32)
	public java.lang.String getFcustomno(){
		return this.fcustomno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户号
	 */
	public void setFcustomno(java.lang.String fcustomno){
		this.fcustomno = fcustomno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  纯代收代付
	 */

	@Column(name ="FCHUN",nullable=true,length=32)
	public java.lang.String getFchun(){
		return this.fchun;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  纯代收代付
	 */
	public void setFchun(java.lang.String fchun){
		this.fchun = fchun;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票号
	 */

	@Column(name ="FAPIAO",nullable=true,length=32)
	public java.lang.String getFapiao(){
		return this.fapiao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票号
	 */
	public void setFapiao(java.lang.String fapiao){
		this.fapiao = fapiao;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附加说明
	 */

	@Column(name ="FINSTRUCTION",nullable=true,length=32)
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

	@Column(name ="FID",nullable=false,length=32)
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
}
