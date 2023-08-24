package com.shruti.livedataapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.shruti.livedataapp.databinding.FragmentColorBinding
import java.util.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ColorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mainActivity: MainActivity
    lateinit var binding: FragmentColorBinding
    lateinit var colorviewmodel: ColorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentColorBinding.inflate(layoutInflater)
      return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        colorviewmodel = ViewModelProvider(mainActivity).get(ColorViewModel::class.java)
        colorviewmodel.color.observe(mainActivity){
            System.out.println("in observe method $it")
            when(it){
                1-> binding.color.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.red))
                2-> binding.color.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.blue))
                3-> binding.color.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.green))
            }
        }
        colorviewmodel.number.observe(mainActivity){
               binding.tvfragment.setText(it.toString())
        }
        binding.btnreset.setOnClickListener {
            var num = 0
            binding.tvfragment.setText(num.toString())
            colorviewmodel.reset.value = num
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ColorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ColorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}