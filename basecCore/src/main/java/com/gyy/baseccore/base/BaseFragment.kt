package com.gyy.baseccore.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gyy.baseccore.buildViewModel
import java.lang.reflect.ParameterizedType

/**
 *
 * 创建时间: 2019/7/28
 *
 * 作者：GuanYangYi
 *
 * 功能描述：fragment的基类
 *
 *
 */

open abstract class BaseFragment<VM:BaseViewModel>:Fragment(){

    private val mViewModel by lazy { buildViewModel(getT(this, 0), null, this) }


    //buildViewModel(getT(this, 0), null, this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(setLayoutId(), container)
    }



    /**
     *
     * 设置布局
     *
     * */
    abstract fun setLayoutId():Int

    private fun  getT(o: Any, i: Int): Class<VM>? {
        val type = o.javaClass.genericSuperclass
        if (type != null) {
            if (type is ParameterizedType) {
                return type.actualTypeArguments[i] as Class<VM>
            }
        }
        return null
    }
}
