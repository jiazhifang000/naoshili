package com.naoshili.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 眼调节功能结果
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-02-02 10:13:27
 */
public class JinggongAdjustDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户ID
	private Integer userId;
	//单段A标段调节微波动
	private Double microwaveParagraphA;
	//单段B标段调节微波动
	private Double microwaveParagraphB;
	//单段C标段调节微波动
	private Double microwaveParagraphC;
	//闪烁A标段调节微波动
	private Double microwaveFlashingA;
	//闪烁B标段调节微波动
	private Double microwaveFlashingB;
	//单段A标段调节滞后量
	private Double lagParagraphA;
	//单段B标段调节滞后量
	private Double lagParagraphB;
	//单段C标段调节滞后量
	private Double lagParagraphC;
	//闪烁A标段调节滞后量
	private Double lagFlashingA;
	//闪烁B标段调节滞后量
	private Double lagFlashingB;

    public JinggongAdjustDO() {
    }

    public JinggongAdjustDO(Integer userId, Double microwaveParagraphA, Double microwaveParagraphB, Double microwaveParagraphC, Double microwaveFlashingA, Double microwaveFlashingB, Double lagParagraphA, Double lagParagraphB, Double lagParagraphC, Double lagFlashingA, Double lagFlashingB) {
        this.userId = userId;
        this.microwaveParagraphA = microwaveParagraphA;
        this.microwaveParagraphB = microwaveParagraphB;
        this.microwaveParagraphC = microwaveParagraphC;
        this.microwaveFlashingA = microwaveFlashingA;
        this.microwaveFlashingB = microwaveFlashingB;
        this.lagParagraphA = lagParagraphA;
        this.lagParagraphB = lagParagraphB;
        this.lagParagraphC = lagParagraphC;
        this.lagFlashingA = lagFlashingA;
        this.lagFlashingB = lagFlashingB;
    }

    /**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：单段A标段调节微波动
	 */
	public void setMicrowaveParagraphA(Double microwaveParagraphA) {
		this.microwaveParagraphA = microwaveParagraphA;
	}
	/**
	 * 获取：单段A标段调节微波动
	 */
	public Double getMicrowaveParagraphA() {
		return microwaveParagraphA;
	}
	/**
	 * 设置：单段B标段调节微波动
	 */
	public void setMicrowaveParagraphB(Double microwaveParagraphB) {
		this.microwaveParagraphB = microwaveParagraphB;
	}
	/**
	 * 获取：单段B标段调节微波动
	 */
	public Double getMicrowaveParagraphB() {
		return microwaveParagraphB;
	}
	/**
	 * 设置：单段C标段调节微波动
	 */
	public void setMicrowaveParagraphC(Double microwaveParagraphC) {
		this.microwaveParagraphC = microwaveParagraphC;
	}
	/**
	 * 获取：单段C标段调节微波动
	 */
	public Double getMicrowaveParagraphC() {
		return microwaveParagraphC;
	}
	/**
	 * 设置：闪烁A标段调节微波动
	 */
	public void setMicrowaveFlashingA(Double microwaveFlashingA) {
		this.microwaveFlashingA = microwaveFlashingA;
	}
	/**
	 * 获取：闪烁A标段调节微波动
	 */
	public Double getMicrowaveFlashingA() {
		return microwaveFlashingA;
	}
	/**
	 * 设置：闪烁B标段调节微波动
	 */
	public void setMicrowaveFlashingB(Double microwaveFlashingB) {
		this.microwaveFlashingB = microwaveFlashingB;
	}
	/**
	 * 获取：闪烁B标段调节微波动
	 */
	public Double getMicrowaveFlashingB() {
		return microwaveFlashingB;
	}
	/**
	 * 设置：单段A标段调节滞后量
	 */
	public void setLagParagraphA(Double lagParagraphA) {
		this.lagParagraphA = lagParagraphA;
	}
	/**
	 * 获取：单段A标段调节滞后量
	 */
	public Double getLagParagraphA() {
		return lagParagraphA;
	}
	/**
	 * 设置：单段B标段调节滞后量
	 */
	public void setLagParagraphB(Double lagParagraphB) {
		this.lagParagraphB = lagParagraphB;
	}
	/**
	 * 获取：单段B标段调节滞后量
	 */
	public Double getLagParagraphB() {
		return lagParagraphB;
	}
	/**
	 * 设置：单段C标段调节滞后量
	 */
	public void setLagParagraphC(Double lagParagraphC) {
		this.lagParagraphC = lagParagraphC;
	}
	/**
	 * 获取：单段C标段调节滞后量
	 */
	public Double getLagParagraphC() {
		return lagParagraphC;
	}
	/**
	 * 设置：闪烁A标段调节滞后量
	 */
	public void setLagFlashingA(Double lagFlashingA) {
		this.lagFlashingA = lagFlashingA;
	}
	/**
	 * 获取：闪烁A标段调节滞后量
	 */
	public Double getLagFlashingA() {
		return lagFlashingA;
	}
	/**
	 * 设置：闪烁B标段调节滞后量
	 */
	public void setLagFlashingB(Double lagFlashingB) {
		this.lagFlashingB = lagFlashingB;
	}
	/**
	 * 获取：闪烁B标段调节滞后量
	 */
	public Double getLagFlashingB() {
		return lagFlashingB;
	}
}
