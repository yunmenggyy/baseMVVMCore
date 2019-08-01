package com.gyy.baseccore.bean

/**
 *
 * 创建时间: 2019/8/1
 *
 * 作者：GuanYangYi
 *
 * 功能描述：Http请求响应基础类
 *
 *
 */
class BaseResponse<T> {
    var code:Int? = null
    var message:String? =null
    var data:T? = null

    override fun toString(): String {
        return "[code:$code, message:$message, data:$data]"
    }
}