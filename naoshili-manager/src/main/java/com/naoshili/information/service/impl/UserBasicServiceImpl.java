package com.naoshili.information.service.impl;

import com.naoshili.common.utils.R;
import com.naoshili.information.dao.UserBasicDao;
import com.naoshili.information.dao.UserEyeDataDao;
import com.naoshili.information.domain.UserBasicDO;
import com.naoshili.information.domain.UserEyeDataDO;
import com.naoshili.information.service.UserBasicService;
import com.naoshili.system.config.ExcelUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class UserBasicServiceImpl implements UserBasicService {
    @Autowired
    private UserBasicDao userBasicDao;
    @Autowired
    private UserEyeDataDao userEyeDataDao;

    @Override
    public UserBasicDO get(Long id) {
        return userBasicDao.get(id);
    }

    @Override
    public List<UserBasicDO> list(Map<String, Object> map) {
        return userBasicDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userBasicDao.count(map);
    }

    @Override
    public int save(UserBasicDO userBasic) {
        return userBasicDao.save(userBasic);
    }

    @Override
    public int update(UserBasicDO userBasic) {
        return userBasicDao.update(userBasic);
    }

    @Override
    public int remove(Long id) {
        return userBasicDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return userBasicDao.batchRemove(ids);
    }

    @Override
    public R importUser(MultipartFile file) {
        int num = 0;
        InputStream in = null;
        Workbook book = null;
        List<Integer> errnum = new ArrayList<>();
        try {
            if (file != null) {
                in = file.getInputStream();
                book = ExcelUtils.getBook(in);
                Sheet sheet = book.getSheetAt(0);
                Row row = null;
                for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    try {
                        row = sheet.getRow(rowNum);
                        String userId = ExcelUtils.getCellFormatValue(row.getCell((short) 0));
                        String phone = ExcelUtils.getCellFormatValue(row.getCell((short) 1));            //手机号
                        String name = ExcelUtils.getCellFormatValue(row.getCell((short) 2));        //姓名
                        String idCard = ExcelUtils.getCellFormatValue(row.getCell((short) 3));        //身份证号
                        String gender = ExcelUtils.getCellFormatValue(row.getCell((short) 4));            //性别
                        String school = ExcelUtils.getCellFormatValue(row.getCell((short) 5));            //学校
                        String grade = ExcelUtils.getCellFormatValue(row.getCell((short) 6));        //年级
                        String classname = ExcelUtils.getCellFormatValue(row.getCell((short) 7));        //班级
                        String contacts = ExcelUtils.getCellFormatValue(row.getCell((short) 8));        //联系人
                        String getupTime = ExcelUtils.getCellFormatValue(row.getCell((short) 9));        //起床时间
                        String sleepTime = ExcelUtils.getCellFormatValue(row.getCell((short) 10));        //睡觉时间
                        String hobby = ExcelUtils.getCellFormatValue(row.getCell((short) 11));        //爱好
                        String readTime = ExcelUtils.getCellFormatValue(row.getCell((short) 12));        //每天大约阅读时间
                        String fatherLvision = ExcelUtils.getCellFormatValue(row.getCell((short) 13));        //父亲左眼视力
                        String fatherRvision = ExcelUtils.getCellFormatValue(row.getCell((short) 14));        //父亲右眼视力
                        String matherLvision = ExcelUtils.getCellFormatValue(row.getCell((short) 15));        //母亲左眼视力
                        String matherRvision = ExcelUtils.getCellFormatValue(row.getCell((short) 16));        //母亲右眼视力
                        String lEyeballDiameter = ExcelUtils.getCellFormatValue(row.getCell((short) 17));        //左眼球径
                        String rEyeballDiameter = ExcelUtils.getCellFormatValue(row.getCell((short) 18));        //右眼球径
                        String lEyepillarDiameter = ExcelUtils.getCellFormatValue(row.getCell((short) 19));        //左眼柱径
                        String rEyepillarDiameter = ExcelUtils.getCellFormatValue(row.getCell((short) 20));        //右眼柱径
                        String lEyeAxis = ExcelUtils.getCellFormatValue(row.getCell((short) 21));        //左眼轴
                        String rEyeAxis = ExcelUtils.getCellFormatValue(row.getCell((short) 22));        //右眼轴
                        String lEyeOptometry = ExcelUtils.getCellFormatValue(row.getCell((short) 23));        //左眼验光
                        String rEyeOptometry = ExcelUtils.getCellFormatValue(row.getCell((short) 24));        //右眼验光
                        String lEyeNakedVision = ExcelUtils.getCellFormatValue(row.getCell((short) 25));        //左眼裸眼视力
                        String rEyeNakedVision = ExcelUtils.getCellFormatValue(row.getCell((short) 26));        //右眼裸眼视力
                        String lEyeGlassesVision = ExcelUtils.getCellFormatValue(row.getCell((short) 27));        //左眼戴镜视力
                        String rEyeGlassesVision = ExcelUtils.getCellFormatValue(row.getCell((short) 28));        //右眼戴镜视力
                        String glassToCornea = ExcelUtils.getCellFormatValue(row.getCell((short) 29));        //视镜到角膜的距离（厘米）
                        String glassDiopter = ExcelUtils.getCellFormatValue(row.getCell((short) 30));        //视镜屈光度

                        UserBasicDO userBasicDO = new UserBasicDO();
                        UserEyeDataDO userEyeDataDO = new UserEyeDataDO();

                        Map<String, Object> mapp = new HashMap<String, Object>();
                        mapp.put("userId", Long.parseLong(userId));

                        if (userId != null && userId != null && userBasicDao.list(mapp).size() <= 0) {
                            userBasicDO.setUserId(Long.parseLong(userId));
                        } else {
                            errnum.add(rowNum);
                            continue;
                        }
                        if (phone != null && phone != "") {
                            userBasicDO.setPhone(phone);
                        } else {
                            errnum.add(rowNum);
                            continue;
                        }
                        if (name != null && name != "") {
                            userBasicDO.setName(name);
                        } else {
                            errnum.add(rowNum);
                            continue;
                        }
                        if (idCard != null && idCard != "") {
                            userBasicDO.setIdCard(idCard);
                        } else {
                            errnum.add(rowNum);
                            continue;
                        }

                        if (gender != null && !"".equals(gender)) {
                            userBasicDO.setGender(gender);
                        }
                        if (school != null && school != "") {
                            userBasicDO.setSchool(school);
                        }
                        if (grade != null && grade != "") {
                            userBasicDO.setGrade(grade);
                        }
                        if (classname != null && classname != "") {
                            userBasicDO.setClassname(classname);
                        }
                        if (contacts != null && contacts != "") {
                            userBasicDO.setContacts(contacts);
                        }
                        if (getupTime != null && getupTime != "") {
                            userBasicDO.setGetupTime(getupTime);
                        }
                        if (sleepTime != null && sleepTime != "") {
                            userBasicDO.setSleepTime(sleepTime);
                        }
                        if (hobby != null && hobby != "") {
                            userBasicDO.setHobby(hobby);
                        }
                        if (readTime != null && readTime != "") {
                            userBasicDO.setReadTime(readTime);
                        }
                        if (fatherLvision != null && fatherLvision != "") {
                            userBasicDO.setFatherLvision(fatherLvision);
                        }
                        if (fatherRvision != null && fatherRvision != "") {
                            userBasicDO.setFatherRvision(fatherRvision);
                        }
                        if (matherLvision != null && matherLvision != "") {
                            userBasicDO.setMatherLvision(matherLvision);
                        }
                        if (matherRvision != null && matherRvision != "") {
                            userBasicDO.setMatherRvision(matherRvision);
                        }
                        if (lEyeballDiameter != null && lEyeballDiameter != "") {
                            userEyeDataDO.setlEyeballDiameter(lEyeballDiameter);
                        }
                        if (lEyeAxis != null && lEyeAxis != "") {
                            userEyeDataDO.setlEyeAxis(lEyeAxis);
                        }
                        if (rEyeAxis != null && rEyeAxis != "") {
                            userEyeDataDO.setrEyeAxis(rEyeAxis);
                        }
                        if (rEyeballDiameter != null && rEyeballDiameter != "") {
                            userEyeDataDO.setrEyeballDiameter(rEyeballDiameter);
                        }
                        if (lEyepillarDiameter != null && lEyepillarDiameter != "") {
                            userEyeDataDO.setlEyepillarDiameter(lEyepillarDiameter);
                        }
                        if (lEyeOptometry != null && lEyeOptometry != "") {
                            userEyeDataDO.setlEyeOptometry(lEyeOptometry);
                        }
                        if (rEyeOptometry != null && rEyeOptometry != "") {
                            userEyeDataDO.setrEyeOptometry((rEyeOptometry));
                        }
                        if (lEyeNakedVision != null && lEyeNakedVision != "") {
                            userEyeDataDO.setlEyeNakedVision(lEyeNakedVision);
                        }
                        if (rEyeNakedVision != null && rEyeNakedVision != "") {
                            userEyeDataDO.setrEyeNakedVision(rEyeNakedVision);
                        }
                        if (lEyeGlassesVision != null && lEyeGlassesVision != "") {
                            userEyeDataDO.setlEyeGlassesVision(lEyeGlassesVision);
                        }
                        if (rEyeGlassesVision != null && rEyeGlassesVision != "") {
                            userEyeDataDO.setrEyeGlassesVision(rEyeGlassesVision);
                        }
                        if (rEyepillarDiameter != null && rEyepillarDiameter != "") {
                            userEyeDataDO.setrEyepillarDiameter(rEyepillarDiameter);
                        }

                        if (glassToCornea != null && glassToCornea != "") {
                            userEyeDataDO.setGlassToCornea(glassToCornea);
                        }
                        if (glassDiopter != null && glassDiopter != "") {
                            userEyeDataDO.setGlassDiopter(glassDiopter);
                        }


                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                        // 15位需要补年份
                        if (userBasicDO.getIdCard().length() == 15) {
                            userBasicDO.setBirthday(substringBir("19" + userBasicDO.getIdCard().substring(6, 12)));
                            userBasicDO.setAge(Integer.parseInt(sdf.format(new Date()))
                                    - (substringAge("19" + userBasicDO.getIdCard().substring(6, 12))));
                            // 18位直接截取7到14位
                        } else if (userBasicDO.getIdCard().length() == 18) {
                            userBasicDO.setBirthday(substringBir(userBasicDO.getIdCard().substring(6, 14)));
                            userBasicDO.setAge(
                                    Integer.parseInt(sdf.format(new Date())) - (substringAge(userBasicDO.getIdCard().substring(6, 14))));
                        }
                        Map<String, Object> params = new HashMap<>();
                        params.put("idCard", idCard);
                        if (!exit(params)) {
                            params.remove("identityCard");
                            params.put("phone", phone);
                            if (!exit(params)) {
                                if (userBasicDao.save(userBasicDO) > 0) {
                                    userEyeDataDO.setUid(Long.parseLong(userId));
                                    userEyeDataDao.save(userEyeDataDO);
                                }
                            }
                        }
                        num++;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return R.error("导入失败！第" + rowNum + "条");
                    }
                }
                if (errnum.size() > 0) {
                    return R.ok("上传成功,共增加[" + num + "]条,第" + errnum + "条上传失败，userId,手机号或身份证号已存在");
                } else {
                    return R.ok("上传成功,共增加[" + num + "]条");
                }

            } else {
                return R.error("请选择导入的文件!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (book != null)
                    book.close();
                if (book != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return R.error();
    }

    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = userBasicDao.list(params).size() > 0;
        return exit;

    }

    @Override
    public Map<String, Object> getAge() {
        return userBasicDao.getAge();
    }

    @Override
    public int getTestPerson() {
        return userBasicDao.getTestPerson();
    }

    @Override
    public Map<String, Object> getEyeHealth() {
        return userBasicDao.getEyeHealth();
    }

    @Override
    public Map<String, Object> getType() {
        return userBasicDao.getType();
    }

    @Override
    public Map<String, Object> getGender() {
        return userBasicDao.getGender();
    }

    public String substringBir(String day) {
        String yyyy = day.substring(0, 4);
        String mm = day.substring(4, 6);
        String dd = day.substring(6);
        return yyyy + "-" + mm + "-" + dd;
    }

    public Integer substringAge(String day) {
        Integer yyyy = Integer.parseInt(day.substring(0, 4));
        return yyyy;
    }

    @Override
    public UserBasicDO getUserId(Long userId) {
        return userBasicDao.getUserId(userId);
    }
}
