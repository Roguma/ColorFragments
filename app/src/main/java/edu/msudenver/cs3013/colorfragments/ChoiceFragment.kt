package edu.msudenver.cs3013.colorfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChoiceFragment : Fragment() {

    private lateinit var choiceListener: MainActivity.ChoiceListener
    private lateinit var blueT: TextView
    private lateinit var redT: TextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity.ChoiceListener) {
            choiceListener = context
        } else {
            throw ClassCastException("$context must implement MainActivity.ChoiceListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        blueT = view.findViewById(R.id.blueText)
        redT = view.findViewById(R.id.redText)

        blueT.setOnClickListener {
            val choice = 1 // BLUE
            choiceListener.onSelected(choice)
        }

        redT.setOnClickListener {
            val choice = 2 // RED
            choiceListener.onSelected(choice)
        }
    }
}