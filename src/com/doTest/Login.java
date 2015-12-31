package com.doTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ArrayList;

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
import org.testng.AssertJUnit;

public class Login {
	private static String path = "http://www.wemart.cn/um/login";
	public static String token;

	Login() {
		
		try {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(path);
		List<NameValuePair> postPara = new ArrayList<NameValuePair>();
		postPara.add(new BasicNameValuePair("username", "13818815870"));
		postPara.add(new BasicNameValuePair("password", "123456"));
		postPara.add(new BasicNameValuePair("accountType", "2"));
		post.setEntity(new UrlEncodedFormEntity(postPara));
		try {
			CloseableHttpResponse response = httpclient.execute(post);
			HttpEntity entiyResponse = response.getEntity();
			String entiy = EntityUtils.toString(entiyResponse);
			JSONObject jsonobject = JSONObject.fromObject(entiy);
			if (jsonobject.getString("result").equals("1")){
				String root = jsonobject.getString("root");
				JSONObject jsonobjecttoken = JSONObject.fromObject(root);
				token = jsonobjecttoken.getString("token");
			}
			else{
				AssertJUnit.fail(jsonobject.toString());
			}

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
