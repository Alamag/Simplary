package bonch.hack.ssd.simplary.repository

import bonch.hack.ssd.simplary.model.UserEntity
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CreateUserInDatabase: (UserEntity) -> Task<DocumentReference> {
    override fun invoke(user: UserEntity): Task<DocumentReference> {
        return Firebase.firestore.collection("Users")
            .add(user)
    }
}