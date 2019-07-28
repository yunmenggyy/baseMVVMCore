package com.gyy.baseccore

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.gyy.baseccore.base.BaseViewModel

/**
 *
 * 创建时间: 2019/7/28
 *
 * 作者：GuanYangYI
 *
 * 功能描述：建造ViewModel工具
 *
 *
 */

fun <VM:BaseViewModel> buildViewModel(viewModelClass: Class<VM>?, fragmentActivity: FragmentActivity? = null, fragment: Fragment? = null ):VM?{
    viewModelClass?.run {
        if ( (fragmentActivity == null && fragment != null )
            || (fragmentActivity != null && fragment == null) ){
            fragmentActivity?.let {  return@let ViewModelProviders.of(fragmentActivity).get(viewModelClass) }
            fragment?.let { return@let ViewModelProviders.of(fragment).get(viewModelClass) }
        }
    }
    return null
}