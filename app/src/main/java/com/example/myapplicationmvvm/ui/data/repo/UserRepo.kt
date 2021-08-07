package com.example.myapplicationmvvm.ui.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplicationmvvm.ui.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepo {
     fun userLogin(email:String,password:String):LiveData<String>{
         val loginResponse= MutableLiveData<String>()

         //this is very bad practise,later we'll learn about dependency injection
         MyApi().userLogin(email,password)
             .enqueue(object :Callback<ResponseBody>{
                 override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                      loginResponse.value=t.message
                     Log.d("call of failure from UserRepo",call.toString())
                 }

                 override fun onResponse(
                     call: Call<ResponseBody>,
                     response: Response<ResponseBody>
                 ) {
                     if(response.isSuccessful)
                     {
                         loginResponse.value=response.body().toString()

                     }
                     else
                     {
                         loginResponse.value=response.errorBody().toString()
                     }
                 }

             })
         Log.d("call of failure from UserRepo (loginResponse) ",loginResponse.toString())
         return loginResponse
     }
}

//our archi. says ,our activity will communicate with viewModel and viewModel will comminuacte with repo.
