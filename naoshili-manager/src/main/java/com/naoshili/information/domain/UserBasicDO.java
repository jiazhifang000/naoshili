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

    private Long userId;
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
    private String readTime;
    //父亲左视力
    private String fatherLvision;
    //父亲右视力
    private String fatherRvision;
    //母亲左视力
    private String matherLvision;
    //母亲右视力
    private String matherRvision;
    //视镜片到角膜顶点的距离
    private String glassToCornea1;
    //视镜片的屈光度值
    private String glassDiopter1;

    private Integer uid;
    // 左眼球径
    private String lEyeballDiameter1;
    // 右眼球径
    private String rEyeballDiameter1;
    // 左眼柱径
    private String lEyepillarDiameter1;
    // 右眼柱径
    private String rEyepillarDiameter1;
    // 左眼轴
    private String lEyeAxis1;
    // 右眼轴
    private String rEyeAxis1;
    // 左眼验光
    private String lEyeOptometry1;
    // 右眼验光
    private String rEyeOptometry1;
    // 左眼裸眼视力
    private String lEyeNakedVision1;
    // 右眼裸眼视力
    private String rEyeNakedVision1;
    // 左眼戴镜视力
    private String lEyeGlassesVision1;
    // 右眼戴镜视力
    private String rEyeGlassesVision1;
    // 左眼戴镜视力
    private String lGlassesVision1;
    // 右眼戴镜视力
    private String rGlassesVision1;
    private int eyeHealth;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGetupTime() {
        return getupTime;
    }

    public void setGetupTime(String getupTime) {
        this.getupTime = getupTime;
    }

    public String getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(String sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    public String getFatherLvision() {
        return fatherLvision;
    }

    public void setFatherLvision(String fatherLvision) {
        this.fatherLvision = fatherLvision;
    }

    public String getFatherRvision() {
        return fatherRvision;
    }

    public void setFatherRvision(String fatherRvision) {
        this.fatherRvision = fatherRvision;
    }

    public String getMatherLvision() {
        return matherLvision;
    }

    public void setMatherLvision(String matherLvision) {
        this.matherLvision = matherLvision;
    }

    public String getMatherRvision() {
        return matherRvision;
    }

    public void setMatherRvision(String matherRvision) {
        this.matherRvision = matherRvision;
    }

    public String getGlassToCornea1() {
        return glassToCornea1;
    }

    public void setGlassToCornea1(String glassToCornea1) {
        this.glassToCornea1 = glassToCornea1;
    }

    public String getGlassDiopter1() {
        return glassDiopter1;
    }

    public void setGlassDiopter1(String glassDiopter1) {
        this.glassDiopter1 = glassDiopter1;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getlEyeballDiameter1() {
        return lEyeballDiameter1;
    }

    public void setlEyeballDiameter1(String lEyeballDiameter1) {
        this.lEyeballDiameter1 = lEyeballDiameter1;
    }

    public String getrEyeballDiameter1() {
        return rEyeballDiameter1;
    }

    public void setrEyeballDiameter1(String rEyeballDiameter1) {
        this.rEyeballDiameter1 = rEyeballDiameter1;
    }

    public String getlEyepillarDiameter1() {
        return lEyepillarDiameter1;
    }

    public void setlEyepillarDiameter1(String lEyepillarDiameter1) {
        this.lEyepillarDiameter1 = lEyepillarDiameter1;
    }

    public String getrEyepillarDiameter1() {
        return rEyepillarDiameter1;
    }

    public void setrEyepillarDiameter1(String rEyepillarDiameter1) {
        this.rEyepillarDiameter1 = rEyepillarDiameter1;
    }

    public String getlEyeAxis1() {
        return lEyeAxis1;
    }

    public void setlEyeAxis1(String lEyeAxis1) {
        this.lEyeAxis1 = lEyeAxis1;
    }

    public String getrEyeAxis1() {
        return rEyeAxis1;
    }

    public void setrEyeAxis1(String rEyeAxis1) {
        this.rEyeAxis1 = rEyeAxis1;
    }

    public String getlEyeOptometry1() {
        return lEyeOptometry1;
    }

    public void setlEyeOptometry1(String lEyeOptometry1) {
        this.lEyeOptometry1 = lEyeOptometry1;
    }

    public String getrEyeOptometry1() {
        return rEyeOptometry1;
    }

    public void setrEyeOptometry1(String rEyeOptometry1) {
        this.rEyeOptometry1 = rEyeOptometry1;
    }

    public String getlEyeNakedVision1() {
        return lEyeNakedVision1;
    }

    public void setlEyeNakedVision1(String lEyeNakedVision1) {
        this.lEyeNakedVision1 = lEyeNakedVision1;
    }

    public String getrEyeNakedVision1() {
        return rEyeNakedVision1;
    }

    public void setrEyeNakedVision1(String rEyeNakedVision1) {
        this.rEyeNakedVision1 = rEyeNakedVision1;
    }

    public String getlEyeGlassesVision1() {
        return lEyeGlassesVision1;
    }

    public void setlEyeGlassesVision1(String lEyeGlassesVision1) {
        this.lEyeGlassesVision1 = lEyeGlassesVision1;
    }

    public String getrEyeGlassesVision1() {
        return rEyeGlassesVision1;
    }

    public void setrEyeGlassesVision1(String rEyeGlassesVision1) {
        this.rEyeGlassesVision1 = rEyeGlassesVision1;
    }

    public String getlGlassesVision1() {
        return lGlassesVision1;
    }

    public void setlGlassesVision1(String lGlassesVision1) {
        this.lGlassesVision1 = lGlassesVision1;
    }

    public String getrGlassesVision1() {
        return rGlassesVision1;
    }

    public void setrGlassesVision1(String rGlassesVision1) {
        this.rGlassesVision1 = rGlassesVision1;
    }

    public int getEyeHealth() {
        return eyeHealth;
    }

    public void setEyeHealth(int eyeHealth) {
        this.eyeHealth = eyeHealth;
    }
}
