package bonch.hack.ssd.simplary.utils

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FirebaseHelper {
    val usersCollection = Firebase.firestore.collection("Users")
}