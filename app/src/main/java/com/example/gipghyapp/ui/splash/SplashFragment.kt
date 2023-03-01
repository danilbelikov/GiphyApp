package com.example.gipghyapp.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gipghyapp.R
import com.example.gipghyapp.databinding.FragmentSearchBinding
import com.example.gipghyapp.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var binding: FragmentSplashBinding? = null
    private val mBinding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

}