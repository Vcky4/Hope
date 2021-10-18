package com.vicksoson.hope.ui.homescreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vicksoson.hope.R
import com.vicksoson.hope.databinding.FragmentHomeBinding
import com.vicksoson.hope.model.Items

class Home : Fragment() {

    private var dataList = mutableListOf<Items>()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }
}