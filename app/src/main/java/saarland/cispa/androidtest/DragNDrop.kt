package saarland.cispa.androidtest

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_drag_n_drop.*

class DragNDrop : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hide the action bar
        val actionBar = supportActionBar

        actionBar!!.hide()

        setContentView(R.layout.activity_drag_n_drop)

        val listener = View.OnTouchListener(function = { view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_MOVE) {

                view.y = motionEvent.rawY - view.height/2
                view.x = motionEvent.rawX - view.width/2
            }

            true

        })

        // Declared in our activity_drag_n_drop.xml file.
        draggableImage.setOnTouchListener(listener)

    }
}