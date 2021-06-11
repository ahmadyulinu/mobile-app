package com.example.pam_uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.pam_uas.models.dataclass.UserRequest
import com.example.pam_uas.models.dataclass.UserResponse
import com.example.pam_uas.models.retrofit.API
import com.example.pam_uas.models.retrofit.Retro
import com.example.pam_uas.models.retrofit.builder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button_login)

        button.setOnClickListener{
            login()
        }

        val register: Button = findViewById(R.id.button_register)

        register.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }




    }

    private fun login() {
        val request = UserRequest()
        request.email = register_name.text.toString().trim()
        request.password = register_password.text.toString().trim()

        val retro = Retro().getRetroClientInstance().create(API::class.java)


        retro.login(request).enqueue(object : Callback<UserResponse> {

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
                        this@MainActivity,
                        FragmentActivity::class.java
                    ) // redirecting to Beranda_Activity.
                    intent.putExtra("id", user?.id.toString())
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "Credentials do not match", Toast.LENGTH_SHORT).show()
                }


                return
            }

        })
    }




}
