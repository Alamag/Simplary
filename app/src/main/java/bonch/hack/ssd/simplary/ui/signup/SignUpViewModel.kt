package bonch.hack.ssd.simplary.ui.signup

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bonch.hack.ssd.simplary.databinding.ActivitySignUpBinding
import bonch.hack.ssd.simplary.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignUpViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth
    private val db = Firebase.firestore

    private val _state: MutableLiveData<SignUpState> = MutableLiveData(SignUpState.Loading)
    val state: LiveData<SignUpState> = _state

    fun createAccount(
        email: String,
        password: String,
        activity: SignUpActivity
    ) {
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _state.value = SignUpState.Success()

                    val newUser = User(login, name, lastName)
                    tryToAddUserInfo(newUser)

                    Log.d(SignUpActivity.TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    //updateUI(user)
                } else {
                    Log.w(SignUpActivity.TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(activity, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }

    private fun tryToAddUserInfo(newUser : User) {
        val users = db.collection("Users")

        users.add(newUser).addOnSuccessListener { documentReference ->
            Log.d(SignUpActivity.TAG,
                "DocumentSnapshot added with ID: ${documentReference.id}")
        }
            .addOnFailureListener { e ->
                Log.w(SignUpActivity.TAG, "Error adding document", e)
        }
    }
}

sealed class SignUpState {
    object Loading: SignUpState()
    class Success: SignUpState()
    class Error(val errorMessage: String): SignUpState()
}