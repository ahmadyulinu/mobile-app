package com.example.pam_uas.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.pam_uas.R
import com.example.pam_uas.models.dataclass.post
import com.example.pam_uas.models.retrofit.builder
import com.squareup.picasso.Picasso
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
    private var imageView: ImageView? = null
    private var button: Button? = null
    private var amount: Int = 0


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
        text = getView()?.findViewById(R.id.checkout_fish_description)
        imageView = getView()?.findViewById(R.id.checkout_fish_image)
        var bundle = this.arguments
        var deskripsi = bundle?.getString("deskripsi")
        var id = bundle?.getInt("id")
        var id_string = id.toString()
        var id_transaksi = bundle?.getInt("id_transaksi")

        var foto = bundle?.getString("foto")
        var harga = bundle?.getString("harga")?.toInt()
        var string = "Deskripsi Ikan Ikan adalah :\n" + deskripsi + "\n ID adalah: " + id
        text?.text = string

        Picasso.get().load(foto).into(imageView)

        // posting
        var nama = checkout_name.text.toString()
        var address = checkout_address.text.toString()
        var checkString = checkout_amount.text?.toString()

        if (
            checkString != ""
        ) {
            amount = checkString!!.toInt()
        }
        var harga_total: Int = harga!!.times(amount)
        var status = "DIPROSES"
        var details = arrayOf(id_transaksi!!+1)

        button = getView()?.findViewById(R.id.checkout_button);
        button?.setOnClickListener {
            create(
                id_string,
                nama,
                address,
                amount,
                harga_total,
                status,
                details
            )
        }

    }

    private fun create(id_user: String, nama: String, alamat:String, jumlah:Int, total:Int,
    status: String, details: Array<Int>) {
        builder.instance.createPost(
            id_user,
            nama,
            alamat,
            jumlah,
            total,
            status,
            details
        ).enqueue(object: Callback<post>{
            override fun onFailure(call: Call<post>?, t: Throwable?) {
                Log.e("ERROR", "Errornya adalah: $t")
            }

            override fun onResponse(call: Call<post>?, response: Response<post>?) {
                Log.d("SUCCESs", "Post Success")
            }
        })
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