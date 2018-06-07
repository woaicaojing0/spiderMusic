package com.spider.common;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cj34920 on 2017/4/14.
 */
public class OkHttpClientManager {
    private static OkHttpClientManager mInstance;
    private OkHttpClient mOkHttpClient;
    private JSON json;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final String TAG = "OkHttpClientManager";

    private OkHttpClientManager() {
        mOkHttpClient = new OkHttpClient();
    }

    public static OkHttpClientManager getInstance() {
        if (mInstance == null) {
            synchronized (OkHttpClientManager.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpClientManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 同步的Get请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    private String getAsyn(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Call call = mOkHttpClient.newCall(request);
        Response response = call.execute();
        return response.body().string();
    }

    /**
     * 同步的Post 请求
     *
     * @param url
     * @param param
     * @return
     * @throws IOException
     */
    private String postAsyn(String url, Map<String, String> param) throws IOException {
        Request request = buildPostRequest(url, param);
        Response response = mOkHttpClient.newCall(request).execute();
        return response.body().string();
    }

    private String postAsyn(String url, Map<String, String> param, Map<String, String> headers) throws IOException {
        Request request = buildPostRequest(url, param);
        Response response = mOkHttpClient.newCall(request).execute();
        return response.body().string();
    }

    private String postAsyn(String url, String json, Map<String, String> headers) throws IOException {
        Request request = buildPostHeadRequest(url, json, headers);
        Response response = mOkHttpClient.newCall(request).execute();
        return response.body().string();
    }

    private Request buildPostHeadRequest(String url, String json, Map<String, String> headers) {
        if (headers == null) {
            headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
        }
        RequestBody responseBody = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder().url(url).post(responseBody);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
        return builder.build();
    }

    private Request buildPostRequest(String url, Map<String, String> param) {
        if (param == null) {
            param = new HashMap<>();
        }

        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            formBodyBuilder.add(entry.getKey(), entry.getValue());
        }
        FormBody formBody = formBodyBuilder.build();
        return  new Request.Builder().url(url).post(formBody).build();
    }

    public static String getAsString(String url) throws IOException {
        return getInstance().getAsyn(url);
    }

    public static String postAsString(String url, String json, Map<String, String> headers) throws IOException {
        return getInstance().postAsyn(url, json, headers);
    }
}