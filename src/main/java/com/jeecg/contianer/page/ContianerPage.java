
package com.jeecg.contianer.page;
import com.jeecg.contianer.entity.ContianerEntity;
import com.jeecg.detail.entity.DetailEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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

/**   
 * @Title: Entity
 * @Description: 集装箱
 * @author onlineGenerator
 * @date 2018-08-01 16:47:07
 * @version V1.0   
 *
 */
public class ContianerPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**箱号*/
    @Excel(name="箱号")
	private java.lang.String fboxno;
	/**封号*/
    @Excel(name="封号")
	private java.lang.String ftitle;
	/**箱型*/
    @Excel(name="箱型")
	private java.lang.String fboxtype;
	/**装船港*/
    @Excel(name="装船港")
	private java.lang.String floadport;
	/**中转港*/
    @Excel(name="中转港")
	private java.lang.String ftransfer;
	/**目的港*/
    @Excel(name="目的港")
	private java.lang.String ftarget;
	/**航名*/
    @Excel(name="航名")
	private java.lang.String fvoyage;
	/**航次*/
    @Excel(name="航次")
	private java.lang.String fvoyagenum;
	/**型号*/
    @Excel(name="型号")
	private java.lang.String fmodel;
	/**做箱时间*/
    @Excel(name="做箱时间",format = "yyyy-MM-dd")
	private java.util.Date fmakeboxtime;
	/**等级*/
    @Excel(name="等级")
	private java.lang.String fgrade;
	/**危规页码*/
    @Excel(name="危规页码")
	private java.lang.String fdrpagenum;
	/**联合国编号*/
    @Excel(name="联合国编号")
	private java.lang.String funnumber;
	/**闪点*/
    @Excel(name="闪点")
	private java.lang.String flashPoint;
	/**冷藏温度*/
    @Excel(name="冷藏温度")
	private java.lang.String fcolddegree;
	/**总件数*/
    @Excel(name="总件数")
	private java.lang.Integer ftotals;
	/**总毛重*/
    @Excel(name="总毛重")
	private java.lang.Integer fgrosses;
	/**总体积*/
    @Excel(name="总体积")
	private java.lang.Integer fvolumes;
	/**提箱点*/
    @Excel(name="提箱点")
	private java.lang.String fextract;
	/**还箱点*/
    @Excel(name="还箱点")
	private java.lang.String freturn;
	/**集装箱经营人*/
    @Excel(name="集装箱经营人")
	private java.lang.String foperator;
	/**主表主键*/
	private java.lang.String fid;
	/**装货门点*/
    @Excel(name="装货门点")
	private java.lang.String fzhdp;
	/**门点地址*/
    @Excel(name="门点地址")
	private java.lang.String fzhdpdz;
	/**装货单位*/
    @Excel(name="装货单位")
	private java.lang.String fzhunit;
	/**联系人*/
    @Excel(name="联系人")
	private java.lang.String fzhcontact;
	/**联系电话*/
    @Excel(name="联系电话")
	private java.lang.String fzhmobile;
	/**备注*/
    @Excel(name="备注")
	private java.lang.String fnote;
	/**特殊业务*/
    @Excel(name="特殊业务")
	private java.lang.String ftsyw;
	/**卸货门点*/
    @Excel(name="卸货门点")
	private java.lang.String fxhdp;
	/**门点地址*/
    @Excel(name="门点地址")
	private java.lang.String fxhdpdz;
	/**卸货时间*/
    @Excel(name="卸货时间",format = "yyyy-MM-dd")
	private java.util.Date fxhtime;
	/**卸货单位*/
    @Excel(name="卸货单位")
	private java.lang.String fxhunit;
	/**联系人*/
    @Excel(name="联系人")
	private java.lang.String fxhcontact;
	/**联系电话*/
    @Excel(name="联系电话")
	private java.lang.String fxhmobile;
	/**对应派车单号*/
    @Excel(name="对应派车单号")
	private java.lang.String fbillno;
	/**暂落*/
    @Excel(name="暂落")
	private java.lang.String fzanluo;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
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

	/**保存-箱货明细*/
    @ExcelCollection(name="箱货明细")
	private List<DetailEntity> detailList = new ArrayList<DetailEntity>();
		public List<DetailEntity> getDetailList() {
		return detailList;
		}
		public void setDetailList(List<DetailEntity> detailList) {
		this.detailList = detailList;
		}
}
