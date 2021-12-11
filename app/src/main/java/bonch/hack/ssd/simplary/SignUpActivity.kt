package bonch.hack.ssd.simplary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bonch.hack.ssd.simplary.databinding.ActivitySignUpBinding
import android.util.Log
import android.widget.Toast
import bonch.hack.ssd.simplary.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toSignInButton.setOnClickListener {

            val email = binding.emailEditText.text.toString()
            val password = binding.passEditText.text.toString()
            val passwordRepeated = binding.pass2EditText.text.toString()

            if (password == passwordRepeated) {
                createAccount(email, password)
            }
        }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            //reload();
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val login = binding.nickEditText.text.toString()
                    val name = binding.nameEditText.text.toString()
                    val lastName = binding.lastNameEditText.text.toString()

                    val users = db.collection("Users")
                    val newUser = User(login, name, lastName)

                    users.add(newUser).addOnSuccessListener { documentReference ->
                        Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                        }

                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.

                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}