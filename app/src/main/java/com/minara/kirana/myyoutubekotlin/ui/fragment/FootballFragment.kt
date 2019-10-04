package com.minara.kirana.myyoutubekotlin.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minara.kirana.kumpulanvideokotlin.ui.main.entity.Item
import com.minara.kirana.kumpulanvideokotlin.ui.main.entity.ResultVideo
import com.minara.kirana.myyoutubekotlin.R
import com.minara.kirana.myyoutubekotlin.network.NetworkConfig
import com.minara.kirana.myyoutubekotlin.ui.adapter.YoutubeAdapter
import kotlinx.android.synthetic.main.fragment_football.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class FootballFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_football, container, false)

        // TODO 9 memanggil objek Network Retrofit Sesuai dengan parameter/query di interface class service
        NetworkConfig.service().getVideo("snippet", "football", "key youtube mu")
            .enqueue(object : Callback<ResultVideo> {
                override fun onFailure(call: Call<ResultVideo>, t: Throwable) {

                }

                override fun onResponse(call: Call<ResultVideo>, response: Response<ResultVideo>) {
                    if (response.isSuccessful) {
                        showData(response.body()?.items)
                    }
                }
            })
        return view
    }

    // TODO 11 Memanggil Youtube Adapter lalu di pasangkan di Recyclerview Footbal Fragment
    fun showData(item: List<Item>?) {
        rvFootballFragment.adapter = YoutubeAdapter(item)
    }
}
