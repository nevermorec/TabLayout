package com.example.tablayouttest


import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_tranlate.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class TranlateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tranlate, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        imageViewTranlate.setOnClickListener {
            ObjectAnimator.ofFloat(it, "translationX", it.translationX+Random.nextInt(-100, 100)).start()
        }
    }


}
