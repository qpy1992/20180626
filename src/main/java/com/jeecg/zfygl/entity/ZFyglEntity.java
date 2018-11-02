package com.jeecg.zfygl.entity;

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
 * @Description: 费用管理
 * @author onlineGenerator
 * @date 2018-08-09 08:50:46
 * @version V1.0   
 *
 */
@Entity
@Table(name = "z_fygl", schema = "")
@SuppressWarnings("serial")
public class ZFyglEntity implements java.io.Serializable {
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
	/**关联工作号*/
	private java.lang.String fglgzh;
	/**委托编号*/
	private java.lang.String fwtbh;
	/**客户号*/
	private java.lang.String fkhh;
	/**客户名称*/
	@Excel(name="客户名称",width=15)
	private java.lang.String fkhname;
	/**双拖*/
	@Excel(name="双拖",width=15)
	private java.lang.String fst;
	/**套箱*/
	@Excel(name="套箱",width=15)
	private java.lang.String ftx;
	/**暂落*/
	@Excel(name="暂落",width=15)
	private java.lang.String fzl;
	/**甩挂*/
	@Excel(name="甩挂",width=15)
	private java.lang.String fsg;
	/**驳箱*/
	@Excel(name="驳箱",width=15)
	private java.lang.String fbx;
	/**外委*/
	@Excel(name="外委",width=15)
	private java.lang.String fww;
	/**预提*/
	@Excel(name="预提",width=15)
	private java.lang.String fyt;
	/**门点地址*/
	@Excel(name="门点地址",width=15)
	private java.lang.String fmddz;
	/**销售订单号*/
	@Excel(name="销售订单号",width=15)
	private java.lang.String fxsddh;
	/**箱型箱量*/
	@Excel(name="箱型箱量",width=15)
	private java.lang.String xxxl;
	/**客户采购订单号*/
	@Excel(name="客户采购订单号",width=15)
	private java.lang.String khcgddh;
	/**封号*/
	@Excel(name="封号",width=15)
	private java.lang.String fh;
	/**应付锁定*/
	@Excel(name="应付锁定",width=15)
	private java.lang.String yfsd;
	/**应收锁定*/
	@Excel(name="应收锁定",width=15)
	private java.lang.String yssd;
	
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
	 *@return: java.lang.String  关联工作号
	 */

	@Column(name ="FGLGZH",nullable=true,length=50)
	public java.lang.String getFglgzh(){
		return this.fglgzh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联工作号
	 */
	public void setFglgzh(java.lang.String fglgzh){
		this.fglgzh = fglgzh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  委托编号
	 */

	@Column(name ="FWTBH",nullable=true,length=50)
	public java.lang.String getFwtbh(){
		return this.fwtbh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  委托编号
	 */
	public void setFwtbh(java.lang.String fwtbh){
		this.fwtbh = fwtbh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户号
	 */

	@Column(name ="FKHH",nullable=true,length=32)
	public java.lang.String getFkhh(){
		return this.fkhh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户号
	 */
	public void setFkhh(java.lang.String fkhh){
		this.fkhh = fkhh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */

	@Column(name ="FKHNAME",nullable=true,length=32)
	public java.lang.String getFkhname(){
		return this.fkhname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setFkhname(java.lang.String fkhname){
		this.fkhname = fkhname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  双拖
	 */

	@Column(name ="FST",nullable=true,length=32)
	public java.lang.String getFst(){
		return this.fst;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  双拖
	 */
	public void setFst(java.lang.String fst){
		this.fst = fst;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  套箱
	 */

	@Column(name ="FTX",nullable=true,length=32)
	public java.lang.String getFtx(){
		return this.ftx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  套箱
	 */
	public void setFtx(java.lang.String ftx){
		this.ftx = ftx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  暂落
	 */

	@Column(name ="FZL",nullable=true,length=32)
	public java.lang.String getFzl(){
		return this.fzl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  暂落
	 */
	public void setFzl(java.lang.String fzl){
		this.fzl = fzl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  甩挂
	 */

	@Column(name ="FSG",nullable=true,length=32)
	public java.lang.String getFsg(){
		return this.fsg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  甩挂
	 */
	public void setFsg(java.lang.String fsg){
		this.fsg = fsg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驳箱
	 */

	@Column(name ="FBX",nullable=true,length=32)
	public java.lang.String getFbx(){
		return this.fbx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驳箱
	 */
	public void setFbx(java.lang.String fbx){
		this.fbx = fbx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外委
	 */

	@Column(name ="FWW",nullable=true,length=32)
	public java.lang.String getFww(){
		return this.fww;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外委
	 */
	public void setFww(java.lang.String fww){
		this.fww = fww;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预提
	 */

	@Column(name ="FYT",nullable=true,length=32)
	public java.lang.String getFyt(){
		return this.fyt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预提
	 */
	public void setFyt(java.lang.String fyt){
		this.fyt = fyt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  门点地址
	 */

	@Column(name ="FMDDZ",nullable=true,length=32)
	public java.lang.String getFmddz(){
		return this.fmddz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  门点地址
	 */
	public void setFmddz(java.lang.String fmddz){
		this.fmddz = fmddz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售订单号
	 */

	@Column(name ="FXSDDH",nullable=true,length=32)
	public java.lang.String getFxsddh(){
		return this.fxsddh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售订单号
	 */
	public void setFxsddh(java.lang.String fxsddh){
		this.fxsddh = fxsddh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  箱型箱量
	 */

	@Column(name ="XXXL",nullable=true,length=32)
	public java.lang.String getXxxl(){
		return this.xxxl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  箱型箱量
	 */
	public void setXxxl(java.lang.String xxxl){
		this.xxxl = xxxl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户采购订单号
	 */

	@Column(name ="KHCGDDH",nullable=true,length=32)
	public java.lang.String getKhcgddh(){
		return this.khcgddh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户采购订单号
	 */
	public void setKhcgddh(java.lang.String khcgddh){
		this.khcgddh = khcgddh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  封号
	 */

	@Column(name ="FH",nullable=true,length=32)
	public java.lang.String getFh(){
		return this.fh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  封号
	 */
	public void setFh(java.lang.String fh){
		this.fh = fh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应付锁定
	 */

	@Column(name ="YFSD",nullable=true,length=32)
	public java.lang.String getYfsd(){
		return this.yfsd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应付锁定
	 */
	public void setYfsd(java.lang.String yfsd){
		this.yfsd = yfsd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  应收锁定
	 */

	@Column(name ="YSSD",nullable=true,length=32)
	public java.lang.String getYssd(){
		return this.yssd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  应收锁定
	 */
	public void setYssd(java.lang.String yssd){
		this.yssd = yssd;
	}
}
