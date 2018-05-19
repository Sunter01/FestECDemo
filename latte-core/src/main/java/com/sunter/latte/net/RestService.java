package com.sunter.latte.net;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * retrofit 使用必须要有接口，接口定义一系列方法。
 */
public interface RestService {


    @GET
    Call<String> get(@Url String url, @QueryMap Map<String, Object> params);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String, Object> params);

    // put和post一样的
    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap Map<String, Object> params);


    // delete和get很像
    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String, Object> params);

    // download 使用的get方式,
    // *** 默认的download方式是把文件一次性下载到内存，下载完后统一写到内存，容易造成文件过大内存溢出
    // 处理方式 : 加入注解@Streaming边下载边写入文件，避免一次写入过大文件造成app报错
    // 需要异步处理
    @GET
    Call<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> params);

    // upload是post的变种
    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);
}
