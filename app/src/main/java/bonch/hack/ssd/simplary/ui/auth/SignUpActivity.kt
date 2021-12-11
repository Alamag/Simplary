package bonch.hack.ssd.simplary.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bonch.hack.ssd.simplary.databinding.ActivitySignUpBinding
import bonch.hack.ssd.simplary.router.AuthRouter

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AuthRouter.setFragmentManager(supportFragmentManager)

        AuthRouter.navigateToSignUp()
    }

    override fun onDestroy() {
        super.onDestroy()

        AuthRouter.setFragmentManager(null)
    }
}