//package saarland.cispa.androidtest
//
//import android.R
//import android.app.Activity
//import android.graphics.Matrix
//import android.os.Bundle
//import android.view.MotionEvent
//import android.view.ScaleGestureDetector
//import android.widget.ImageView
//
//class PinchInPinchOut :Activity() {
//
//    private var imageView: ImageView? = null
//    private var scaleGestureDetector: ScaleGestureDetector? = null
//    private val matrix = Matrix()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(saarland.cispa.androidtest.R.layout.activity_pinch_in_pinch_out)
//        imageView = findViewById(saarland.cispa.androidtest.R.id.imageView) as ImageView
//        scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
//    }
//
//    override fun onTouchEvent(ev: MotionEvent): Boolean {
//        scaleGestureDetector!!.onTouchEvent(ev)
//        return true
//    }
//
//    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
//        override fun onScale(detector: ScaleGestureDetector): Boolean {
//            var scaleFactor = detector.scaleFactor
////            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f))
//            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 10.0f));
//            matrix.setScale(scaleFactor, scaleFactor)
//            imageView!!.imageMatrix = matrix
//            return true
//        }
//    }
//}


package saarland.cispa.androidtest
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import saarland.cispa.androidtest.R

class PinchInPinchOut : AppCompatActivity() {
    private var mScaleGestureDetector: ScaleGestureDetector? = null
    private var mScaleFactor = 1f
    private var mImageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pinch_in_pinch_out)
        mImageView = findViewById<View>(R.id.imageView) as ImageView
        mScaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
    }

    override fun onTouchEvent(motionEvent: MotionEvent): Boolean {
        mScaleGestureDetector?.onTouchEvent(motionEvent)
        return true
    }

    private inner class ScaleListener : SimpleOnScaleGestureListener() {
        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            mScaleFactor *= scaleGestureDetector.scaleFactor
            mScaleFactor = Math.max(0.2f, Math.min(mScaleFactor, 10.0f))
            mImageView?.scaleX = mScaleFactor
            mImageView?.scaleY = mScaleFactor
            return true
        }
    }
}
