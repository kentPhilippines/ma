package com.pay.gateway.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hutool.json.JSONUtil;

@Controller
@RequestMapping("/test1234569")
public class TestContorller {
	@RequestMapping("/test")
	public void TestConnection(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().write("项目启动正常");
	}
}