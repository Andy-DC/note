package com.demo.common.sms;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Service
public class HttpClientService {

    public String postWithFormEntity(String url, List<NameValuePair> params) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(entity);
        return send(httpClient, httpPost);
    }

    public String postWithJSON(String url, String json) throws IOException {
        StringEntity stringEntity = new StringEntity(json, Consts.UTF_8);
        stringEntity.setContentType("application/json");
        stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return send(httpClient, httpPost);
    }

    public String get(String url, List<NameValuePair> params) throws IOException{
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