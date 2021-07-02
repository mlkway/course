package com.raywenderlich.coursesshemajamebeli.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.coursesshemajamebeli.R
import com.raywenderlich.coursesshemajamebeli.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private  var binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var adapter: Myadapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(binding == null){
            binding = FragmentHomeBinding.inflate(inflater,container,false)
            bind()
        }
        return binding?.root
    }


    private fun bind(){
        viewModel.loadData()
        viewModel.topic.observe(viewLifecycleOwner){
            adapter.data = it
        }
        adapter = Myadapter()
        binding?.horizontalRecyclerView?.layoutManager=
            LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding?.horizontalRecyclerView?.adapter = adapter
    }

}