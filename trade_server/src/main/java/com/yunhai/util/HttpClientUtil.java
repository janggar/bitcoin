package com.yunhai.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @description httpClient 模拟发送请求工具类
 * @author jiayanxing
 * @date 2017年3月8日 下午8:54:56
 */
public class HttpClientUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	private static PoolingHttpClientConnectionManager cm;
	private static String EMPTY_STR = "";
	private static String UTF_8 = "UTF-8";

	/**
	 * 
	 * @description 初始化连接池
	 * @author jiayanxing
	 * @time 2017年3月8日 下午9:04:42
	 * @return void
	 */
	private static void init() {
		if (cm == null) {
			cm = new PoolingHttpClientConnectionManager();
			cm.setMaxTotal(50);// 整个连接池最大连接数
			cm.setDefaultMaxPerRoute(5);// 每路由最大连接数，默认值是2
		}
	}

	/**
	 * 
	 * @description 通过连接池获取HttpClient
	 * @author jiayanxing
	 * @time 2017年3月8日 下午9:05:09
	 * @return CloseableHttpClient
	 */
	private static CloseableHttpClient getHttpClient() {
		init();
		return HttpClients.custom().setConnectionManager(cm).build();
	}

	/**
	 * 
	 * @description 发送get请求，不带参数
	 * @author jiayanxing
	 * @time 2017年3月8日 下午9:01:51
	 * @param url
	 *            请求地址
	 * @return String
	 */
	public static String httpGetRequest(String url) {
		HttpGet httpGet = new HttpGet(url);
		return getResult(httpGet);
	}

	/**
	 * 
	 * @description 发送get请求，带参数
	 * @author jiayanxing
	 * @time 2017年3月8日 下午9:06:21
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @throws URISyntaxException
	 * @return String
	 */
	public static String httpGetRequest(String url, Map<String, Object> params) {
		URIBuilder ub = new URIBuilder();
		ub.setPath(url);
		if (params != null && !params.isEmpty()) {
			ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
			ub.setParameters(pairs);
		}
		try {
			HttpGet httpGet = new HttpGet(ub.build());
			return getResult(httpGet);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @description 发送get请求，带参数，带头信息
	 * @author jiayanxing
	 * @time 2017年3月8日 下午9:06:59
	 * @param url
	 *            请求地址
	 * @param headers
	 *            请求头信息
	 * @param params
	 *            请求参数
	 * @throws URISyntaxException
	 * @return String
	 */
	public static String httpGetRequest(String url, Map<String, Object> headers, Map<String, Object> params) {
		try {
			URIBuilder ub = new URIBuilder();
			ub.setPath(url);
			if (params != null && !params.isEmpty()) {
				ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
				ub.setParameters(pairs);
			}
			HttpGet httpGet = new HttpGet(ub.build());
			if (headers != null && !headers.isEmpty()) {
				for (Map.Entry<String, Object> param : headers.entrySet()) {
					httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
				}
			}
			return getResult(httpGet);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @description 发送post请求，不带参数
	 * @author jiayanxing
	 * @time 2017年3月8日 下午9:01:51
	 * @param url
	 *            请求地址
	 * @return String
	 */
	public static String httpPostRequest(String url) {
		HttpPost httpPost = new HttpPost(url);
		return getResult(httpPost);
	}

	/**
	 * 
	 * @description 发送post请求，带参数
	 * @author jiayanxing
	 * @time 2017年3月8日 下午9:06:21
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 * @throws UnsupportedEncodingException
	 * @return String
	 */
	public static String httpPostRequest(String url, Map<String, Object> params) {
		try {
			HttpPost httpPost = new HttpPost(url);
			if (params != null && !params.isEmpty()) {
				ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
				httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
			}
			return getResult(httpPost);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @description 发送post请求，带参数，带头信息
	 * @author jiayanxing
	 * @time 2017年3月8日 下午9:06:59
	 * @param url
	 *            请求地址
	 * @param headers
	 *            请求头信息
	 * @param params
	 *            请求参数
	 * @throws UnsupportedEncodingException
	 * @return String
	 */
	public static String httpPostRequest(String url, Map<String, Object> headers, Map<String, Object> params) {
		try {
			HttpPost httpPost = new HttpPost(url);
			if(headers !=null && !headers.isEmpty()){
				for (Map.Entry<String, Object> param : headers.entrySet()) {
					httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
				}
			}
			if(params !=null && !params.isEmpty()){
				ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
				httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
			}
			return getResult(httpPost);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
		ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
		}
		return pairs;
	}

	/**
	 * 
	 * @description 处理Http请求
	 * @author jiayanxing
	 * @time 2017年3月8日 下午9:11:10
	 * @param request
	 * @return String
	 */
	private static String getResult(HttpRequestBase request) {
		// CloseableHttpClient httpClient = HttpClients.createDefault();
		logger.info("======>>>>>>>>>>>>>>getResult开始执行httpClient请求=================");
		CloseableHttpClient httpClient = getHttpClient();
		try {
			CloseableHttpResponse response = httpClient.execute(request);
			// response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// long len = entity.getContentLength();// -1 表示长度未知
				String result = EntityUtils.toString(entity);
				response.close();
				// httpClient.close();
				logger.info("======>>>>>>>>>>>>>>getResult执行httpClient请求成功返回的result: " + result);
				return result;
			}
		} catch (ClientProtocolException e) {
			logger.info("======>>>>>>>>>>>>>>getResult执行httpClient请求失败" + e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("======>>>>>>>>>>>>>>getResult执行httpClient请求失败" + e);
			e.printStackTrace();
		}
		return EMPTY_STR;
	}
}
