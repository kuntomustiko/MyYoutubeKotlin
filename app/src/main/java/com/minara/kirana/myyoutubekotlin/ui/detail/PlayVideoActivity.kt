package com.minara.kirana.myyoutubekotlin.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minara.kirana.myyoutubekotlin.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_play_video.*

// TODO 13 membuat PlayVideoActivity
class PlayVideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)

        lifecycle.addObserver(yt_player_view)

        // TODO 14 menerima kiriman dari intent putExtra berdasarkan key "id"
        yt_player_view.addYouTubePlayerListener(object :AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(intent.getStringExtra("id"),0f)
            }
        })
    }
}
