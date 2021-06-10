package com.example.pam_uas.fragments

import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pam_uas.R
import com.example.pam_uas.models.dataclass.FishItems
import com.example.pam_uas.models.dataclass.HorizontalItems
import com.example.pam_uas.models.recycler.FishAdapter
import com.example.pam_uas.models.recycler.HorizontalAdapter
import com.example.pam_uas.models.retrofit.builder
import kotlinx.android.synthetic.main.fragment_beranda.*
import kotlinx.android.synthetic.main.fragment_order.RecyclerOrder
import retrofit2.Call
import retrofit2.Response
import androidx.fragment.app.FragmentManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [beranda.newInstance] factory method to
 * create an instance of this fragment.
 */
class beranda : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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

        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val checkout = checkout()
        val data = ArrayList<FishItems>()

        // Populate Data Class
//        for (i in 0..5) {
//            data.add(FishItems(i, "https://i.ibb.co/ZB47QwH/2122931718.jpg", "Ikan Goreng $i", "Rp. $i" ))
//        }
        builder.instance.getPosts().enqueue(object: retrofit2.Callback<ArrayList<FishItems>> {
            override fun onResponse(
                call: Call<ArrayList<FishItems>>?,
                response: Response<ArrayList<FishItems>>?
            ) {
                response?.body()?.let { data.addAll(it) }
                var adapter = FishAdapter(data)

                RecyclerOrder.adapter = adapter
                adapter.setOnItemClickCallback(object: FishAdapter.OnItemClickCallback{
                    override fun onItemClicked(data: FishItems) {
                        var args = Bundle().apply {
                            putString("deskripsi", data.deskripsi)
                            putInt("id", data.id)
                            putString("harga", data.harga)
                            putString("foto", data.foto)
                            putInt("id_transaksi", 7)
                        }
                        checkout.arguments = args
                        makeCurrentFragment(checkout)
//                        Toast.makeText(activity, data.nama_ikan, Toast.LENGTH_SHORT).show()
                    }
                })


            }
            override fun onFailure(call: Call<ArrayList<FishItems>>?, t: Throwable?) {
                Log.e("R", "Error adalah :" + t.toString())
            }
        })
        RecyclerOrder.layoutManager = LinearLayoutManager(activity)




        // horizontal recycler view

        val horidata = ArrayList<HorizontalItems>()

        horidata.add(HorizontalItems(1, R.drawable.ikan1))
        horidata.add(HorizontalItems(2, R.drawable.ikan2))
        horidata.add(HorizontalItems(3, R.drawable.ikan3))

        RecyclerHorizon.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        RecyclerHorizon.adapter = HorizontalAdapter(horidata)
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
         * @return A new instance of fragment beranda.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            beranda().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}