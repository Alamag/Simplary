package bonch.hack.ssd.simplary.router

import android.content.Intent
import androidx.fragment.app.FragmentManager
import bonch.hack.ssd.simplary.App
import bonch.hack.ssd.simplary.MainActivity
import bonch.hack.ssd.simplary.R
import bonch.hack.ssd.simplary.ui.auth.signin.FragmentSignIn
import bonch.hack.ssd.simplary.ui.auth.signup.FragmentSignUp

object AuthRouter {

    private var fragmentManager: FragmentManager? = null

    fun setFragmentManager(fragmentManager: FragmentManager?) {
        this.fragmentManager = fragmentManager
    }

    fun back() {
        fragmentManager?.popBackStack()
    }

    fun navigateToMainActivity() {
        val intent = Intent(App.applicationContext(), MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NO_HISTORY
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        App.applicationContext().startActivity(intent)
    }

    fun navigateToSignIn() {
        fragmentManager?.let {
            it.beginTransaction()
                .add(R.id.auth_fragment_container, FragmentSignIn.newInstance())
                .addToBackStack(null)
                .commitAllowingStateLoss()
        }
    }

    fun navigateToSignUp() {
        fragmentManager?.let {
            it.beginTransaction()
                .add(R.id.auth_fragment_container, FragmentSignUp.newInstance())
                .addToBackStack(null)
                .commitAllowingStateLoss()
        }
    }
}