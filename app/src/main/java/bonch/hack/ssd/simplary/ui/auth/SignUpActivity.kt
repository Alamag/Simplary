package bonch.hack.ssd.simplary.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bonch.hack.ssd.simplary.databinding.ActivitySignUpBinding
import bonch.hack.ssd.simplary.model.UserEntity
import bonch.hack.ssd.simplary.router.AuthRouter
import bonch.hack.ssd.simplary.utils.CurrentUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AuthRouter.setFragmentManager(supportFragmentManager)

        val currentUid = Firebase.auth.currentUser?.uid

        currentUid?.let {
           Firebase.firestore.collection("Users").document(it).get()
                .addOnSuccessListener { docSnapshot ->
                    CurrentUser.uid = currentUid
                    CurrentUser.user = docSnapshot.toObject<UserEntity>()!!

                    AuthRouter.navigateToMainActivity()
                }
        } ?: run {
            AuthRouter.navigateToSignUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        AuthRouter.setFragmentManager(null)
    }
}