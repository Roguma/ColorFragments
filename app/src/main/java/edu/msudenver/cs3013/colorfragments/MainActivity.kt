// Rory Oguma CS-3013-001 Major Project 2


package edu.msudenver.cs3013.colorfragments

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(), MainActivity.ChoiceListener {

    interface ChoiceListener {
        fun onSelected(choice: Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val cfv = findViewById<FragmentContainerView>(R.id.upperfragment_container)
            val choiceFragment = ChoiceFragment()
            supportFragmentManager.commit {
                add(cfv.id, choiceFragment)
            }
        }
    }

    override fun onSelected(choiceID: Int) {
        val fcv = findViewById<FrameLayout>(R.id.lowerfragment_container)
        val colorFragment = ColorFragment.newInstance(choiceID)

        supportFragmentManager.commit {
            replace(fcv.id, colorFragment)
            addToBackStack(null)
        }
    }
}