package com.naoshili.information.controller;

import com.naoshili.common.annotation.Log;
import com.naoshili.common.controller.BaseController;
import com.naoshili.common.utils.MD5Utils;
import com.naoshili.common.utils.R;
import com.naoshili.common.utils.ShiroUtils;
import com.naoshili.information.domain.UserBasicDO;
import com.naoshili.information.domain.UserEyeDataDO;
import com.naoshili.information.service.UserBasicService;
import com.naoshili.information.service.UserEyeDataService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/LoginController")
public class LoginController extends BaseController {

    @Autowired
    UserBasicService userBasicService;
    @Autowired
    UserEyeDataService userEyeDataService;

    @Log("登录")
    @PostMapping("/login")
    @ResponseBody
    R ajaxLogin(String username, String password) {

        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok("登录成功");
        } catch (AuthenticationException e) {
            return R.error("用户或密码错误");
        }
    }

    @Log("登出")
    @GetMapping("/logout")
    @ResponseBody
    R logout() {
        ShiroUtils.logout();
        return R.ok("登出成功");
    }

    @Log("获取用户信息")
    @GetMapping("/getUserInfo")
    @ResponseBody
    R getUserInfo(String name) {
        Map<String,Object> params  = new HashMap<>();
        params.put("name",name);
        List<UserBasicDO> userBasicDOList = userBasicService.list(params);

        for (UserBasicDO userBasicDO : userBasicDOList) {
            if(userBasicDO != null){
                params.remove("name");
                params.put("uid",userBasicDO.getId());
                List<UserEyeDataDO> userEyeDataDOList = userEyeDataService.list(params);
                for (UserEyeDataDO userEyeDataDO : userEyeDataDOList) {
                    //左、右眼球径
                    userBasicDO.setlEyeballDiameter1(userEyeDataDO.getlEyeballDiameter());
                    userBasicDO.setrEyeballDiameter1(userEyeDataDO.getrEyeballDiameter());
                    //左、右眼柱径
                    userBasicDO.setlEyepillarDiameter1(userEyeDataDO.getlEyepillarDiameter());
                    userBasicDO.setrEyepillarDiameter1(userEyeDataDO.getrEyepillarDiameter());
                    //左、右眼眼轴
                    userBasicDO.setlEyeAxis1(userEyeDataDO.getlEyeAxis());
                    userBasicDO.setrEyeAxis1(userEyeDataDO.getrEyeAxis());
                    //左、右眼验光
                    userBasicDO.setlEyeOptometry1(userEyeDataDO.getlEyeOptometry());
                    userBasicDO.setrEyeOptometry1(userEyeDataDO.getrEyeOptometry());
                    //左、右眼裸眼视力
                    userBasicDO.setlEyeNakedVision1(userEyeDataDO.getlEyeNakedVision());
                    userBasicDO.setrEyeNakedVision1(userEyeDataDO.getrEyeNakedVision());
                    //左、右眼戴镜视力
                    userBasicDO.setlEyeGlassesVision1(userEyeDataDO.getLEyeGlassesVision());
                    userBasicDO.setrEyeGlassesVision1(userEyeDataDO.getrEyeGlassesVision());
                    //视镜片到角膜距离
                    userBasicDO.setGlassToCornea1(userEyeDataDO.getGlassToCornea());
                    //视镜片屈光度
                    userBasicDO.setGlassDiopter1(userEyeDataDO.getGlassDiopter());
                }

            }
        }

        return R.data(userBasicDOList);
    }


}
