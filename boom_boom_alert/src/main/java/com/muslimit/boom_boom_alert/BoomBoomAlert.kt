package com.muslimit.boom_boom_alert

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.show_alert_popup.view.*


/**
 *AlertPlugin
 *Rasel Khan
 *Time: 6:05 PM
 *Date: 9/16/2020
 */

class BoomBoomAlert (internal val context: Context, internal var alertType:Int, internal var title:String, internal var message:String, internal var successButton:String, internal var failButton:String, internal var from:String, internal var activity: Activity){
    init {
        view = LayoutInflater.from(context).inflate(R.layout.show_alert_popup,null,false)
        var alert = AlertDialog.Builder(context)
        alert.setView(view)
        view.title.text = if (title != "") title else ""
        view.title.setTextColor(when(alertType){1->context.resources.getColor(R.color.success_color) else->context.resources.getColor(R.color.failure_color)})
        view.message.text = if (message != "") message else ""
        if (successButton != "") view.success.text = successButton else view.success.visibility = View.GONE
        if (failButton != "") view.cancel.text = failButton else view.cancel.visibility = View.GONE
        if (view.success.visibility == View.GONE && view.cancel.visibility == View.GONE) alert.setCancelable(true) else alert.setCancelable(false)
        view.image.setImageResource(when(alertType){1->R.drawable.ic_suc 2->R.drawable.ic_error 3->R.drawable.ic_ialert 4->R.drawable.ic_warning else->R.drawable.ic_no_sig})
        messageDialog = alert.create()
        messageDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if (messageDialog.isShowing){
            messageDialog.dismiss()}
        messageDialog.show()
    }
    companion object{
        lateinit var view: View
        lateinit var messageDialog: Dialog
        val successButton
            get() = view.success
        val cancelButton
            get() = view.cancel
        val dialog
            get() = messageDialog
        val TYPE_SUCCESS = 1
        val TYPE_FAILURE = 2
        val TYPE_ALERT = 3
        val TYPE_FILE = 4
        val TYPE_INTERNET_FAIL = 5

    }
}