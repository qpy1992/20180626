package com.jeecg.contianer.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 集装箱
 * @author onlineGenerator
 * @date 2018-08-01 16:47:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_contianer", schema = "")
@SuppressWarnings("serial")
public class ContianerEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**箱号*/
    @Excel(name="箱号",width=15)
	private java.lang.String fboxno;
	/**封号*/
    @Excel(name="封号",width=15)
	private java.lang.String ftitle;
	/**箱型*/
    @Excel(name="箱型",width=15)
	private java.lang.String fboxtype;
	/**装船港*/
    @Excel(name="装船港",width=15)
	private java.lang.String floadport;
	/**中转港*/
    @Excel(name="中转港",width=15)
	private java.lang.String ftransfer;
	/**目的港*/
    @Excel(name="目的港",width=15)
	private java.lang.String ftarget;
	/**航名*/
    @Excel(name="船名",width=15)
	private java.lang.String fvoyage;
	/**航次*/
    @Excel(name="航次",width=15)
	private java.lang.String fvoyagenum;
	/**型号*/
    @Excel(name="型号",width=15)
	private java.lang.String fmodel;
	/**做箱时间*/
    @Excel(name="做箱时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fmakeboxtime;
	/**等级*/
    @Excel(name="等级",width=15)
	private java.lang.String fgrade;
	/**危规页码*/
    @Excel(name="危规页码",width=15)
	private java.lang.String fdrpagenum;
	/**货物名称*/
    @Excel(name="货物名称",width=15)
	private java.lang.String funnumber;
	/**闪点*/
    @Excel(name="闪点",width=15)
	private java.lang.String flashPoint;
	/**冷藏温度*/
    @Excel(name="冷藏温度",width=15)
	private java.lang.String fcolddegree;
	/**总件数*/
    @Excel(name="总件数",width=15)
	private java.math.BigDecimal ftotals;
	/**总毛重*/
    @Excel(name="总毛重",width=15)
	private java.math.BigDecimal fgrosses;
	/**总体积*/
    @Excel(name="总体积",width=15)
	private java.math.BigDecimal fvolumes;
	/**提箱点*/
    @Excel(name="提箱点",width=15)
	private java.lang.String fextract;
	/**还箱点*/
    @Excel(name="还箱点",width=15)
	private java.lang.String freturn;
	/**集装箱经营人*/
    @Excel(name="集装箱经营人",width=15)
	private java.lang.String foperator;
	/**主表主键*/
	private java.lang.String fid;
	/**装货门点*/
    @Excel(name="装货门点",width=15)
	private java.lang.String fzhdp;
	/**门点地址*/
    @Excel(name="门点地址",width=15)
	private java.lang.String fzhdpdz;
	/**装货单位*/
    @Excel(name="装货单位",width=15)
	private java.lang.String fzhunit;
	/**联系人*/
    @Excel(name="联系人",width=15)
	private java.lang.String fzhcontact;
	/**联系电话*/
    @Excel(name="联系电话",width=15)
	private java.lang.String fzhmobile;
	/**备注*/
    @Excel(name="备注",width=15)
	private java.lang.String fnote;
	/**特殊业务*/
    @Excel(name="特殊业务",width=15)
	private java.lang.String ftsyw;
	/**卸货门点*/
    @Excel(name="卸货门点",width=15)
	private java.lang.String fxhdp;
	/**门点地址*/
    @Excel(name="门点地址",width=15)
	private java.lang.String fxhdpdz;
	/**卸货时间*/
    @Excel(name="卸货时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date fxhtime;
	/**卸货单位*/
    @Excel(name="卸货单位",width=15)
	private java.lang.String fxhunit;
	/**联系人*/
    @Excel(name="联系人",width=15)
	private java.lang.String fxhcontact;
	/**联系电话*/
    @Excel(name="联系电话",width=15)
	private java.lang.String fxhmobile;
	/**对应派车单号*/
    @Excel(name="对应派车单号",width=15)
	private java.lang.String fbillno;
	/**暂落*/
    @Excel(name="暂落",width=15)
	private java.lang.String fzanluo;
    /**甩挂*/
    private java.lang.String fshuaigua;
    /**驳箱*/
    private java.lang.String fboxiang;
    /**预提*/
    private java.lang.String fyuti;
    /**继续业务*/
    private java.lang.String fjixu;
	/**取消运输*/
	private java.lang.String fquxiao;
	/**先到*/
	private java.lang.String fxiandao;
	/**放在前面*/
	private java.lang.String fup;
	/**签收日期*/
	private java.util.Date fqsdate;
	/**进出口类型*/
	private java.lang.String fieport;
	/**带货*/
	private java.lang.String fdaihuo;
	/**审核*/
	private java.lang.String fcheck;
	/**审核人*/
	private java.lang.String fchecker;
	/**审核时间*/
	private java.util.Date fcheckdate;
	/**加热温度*/
	private java.lang.String fhot;
	/**装货重量*/
	private java.math.BigDecimal fzhweight;
	/**卸货重量*/
	private java.math.BigDecimal fxhweight;
	/**人孔*/
	private java.lang.String fmanhole;
	/**气阀*/
	private java.lang.String fvalve;
	/**价格*/
	private java.lang.Double fprice;
	/**底阀1*/
	private java.lang.String ftitle1;
	/**人孔1*/
	private java.lang.String fmanhole1;
	/**气阀1*/
	private java.lang.String fvalve1;
	/**卸货件数*/
	private java.lang.Integer fxhnum;
	/**到场时间*/
	private java.util.Date fdao;
	/**离场时间*/
	private java.util.Date fli;
	/**预派车时间*/
	private java.util.Date fyupai;
	/**费用组合主键*/
	private java.lang.String cid1;
	/**装货时间*/
	private java.util.Date fzhtime;
	/**委托装货重量*/
	private java.lang.Double fwtzhweight;
	/**第三方过磅*/
	private java.lang.Double fother;
	/**委托卸货件数*/
	private java.lang.Integer fwtxhnum;
	/**磅差*/
	private java.lang.Double fbang;
	/**委托卸货重量*/
	private java.lang.Double fwtxhweight;
	/**第三方过磅*/
	private java.lang.Double fother1;
	/**序号*/
	private java.lang.String fno;
	/**箱重*/
	private java.lang.Double fboxweight;

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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  封号
	 */
	
	@Column(name ="FTITLE",nullable=true,length=32)
	public java.lang.String getFtitle(){
		return this.ftitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  封号
	 */
	public void setFtitle(java.lang.String ftitle){
		this.ftitle = ftitle;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  箱型
	 */
	
	@Column(name ="FBOXTYPE",nullable=true,length=32)
	public java.lang.String getFboxtype(){
		return this.fboxtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱型
	 */
	public void setFboxtype(java.lang.String fboxtype){
		this.fboxtype = fboxtype;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装船港
	 */
	
	@Column(name ="FLOADPORT",nullable=true,length=32)
	public java.lang.String getFloadport(){
		return this.floadport;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装船港
	 */
	public void setFloadport(java.lang.String floadport){
		this.floadport = floadport;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  中转港
	 */
	
	@Column(name ="FTRANSFER",nullable=true,length=32)
	public java.lang.String getFtransfer(){
		return this.ftransfer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  中转港
	 */
	public void setFtransfer(java.lang.String ftransfer){
		this.ftransfer = ftransfer;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  目的港
	 */
	
	@Column(name ="FTARGET",nullable=true,length=32)
	public java.lang.String getFtarget(){
		return this.ftarget;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目的港
	 */
	public void setFtarget(java.lang.String ftarget){
		this.ftarget = ftarget;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  航名
	 */
	
	@Column(name ="FVOYAGE",nullable=true,length=32)
	public java.lang.String getFvoyage(){
		return this.fvoyage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  航名
	 */
	public void setFvoyage(java.lang.String fvoyage){
		this.fvoyage = fvoyage;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  航次
	 */
	
	@Column(name ="FVOYAGENUM",nullable=true,length=32)
	public java.lang.String getFvoyagenum(){
		return this.fvoyagenum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  航次
	 */
	public void setFvoyagenum(java.lang.String fvoyagenum){
		this.fvoyagenum = fvoyagenum;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  型号
	 */
	
	@Column(name ="FMODEL",nullable=true,length=32)
	public java.lang.String getFmodel(){
		return this.fmodel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  型号
	 */
	public void setFmodel(java.lang.String fmodel){
		this.fmodel = fmodel;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  做箱时间
	 */
	
	@Column(name ="FMAKEBOXTIME",nullable=true,length=32)
	public java.util.Date getFmakeboxtime(){
		return this.fmakeboxtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  做箱时间
	 */
	public void setFmakeboxtime(java.util.Date fmakeboxtime){
		this.fmakeboxtime = fmakeboxtime;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  等级
	 */
	
	@Column(name ="FGRADE",nullable=true,length=32)
	public java.lang.String getFgrade(){
		return this.fgrade;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  等级
	 */
	public void setFgrade(java.lang.String fgrade){
		this.fgrade = fgrade;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  危规页码
	 */
	
	@Column(name ="FDRPAGENUM",nullable=true,length=32)
	public java.lang.String getFdrpagenum(){
		return this.fdrpagenum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  危规页码
	 */
	public void setFdrpagenum(java.lang.String fdrpagenum){
		this.fdrpagenum = fdrpagenum;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联合国编号
	 */
	
	@Column(name ="FUNNUMBER",nullable=true,length=32)
	public java.lang.String getFunnumber(){
		return this.funnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联合国编号
	 */
	public void setFunnumber(java.lang.String funnumber){
		this.funnumber = funnumber;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  闪点
	 */
	
	@Column(name ="FLASH_POINT",nullable=true,length=32)
	public java.lang.String getFlashPoint(){
		return this.flashPoint;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  闪点
	 */
	public void setFlashPoint(java.lang.String flashPoint){
		this.flashPoint = flashPoint;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  冷藏温度
	 */
	
	@Column(name ="FCOLDDEGREE",nullable=true,length=32)
	public java.lang.String getFcolddegree(){
		return this.fcolddegree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  冷藏温度
	 */
	public void setFcolddegree(java.lang.String fcolddegree){
		this.fcolddegree = fcolddegree;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总件数
	 */
	
	@Column(name ="FTOTALS",nullable=true,length=32)
	public java.math.BigDecimal getFtotals(){
		return this.ftotals;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总件数
	 */
	public void setFtotals(java.math.BigDecimal ftotals){
		this.ftotals = ftotals;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总毛重
	 */
	
	@Column(name ="FGROSSES",nullable=true,length=32)
	public java.math.BigDecimal getFgrosses(){
		return this.fgrosses;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总毛重
	 */
	public void setFgrosses(java.math.BigDecimal fgrosses){
		this.fgrosses = fgrosses;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总体积
	 */
	
	@Column(name ="FVOLUMES",nullable=true,length=32)
	public java.math.BigDecimal getFvolumes(){
		return this.fvolumes;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总体积
	 */
	public void setFvolumes(java.math.BigDecimal fvolumes){
		this.fvolumes = fvolumes;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提箱点
	 */
	
	@Column(name ="FEXTRACT",nullable=true,length=32)
	public java.lang.String getFextract(){
		return this.fextract;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提箱点
	 */
	public void setFextract(java.lang.String fextract){
		this.fextract = fextract;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  还箱点
	 */
	
	@Column(name ="FRETURN",nullable=true,length=32)
	public java.lang.String getFreturn(){
		return this.freturn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  还箱点
	 */
	public void setFreturn(java.lang.String freturn){
		this.freturn = freturn;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  集装箱经营人
	 */
	
	@Column(name ="FOPERATOR",nullable=true,length=32)
	public java.lang.String getFoperator(){
		return this.foperator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  集装箱经营人
	 */
	public void setFoperator(java.lang.String foperator){
		this.foperator = foperator;
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
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装货门点
	 */
	
	@Column(name ="FZHDP",nullable=true,length=1000)
	public java.lang.String getFzhdp(){
		return this.fzhdp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装货门点
	 */
	public void setFzhdp(java.lang.String fzhdp){
		this.fzhdp = fzhdp;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  门点地址
	 */
	
	@Column(name ="FZHDPDZ",nullable=true,length=1000)
	public java.lang.String getFzhdpdz(){
		return this.fzhdpdz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  门点地址
	 */
	public void setFzhdpdz(java.lang.String fzhdpdz){
		this.fzhdpdz = fzhdpdz;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装货单位
	 */
	
	@Column(name ="FZHUNIT",nullable=true,length=32)
	public java.lang.String getFzhunit(){
		return this.fzhunit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装货单位
	 */
	public void setFzhunit(java.lang.String fzhunit){
		this.fzhunit = fzhunit;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人
	 */
	
	@Column(name ="FZHCONTACT",nullable=true,length=32)
	public java.lang.String getFzhcontact(){
		return this.fzhcontact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人
	 */
	public void setFzhcontact(java.lang.String fzhcontact){
		this.fzhcontact = fzhcontact;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	
	@Column(name ="FZHMOBILE",nullable=true,length=32)
	public java.lang.String getFzhmobile(){
		return this.fzhmobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setFzhmobile(java.lang.String fzhmobile){
		this.fzhmobile = fzhmobile;
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
	 *@return: java.lang.String  特殊业务
	 */
	
	@Column(name ="FTSYW",nullable=true,length=32)
	public java.lang.String getFtsyw(){
		return this.ftsyw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  特殊业务
	 */
	public void setFtsyw(java.lang.String ftsyw){
		this.ftsyw = ftsyw;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卸货门点
	 */
	
	@Column(name ="FXHDP",nullable=true,length=1000)
	public java.lang.String getFxhdp(){
		return this.fxhdp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卸货门点
	 */
	public void setFxhdp(java.lang.String fxhdp){
		this.fxhdp = fxhdp;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  门点地址
	 */
	
	@Column(name ="FXHDPDZ",nullable=true,length=1000)
	public java.lang.String getFxhdpdz(){
		return this.fxhdpdz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  门点地址
	 */
	public void setFxhdpdz(java.lang.String fxhdpdz){
		this.fxhdpdz = fxhdpdz;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  卸货时间
	 */
	
	@Column(name ="FXHTIME",nullable=true,length=32)
	public java.util.Date getFxhtime(){
		return this.fxhtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  卸货时间
	 */
	public void setFxhtime(java.util.Date fxhtime){
		this.fxhtime = fxhtime;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卸货单位
	 */
	
	@Column(name ="FXHUNIT",nullable=true,length=32)
	public java.lang.String getFxhunit(){
		return this.fxhunit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卸货单位
	 */
	public void setFxhunit(java.lang.String fxhunit){
		this.fxhunit = fxhunit;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人
	 */
	
	@Column(name ="FXHCONTACT",nullable=true,length=32)
	public java.lang.String getFxhcontact(){
		return this.fxhcontact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人
	 */
	public void setFxhcontact(java.lang.String fxhcontact){
		this.fxhcontact = fxhcontact;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	
	@Column(name ="FXHMOBILE",nullable=true,length=32)
	public java.lang.String getFxhmobile(){
		return this.fxhmobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setFxhmobile(java.lang.String fxhmobile){
		this.fxhmobile = fxhmobile;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对应派车单号
	 */
	
	@Column(name ="FBILLNO",nullable=true,length=32)
	public java.lang.String getFbillno(){
		return this.fbillno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对应派车单号
	 */
	public void setFbillno(java.lang.String fbillno){
		this.fbillno = fbillno;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  暂落
	 */
	
	@Column(name ="FZANLUO",nullable=true,length=32)
	public java.lang.String getFzanluo(){
		return this.fzanluo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  暂落
	 */
	public void setFzanluo(java.lang.String fzanluo){
		this.fzanluo = fzanluo;
	}

	@Column(name ="FSHUAIGUA",nullable=true,length=32)
	public String getFshuaigua() {
		return fshuaigua;
	}

	public void setFshuaigua(String fshuaigua) {
		this.fshuaigua = fshuaigua;
	}

	@Column(name ="FBOXIANG",nullable=true,length=32)
	public String getFboxiang() {
		return fboxiang;
	}

	public void setFboxiang(String fboxiang) {
		this.fboxiang = fboxiang;
	}

	@Column(name ="FYUTI",nullable=true,length=32)
	public String getFyuti() {
		return fyuti;
	}

	public void setFyuti(String fyuti) {
		this.fyuti = fyuti;
	}

	@Column(name ="FJIXU",nullable=true,length=32)
	public String getFjixu() {
		return fjixu;
	}

	public void setFjixu(String fjixu) {
		this.fjixu = fjixu;
	}

	@Column(name ="FQUXIAO",nullable=true,length=32)
	public String getFquxiao() {
		return fquxiao;
	}

	public void setFquxiao(String fquxiao) {
		this.fquxiao = fquxiao;
	}

	@Column(name ="FXIANDAO",nullable=true,length=32)
	public String getFxiandao() {
		return fxiandao;
	}

	public void setFxiandao(String fxiandao) {
		this.fxiandao = fxiandao;
	}

	@Column(name ="FUP",nullable=true,length=32)
	public String getFup() {
		return fup;
	}

	public void setFup(String fup) {
		this.fup = fup;
	}

	@Column(name ="FQSDATE",nullable=true,length=32)
	public Date getFqsdate() {
		return fqsdate;
	}

	public void setFqsdate(Date fqsdate) {
		this.fqsdate = fqsdate;
	}

	@Column(name ="FIEPORT",nullable=true,length=32)
	public String getFieport() {
		return fieport;
	}

	public void setFieport(String fieport) {
		this.fieport = fieport;
	}

	@Column(name ="FDAIHUO",nullable=true,length=32)
	public String getFdaihuo() {
		return fdaihuo;
	}

	public void setFdaihuo(String fdaihuo) {
		this.fdaihuo = fdaihuo;
	}

    @Column(name ="FCHECK",nullable=true,length=32)
    public String getFcheck() {
        return fcheck;
    }

    public void setFcheck(String fcheck) {
        this.fcheck = fcheck;
    }

    @Column(name ="FCHECKER",nullable=true,length=32)
    public String getFchecker() {
        return fchecker;
    }

    public void setFchecker(String fchecker) {
        this.fchecker = fchecker;
    }

    @Column(name ="FCHECKDATE",nullable=true)
    public Date getFcheckdate() {
        return fcheckdate;
    }

    public void setFcheckdate(Date fcheckdate) {
        this.fcheckdate = fcheckdate;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  加热温度
     */
    @Column(name ="FHOT",nullable=true,length=32)
    public java.lang.String getFhot(){
        return this.fhot;
    }
    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  加热温度
     */
    public void setFhot(java.lang.String fhot){
        this.fhot = fhot;
    }

    @Column(name="FZHWEIGHT",nullable=true,length=32)
	public BigDecimal getFzhweight() {
		return fzhweight;
	}

	public void setFzhweight(BigDecimal fzhweight) {
		this.fzhweight = fzhweight;
	}

	@Column(name="FXHWEIGHT",nullable=true,length=32)
	public BigDecimal getFxhweight() {
		return fxhweight;
	}

	public void setFxhweight(BigDecimal fxhweight) {
		this.fxhweight = fxhweight;
	}

	@Column(name="FMANHOLE",nullable=true,length=32)
	public String getFmanhole() {
		return fmanhole;
	}

	public void setFmanhole(String fmanhole) {
		this.fmanhole = fmanhole;
	}

	@Column(name="FVALVE",nullable=true,length=32)
	public String getFvalve() {
		return fvalve;
	}

	public void setFvalve(String fvalve) {
		this.fvalve = fvalve;
	}

	@Column(name="FPRICE")
	public java.lang.Double getFprice() {
		return fprice;
	}

	public void setFprice(java.lang.Double fprice) {
		this.fprice = fprice;
	}

	@Column(name="ftitle1",nullable=true)
	public String getFtitle1() {
		return ftitle1;
	}

	public void setFtitle1(String ftitle1) {
		this.ftitle1 = ftitle1;
	}

	@Column(name="fmanhole1",nullable=true)
	public String getFmanhole1() {
		return fmanhole1;
	}

	public void setFmanhole1(String fmanhole1) {
		this.fmanhole1 = fmanhole1;
	}

	@Column(name="fvalve1",nullable=true)
	public String getFvalve1() {
		return fvalve1;
	}

	public void setFvalve1(String fvalve1) {
		this.fvalve1 = fvalve1;
	}

	@Column(name="fxhnum",length=32)
	public Integer getFxhnum() {
		return fxhnum;
	}

	public void setFxhnum(Integer fxhnum) {
		this.fxhnum = fxhnum;
	}

	@Column(name="fdao",length=32)
	public Date getFdao() {
		return fdao;
	}

	public void setFdao(Date fdao) {
		this.fdao = fdao;
	}

	@Column(name="fli",length=32)
	public Date getFli() {
		return fli;
	}

	public void setFli(Date fli) {
		this.fli = fli;
	}

	@Column(name="fyupai",length=32)
	public Date getFyupai() {
		return fyupai;
	}

	public void setFyupai(Date fyupai) {
		this.fyupai = fyupai;
	}

	@Column(name="cid1",length=32)
	public String getCid1() {
		return cid1;
	}

	public void setCid1(String cid1) {
		this.cid1 = cid1;
	}

	@Column(name="fzhtime",length=32)
	public Date getFzhtime() {
		return fzhtime;
	}

	public void setFzhtime(Date fzhtime) {
		this.fzhtime = fzhtime;
	}

	@Column(name="fwtzhweight",length=32)
	public Double getFwtzhweight() {
		return fwtzhweight;
	}

	public void setFwtzhweight(Double fwtzhweight) {
		this.fwtzhweight = fwtzhweight;
	}

	@Column(name="fother",length=32)
	public Double getFother() {
		return fother;
	}

	public void setFother(Double fother) {
		this.fother = fother;
	}

	@Column(name="fwtxhnum",length=32)
	public Integer getFwtxhnum() {
		return fwtxhnum;
	}

	public void setFwtxhnum(Integer fwtxhnum) {
		this.fwtxhnum = fwtxhnum;
	}

	@Column(name="fbang",length=32)
	public Double getFbang() {
		return fbang;
	}

	public void setFbang(Double fbang) {
		this.fbang = fbang;
	}

	@Column(name="fwtxhweight",length = 32)
	public Double getFwtxhweight() {
		return fwtxhweight;
	}

	public void setFwtxhweight(Double fwtxhweight) {
		this.fwtxhweight = fwtxhweight;
	}

	@Column(name="fother1",length = 32)
	public Double getFother1() {
		return fother1;
	}

	public void setFother1(Double fother1) {
		this.fother1 = fother1;
	}

	@Column(name="fno",length = 32)
	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	@Column(name="fboxweight",nullable = true)
	public Double getFboxweight() {
		return fboxweight;
	}

	public void setFboxweight(Double fboxweight) {
		this.fboxweight = fboxweight;
	}
}
