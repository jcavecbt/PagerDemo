package com.example.jcave.pagerdemo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val viewModel = activity?.run {
            ViewModelProviders.of(this).get(SharedViewModel::class.java)
        }

        viewModel?.getData()?.observe(this, Observer {
            Toast.makeText(activity, "Fragment 2: $it", Toast.LENGTH_SHORT).show()
        })

        return view
    }


    companion object {

        fun newInstance() = SecondFragment()
    }
}
