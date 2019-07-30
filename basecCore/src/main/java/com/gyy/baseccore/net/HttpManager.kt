package com.gyy.baseccore.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 *
 * 创建时间: 2019/7/30
 *
 * 作者：GuanYangYi
 *
 * 功能描述：Http请求管理器
 *
 *
 */
class HttpManager private constructor(okHttpClient: OkHttpClient? = null, clazz: Class<Any>? = null){

    private val mOkHttpClient by lazy { construct(okHttpClient, clazz) }
    private var retrofit = null

    private fun construct(okHttpClient: OkHttpClient?, clazz: Class<Any>?): OkHttpClient? {
        okHttpClient?.let { Retrofit.Builder().client(okHttpClient) }
            .let { if (clazz!=null) {
              it?.baseUrl("")?.build()?.create(clazz)
            }}

        return okHttpClient
    }


    companion object {
        @Volatile private var instance:HttpManager? = null

        fun  getInstance(okHttpClient: OkHttpClient? = null, clazz: Class<Any>? = null):HttpManager{
            if (instance == null || okHttpClient!=null || clazz!= null) {
                synchronized(HttpManager ::class) {
                    if (instance == null) {
                        instance = HttpManager (okHttpClient, clazz)
                    }
                }
            }
            return instance!!
        }
    }
}

