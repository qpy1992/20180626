package com.jeecg.item.entity;

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
 * @Description: 货物信息
 * @author onlineGenerator
 * @date 2018-07-04 16:08:39
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_item", schema = "")
@SuppressWarnings("serial")
public class ItemEntity implements java.io.Serializable {
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
	/**货物名称*/
	@Excel(name="货物名称",width=15)
	private java.lang.String fname;
	/**分拆*/
	@Excel(name="分拆",width=15,dicCode="sf_yn")
	private java.lang.String fsplit;
	/**唛头*/
	@Excel(name="唛头",width=15)
    private java.lang.String fmark;
	/**商品简称*/
	@Excel(name="商品简称",width=15)
	private java.lang.String fabbr;
	/**商品编号*/
	@Excel(name="商品编号",width=15)
	private java.lang.String fnumber;
	/**客户分类*/
	@Excel(name="客户分类",width=15)
	private java.lang.String fcusClass;
	/**厂商编号*/
	@Excel(name="厂商编号",width=15)
	private java.lang.String fmanuNumber;
	/**运输条件*/
	@Excel(name="运输条件",width=15)
	private java.lang.String ftransCondition;
	/**保存条件*/
	@Excel(name="保存条件",width=15)
	private java.lang.String fpreseCondition;
	/**运输备注*/
	@Excel(name="运输备注",width=15)
	private java.lang.String ftransNote;
	/**毛重*/
	@Excel(name="毛重",width=15)
	private java.lang.Double fgross;
	/**净重*/
	@Excel(name="净重",width=15)
	private java.lang.Double fnet;
	/**单价*/
	@Excel(name="单价",width=15)
	private java.lang.Double fprice;
	/**包装类型*/
	@Excel(name="包装类型",width=15,dicCode="bag")
	private java.lang.String fpackType;
	/**卸货时间*/
	@Excel(name="卸货时间",width=15)
	private java.lang.Double funloadTime;
	/**长度*/
	@Excel(name="长度",width=15)
	private java.lang.Double flength;
	/**宽度*/
	@Excel(name="宽度",width=15)
	private java.lang.Double fwidth;
	/**高度*/
	@Excel(name="高度",width=15)
	private java.lang.Double fheight;
	/**体积*/
	@Excel(name="体积",width=15)
	private java.lang.Double fvolume;
	/**下级数量*/
	@Excel(name="下级数量",width=15)
	private java.lang.Double flowerNumber;
	/**下级单位*/
	@Excel(name="下级单位",width=15,dicCode="underunit")
	private java.lang.String flowerUnit;
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
	 *@return: java.lang.String  货物名称
	 */

	@Column(name ="FNAME",nullable=true,length=255)
	public java.lang.String getFname(){
		return this.fname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  货物名称
	 */
	public void setFname(java.lang.String fname){
		this.fname = fname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分拆
	 */

	@Column(name ="FSPLIT",nullable=true,length=32)
	public java.lang.String getFsplit(){
		return this.fsplit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分拆
	 */
	public void setFsplit(java.lang.String fsplit){
		this.fsplit = fsplit;
	}

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  唛头
     */
    @Column(name="FMARK",nullable=true,length=32)
    public String getFmark() {
        return fmark;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  唛头
     */
    public void setFmark(String fmark) {
        this.fmark = fmark;
    }

    /**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品简称
	 */

	@Column(name ="FABBR",nullable=true,length=32)
	public java.lang.String getFabbr(){
		return this.fabbr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品简称
	 */
	public void setFabbr(java.lang.String fabbr){
		this.fabbr = fabbr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品编号
	 */

	@Column(name ="FNUMBER",nullable=true,length=32)
	public java.lang.String getFnumber(){
		return this.fnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品编号
	 */
	public void setFnumber(java.lang.String fnumber){
		this.fnumber = fnumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户分类
	 */

	@Column(name ="FCUS_CLASS",nullable=true,length=32)
	public java.lang.String getFcusClass(){
		return this.fcusClass;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户分类
	 */
	public void setFcusClass(java.lang.String fcusClass){
		this.fcusClass = fcusClass;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  厂商编号
	 */

	@Column(name ="FMANU_NUMBER",nullable=true,length=32)
	public java.lang.String getFmanuNumber(){
		return this.fmanuNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  厂商编号
	 */
	public void setFmanuNumber(java.lang.String fmanuNumber){
		this.fmanuNumber = fmanuNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输条件
	 */

	@Column(name ="FTRANS_CONDITION",nullable=true,length=32)
	public java.lang.String getFtransCondition(){
		return this.ftransCondition;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输条件
	 */
	public void setFtransCondition(java.lang.String ftransCondition){
		this.ftransCondition = ftransCondition;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保存条件
	 */

	@Column(name ="FPRESE_CONDITION",nullable=true,length=32)
	public java.lang.String getFpreseCondition(){
		return this.fpreseCondition;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保存条件
	 */
	public void setFpreseCondition(java.lang.String fpreseCondition){
		this.fpreseCondition = fpreseCondition;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运输备注
	 */

	@Column(name ="FTRANS_NOTE",nullable=true,length=255)
	public java.lang.String getFtransNote(){
		return this.ftransNote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运输备注
	 */
	public void setFtransNote(java.lang.String ftransNote){
		this.ftransNote = ftransNote;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  毛重
	 */

	@Column(name ="FGROSS",nullable=true,length=32)
	public java.lang.Double getFgross(){
		return this.fgross;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  毛重
	 */
	public void setFgross(java.lang.Double fgross){
		this.fgross = fgross;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  净重
	 */

	@Column(name ="FNET",nullable=true,length=32)
	public java.lang.Double getFnet(){
		return this.fnet;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  净重
	 */
	public void setFnet(java.lang.Double fnet){
		this.fnet = fnet;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  单价
	 */

	@Column(name ="FPRICE",nullable=true,length=32)
	public java.lang.Double getFprice(){
		return this.fprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  单价
	 */
	public void setFprice(java.lang.Double fprice){
		this.fprice = fprice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包装类型
	 */

	@Column(name ="FPACK_TYPE",nullable=true,length=32)
	public java.lang.String getFpackType(){
		return this.fpackType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装类型
	 */
	public void setFpackType(java.lang.String fpackType){
		this.fpackType = fpackType;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  卸货时间
	 */

	@Column(name ="FUNLOAD_TIME",nullable=true,length=32)
	public java.lang.Double getFunloadTime(){
		return this.funloadTime;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  卸货时间
	 */
	public void setFunloadTime(java.lang.Double funloadTime){
		this.funloadTime = funloadTime;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  长度
	 */

	@Column(name ="FLENGTH",nullable=true,length=32)
	public java.lang.Double getFlength(){
		return this.flength;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  长度
	 */
	public void setFlength(java.lang.Double flength){
		this.flength = flength;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  宽度
	 */

	@Column(name ="FWIDTH",nullable=true,length=32)
	public java.lang.Double getFwidth(){
		return this.fwidth;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  宽度
	 */
	public void setFwidth(java.lang.Double fwidth){
		this.fwidth = fwidth;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  高度
	 */

	@Column(name ="FHEIGHT",nullable=true,length=32)
	public java.lang.Double getFheight(){
		return this.fheight;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  高度
	 */
	public void setFheight(java.lang.Double fheight){
		this.fheight = fheight;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  体积
	 */

	@Column(name ="FVOLUME",nullable=true,length=32)
	public java.lang.Double getFvolume(){
		return this.fvolume;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  体积
	 */
	public void setFvolume(java.lang.Double fvolume){
		this.fvolume = fvolume;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  下级数量
	 */

	@Column(name ="FLOWER_NUMBER",nullable=true,length=32)
	public java.lang.Double getFlowerNumber(){
		return this.flowerNumber;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  下级数量
	 */
	public void setFlowerNumber(java.lang.Double flowerNumber){
		this.flowerNumber = flowerNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下级单位
	 */

	@Column(name ="FLOWER_UNIT",nullable=true,length=32)
	public java.lang.String getFlowerUnit(){
		return this.flowerUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下级单位
	 */
	public void setFlowerUnit(java.lang.String flowerUnit){
		this.flowerUnit = flowerUnit;
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
