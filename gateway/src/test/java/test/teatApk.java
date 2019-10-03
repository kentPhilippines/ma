package test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

public class teatApk {
	public static void main(String[] args) {
		/*HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("money", " ");
		paramMap.put("deviceid", "13566655858");
		paramMap.put("title", "支付宝转卡");
		paramMap.put("content", "您尾号0889储蓄卡09月11日11：30存入200元,更多优惠咨询请关注。【中国银行】");
		paramMap.put("encrypt", "0");
		paramMap.put("time", "2019-10-01 20:34:18");
		paramMap.put("type", "alipayTocard");
		String post = HttpUtil.post("http://127.0.0.1:8080/http/http", paramMap);
		System.out.println("【结果】："+post);
		
		*/
		
		
		
		
		String content  = "您尾号0883龙卡储蓄卡09月16日11：30存入200.00元，该卡本期人民币账单需还款。";
		String[] split = content.split("\\.");
		System.out.println(split.toString()
				);
		//BigDecimal extractMoney = extractMoney(content);
		//System.out.println("jieguo:"+extractMoney);
	}
	private static BigDecimal extractMoney(String content) {
		System.out.println("【正则表达式开始匹配，传入短信内容为："+content+"】");
		Pattern pattern = Pattern.compile("(收到|收款|向你付款|人名币|收入|转账|存入|转入)(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?元");
		Matcher matcher = pattern.matcher(content);
		if(matcher.find()){ 
			String tmp=matcher.group();
			String regEx="[^0-9]";  
			Pattern p = Pattern.compile(regEx);  
			Matcher m = p.matcher(tmp);  
			System.out.println("【截取完毕之后的短信转账金额为："+m.replaceAll("").trim()+"】");
			BigDecimal mount = new BigDecimal(m.replaceAll("").trim());
			mount = mount.divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);
			System.out.println(mount);
			return mount;
		}
		return null;
	}

}
