package com.naoshili.common.controller;

import org.springframework.stereotype.Controller;

import com.naoshili.common.utils.ShiroUtils;
import com.naoshili.system.domain.UserDO;
import com.naoshili.system.domain.UserToken;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}