package com.example.myapplicationmvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplicationmvvm.R
import com.example.myapplicationmvvm.databinding.ActivityLoginBinding
import com.example.myapplicationmvvm.ui.utils.toast
import kotlinx.android.synthetic.main.activity_login.*

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
        progress_bar.visibility=View.VISIBLE
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        toast("Login Success")
        progress_bar.visibility=View.GONE
        loginResponse.observe(this, Observer {
            toast(it)
        })
    }

    override fun onFailure(message: String) {
        progress_bar.visibility=View.GONE
        toast(message)
    }
    //thjs activity should contain the logic that are only resposible for handling ui elements

}