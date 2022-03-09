package com.example.mycountryapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mycountryapp.databinding.LoginLayoutBinding


class LoginFragment : Fragment() {

    lateinit var binding: LoginLayoutBinding

    var userName = "test@test.com"
    var password = "test1234"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginLayoutBinding.inflate(inflater, container, false)

        bindUI()

        return binding.root
    }

    fun bindUI(){
        binding.btnLogin.setOnClickListener{
            if(binding.etUsername.text.toString() == userName && binding.etPassword.text.toString() == password){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment("hugo"))
            }
            else{
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}