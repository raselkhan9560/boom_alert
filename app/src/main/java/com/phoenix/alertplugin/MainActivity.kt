package com.phoenix.alertplugin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muslimit.boom_boom_alert.BoomBoomAlert
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            BoomBoomAlert(this).quitMessage(R.mipmap.ic_launcher,resources.getString(R.string.app_name))
        }
    }
}