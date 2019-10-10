package com.pay.gateway.util;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.hutool.setting.Setting;

/**
 * <p>外部配置文件处理</p>
 * @author K
 *
 */
@Component
public class SettingFile {
	private Setting setting = new Setting();

	public Setting getSetting() {
		return setting;
	}
	public void setSetting(Setting setting) {
		this.setting = setting;
	}
	
	/**
	 * <p>根据key值获取value</p>
	 * @param key
	 * @return
	 */
	public String getName(String key) {
		String string = setting.get(key);
		return string;
	}
	/**
	 * <p>从新加载配置文件</p>
	 * @return
	 */
	public boolean load() {
		boolean load = setting.load();
		return load;
	}
	
	
	
}
