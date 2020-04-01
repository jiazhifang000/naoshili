package com.naoshili.information.domain;

import java.io.Serializable;

/**
 * 用户基本数据表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-02-28 14:37:44
 */
public class UserBasicDO implements Serializable {
    private static final long serialVersionUID = 1L;

    // id
    private Long id;
    //
    private String name;
    // 身份证
    private String idCard;
    // 生日
    private String birthday;
    // 年龄
    private Integer age;
    // 性别
    private String gender;
    // 学校
    private String school;
    // 年级
    private String grade;
    // 班级
    private String classname;
    // 联系人
    private String contacts;
    // 电话
    private String phone;
    // 通常起床时间
    private String getupTime;
    // 通常睡觉时间
    private String sleepTime;
    // 爱好
    private String hobby;
    // 每天大约阅读时间
    private Double readTime;
    //父亲左视力
    private Double fatherLvision;
    //父亲右视力
    private Double fatherRvision;
    //母亲左视力
    private Double matherLvision;
    //母亲右视力
    private Double matherRvision;
    //视镜片到角膜顶点的距离
    private Double glassToCornea1;
    //视镜片的屈光度值
    private Double glassDiopter1;

    private Integer uid;
    // 左眼球径
    private Double lEyeballDiameter1;
    // 右眼球径
    private Double rEyeballDiameter1;
    // 左眼柱径
    private Double lEyepillarDiameter1;
    // 右眼柱径
    private Double rEyepillarDiameter1;
    // 左眼轴
    private Double lEyeAxis1;
    // 右眼轴
    private Double rEyeAxis1;
    // 左眼验光
    private Double lEyeOptometry1;
    // 右眼验光
    private Double rEyeOptometry1;
    // 左眼裸眼视力
    private Double lEyeNakedVision1;
    // 右眼裸眼视力
    private Double rEyeNakedVision1;
    // 左眼戴镜视力
    private Double lEyeGlassesVision1;
    // 右眼戴镜视力
    private Double rEyeGlassesVision1;

    public Double getGlassToCornea1() {
        return glassToCornea1;
    }

    public void setGlassToCornea1(Double glassToCornea1) {
        this.glassToCornea1 = glassToCornea1;
    }

    public Double getGlassDiopter1() {
        return glassDiopter1;
    }

    public void setGlassDiopter1(Double glassDiopter1) {
        this.glassDiopter1 = glassDiopter1;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getlEyeballDiameter1() {
        return lEyeballDiameter1;
    }

    public void setlEyeballDiameter1(Double lEyeballDiameter1) {
        this.lEyeballDiameter1 = lEyeballDiameter1;
    }

    public Double getrEyeballDiameter1() {
        return rEyeballDiameter1;
    }

    public void setrEyeballDiameter1(Double rEyeballDiameter1) {
        this.rEyeballDiameter1 = rEyeballDiameter1;
    }

    public Double getlEyepillarDiameter1() {
        return lEyepillarDiameter1;
    }

    public void setlEyepillarDiameter1(Double lEyepillarDiameter1) {
        this.lEyepillarDiameter1 = lEyepillarDiameter1;
    }

    public Double getrEyepillarDiameter1() {
        return rEyepillarDiameter1;
    }

    public void setrEyepillarDiameter1(Double rEyepillarDiameter1) {
        this.rEyepillarDiameter1 = rEyepillarDiameter1;
    }

    public Double getrEyeAxis1() {
        return rEyeAxis1;
    }

    public void setrEyeAxis1(Double rEyeAxis1) {
        this.rEyeAxis1 = rEyeAxis1;
    }

    public Double getlEyeOptometry1() {
        return lEyeOptometry1;
    }

    public void setlEyeOptometry1(Double lEyeOptometry1) {
        this.lEyeOptometry1 = lEyeOptometry1;
    }

    public Double getrEyeOptometry1() {
        return rEyeOptometry1;
    }

    public void setrEyeOptometry1(Double rEyeOptometry1) {
        this.rEyeOptometry1 = rEyeOptometry1;
    }

    public Double getlEyeNakedVision1() {
        return lEyeNakedVision1;
    }

    public void setlEyeNakedVision1(Double lEyeNakedVision1) {
        this.lEyeNakedVision1 = lEyeNakedVision1;
    }

    public Double getrEyeNakedVision1() {
        return rEyeNakedVision1;
    }

    public void setrEyeNakedVision1(Double rEyeNakedVision1) {
        this.rEyeNakedVision1 = rEyeNakedVision1;
    }

    public Double getlEyeGlassesVision1() {
        return lEyeGlassesVision1;
    }

    public void setlEyeGlassesVision1(Double lEyeGlassesVision1) {
        this.lEyeGlassesVision1 = lEyeGlassesVision1;
    }

    public Double getrEyeGlassesVision1() {
        return rEyeGlassesVision1;
    }

    public void setrEyeGlassesVision1(Double rEyeGlassesVision1) {
        this.rEyeGlassesVision1 = rEyeGlassesVision1;
    }

    public Double getlEyeAxis1() {
        return lEyeAxis1;
    }

    public void setlEyeAxis1(Double lEyeAxis1) {
        this.lEyeAxis1 = lEyeAxis1;
    }

    public String getGetupTime() {
        return getupTime;
    }

    public String getSleepTime() {
        return sleepTime;
    }

    public void setGetupTime(String getupTime) {
        this.getupTime = getupTime;
    }

    public void setSleepTime(String sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
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
     * 设置：
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：
     */
    public String getName() {
        return name;
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
     * 设置：生日
     */

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 设置：年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    /**
     * 获取：年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置：性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取：性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置：学校
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 获取：学校
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置：年级
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 获取：年级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 设置：班级
     */

    /**
     * 设置：联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    /**
     * 获取：联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置：电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置：通常起床时间
     */

    /**
     * 设置：爱好
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * 获取：爱好
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * 设置：每天大约阅读时间
     */
    public void setReadTime(Double readTime) {
        this.readTime = readTime;
    }

    /**
     * 获取：每天大约阅读时间
     */
    public Double getReadTime() {
        return readTime;
    }


    public Double getFatherLvision() {
        return fatherLvision;
    }

    public void setFatherLvision(Double fatherLvision) {
        this.fatherLvision = fatherLvision;
    }

    public Double getFatherRvision() {
        return fatherRvision;
    }

    public void setFatherRvision(Double fatherRvision) {
        this.fatherRvision = fatherRvision;
    }

    public Double getMatherLvision() {
        return matherLvision;
    }

    public void setMatherLvision(Double matherLvision) {
        this.matherLvision = matherLvision;
    }

    public Double getMatherRvision() {
        return matherRvision;
    }

    public void setMatherRvision(Double matherRvision) {
        this.matherRvision = matherRvision;
    }

    @Override
    public String toString() {
        return "UserBasicDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", birthday='" + birthday + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", school='" + school + '\'' +
                ", grade='" + grade + '\'' +
                ", classname='" + classname + '\'' +
                ", contacts='" + contacts + '\'' +
                ", phone='" + phone + '\'' +
                ", getupTime='" + getupTime + '\'' +
                ", sleepTime='" + sleepTime + '\'' +
                ", hobby='" + hobby + '\'' +
                ", readTime=" + readTime +
                ", fatherLvision=" + fatherLvision +
                ", fatherRvision=" + fatherRvision +
                ", matherLvision=" + matherLvision +
                ", matherRvision=" + matherRvision +
                ", glassToCornea1=" + glassToCornea1 +
                ", glassDiopter1=" + glassDiopter1 +
                ", uid=" + uid +
                ", lEyeballDiameter1=" + lEyeballDiameter1 +
                ", rEyeballDiameter1=" + rEyeballDiameter1 +
                ", lEyepillarDiameter1=" + lEyepillarDiameter1 +
                ", rEyepillarDiameter1=" + rEyepillarDiameter1 +
                ", lEyeAxis1=" + lEyeAxis1 +
                ", rEyeAxis1=" + rEyeAxis1 +
                ", lEyeOptometry1=" + lEyeOptometry1 +
                ", rEyeOptometry1=" + rEyeOptometry1 +
                ", lEyeNakedVision1=" + lEyeNakedVision1 +
                ", rEyeNakedVision1=" + rEyeNakedVision1 +
                ", lEyeGlassesVision1=" + lEyeGlassesVision1 +
                ", rEyeGlassesVision1=" + rEyeGlassesVision1 +
                '}';
    }
}
