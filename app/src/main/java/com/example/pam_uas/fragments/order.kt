package com.example.pam_uas.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_uas.R
import com.example.pam_uas.models.dataclass.FishItems
import com.example.pam_uas.models.recycler.RecyclerAdapter
import com.example.pam_uas.models.dataclass.items
import com.example.pam_uas.models.recycler.FishAdapter
import com.example.pam_uas.models.recycler.HorizontalAdapter
import com.example.pam_uas.models.retrofit.builder
import kotlinx.android.synthetic.main.fragment_beranda.*
import kotlinx.android.synthetic.main.fragment_order.*
import kotlinx.android.synthetic.main.fragment_order.RecyclerOrder
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [order.newInstance] factory method to
 * create an instance of this fragment.
 */
class order : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapterUsed: RecyclerAdapter? = null


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

        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var id = arguments?.getInt("id_user");
        Log.d("F/D", "ID_USER(FRAGMENT): $id")

        val data = ArrayList<items>()

        // Populate Array

//        data.add(items(1,R.drawable.ikan1, "Ikan 1", "Ikan 3"))
//
//        data.add(items(2,R.drawable.ikan1, "Ikan 2", "Ikan 2"))
//
//        data.add(items(3, R.drawable.ikan1, "Ikan 3", "Ikan 3"))
//
//        data.add(items(4, R.drawable.ikan1, "Ikan 4", "Ikan 4"))
//
//        data.add(items(5, R.drawable.ikan1, "Ikan 5", "Ikan 5"))
//
//        data.add(items(6, R.drawable.ikan1, "Ikan 6", "Ikan 6"))

        builder.instance.getOrder(id).enqueue(object: retrofit2.Callback<ArrayList<items>> {
            override fun onResponse(
                call: Call<ArrayList<items>>?,
                response: Response<ArrayList<items>>?
            ) {
                response?.body()?.let { data.addAll(it) }
                var adapter = RecyclerAdapter(data)

                RecyclerOrder.adapter = adapter

            }
            override fun onFailure(call: Call<ArrayList<items>>?, t: Throwable?) {
                Log.e("R", "Error adalah :" + t.toString())

                order_error.visibility = View.VISIBLE
            }
        })
        RecyclerOrder.layoutManager = LinearLayoutManager(activity)
        RecyclerOrder.adapter = RecyclerAdapter(data)

    }

    private fun init() {



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment order.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            order().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}