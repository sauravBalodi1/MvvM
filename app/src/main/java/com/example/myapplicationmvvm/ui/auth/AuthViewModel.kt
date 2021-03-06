package com.example.myapplicationmvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.myapplicationmvvm.ui.data.repo.UserRepo

class AuthViewModel :ViewModel (){
    var email:String?=null//interface function are being defined in  the login activity
    var password:String?=null
    var authListner:AuthListner?=null

    fun buttonClick(view: View){
        authListner?.onStarted()
        val loginResponse=UserRepo().userLogin(email!!,password!!)
        if(email.isNullOrEmpty()||password.isNullOrEmpty())
        {
           authListner?.onFailure("invalid password or email")
            return
        }
        else {
            authListner?.onSuccess(loginResponse)
        }


    }
}
//OUR LOGIN ACTIVITY WILL ONLY COMUNICATE WITH VIEW MODEL
//WE WILL SEND EMAIL ND PASSWORD TO THIS VIEWMODEL AND
//THIS VIEWMODEL WILL COMMUNICATE WITH REPOSITORY TO INTERACT WITH BACKEND,THEN WEBSERVER WILL
// VALIDATE EMAIL AND PASSWORD AND WILL GIVE THE RESPONSE