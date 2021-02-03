package com.naoshili.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 临时图片保存  可以清空
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-02-02 15:24:04
 */
public class LinshiUrlDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//user_id
	private Integer userId;
	//单段图片base64
	private String danduantu;
	//交替图片base64
	private String jiaotitu;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：user_id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：user_id
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：单段图片base64
	 */
	public void setDanduantu(String danduantu) {
		this.danduantu = danduantu;
	}
	/**
	 * 获取：单段图片base64
	 */
	public String getDanduantu() {
		return danduantu;
	}
	/**
	 * 设置：交替图片base64
	 */
	public void setJiaotitu(String jiaotitu) {
		this.jiaotitu = jiaotitu;
	}
	/**
	 * 获取：交替图片base64
	 */
	public String getJiaotitu() {
		return jiaotitu;
	}
}
