package com.naoshili.system.controller;

import com.naoshili.common.annotation.Log;
import com.naoshili.common.controller.BaseController;
import com.naoshili.common.domain.FileDO;
import com.naoshili.common.domain.Tree;
import com.naoshili.common.service.FileService;
import com.naoshili.common.utils.MD5Utils;
import com.naoshili.common.utils.R;
import com.naoshili.common.utils.ShiroUtils;
import com.naoshili.information.service.UserBasicService;
import com.naoshili.system.domain.MenuDO;
import com.naoshili.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class LoginController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MenuService menuService;
    @Autowired
    FileService fileService;
    @Autowired
    UserBasicService userBasicService;

    @GetMapping({"/", ""})
    String welcome(Model model) {

        return "redirect:/login";
    }

    @Log("请求访问主页")
    @GetMapping({"/index"})
    String index(Model model) {
        List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
        model.addAttribute("menus", menus);
        model.addAttribute("name", getUser().getName());
        FileDO fileDO = fileService.get(getUser().getPicId());
        if (fileDO != null && fileDO.getUrl() != null) {
            if (fileService.isExist(fileDO.getUrl())) {
                model.addAttribute("picUrl", fileDO.getUrl());
            } else {
                model.addAttribute("picUrl", "/img/xinshineng.png");
            }
        } else {
            model.addAttribute("picUrl", "/img/xinshineng.png");
        }
        model.addAttribute("username", getUser().getUsername());
        return "index_v1";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @Log("登录")
    @PostMapping("/login")
    @ResponseBody
    R ajaxLogin(String username, String password, boolean rememberme) {

        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberme);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok();
        } catch (AuthenticationException e) {
            return R.error("用户或密码错误");
        }
    }

    @GetMapping("/logout")
    String logout() {
        ShiroUtils.logout();
        return "redirect:/login";
    }

    @GetMapping("/main")
    String main(Model model) {
        //受试者总人数
        int personAll = userBasicService.getTestPerson();
        model.addAttribute("personAll", personAll);

        //受试者眼健康情况  正视人数，假性近视人数，未确诊近视人数，真性近视人数（左眼或右眼视力小于1），弱视人数，其他
        Map<String, Object> eyeHealth = userBasicService.getEyeHealth();
        model.addAttribute("eyeHealth", eyeHealth);


        //受试者性别结构 男性数量，女性数量
        Map<String, Object> gender = userBasicService.getGender();
        model.addAttribute("gender", gender);

        //受试者年龄结构  6岁以下，6-8岁，9-10岁，10-12岁，13-15岁，16-18岁
        Map<String, Object> ageMap = userBasicService.getAge();
        model.addAttribute("ageMap", ageMap);
        //实验类型数量统计  3种类型数量
        Map<String, Object> type = userBasicService.getType();
        model.addAttribute("type", type);

        return "main";
    }

}
