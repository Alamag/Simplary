package bonch.hack.ssd.simplary.ui.signup

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import bonch.hack.ssd.simplary.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth

    private val model: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        binding.bSignUp.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val passwordRepeated = binding.etPasswordRep.text.toString()
            val login = binding.etLogin.text.toString()
            val name = binding.etName.text.toString()
            val lastNane = binding.etLastName.text.toString()

            if (password == passwordRepeated) {
                model.createAccount(email, password, this)
            }
        }

        model.state.observe(this) { state ->
            processState(state)
        }

        setContentView(binding.root)
    }

    private fun processState(state: SignUpState) {
        when (state) {
            is SignUpState.Error -> {
                Toast.makeText(this, state.errorMessage, Toast.LENGTH_SHORT).show()
            }
            SignUpState.Loading -> {

            }
            is SignUpState.Success -> {

            }
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            //reload();
        }
    }

    companion object {
        const val TAG = "EmailPassword"
    }
}