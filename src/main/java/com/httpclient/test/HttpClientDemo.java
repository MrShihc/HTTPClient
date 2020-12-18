package com.httpclient.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * httpClient测试类
 */
public class HttpClientDemo {

    /**
     * GET--无参测试
     */
    @Test
    public void doGetTestOne(){
        //获得Http客户端(可以理解为：你得先有一个浏览器;注意：实际上HTTPClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //创建Get请求
        HttpGet httpGet = new HttpGet("http://localhost:9103/httpClient/doGetControllerOne.do");

        //响应模型
        CloseableHttpResponse response = null;

        try {
            //由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            //从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:"+response.getStatusLine());
            if(responseEntity != null){
                System.out.println("响应内容长度为：" + responseEntity.getContentLength());
                System.out.println("响应内容为：" + EntityUtils.toString(responseEntity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                //释放资源
                if(httpClient != null){
                    httpClient.close();
                }
                if(response != null){
                    response.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    /**
     * GET -- 有参测试(方式一；手动在url后面加上参数)
     */

}
