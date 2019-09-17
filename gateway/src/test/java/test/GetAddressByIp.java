package test;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

import cn.hutool.json.JSONUtil;





public class GetAddressByIp {

    public static void main(String[] args) {
        String resout = "";
        try{
            String str = getJsonContent("http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip="+"47.90.116.62");
            System.out.println(str);
         //  JSONObject parseObj = (JSONObject)JSONUtil.parseObj(str);
        //    JSONObject obj2 =  (JSONObject) parseObj.get("data");
        //    String code = (String) parseObj.get("code");
        //    if(code.equals("0")){
        //        resout =  obj2.get("country")+"--" +obj2.get("area")+"--" +obj2.get("city")+"--" +obj2.get("isp");
        //    }else{
        //        resout =  "IP地址有误";
      //      }
        }catch(Exception e){

            e.printStackTrace();
            resout = "获取IP地址异常："+e.getMessage();
        }
        System.out.println("result: " + resout);
    }

    public static String getJsonContent(String urlStr) {
        try
        {// 获取HttpURLConnection连接对象
            URL url = new URL(urlStr);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            // 设置连接属性
            httpConn.setConnectTimeout(3000);
            httpConn.setDoInput(true);
            httpConn.setRequestMethod("GET");
            // 获取相应码
            int respCode = httpConn.getResponseCode();
            if (respCode == 200)
            {
                return ConvertStream2Json(httpConn.getInputStream());
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    private static String ConvertStream2Json(InputStream inputStream) {
        String jsonStr = "";
        // ByteArrayOutputStream相当于内存输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        // 将输入流转移到内存输出流中
        try
        {
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1)
            {
                out.write(buffer, 0, len);
            }
            // 将内存流转换为字符串
            jsonStr = new String(out.toByteArray());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonStr;
    }
}