package bonch.hack.ssd.simplary.ui.auth.signup

sealed class SignUpState {
    object Loading : SignUpState()
    object Waiting : SignUpState()
    class Success : SignUpState()
    class Error(val msg: String) : SignUpState()
}