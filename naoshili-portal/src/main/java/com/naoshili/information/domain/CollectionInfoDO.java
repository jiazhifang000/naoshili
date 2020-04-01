package com.naoshili.information.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 采集数据基本信息
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public class CollectionInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	// id
	private Long id;
	// 身份证
	private String idCard;
	// 采集日期
	private Date collectionDate;
	// 采集时间
	private Date collectionTime;
	// 实验方式
	private String experimentalMode;
	// 负责医生
	private String responsibleDoctor;
	// 设备名称
	private String deviceName;
	// 精工平均屈光度
	private Double avgDiopter;

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
	 * 设置：身份证
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * 获取：身份证
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * 设置：采集日期
	 */
	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}

	/**
	 * 获取：采集日期
	 */
	public Date getCollectionDate() {
		return collectionDate;
	}

	/**
	 * 设置：采集时间
	 */

	/**
	 * 设置：实验方式
	 */
	public void setExperimentalMode(String experimentalMode) {
		this.experimentalMode = experimentalMode;
	}

	public Date getCollectionTime() {
		return collectionTime;
	}

	public void setCollectionTime(Date collectionTime) {
		this.collectionTime = collectionTime;
	}

	/**
	 * 获取：实验方式
	 */
	public String getExperimentalMode() {
		return experimentalMode;
	}

	/**
	 * 设置：负责医生
	 */
	public void setResponsibleDoctor(String responsibleDoctor) {
		this.responsibleDoctor = responsibleDoctor;
	}

	/**
	 * 获取：负责医生
	 */
	public String getResponsibleDoctor() {
		return responsibleDoctor;
	}

	/**
	 * 设置：设备名称
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * 获取：设备名称
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * 设置：精工平均屈光度
	 */
	public void setAvgDiopter(Double avgDiopter) {
		this.avgDiopter = avgDiopter;
	}

	/**
	 * 获取：精工平均屈光度
	 */
	public Double getAvgDiopter() {
		return avgDiopter;
	}
}
