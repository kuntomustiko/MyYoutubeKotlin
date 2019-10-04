package com.minara.kirana.myyoutubekotlin.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minara.kirana.kumpulanvideokotlin.ui.main.entity.Item
import com.minara.kirana.myyoutubekotlin.ui.detail.PlayVideoActivity
import com.minara.kirana.myyoutubekotlin.R
import kotlinx.android.synthetic.main.video_item.view.*


// TODO 10 membuat YoutubeAdapter untuk setiap Recyclerview di masing-masing fragment
class YoutubeAdapter(val data: List<Item>?) : RecyclerView.Adapter<YoutubeAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)

        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))

        // TODO 12 membuat intent untuk berpindah ke detail play video activity
        //  dengan key "id" di putExtra sesuai dengan posisi data (List<Item>?) yang di klik di recyclerview
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlayVideoActivity::class.java)
            intent.putExtra("id", data?.get(position)?.id?.videoId)
            holder.itemView.context.startActivity(intent)
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: Item?) {
            itemView.tvTitle.text = get?.snippet?.title
            itemView.tvChannelTitle.text = get?.snippet?.channelTitle
            itemView.tvDescription.text = get?.snippet?.description

            Glide.with(itemView.context).load(get?.snippet?.thumbnails?.high?.url)
                .into(itemView.imgThumbnails)
        }


    }
}