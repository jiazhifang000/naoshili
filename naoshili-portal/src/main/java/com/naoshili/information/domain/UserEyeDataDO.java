package com.naoshili.information.domain;

import java.io.Serializable;

/**
 * 用户眼部数据表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public class UserEyeDataDO implements Serializable {
    private static final long serialVersionUID = 1L;

    // id
    private Long id;
    // 用户id
    private Long uid;
    // 左眼球径
    private Double lEyeballDiameter;
    // 右眼球径
    private Double rEyeballDiameter;
    // 左眼柱径
    private Double lEyepillarDiameter;
    // 右眼柱径
    private Double rEyepillarDiameter;
    // 左眼轴
    private Double lEyeAxis;
    // 右眼轴
    private Double rEyeAxis;
    // 左眼验光
    private Double lEyeOptometry;
    // 右眼验光
    private Double rEyeOptometry;
    // 左眼裸眼视力
    private Double lEyeNakedVision;
    // 右眼裸眼视力
    private Double rEyeNakedVision;
    // 左眼戴镜视力
    private Double lEyeGlassesVision;
    // 右眼戴镜视力
    private Double rEyeGlassesVision;
    //视镜片到角膜顶点的距离
    private Double glassToCornea;
    //视镜片的屈光度值
    private Double glassDiopter;

    private String uname;

    // 左眼眼镜视力
    private Double lGlassesVision;
    // 右眼眼镜视力
    private Double rGlassesVision;

    public Double getlGlassesVision() {
        return lGlassesVision;
    }

    public void setlGlassesVision(Double lGlassesVision) {
        this.lGlassesVision = lGlassesVision;
    }

    public Double getrGlassesVision() {
        return rGlassesVision;
    }

    public void setrGlassesVision(Double rGlassesVision) {
        this.rGlassesVision = rGlassesVision;
    }

    public Double getGlassToCornea() {
        return glassToCornea;
    }

    public void setGlassToCornea(Double glassToCornea) {
        this.glassToCornea = glassToCornea;
    }

    public Double getGlassDiopter() {
        return glassDiopter;
    }

    public void setGlassDiopter(Double glassDiopter) {
        this.glassDiopter = glassDiopter;
    }

    public Double getlEyeballDiameter() {
        return lEyeballDiameter;
    }

    public void setlEyeballDiameter(Double lEyeballDiameter) {
        this.lEyeballDiameter = lEyeballDiameter;
    }

    public Double getrEyeballDiameter() {
        return rEyeballDiameter;
    }

    public void setrEyeballDiameter(Double rEyeballDiameter) {
        this.rEyeballDiameter = rEyeballDiameter;
    }

    public Double getlEyepillarDiameter() {
        return lEyepillarDiameter;
    }

    public void setlEyepillarDiameter(Double lEyepillarDiameter) {
        this.lEyepillarDiameter = lEyepillarDiameter;
    }

    public Double getrEyepillarDiameter() {
        return rEyepillarDiameter;
    }

    public void setrEyepillarDiameter(Double rEyepillarDiameter) {
        this.rEyepillarDiameter = rEyepillarDiameter;
    }

    public Double getlEyeAxis() {
        return lEyeAxis;
    }

    public void setlEyeAxis(Double lEyeAxis) {
        this.lEyeAxis = lEyeAxis;
    }

    public Double getrEyeAxis() {
        return rEyeAxis;
    }

    public void setrEyeAxis(Double rEyeAxis) {
        this.rEyeAxis = rEyeAxis;
    }

    public Double getlEyeOptometry() {
        return lEyeOptometry;
    }

    public void setlEyeOptometry(Double lEyeOptometry) {
        this.lEyeOptometry = lEyeOptometry;
    }

    public Double getrEyeOptometry() {
        return rEyeOptometry;
    }

    public void setrEyeOptometry(Double rEyeOptometry) {
        this.rEyeOptometry = rEyeOptometry;
    }

    public Double getlEyeNakedVision() {
        return lEyeNakedVision;
    }

    public void setlEyeNakedVision(Double lEyeNakedVision) {
        this.lEyeNakedVision = lEyeNakedVision;
    }

    public Double getrEyeNakedVision() {
        return rEyeNakedVision;
    }

    public void setrEyeNakedVision(Double rEyeNakedVision) {
        this.rEyeNakedVision = rEyeNakedVision;
    }

    public Double getlEyeGlassesVision() {
        return lEyeGlassesVision;
    }

    public void setlEyeGlassesVision(Double lEyeGlassesVision) {
        this.lEyeGlassesVision = lEyeGlassesVision;
    }

    public Double getrEyeGlassesVision() {
        return rEyeGlassesVision;
    }

    public void setrEyeGlassesVision(Double rEyeGlassesVision) {
        this.rEyeGlassesVision = rEyeGlassesVision;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

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
     * 设置：用户id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取：用户id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置：左眼球径
     */
    public void setLEyeballDiameter(Double lEyeballDiameter) {
        this.lEyeballDiameter = lEyeballDiameter;
    }

    /**
     * 获取：左眼球径
     */
    public Double getLEyeballDiameter() {
        return lEyeballDiameter;
    }

    /**
     * 设置：右眼球径
     */
    public void setREyeballDiameter(Double rEyeballDiameter) {
        this.rEyeballDiameter = rEyeballDiameter;
    }

    /**
     * 获取：右眼球径
     */
    public Double getREyeballDiameter() {
        return rEyeballDiameter;
    }

    /**
     * 设置：左眼柱径
     */
    public void setLEyepillarDiameter(Double lEyepillarDiameter) {
        this.lEyepillarDiameter = lEyepillarDiameter;
    }

    /**
     * 获取：左眼柱径
     */
    public Double getLEyepillarDiameter() {
        return lEyepillarDiameter;
    }

    /**
     * 设置：右眼柱径
     */
    public void setREyepillarDiameter(Double rEyepillarDiameter) {
        this.rEyepillarDiameter = rEyepillarDiameter;
    }

    /**
     * 获取：右眼柱径
     */
    public Double getREyepillarDiameter() {
        return rEyepillarDiameter;
    }

    /**
     * 设置：左眼轴
     */
    public void setLEyeAxis(Double lEyeAxis) {
        this.lEyeAxis = lEyeAxis;
    }

    /**
     * 获取：左眼轴
     */
    public Double getLEyeAxis() {
        return lEyeAxis;
    }

    /**
     * 设置：右眼轴
     */
    public void setREyeAxis(Double rEyeAxis) {
        this.rEyeAxis = rEyeAxis;
    }

    /**
     * 获取：右眼轴
     */
    public Double getREyeAxis() {
        return rEyeAxis;
    }

    /**
     * 设置：左眼验光
     */
    public void setLEyeOptometry(Double lEyeOptometry) {
        this.lEyeOptometry = lEyeOptometry;
    }

    /**
     * 获取：左眼验光
     */
    public Double getLEyeOptometry() {
        return lEyeOptometry;
    }

    /**
     * 设置：右眼验光
     */
    public void setREyeOptometry(Double rEyeOptometry) {
        this.rEyeOptometry = rEyeOptometry;
    }

    /**
     * 获取：右眼验光
     */
    public Double getREyeOptometry() {
        return rEyeOptometry;
    }

    /**
     * 设置：左眼裸眼视力
     */
    public void setLEyeNakedVision(Double lEyeNakedVision) {
        this.lEyeNakedVision = lEyeNakedVision;
    }

    /**
     * 获取：左眼裸眼视力
     */
    public Double getLEyeNakedVision() {
        return lEyeNakedVision;
    }

    /**
     * 设置：右眼裸眼视力
     */
    public void setREyeNakedVision(Double rEyeNakedVision) {
        this.rEyeNakedVision = rEyeNakedVision;
    }

    /**
     * 获取：右眼裸眼视力
     */
    public Double getREyeNakedVision() {
        return rEyeNakedVision;
    }

    /**
     * 设置：左眼戴镜视力
     */
    public void setLEyeGlassesVision(Double lEyeGlassesVision) {
        this.lEyeGlassesVision = lEyeGlassesVision;
    }

    /**
     * 获取：左眼戴镜视力
     */
    public Double getLEyeGlassesVision() {
        return lEyeGlassesVision;
    }

    /**
     * 设置：右眼戴镜视力
     */
    public void setREyeGlassesVision(Double rEyeGlassesVision) {
        this.rEyeGlassesVision = rEyeGlassesVision;
    }

    /**
     * 获取：右眼戴镜视力
     */
    public Double getREyeGlassesVision() {
        return rEyeGlassesVision;
    }

    @Override
    public String toString() {
        return "UserEyeDataDO [id=" + id + ", uid=" + uid + ", lEyeballDiameter=" + lEyeballDiameter
                + ", rEyeballDiameter=" + rEyeballDiameter + ", lEyepillarDiameter=" + lEyepillarDiameter
                + ", rEyepillarDiameter=" + rEyepillarDiameter + ", lEyeAxis=" + lEyeAxis + ", rEyeAxis=" + rEyeAxis
                + ", lEyeOptometry=" + lEyeOptometry + ", rEyeOptometry=" + rEyeOptometry + ", lEyeNakedVision="
                + lEyeNakedVision + ", rEyeNakedVision=" + rEyeNakedVision + ", lEyeGlassesVision=" + lEyeGlassesVision
                + ", rEyeGlassesVision=" + rEyeGlassesVision + "]";
    }

}
