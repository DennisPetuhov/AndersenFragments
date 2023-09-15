package com.example.andersenfragments.Presenter

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.andersenfragments.Data.Cat
import com.example.andersenfragments.R

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
class MainActivity : AppCompatActivity(), ClickFirstFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigatorWithFirstFragment()
    }

    private fun initNavigatorWithFirstFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, FirstFragment.newInstance())
            .commit()
    }


    override fun onClick(cat: Cat) {
        val bundle = Bundle()
        bundle.putParcelable("cat", cat)
        val secondFragment = SecondFragment.newInstance()
        secondFragment.arguments = bundle
        if (isTablet(applicationContext)) {
            navigateToSecondFragment(R.id.fragmentContainerView2, secondFragment)
        } else {
            navigateToSecondFragment(checkOrientation(), secondFragment)

        }

    }

    private fun navigateToSecondFragment(container: Int, secondFragment: SecondFragment) {
        supportFragmentManager.beginTransaction()
            .replace(container, secondFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun checkOrientation(): Int {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                R.id.fragmentContainerView2
            }

            Configuration.ORIENTATION_PORTRAIT -> {
                R.id.fragmentContainerView
            }


            else -> {
                0
            }
        }

    }

    private fun isTablet(context: Context): Boolean {
        return context.resources
            .configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
    }

}