package saarland.cispa.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_keyboard__focus.*
import kotlinx.android.synthetic.main.activity_keyboard__load.*

class Keyboard_Load : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keyboard__load)
        edit_view.requestFocus()

    }
}
