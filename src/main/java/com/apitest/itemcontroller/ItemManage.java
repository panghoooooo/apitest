package com.apitest.itemcontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.apitest.entity.UserLogin;
import com.apitest.model.ItemInfo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ItemManage {
    //添加商品
    public boolean addItemInfo(ItemInfo itemInfo) {
        itemInfo.setAbcClass("A");
        itemInfo.setBatch("abcd");
        itemInfo.setCompanyId(112);
        itemInfo.setDefaultPrice(10.0);
        itemInfo.setFloorLimit(10);
        itemInfo.setItemBarCode("123");
        itemInfo.setItemClass("有打");
        itemInfo.setItemCode("IM1000002");
        itemInfo.setItemName("打印机002");
        itemInfo.setItemTypeCode("IT1120145514");
        itemInfo.setMemo("测试003");
        itemInfo.setSupplierCode("string");
        itemInfo.setUnitCode("string");
        itemInfo.setUpperLimit(50);
        itemInfo.setWeight("100");


        //RESTFUL 风格的 API 接口 URL
        String POST_URL = "http://127.0.0.1:8000/wms/item/infos/insert";
        HttpURLConnection connection = null;

        try {
            URL url = new URL(POST_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("connection", "Keep-Alive");
            // 发送的数据为：JOSN格式--->application/json
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            connection.setRequestProperty("access-token", "E8ACEA13605DD3619E872D8FF2F13298698CD2D2");
            // 连接【】
            connection.connect();

            // 创建一个将数据写入到指定输出流的【数据输出流】--数据输出到connection的输出流中
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());

            // 构建User数据


            // 转一下--- Object -To- JOSN
            String msgSend = JSONObject.toJSONString(itemInfo);

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
            int status = object.getIntValue("code");


            // 关闭资源
            reader.close();
            System.out.println("关闭reader成功");
            if (status == 200) {
                // 成功  return true
                System.out.println("请求成功！返回信息："+sb);
                return true;

            } else {
                // 失败 return false
                System.out.println("请求失败!返回信息："+sb);
                return  false;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            // 断开连接
            connection.disconnect();
            System.out.println("关闭Connection成功");
        }


        return false;
    }

    //测试
    public static void main(String[] args) {
        ItemManage im = new ItemManage();
        ItemInfo itemInfo = new ItemInfo();
        System.out.println(im.addItemInfo(itemInfo));

    }

}
