package com.minara.kirana.myyoutubekotlin.ui.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minara.kirana.kumpulanvideokotlin.ui.main.entity.Item
import com.minara.kirana.kumpulanvideokotlin.ui.main.entity.ResultVideo
import com.minara.kirana.myyoutubekotlin.R
import com.minara.kirana.myyoutubekotlin.network.NetworkConfig
import com.minara.kirana.myyoutubekotlin.ui.adapter.YoutubeAdapter
import kotlinx.android.synthetic.main.fragment_destination.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class DestinationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_destination, container, false)

        NetworkConfig.service().getVideo("snippet","destination","key youtube mu")
            .enqueue(object : Callback<ResultVideo>{
                override fun onFailure(call: Call<ResultVideo>, t: Throwable) {
                        Log.d("TAG", t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultVideo>, response: Response<ResultVideo>) {
                    if (response.isSuccessful){
                        showData(response.body()?.items)
                    }
                }

            })
        return view

    }


    fun showData(items: List<Item>?){
        rvDestinationFragment.adapter = YoutubeAdapter(items)
    }

}
