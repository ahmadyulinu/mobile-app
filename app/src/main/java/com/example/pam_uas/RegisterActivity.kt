package com.example.pam_uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.pam_uas.models.dataclass.UserRequest
import com.example.pam_uas.models.dataclass.UserResponse
import com.example.pam_uas.models.retrofit.API
import com.example.pam_uas.models.retrofit.Retro
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button: Button = findViewById(R.id.button_form_register)

        button.setOnClickListener{
            register()
        }
    }

    private fun register() {
        val request = UserRequest()
        request.name = form_register_name.text.toString().trim()
        request.email = form_register_email.text.toString().trim()
        request.password = form_register_password.text.toString().trim()

        val retro = Retro().getRetroClientInstance().create(API::class.java)


        retro.register(request).enqueue(object : Callback<UserResponse> {

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e(t.message, "error")
                return
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val user = response.body()
                if (response.code() == 200) {

                    Log.d("data", user?.id.toString())

                    //redirect
                    val intent = Intent(
                        this@RegisterActivity,
                        MainActivity::class.java
                    ) // redirecting to Beranda_Activity.
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "All fields required", Toast.LENGTH_SHORT).show()
                }


                return
            }

        })
    }
}