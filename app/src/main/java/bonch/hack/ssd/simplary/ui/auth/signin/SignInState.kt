package bonch.hack.ssd.simplary.ui.auth.signin

sealed class SignInState {
    object Loading: SignInState()
    class Success: SignInState()
    class Error(val msg: String): SignInState()
}