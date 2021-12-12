package bonch.hack.ssd.simplary.ui.auth.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bonch.hack.ssd.simplary.repository.SignUp
import bonch.hack.ssd.simplary.router.AuthRouter
import bonch.hack.ssd.simplary.utils.CurrentUser

class SignUpViewModel : ViewModel() {

    private val _state: MutableLiveData<SignUpState> = MutableLiveData(SignUpState.Waiting)
    val state: LiveData<SignUpState> = _state

    fun onSignUpClicked(user: User) {
        require(user.pass == user.confirmPass && user.pass.isNotEmpty()) {
            _state.value = SignUpState.Error("Пароли должны совпадать и быть длиннее 6 символов")
            _state.value = SignUpState.Waiting
            return
        }

        SignUp().invoke(user.email, user.pass)
            .addOnSuccessListener {
                it.user?.let { currentUser ->
                    user.id = currentUser.uid
                    CurrentUser.uid = currentUser.uid

//                    CreateUserInDatabase().invoke(UserEntity.fromUserData(user))
//                        .addOnSuccessListener {
//                            _state.value = SignUpState.Success()
//
//                            AuthRouter.navigateToMainActivity()
//                        }
//                        .addOnFailureListener {
//                            _state.value = SignUpState.Error(it.localizedMessage)
//                            _state.value = SignUpState.Waiting
//                        }
                }
            }
            .addOnFailureListener {
                _state.value = SignUpState.Error(it.localizedMessage)
                _state.value = SignUpState.Waiting
            }
    }

    fun onSignInClicked() {
        AuthRouter.navigateToSignIn()
    }

    data class User(
        var id: String = "",
        val login: String,
        val name: String,
        val lastName: String,
        val email: String,
        val pass: String,
        val confirmPass: String
    )
}