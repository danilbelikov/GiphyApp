package com.example.gipghyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gipghyapp.databinding.ActivityMainBinding
import com.example.gipghyapp.ui.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val mBinding get() = binding!!

    private val activityViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(mBinding.root)
            bottom_nav_menu.setupWithNavController(
                navController = nav_host_fragment.findNavController()
            )
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}