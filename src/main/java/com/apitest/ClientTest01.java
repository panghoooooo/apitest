package com.apitest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.apitest.entity.UserLogin;


public class ClientTest01 {


    public void PostUserCreator(){

        //RESTFUL 风格的 API 接口 URL
        String POST_URL = "http://127.0.0.1:8000/wms/login";

        try {
            URL url = new URL(POST_URL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("connection", "Keep-Alive");
            // 发送的数据为：JOSN格式--->application/json
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            // 连接【】
            connection.connect();

            // 创建一个将数据写入到指定输出流的【数据输出流】--数据输出到connection的输出流中
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());

            // 构建User数据
            UserLogin user = new UserLogin();
            //user.setuID(自增长，不用设置);
            user.setAccount("13685133739");//---------------------------------收入参数
            user.setPassword("yyyx0000");//
            user.setValidateCode("String");//

            // 转一下--- Object -To- JOSN
            String msgSend = JSONObject.toJSONString(user);

            //设置发送数据的json串的编码，防止中文乱码
            out.write(msgSend.getBytes("utf-8"));

            //打印发送的数据
            System.out.println(msgSend.toString());

            // 清除输出流out的缓冲区
            out.flush();

            // 关闭输出流out
            out.close();

            // 读取响应  --从内存中的缓冲区里面读
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }

            // 转一下  stringbuffer -- to -- JOSN对象
            JSONObject object = JSON.parseObject(sb.toString());

            // 拿到响应结果中的状态码
            int status = object.getIntValue("status");
            if(status == 200){
                // 成功  return true
                System.out.println(sb);

            }else{
                // 失败 return false
                System.out.println(sb);
            }

            // 关闭资源
            reader.close();
            // 断开连接
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        ClientTest01 ct = new ClientTest01();
        ct.PostUserCreator();
    }
}