package com.sunter.latte.net;

import com.sunter.latte.net.callback.IError;
import com.sunter.latte.net.callback.IFailure;
import com.sunter.latte.net.callback.IRequest;
import com.sunter.latte.net.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RestClientBuilder {

    private String mUrl;
//    private Map<String, Object> mParams;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest;

    private ISuccess mISuccess;
    private IFailure mIFailure;
    private IError mIError;
    private RequestBody mBody;

    RestClientBuilder() {

    }

    public final RestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params){
//        this.mParams = params;
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value){
//        if (mParams == null){
//            mParams = new WeakHashMap<>();
//        }
//        this.mParams.put(key, value);
        PARAMS.put(key, value);
        return this;
    }


    //传入原始数据
    public final RestClientBuilder raw(String raw){
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest){
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess){
        this.mISuccess = iSuccess;
        return this;
    }


    public final RestClientBuilder failure(IFailure iFailure){
        this.mIFailure = mIFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError){
        this.mIError = iError;
        return this;
    }

//    private Map<String, Object> checkParams(){
//        if (mParams == null){
//            return new WeakHashMap<>();
//        }
//        return mParams;
//    }

    public  final RestClient build(){
        return  new RestClient(mUrl, PARAMS, mIRequest, mISuccess, mIFailure, mIError, mBody);
    }
}
