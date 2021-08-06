package com.example.myapplicationmvvm.ui.auth

interface AuthListner {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}