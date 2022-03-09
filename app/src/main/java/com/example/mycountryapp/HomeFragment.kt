package com.example.mycountryapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.mycountryapp.databinding.HomeLayoutBinding


class HomeFragment : Fragment() {

    private val args: HomeFragmentArgs by navArgs()
    private val mainViewModel: MainViewModel by activityViewModels()
    lateinit var binding: HomeLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvWelcome.text = getString(R.string.welcome_user, args.name)

        binding.tvNbVisitor.text = getString(R.string.visitor_num, mainViewModel.nbVisitor.value.toString())

        bindUI()
        subcribeUI()
        timerUI()
    }

    fun bindUI(){
        binding.btnPlus.setOnClickListener {
            mainViewModel.addVisitor()

        }

        binding.btnMoins.setOnClickListener {
            mainViewModel.deleteVisitor()
        }

        binding.btnReset.setOnClickListener {
            mainViewModel.resetCompteur()
        }

        binding.btnQuit.setOnClickListener {
            mainViewModel.quit()
        }

    }

    private fun timerUI(){
        mainViewModel.rnds.observe(viewLifecycleOwner, Observer{
            binding.tvRandom.text = getString(R.string.random_number, it.toString())
        })
    }

    private fun subcribeUI(){
        mainViewModel.nbVisitor.observe(viewLifecycleOwner, Observer{
            binding.tvNbVisitor.text = getString(R.string.visitor_num, it.toString())
        })
    }
}