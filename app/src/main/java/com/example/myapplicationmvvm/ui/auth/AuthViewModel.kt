package com.example.myapplicationmvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel :ViewModel (){
    var email:String?=null//interface function are being defined in  the login activity
    var password:String?=null
    var authListner:AuthListner?=null

    fun buttonClick(view: View){
        authListner?.onStarted()
        if(email.isNullOrEmpty()||password.isNullOrEmpty())
        {
           authListner?.onFailure("invalid password or email")
            return
        }
        else {
            authListner?.onSuccess()
        }


    }
}