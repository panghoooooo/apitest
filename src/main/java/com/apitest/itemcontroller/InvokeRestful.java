package com.apitest.itemcontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class InvokeRestful {

    //对itemInfo操作
    public static boolean invokeRest(String param,String url,String method){
        HttpURLConnection connection = null;
        try {
            URL realurl = new URL(url);
            connection = (HttpURLConnection) realurl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod(method);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("connection", "Keep-Alive");
            // 发送的数据为：JOSN格式--->application/json
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            // connection.setRequestProperty("access-token", "E8ACEA13605DD3619E872D8FF2F13298698CD2D2");
            // 连接【】
            connection.connect();

            // 创建一个将数据写入到指定输出流的【数据输出流】--数据输出到connection的输出流中
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());

            //设置发送数据的json串的编码，防止中文乱码
            out.write(param.getBytes("utf-8"));

            //打印发送的数据
            System.out.println(param.toString());

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
            int status = object.getIntValue("code");

            // 关闭资源
            reader.close();
            System.out.println("关闭reader成功");
            if (status == 200) {
                // 成功  return true
                System.out.println("请求成功！返回信息：" + sb);
                return true;

            } else {
                // 失败 return false
                System.out.println("请求失败!返回信息：" + sb);
                return false;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 断开连接
            connection.disconnect();
            System.out.println("关闭Connection成功");
        }

        return  false;
    }

    //重载invokeRest方法
    public static boolean invokeRest(String param,String url,String method,String token){
        HttpURLConnection connection = null;
        try {
            URL realurl = new URL(url);
            connection = (HttpURLConnection) realurl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod(method);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("connection", "Keep-Alive");
            // 发送的数据为：JOSN格式--->application/json
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            connection.setRequestProperty("access-token", token);
            // 连接【】
            connection.connect();

            // 创建一个将数据写入到指定输出流的【数据输出流】--数据输出到connection的输出流中
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());

            //设置发送数据的json串的编码，防止中文乱码
            out.write(param.getBytes("utf-8"));

            //打印发送的数据
            System.out.println(param.toString());

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
            int code = object.getIntValue("code");

            // 关闭资源
            reader.close();
            System.out.println("关闭reader成功");
            if (code == 200) {
                // 成功  return true
                System.out.println("请求成功！返回信息：" + sb);
                return true;

            } else {
                // 失败 return false
                System.out.println("请求失败!返回信息：" + sb);
                return false;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 断开连接
            connection.disconnect();
            System.out.println("关闭Connection成功");
        }

        return  false;

    }

}
