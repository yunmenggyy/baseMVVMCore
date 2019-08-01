package com.gyy.basecore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gyy.baseccore.base.BaseActivity
import com.gyy.basecore.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {
    override fun setLayoutId(): Int = R.layout.activity_main

    override fun observe() {
        mViewModel
    }

}
