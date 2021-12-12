package bonch.hack.ssd.simplary.ui.auth.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bonch.hack.ssd.simplary.repository.SignIn
import bonch.hack.ssd.simplary.router.AuthRouter

class SignInViewModel : ViewModel() {

    private val _state: MutableLiveData<SignInState> = MutableLiveData()
    val state: LiveData<SignInState> = _state

    fun onSignInClicked(email: String, pass: String) {
        SignIn().invoke(email, pass)
            .addOnSuccessListener {
                AuthRouter.navigateToMainActivity()
            }
            .addOnFailureListener {
                _state.value = SignInState.Error(it.localizedMessage)
            }
    }
}