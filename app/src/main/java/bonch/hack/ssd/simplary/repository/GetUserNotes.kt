package bonch.hack.ssd.simplary.repository

import bonch.hack.ssd.simplary.model.UserEntity
import bonch.hack.ssd.simplary.utils.CurrentUser
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class GetUserNotes: () -> Task<DocumentSnapshot> {
    override fun invoke(): Task<DocumentSnapshot> {
        return Firebase.firestore.collection("Users").document(CurrentUser.uid).get()
    }

}
