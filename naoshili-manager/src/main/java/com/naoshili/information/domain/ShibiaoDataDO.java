package com.naoshili.information.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 视标数据表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public class ShibiaoDataDO implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShibiaoDataDO() {
	}

	// id
	private Long id;
	// 单次数据序号
	private String dataId;
	// 时间
	private Date time;

	// 位置（移动视标）
	private Integer localtion;
	// 速度（移动视标）
	private Double speed;
	// 视标1（交替通断）
	private Double visualStandard1;
	// 视标2（交替通断）
	private Double visualStandard2;
	// 视标3（交替通断）
	private Double visualStandard3;

	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置：单次数据序号
	 */
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	/**
	 * 获取：单次数据序号
	 */
	public String getDataId() {
		return dataId;
	}

	/**
	 * 设置：时间
	 */

	/**
	 * 设置：位置（移动视标）
	 */
	public void setLocaltion(Integer localtion) {
		this.localtion = localtion;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * 获取：位置（移动视标）
	 */
	public Integer getLocaltion() {
		return localtion;
	}

	/**
	 * 设置：速度（移动视标）
	 */
	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	/**
	 * 获取：速度（移动视标）
	 */
	public Double getSpeed() {
		return speed;
	}

	/**
	 * 设置：视标1（交替通断）
	 */
	public void setVisualStandard1(Double visualStandard1) {
		this.visualStandard1 = visualStandard1;
	}

	/**
	 * 获取：视标1（交替通断）
	 */
	public Double getVisualStandard1() {
		return visualStandard1;
	}

	/**
	 * 设置：视标2（交替通断）
	 */
	public void setVisualStandard2(Double visualStandard2) {
		this.visualStandard2 = visualStandard2;
	}

	/**
	 * 获取：视标2（交替通断）
	 */
	public Double getVisualStandard2() {
		return visualStandard2;
	}

	/**
	 * 设置：视标3（交替通断）
	 */
	public void setVisualStandard3(Double visualStandard3) {
		this.visualStandard3 = visualStandard3;
	}

	/**
	 * 获取：视标3（交替通断）
	 */
	public Double getVisualStandard3() {
		return visualStandard3;
	}

	@Override
	public String toString() {
		return "ShibiaoDataDO{" +
				"id=" + id +
				", dataId=" + dataId +
				", time=" + time +
				", localtion=" + localtion +
				", speed=" + speed +
				", visualStandard1=" + visualStandard1 +
				", visualStandard2=" + visualStandard2 +
				", visualStandard3=" + visualStandard3 +
				'}';
	}
}
