package com.example.andersenfragments.Presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andersenfragments.Data.Cat
import com.example.andersenfragments.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler(updateCatList(viewModel.getCats()))


    }

    private fun initRecycler(listCat: List<Cat>) {
        val adapter = CatAdapter(mutableListOf(), requireActivity() as ClickFirstFragment)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        adapter.addData(listCat)
    }

    private fun updateCatList(listCat: List<Cat>): List<Cat> {
        val cat = arguments?.getParcelable<Cat>("cat1")
        return if (cat != null) {
            for (i in listCat) {
                if (cat.id == i.id) {
                    i.name = cat.name
                    i.surname = cat.surname
                    i.phone = cat.phone
                }
            }

            listCat
        } else {
            listCat
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = FirstFragment()
    }

}