package com.demo.common.sms;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 发短信接口
 */
@Service
public class SMSService {
	@Autowired
	private HttpClientService httpClientService;
    private	String userName = "renshipingtai";
    private	String password = "C6C2544C04003F978CA70B19CE041B33";
	String baseUrl = "http://sms.dachao.com.cn:8080/SMS/WebSendSMS.aspx";

	public String sendSMS(String phoneNumber, String content) throws Exception{
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("UserName", userName));
		params.add(new BasicNameValuePair("Password", password));
		params.add(new BasicNameValuePair("mobileNo", phoneNumber));
		params.add(new BasicNameValuePair("SendContent", content));
		String ret = httpClientService.get(baseUrl, params);
		return ret;
	}
}