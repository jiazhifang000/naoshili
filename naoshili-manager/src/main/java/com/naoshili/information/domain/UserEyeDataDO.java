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
    private String lEyeballDiameter;
    // 右眼球径
    private String rEyeballDiameter;
    // 左眼柱径
    private String lEyepillarDiameter;
    // 右眼柱径
    private String rEyepillarDiameter;
    // 左眼轴
    private String lEyeAxis;
    // 右眼轴
    private String rEyeAxis;
    // 左眼验光
    private String lEyeOptometry;
    // 右眼验光
    private String rEyeOptometry;
    // 左眼裸眼视力
    private String lEyeNakedVision;
    // 右眼裸眼视力
    private String rEyeNakedVision;
    // 左眼戴镜视力
    private String lEyeGlassesVision;
    // 右眼戴镜视力
    private String rEyeGlassesVision;
    // 左眼眼镜视力
    private String lGlassesVision;
    // 右眼眼镜视力
    private String rGlassesVision;
    //视镜片到角膜顶点的距离
    private String glassToCornea;
    //视镜片的屈光度值
    private String glassDiopter;

    private String uname;

    private int eyeHealth;

    public int getEyeHealth() {
        return eyeHealth;
    }

    public void setEyeHealth(int eyeHealth) {
        this.eyeHealth = eyeHealth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getlEyeballDiameter() {
        return lEyeballDiameter;
    }

    public void setlEyeballDiameter(String lEyeballDiameter) {
        this.lEyeballDiameter = lEyeballDiameter;
    }

    public String getrEyeballDiameter() {
        return rEyeballDiameter;
    }

    public void setrEyeballDiameter(String rEyeballDiameter) {
        this.rEyeballDiameter = rEyeballDiameter;
    }

    public String getlEyepillarDiameter() {
        return lEyepillarDiameter;
    }

    public void setlEyepillarDiameter(String lEyepillarDiameter) {
        this.lEyepillarDiameter = lEyepillarDiameter;
    }

    public String getrEyepillarDiameter() {
        return rEyepillarDiameter;
    }

    public void setrEyepillarDiameter(String rEyepillarDiameter) {
        this.rEyepillarDiameter = rEyepillarDiameter;
    }

    public String getlEyeAxis() {
        return lEyeAxis;
    }

    public void setlEyeAxis(String lEyeAxis) {
        this.lEyeAxis = lEyeAxis;
    }

    public String getrEyeAxis() {
        return rEyeAxis;
    }

    public void setrEyeAxis(String rEyeAxis) {
        this.rEyeAxis = rEyeAxis;
    }

    public String getlEyeOptometry() {
        return lEyeOptometry;
    }

    public void setlEyeOptometry(String lEyeOptometry) {
        this.lEyeOptometry = lEyeOptometry;
    }

    public String getrEyeOptometry() {
        return rEyeOptometry;
    }

    public void setrEyeOptometry(String rEyeOptometry) {
        this.rEyeOptometry = rEyeOptometry;
    }

    public String getlEyeNakedVision() {
        return lEyeNakedVision;
    }

    public void setlEyeNakedVision(String lEyeNakedVision) {
        this.lEyeNakedVision = lEyeNakedVision;
    }

    public String getrEyeNakedVision() {
        return rEyeNakedVision;
    }

    public void setrEyeNakedVision(String rEyeNakedVision) {
        this.rEyeNakedVision = rEyeNakedVision;
    }

    public String getlEyeGlassesVision() {
        return lEyeGlassesVision;
    }

    public void setlEyeGlassesVision(String lEyeGlassesVision) {
        this.lEyeGlassesVision = lEyeGlassesVision;
    }

    public String getrEyeGlassesVision() {
        return rEyeGlassesVision;
    }

    public void setrEyeGlassesVision(String rEyeGlassesVision) {
        this.rEyeGlassesVision = rEyeGlassesVision;
    }

    public String getlGlassesVision() {
        return lGlassesVision;
    }

    public void setlGlassesVision(String lGlassesVision) {
        this.lGlassesVision = lGlassesVision;
    }

    public String getrGlassesVision() {
        return rGlassesVision;
    }

    public void setrGlassesVision(String rGlassesVision) {
        this.rGlassesVision = rGlassesVision;
    }

    public String getGlassToCornea() {
        return glassToCornea;
    }

    public void setGlassToCornea(String glassToCornea) {
        this.glassToCornea = glassToCornea;
    }

    public String getGlassDiopter() {
        return glassDiopter;
    }

    public void setGlassDiopter(String glassDiopter) {
        this.glassDiopter = glassDiopter;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


}
