package com.example.myapplicationmvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplicationmvvm.R
import com.example.myapplicationmvvm.databinding.ActivityLoginBinding
import com.example.myapplicationmvvm.ui.utils.toast

class LoginActivity : AppCompatActivity(),AuthListner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //now binding viewModel

        val binding: ActivityLoginBinding=DataBindingUtil.setContentView(this,R.layout.activity_login)
         val viewModel=ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel=viewModel//getiing data from ui
        viewModel.authListner=this
    }

    override fun onStarted() {
      toast("Login started")
    }

    override fun onSuccess() {
        toast("Login Success")
    }

    override fun onFailure(message: String) {
        toast(message)
    }
    //thjs activity should contain the logic that are only resposible for handling ui elements

}