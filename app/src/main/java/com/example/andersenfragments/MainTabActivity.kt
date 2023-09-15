//package com.example.andersenfragments
//
//import android.content.Context
//import android.content.res.Configuration
//import android.os.Bundle
//import android.util.DisplayMetrics
//import android.view.View
//import android.widget.Button
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//
//class MainTabActivity : AppCompatActivity() {
//override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val textView: TextView = findViewById(R.id.checkphonetablet)
//        val buttonX: Button = findViewById(R.id.button) as Button
//        buttonX.setOnClickListener(object : View.OnClickListener() {
//            override fun onClick(v: View?) {
//                textView.setText(getDeviceInfo(getApplicationContext(), Device.DEVICE_TYPE))
//                textView.setVisibility(View.VISIBLE)
//            }
//        })
//    }
//
//    enum class Device {
//        DEVICE_TYPE
//    }
//
//    companion object {
//        fun getDeviceInfo(context: Context, device: Device): String {
//            try {
//                if (device == Device.DEVICE_TYPE) {
//                    return if (isTablet(context)) {
//                        if (getDevice5Inch(context)) {
//                            "This is Tablet"
//                        } else {
//                            "This is Mobile"
//                        }
//                    } else {
//                        "This is Mobile"
//                    }
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//            return ""
//        }
//
//        private fun getDevice5Inch(context: Context): Boolean {
//            return try {
//                val displayMetrics: DisplayMetrics = context.resources.displayMetrics
//                val yinch: Float = displayMetrics.heightPixels / displayMetrics.ydpi
//                val xinch: Float = displayMetrics.widthPixels / displayMetrics.xdpi
//                val diagonalinch = Math.sqrt((xinch * xinch + yinch * yinch).toDouble())
//                if (diagonalinch >= 7) {
//                    true
//                } else {
//                    false
//                }
//            } catch (e: Exception) {
//                false
//            }
//        }
//
//        private fun isTablet(context: Context): Boolean {
//            return context.resources
//                .configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
//        }
//    }
//}