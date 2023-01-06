package app.savedinstansestateexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val TAG: String = "TAG_TEST"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")
        val btn: Button = findViewById(R.id.intentBtn)

        if (savedInstanceState == null)
            Log.d(TAG, "액티비티가 처음 생성 됨")
        else {
            with(savedInstanceState) {
                Log.d(TAG, "액티비티가 재생성 됨 : " + getString("key"))
            }
        }

        btn.setOnClickListener() {
            val intent = Intent(this, IntentActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"onSaveInstanceState")
        outState.putString("key","value")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG,"onRestoreInstanceState : " + savedInstanceState.getString("key"))
        val tv: TextView = findViewById(R.id.textView)
        tv.text = savedInstanceState.getString("key")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
        Log.d(TAG,"---------------")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
        Log.d(TAG,"---------------")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }
}