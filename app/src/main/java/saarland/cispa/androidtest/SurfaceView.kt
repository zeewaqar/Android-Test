package saarland.cispa.androidtest

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import kotlinx.android.synthetic.main.activity_surface_view.*

class SurfaceView : AppCompatActivity(), SurfaceHolder.Callback2 {

    lateinit var mediaPlayer: MediaPlayer
    lateinit var surfaceHolder: SurfaceHolder
    lateinit var fileDescriptor: AssetFileDescriptor



    override fun surfaceRedrawNeeded(holder: SurfaceHolder?) {
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
   }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
   }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDisplay(surfaceHolder)
        mediaPlayer.setDataSource(fileDescriptor)
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener{mediaPlayer -> mediaPlayer.start()}
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surface_view)

        surfaceHolder = surface_view.holder
        surfaceHolder.addCallback(this)
        fileDescriptor = assets.openFd("video.mp4")
    }
}
