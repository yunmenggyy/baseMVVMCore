package com.gyy.baseccore

import com.gyy.baseccore.bean.BaseResponse
import com.gyy.baseccore.net.BaseApi
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *
 * 创建时间: 2019/8/1
 *
 * 作者：
 *
 * 功能描述：
 *
 *
 */
interface MyApi2: BaseApi {
    @GET("https://www.baidu.com/")
    fun getBaidu():Observable<BaseResponse<String>>
}