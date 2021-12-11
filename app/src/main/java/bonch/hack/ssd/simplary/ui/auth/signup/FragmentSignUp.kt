package bonch.hack.ssd.simplary.ui.auth.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import bonch.hack.ssd.simplary.R
import bonch.hack.ssd.simplary.databinding.FragmentSignUpBinding
import bonch.hack.ssd.simplary.ui.base.BaseBindingFragment
import bonch.hack.ssd.simplary.utils.ToastHelper

class FragmentSignUp :
    BaseBindingFragment<FragmentSignUpBinding, SignUpViewModel>(FragmentSignUpBinding::inflate) {

    companion object {
        fun newInstance(): FragmentSignUp {
            return FragmentSignUp()
        }
    }

    override val model: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.state.observe(viewLifecycleOwner) {
            processState(it)
        }

        setClickers()
    }

    private fun processState(state: SignUpState) {
        when (state) {
            is SignUpState.Error -> {
                ToastHelper.showShort(requireContext(), state.msg)
            }
            SignUpState.Loading -> {

            }
            is SignUpState.Success -> {
                ToastHelper.showShort(requireContext(), getString(R.string.sign_up_success))
            }
            SignUpState.Waiting -> {

            }
        }
    }

    private fun setClickers() {
        binding.signUpButton.setOnClickListener {
            binding.run {
                val login = nickEditText.text.toString()
                val name = nameEditText.text.toString()
                val lastName = lastNameEditText.text.toString()
                val email = emailEditText.text.toString()
                val pass = passEditText.text.toString()
                val confirmPass = pass2EditText.text.toString()

                model.onSignUpClicked(
                    SignUpViewModel.User(
                        login = login,
                        name = name,
                        lastName = lastName,
                        email = email,
                        pass = pass,
                        confirmPass = confirmPass
                    )
                )
            }
        }

        binding.toSignInButton.setOnClickListener {
            model.onSignInClicked()
        }
    }
}