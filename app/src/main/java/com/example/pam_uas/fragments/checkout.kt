package com.example.pam_uas.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.pam_uas.FragmentActivity
import com.example.pam_uas.R
import com.example.pam_uas.models.dataclass.*
import com.example.pam_uas.models.retrofit.API
import com.example.pam_uas.models.retrofit.Retro
import com.example.pam_uas.models.retrofit.builder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_checkout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [checkout.newInstance] factory method to
 * create an instance of this fragment.
 */
class checkout : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var text: TextView? = null
    private var fish_name: TextView? = null
    private var imageView: ImageView? = null
    private var button: Button? = null
//    private var amount: Int? = 0
//    private var total: Int? = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // get View IDs
        text = getView()?.findViewById(R.id.checkout_fish_description)
        imageView = getView()?.findViewById(R.id.checkout_fish_image)
        fish_name = getView()?.findViewById(R.id.checkout_fish_name)
        button = getView()?.findViewById(R.id.checkout_button);
        // get variables from bundle
        var bundle = this.arguments
        var deskripsi = bundle?.getString("deskripsi")
        var id = bundle!!.getInt("id")
        var id_string = id.toString()
        var nama_ikan = bundle?.getString("nama_ikan")
        var foto = bundle?.getString("foto")
        var harga = bundle?.getString("harga")?.toInt()
        var id_user = bundle?.getString("id_user")

        //  Use Variables
        text?.text = deskripsi
        fish_name?.text = nama_ikan
        Picasso.get().load(foto).into(imageView)

        // posting
        button?.setOnClickListener {
            checkOut(harga, id_user, id)
        }
    }

    private fun checkOut(harga: Int?, id: String?, id_ikan: Int) {
        val request = CheckoutRequest()
        var status = "DIPROSES"
        var nama = checkout_name.text.toString()
        var alamat = checkout_address.text.toString()
        var amount = checkout_amount.text.toString().toInt()
        var total = amount * harga!!
        var beranda = beranda()

        request.id_user = id
        request.nama = nama
        request.alamat = alamat
        request.jumlah_pesanan = amount
        request.harga_total = total
        request.status_transaksi = status
        request.transaction_details = arrayOf(id_ikan)



        val retro = Retro().getRetroClientInstance().create(API::class.java)


        retro.checkout(request).enqueue(object : Callback<CheckoutResponse> {

            override fun onFailure(call: Call<CheckoutResponse>, t: Throwable) {
                Log.e(t.message, "error")
                return
            }

            override fun onResponse(call: Call<CheckoutResponse>, response: Response<CheckoutResponse>) {
                if (response.code() == 200) {
                    Toast.makeText(activity, "Checked Out Successfully", Toast.LENGTH_SHORT).show()
                    makeCurrentFragment(beranda)
                } else {
                    Toast.makeText(activity, "Failed?", Toast.LENGTH_SHORT).show()
                }
                return
            }
        })
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fl_layout, fragment)
            commit()
        }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment checkout.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            checkout().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}