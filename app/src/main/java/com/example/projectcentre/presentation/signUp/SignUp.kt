package com.example.projectcentre.presentation.signUp

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.projectcentre.R
import com.example.projectcentre.databinding.FragmentSignUpBinding
import com.example.projectcentre.presentation.signIn.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SignUp : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.hide()

        initListeners()
    }

    private fun initListeners(){

        binding.btnRegister.setOnClickListener {
//            val mail = binding.etEmail.text.toString()
//            val password = binding.etPassword.text.toString()
//
//            if (isValidate()) {
//                viewModel.signIn(email = mail, password = password)
//                viewModel.state.onEach { state ->
//                    if (state.data?.isNotEmpty() == true) {
//                        findNavController().navigate(R.id.action_signIn_to_projectsFragment)
//                    }
//                }.launchWhenStarted()
//            }
            findNavController().navigate(R.id.action_signUp_to_mainPage)
        }

//        binding.textregister.setOnClickListener {
//            findNavController().navigate(R.id.action_signIn_to_signUp)
//        }
    }

    private fun isValidate(): Boolean =
        validatePassword() && validateEmail()

    private fun validateEmail(): Boolean {
        if (binding.etEmail.text.toString().trim().isEmpty()) {
            binding.etEmailTIL.error = getString(R.string.require_field)
            binding.etEmail.requestFocus()
            return false
        } else if (!isValidEmail(binding.etEmail.text.toString())) {
            binding.etEmailTIL.error = getString(R.string.email_wrong)
            binding.etEmail.requestFocus()
            return false
        } else {
            binding.etEmailTIL.isErrorEnabled = false
        }
        return true
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validatePassword(): Boolean {
        if (binding.etPassword.text.toString().trim().isEmpty()) {
            binding.etPasswordTIL.error = getString(R.string.require_field)
            binding.etPassword.requestFocus()
            return false
        } else if (binding.etPassword.text.toString().length < 8) {
            binding.etPasswordTIL.error = getString(R.string.password_def_helper)
            binding.etPassword.requestFocus()
            return false
        } else {
            binding.etPasswordTIL.isErrorEnabled = false
        }
        return true
    }


    private fun <T> Flow<T>.launchWhenStarted() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted { collect () }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}