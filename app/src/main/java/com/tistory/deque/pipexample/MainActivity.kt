package com.tistory.deque.pipexample

import android.app.PictureInPictureParams
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Rational
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mPipBuilder = PictureInPictureParams.Builder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_video_view?.run {
            setOnCompletionListener { it.start() }
            setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.sample}"))
            start()
        }

        main_go_to_pip?.setOnClickListener {
            mPipBuilder.setAspectRatio(Rational(main_video_view.width, main_video_view.height))
            enterPictureInPictureMode(mPipBuilder.build())
        }
    }


}
