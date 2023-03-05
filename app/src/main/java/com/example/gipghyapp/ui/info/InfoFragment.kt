package com.example.gipghyapp.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.gipghyapp.databinding.FragmentInfoBinding
import com.example.gipghyapp.ui.SharedViewModel

class InfoFragment : Fragment() {

    private var binding: FragmentInfoBinding? = null
    private val mBinding get() = binding!!

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shared.observe(viewLifecycleOwner) { response ->
            mBinding.title.text = response.title
            mBinding.name.text = "Имя пользователя: " + response.username
            mBinding.ratingText.text = "ID: " + response.id
            Toast.makeText(requireContext(), response.toString(), Toast.LENGTH_SHORT).show()
        }

    }
}