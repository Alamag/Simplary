package bonch.hack.ssd.simplary.ui.signup

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignUpViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth
    val db = Firebase.firestore



}