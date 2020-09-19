package com.muslimit.boom_boom_alert

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.show_alert_popup.view.*
import kotlinx.android.synthetic.main.show_alert_popup.view.message
import kotlinx.android.synthetic.main.show_alert_popup.view.title
import kotlinx.android.synthetic.main.single_choice_alert.view.*
import kotlinx.android.synthetic.main.alert_views.view.*
import kotlinx.android.synthetic.main.delete_alert.view.*


/**
 *AlertPlugin
 *Rasel Khan
 *Time: 6:05 PM
 *Date: 9/16/2020
 */

class BoomBoomAlert (val activity: Activity){
    fun customAlert(alertType:Int,title:String,message:String,successButton:String,failButton:String,from:String? = "", ){
        val mFrom:String? = from
        view = LayoutInflater.from(activity).inflate(R.layout.show_alert_popup,null,false)
        var alert = AlertDialog.Builder(activity)
        alert.setView(view)
        view.title.text = if (title != "") title else ""
        view.title.setTextColor(when(alertType){1->activity.resources.getColor(R.color.success_color) else->activity.resources.getColor(R.color.failure_color)})
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

    @SuppressLint("InflateParams")
    fun DeleteAlert(title:String? = "", message:String,yesButton:String = "YES", noButton:String = "NO", isCancelForFinish:Boolean = true){
        val mTitle = title
        val mYesButton = yesButton
        val mNoButton = noButton
        val mCancelSelect = isCancelForFinish
        view = LayoutInflater.from(activity).inflate(R.layout.delete_alert,null,false)
        val alert = AlertDialog.Builder(activity)
        alert.setView(view)
        val dialog = alert.create()
        view.delete_title.text = mTitle
        view.delete_message.text = message
        view.delete_yes.text = mYesButton
        view.delete_no.text = mNoButton
        if(!mCancelSelect) view.delete_no.setOnClickListener { dialog.dismiss() }
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    @SuppressLint("InflateParams")
    fun Single_Alert(title:String, message: String, icon:Int = 0, buttonOk:String = "Ok", buttonCancel:String = "Cancel" ){
        val okButton = buttonOk
        val cancelButton = buttonCancel
        var myIcon = icon

        view = LayoutInflater.from(activity).inflate(R.layout.single_choice_alert,null,false)
        val alert = AlertDialog.Builder(activity)
        alert.setView(view)
        view.title.text = if (title != "") title else ""
//        view.title.setTextColor(when(alertType){1->context.resources.getColor(R.color.success_color) else->context.resources.getColor(R.color.failure_color)})
        view.message.text = if (message != "") message else ""
        view.yes.text = okButton
        view.no.text = cancelButton
        if (view.success.visibility == View.GONE && view.cancel.visibility == View.GONE) alert.setCancelable(true) else alert.setCancelable(false)
//        view.image.setImageResource(when(alertType){1->R.drawable.ic_suc 2->R.drawable.ic_error 3->R.drawable.ic_ialert 4->R.drawable.ic_warning else->R.drawable.ic_no_sig})
        messageDialog = alert.create()
        messageDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if (messageDialog.isShowing){
            messageDialog.dismiss()}
        messageDialog.show()
    }

    fun quitMessage(icon:Int,appname:String){
        val quitview = LayoutInflater.from(activity).inflate(R.layout.single_choice_alert,null,false)
        var alert = AlertDialog.Builder(activity)
        alert.setView(quitview)
        val myDialog = alert.create()
        if (icon == 0)quitview.quit_image.visibility = View.GONE else quitview.quit_logo.setImageResource(icon)
        quitview.message.text = "Dear user, are you sure want to quit $appname"
        quitview.yes_2.setOnClickListener { activity.finish() }
        quitview.no_2.setOnClickListener { myDialog.dismiss() }
        myDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog.show()
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
        val yes
            get() = view.yes
        val no
            get() = view.no
        val deleteYes
            get() = view.delete_yes
        val deleteNo
            get() = view.delete_no
        val TYPE_SUCCESS = 1
        val TYPE_FAILURE = 2
        val TYPE_ALERT = 3
        val TYPE_FILE = 4
        val TYPE_INTERNET_FAIL = 5

    }
}