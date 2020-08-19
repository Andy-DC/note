package com.demo.service.impl;

import com.demo.service.UserService;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String sendSMS(String phoneNumber, String content)throws IOException {
        String userName = "renshipingtai";
        String password = "C6C2544C04003F978CA70B19CE041B33";
        String baseUrl = "http://sms.dachao.com.cn:8080/SMS/WebSendSMS.aspx";
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("UserName", userName));
        params.add(new BasicNameValuePair("Password", password));
        params.add(new BasicNameValuePair("mobileNo", phoneNumber));
        params.add(new BasicNameValuePair("SendContent", content));
        return get(baseUrl, params);
    }

    public String get(String url, List<NameValuePair> params) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"GB2312" /*Consts.UTF_8*/);
        String queryPath = EntityUtils.toString(entity);
        HttpGet httpGet = new HttpGet(url+"?"+queryPath);
        return send(httpClient, httpGet);
    }
    private String send(CloseableHttpClient httpClient, HttpUriRequest httpRequest) throws IOException {
        try {
            CloseableHttpResponse response = httpClient.execute(httpRequest);
            HttpEntity responseEntity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == 200){
                String jsonRet = EntityUtils.toString(responseEntity);
                return jsonRet;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return null;
    }


}
