package saarland.cispa.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.app.Activity
import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.graphics.Point
import android.os.Build
import android.util.Rational
import android.view.View
import kotlinx.android.synthetic.main.activity_pip.*
import java.util.*

class PIP : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pip)


        textview.visibility = View.GONE

        button.setOnClickListener {

            val mpipParams = PictureInPictureParams.Builder()
            val display = windowManager.defaultDisplay
            val point = Point()
            display.getSize(point)
            mpipParams.setAspectRatio(Rational(point.x,point.y))
            enterPictureInPictureMode(mpipParams.build())
        }
    }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean, newConfig: Configuration?) {
        if(isInPictureInPictureMode){
            textview.visibility = View.VISIBLE
            button.visibility = View.GONE
            supportActionBar?.hide()
        }else{
            textview.visibility = View.GONE
            button.visibility = View.VISIBLE
            supportActionBar?.show()
        }
    }

}
