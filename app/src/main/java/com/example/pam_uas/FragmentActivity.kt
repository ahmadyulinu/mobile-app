package com.example.pam_uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_uas.fragments.beranda
import com.example.pam_uas.fragments.checkout
import com.example.pam_uas.fragments.order
import kotlinx.android.synthetic.main.activity_check_out.*

class FragmentActivity : AppCompatActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)



        val homeFragment = beranda()
        val checkout = checkout()
        val order = order()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_cart -> makeCurrentFragment(order)
                R.id.ic_logout -> logOut()
            }

            true
        }


    }



    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_layout, fragment)
            commit()
        }

    fun logOut() {
        val intent = Intent(this,MainActivity::class.java )
        startActivity(intent)
        finish()
    }
}