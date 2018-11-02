package com.jeecg.container.page;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

import com.jeecg.contianer.entity.ContianerEntity;
import com.jeecg.detail.entity.DetailEntity;

/**   
 * @Title: Entity
 * @Description: 集装箱
 * @author onlineGenerator
 * @date 2018-07-02 10:52:51
 * @version V1.0   
 *
 */

public class ContainerPage implements java.io.Serializable {
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
	@Excel(name="航名",width=15)
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
	/**联合国编号*/
	@Excel(name="联合国编号",width=15)
	private java.lang.String funnumber;
	/**闪点*/
	@Excel(name="闪点",width=15)
	private java.lang.String flashPoint;
	/**冷藏温度*/
	@Excel(name="冷藏温度",width=15)
	private java.lang.String fcolddegree;
	/**总件数*/
	@Excel(name="总件数",width=15)
	private java.lang.Integer ftotals;
	/**总毛重*/
	@Excel(name="总毛重",width=15)
	private java.lang.Integer fgrosses;
	/**总体积*/
	@Excel(name="总体积",width=15)
	private java.lang.Integer fvolumes;
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
	/**对应派车单号*/
	private java.lang.String fbillno;
	
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
	public java.lang.Integer getFtotals(){
		return this.ftotals;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总件数
	 */
	public void setFtotals(java.lang.Integer ftotals){
		this.ftotals = ftotals;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总毛重
	 */

	@Column(name ="FGROSSES",nullable=true,length=32)
	public java.lang.Integer getFgrosses(){
		return this.fgrosses;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总毛重
	 */
	public void setFgrosses(java.lang.Integer fgrosses){
		this.fgrosses = fgrosses;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总体积
	 */

	@Column(name ="FVOLUMES",nullable=true,length=32)
	public java.lang.Integer getFvolumes(){
		return this.fvolumes;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总体积
	 */
	public void setFvolumes(java.lang.Integer fvolumes){
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

	@Column(name ="FBILLNO",nullable=false,length=32)
	public String getFbillno() {
		return fbillno;
	}

	public void setFbillno(String fbillno) {
		this.fbillno = fbillno;
	}
	
	/**保存-集装箱*/
    @ExcelCollection(name="集装箱明细")
	private List<DetailEntity> detailList = new ArrayList<DetailEntity>();
		public List<DetailEntity> getDetailList() {
			return detailList;
		}
		public void setDetailList(List<DetailEntity> detailList) {
		this.detailList = detailList;
   }
}
