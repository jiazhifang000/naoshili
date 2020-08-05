package com.naoshili.information.controller;

import com.naoshili.common.annotation.Log;
import com.naoshili.common.controller.BaseController;
import com.naoshili.common.utils.MD5Utils;
import com.naoshili.common.utils.R;
import com.naoshili.common.utils.ShiroUtils;
import com.naoshili.information.domain.UserBasicDO;
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
            return R.data(getUser());
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
    R getUserInfo(String name, String id, String idCard) {
        Map<String, Object> params = new HashMap<>();
        if (name != null) {
            params.put("name", name);
        }
        if (id != null) {
            params.put("id", id);
        }
        if (idCard != null) {
            params.put("idCard", idCard);
        }
        List<UserBasicDO> userBasicDOList = userBasicService.listLike(params);

        return R.data(userBasicDOList);
    }


}
