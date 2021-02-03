package com.naoshili.information.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.naoshili.information.service.CollectionInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naoshili.information.domain.LinshiUrlDO;
import com.naoshili.information.service.LinshiUrlService;
import com.naoshili.common.utils.PageUtils;
import com.naoshili.common.utils.Query;
import com.naoshili.common.utils.R;

import javax.servlet.http.HttpServletRequest;

/**
 * 临时图片保存  可以清空
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-02-02 15:24:04
 */
 
@Controller
@RequestMapping("/information/linshiUrl")
public class LinshiUrlController {
	@Autowired
	private LinshiUrlService linshiUrlService;
	@Autowired
    private CollectionInfoService collectionInfoService;
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(HttpServletRequest request){
        String userId=request.getParameter("userId");
        Integer userId1 = collectionInfoService.getUserId(Long.parseLong(userId));
        String danduantu=request.getParameter("danduantu");
        String danduantu1 = baseString(danduantu);
        String jiaotitu=request.getParameter("jiaotitu");
        String jiaotitu1 = baseString(jiaotitu);
        LinshiUrlDO ls = new LinshiUrlDO();
        ls.setUserId(userId1);
        ls.setDanduantu(danduantu1);
        ls.setJiaotitu(jiaotitu1);
        Map map = new HashMap();
        map.put("userId",userId1);
        List list = linshiUrlService.list(map);
        if (list.size()>0){
            linshiUrlService.update(ls);
        }else {
            linshiUrlService.save(ls);
        }
        return R.ok();
	}
    public String baseString(String imgData){
        String newImageInfo = imgData.replaceAll(" ", "+");
        // 数据中：data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAABI4AAAEsCAYAAAClh/jbAAA ...
        // 在"base64,"之后的才是图片信息
        String[] arr = newImageInfo.split("base64,");
        return arr[1];

    }

	
}
