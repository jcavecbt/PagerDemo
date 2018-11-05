package com.example.jcave.pagerdemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_first.view.*


class FirstFragment : Fragment() {

    private var textView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // TODO: If you remove this line you won't have the leak canary error when you
        // TODO: scroll all the way to the 4th tab.
        textView = view.textView

//        val viewModel = activity?.run {
//            ViewModelProviders.of(this).get(SharedViewModel::class.java)
//        }
//
//        viewModel?.getData()?.observe(this, Observer {
//            Toast.makeText(activity, "Fragment 1: $it", Toast.LENGTH_SHORT).show()
//        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        textView = null
    }


    companion object {
        fun newInstance() = FirstFragment()
    }
}
