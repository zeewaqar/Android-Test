package saarland.cispa.androidtest

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_landscape__mode.*

class Landscape_Mode : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landscape__mode)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        togglebutton.setOnCheckedChangeListener { _, isChecked ->
            requestedOrientation = if (isChecked)
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            else
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        }
    }
}
