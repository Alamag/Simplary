package bonch.hack.ssd.simplary.ui.auth.signin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import bonch.hack.ssd.simplary.databinding.FragmentSignInBinding
import bonch.hack.ssd.simplary.ui.base.BaseBindingFragment
import bonch.hack.ssd.simplary.utils.ToastHelper

class FragmentSignIn: BaseBindingFragment<FragmentSignInBinding, SignInViewModel>(FragmentSignInBinding::inflate) {

    companion object {
        fun newInstance(): FragmentSignIn {
            return FragmentSignIn()
        }
    }

    override val model: SignInViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.state.observe(viewLifecycleOwner) {
            processState(it)
        }

        setClickers()
    }

    private fun processState(state: SignInState) {
        when (state) {
            is SignInState.Error -> {
                ToastHelper.showShort(requireContext(), state.msg)
            }
            SignInState.Loading -> {

            }
            is SignInState.Success -> {

            }
        }
    }

    private fun setClickers() {
        binding.btnSignIn.setOnClickListener {
            val email: String = binding.etEmail.text.toString()
            val pass: String = binding.etPass.text.toString()

            model.onSignInClicked(email, pass)
        }
    }
}