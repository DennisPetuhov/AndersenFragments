package com.example.andersenfragments.Presenter

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.andersenfragments.Data.Cat
import com.example.andersenfragments.R
import com.example.andersenfragments.databinding.FragmentSecondBinding

@RequiresApi(Build.VERSION_CODES.TIRAMISU)

class SecondFragment : Fragment() {


    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        receiveCat()
        binding.button.setOnClickListener {
            sendCat(putCatInBundle(makeCat()))
        }


    }

    private fun receiveCat() {
        val cat = arguments?.getParcelable<Cat>("cat")
        binding.phone.setText(cat?.phone.toString())
        binding.nameSecond.setText(cat?.name)
        binding.surname.setText(cat?.surname)
        binding.id.setText(cat?.id.toString())
    }

    private fun sendCat(bundle: Bundle) {

        val firstFragment = FirstFragment.newInstance()
        firstFragment.arguments = bundle
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, firstFragment)
            .addToBackStack(null)
            .commit()


    }

    private fun putCatInBundle(newCat: Cat): Bundle {

        val bundle = Bundle()
        bundle.putParcelable("cat1", newCat)
        return bundle
    }

    private fun makeCat(): Cat {
        val id = binding.id.text.toString().toInt()
        val phone = binding.phone.text.toString().toInt()
        val name = binding.nameSecond.text.toString()
        val surname = binding.surname.text.toString()
        return Cat(id, name, surname, phone)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        fun newInstance() = SecondFragment()
    }
}