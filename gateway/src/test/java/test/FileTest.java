package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pay.gateway.application;
import com.pay.gateway.util.SettingFile;

import cn.hutool.setting.Setting;
@SpringBootApplication
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FileTest {
	@Autowired
	SettingFile settingFile;
	public static void main(String[] args) { 
		/*
		 * settingFile. String string = setting.get("name"); boolean load =
		 * setting.load();//从新加载配置文件 System.out.println(string);
		 */
	}
	@Test
	public void test () {
		
		Setting setting = settingFile.getSetting();
		String string = setting.get("name");
		System.out.println("配置文件加载内容为："+string);
	}
}
