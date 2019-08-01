package com.gyy.baseccore.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.gyy.baseccore.buildViewModel
import java.lang.reflect.ParameterizedType

/**
 *
 * 创建时间: 2019/7/29
 *
 * 作者：GuanYangYi
 *
 * 功能描述：Activity基础类
 *
 *
 */
open abstract class BaseActivity<VM:BaseViewModel>:AppCompatActivity(){

    val mViewModel by lazy { buildViewModel(getT(this, 0), this) }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        setContentView(setLayoutId())
        initView()
        observe()
    }





    private fun  getT(o: Any, i: Int): Class<VM>? {
        val type = o.javaClass.genericSuperclass
        if (type != null) {
            if (type is ParameterizedType) {
                return type.actualTypeArguments[i] as Class<VM>
            }
        }
        return null
    }


    /**
     *
     * 设置布局
     *
     * */
    abstract fun setLayoutId():Int

    /**
     *
     * 初始化ViewModel
     *
     * */
    abstract fun observe()

    /**
     *
     * 初始化布局
     *
     * */
    fun initView(){}

}