package com.crypto.trademaster.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.crypto.trademaster.R
import com.crypto.trademaster.databinding.FragmentAuthBinding
import com.crypto.trademaster.ui.viewmodels.MainViewModel
import com.facebook.CallbackManager
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : Fragment(R.layout.fragment_auth) {
    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private var _fireAuth: FirebaseAuth? = null
    private val fireAuth get() = _fireAuth!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        val view = binding.root
        _fireAuth = FirebaseAuth.getInstance()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _fireAuth = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mCallbackManager = CallbackManager.Factory.create()
        binding.loginButton.setPermissions("public_profile","email", "user_birthday", "user_friends")
//        binding.loginButton.registerCallback(mCallbackManager)
        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_loginFragment)
        }
        binding.facebookButton.setOnClickListener {
//            val authCredential = FacebookAuthProvider.getCredential()
//            fireAuth.signInWithCredential()
        }
        binding.googleButton.setOnClickListener {  }


    }
}