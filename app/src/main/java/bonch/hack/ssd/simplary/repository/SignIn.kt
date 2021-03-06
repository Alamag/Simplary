package bonch.hack.ssd.simplary.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignIn : (String, String) -> Task<AuthResult> {
    override fun invoke(email: String, pass: String): Task<AuthResult> {
        return Firebase.auth.signInWithEmailAndPassword(email, pass)
    }
}