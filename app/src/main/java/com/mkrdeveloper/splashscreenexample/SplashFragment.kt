package com.mkrdeveloper.splashscreenexample

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Handler(Looper.getMainLooper()).postDelayed({

            if (onBoardingIsFinished()){
                findNavController().navigate(R.id.navigate_splashFragment_to_homeFragment)
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
            }




        }, 3000)


        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        val animTop = AnimationUtils.loadAnimation(view.context, R.anim.from_top)
        val animBottom = AnimationUtils.loadAnimation(view.context, R.anim.from_bottom)

        val tvSplash = view.findViewById<TextView>(R.id.tv_splash)
        val imgSplash = view.findViewById<ImageView>(R.id.imageView)

        tvSplash.animation = animBottom
        imgSplash.animation = animTop


        return view
    }


    private fun onBoardingIsFinished(): Boolean{

        val sharedPreferences = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("finished",false)
    }
}