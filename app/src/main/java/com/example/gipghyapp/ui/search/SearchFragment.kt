package com.example.gipghyapp.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gipghyapp.R
import com.example.gipghyapp.databinding.FragmentSearchBinding
import com.example.gipghyapp.models.Data
import com.example.gipghyapp.ui.SharedViewModel
import com.example.gipghyapp.ui.adapters.GifsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*


@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var binding: FragmentSearchBinding? = null
    private val mBinding get() = binding!!
    lateinit var gifsAdapter: GifsAdapter

    private val fragmentViewModel: SharedViewModel by activityViewModels()


    private val viewModel by viewModels<SearchViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()

        binding!!.edSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty())
                    viewModel.getAll(s.toString())
            }
        })
        viewModel.all.observe(viewLifecycleOwner) { response ->
            response.data.let {
                gifsAdapter.differ.submitList(it)
            }
        }
    }

    private fun initAdapter() {
        gifsAdapter = GifsAdapter(::itemClick)
        gifs_adapter.apply {
            adapter = gifsAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun itemClick(data: Data){
        val action = SearchFragmentDirections.actionSearchFragmentToInfoFragment()
        findNavController().navigate(action)
        fragmentViewModel.setShared(data = data)
    }

}