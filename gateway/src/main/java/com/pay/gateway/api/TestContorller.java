package com.pay.gateway.api;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pay.gateway.util.SettingFile;

import cn.hutool.json.JSONUtil;
import cn.hutool.setting.Setting;

@Controller
@RequestMapping("/test1234569")
public class TestContorller {
	@Autowired
	SettingFile settingFile;
	@RequestMapping("/test")
	public void TestConnection(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().write("项目启动正常<br>");
		Setting setting = settingFile.getSetting();
		boolean load = setting.load();
		if(load) {
			response.getWriter().write("获取配置文件<br>");
		}
		Set<String> keySet = setting.keySet();
		Collection<String> values = setting.values();
		for( String key : keySet ) {
			String context = setting.get(key);
			response.getWriter().write(key+" = "+context+"<br>");
		}
	}
}