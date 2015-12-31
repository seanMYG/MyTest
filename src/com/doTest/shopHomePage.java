package com.doTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class shopHomePage {
	
	private static String path = "http://www.wemart.cn/um/oauth";

	@Test
	public void shopHomePageTest() {
		Login login = new Login();
		try {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(path);
		List<NameValuePair> postPara = new ArrayList<NameValuePair>();
		postPara.add(new BasicNameValuePair("token", login.token));
		post.setEntity(new UrlEncodedFormEntity(postPara));
		try {
			CloseableHttpResponse response = httpclient.execute(post);
			HttpEntity entiyResponse = response.getEntity();
			String entiy = EntityUtils.toString(entiyResponse);
			System.out.println(entiy);

		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
